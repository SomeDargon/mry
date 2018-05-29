package com.mry.util;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * poi框架工具类（poi:数据转office文档）
 *
 * @author vito
 * @version 1.0
 * 创建时间 2016/11/3 10:50
 */
public class OfficeUtil {
    private static final String reg = "\\{\\{\\S*\\}\\}";
    private static final String reg2 = "\\{\\S*";
    private static final String reg3 = "\\{\\{\\S*";
    private static final String reg4 = "\\S*\\}";
    private static final String reg5 = "\\S*\\}\\}";

    /**
     * 数据转word
     */
    public static void readWriteWord(OutputStream out, String filePath, Map<String, Object> data) throws IOException {
        FileInputStream in = new FileInputStream(filePath);
        XWPFDocument doc = new XWPFDocument(in);
        replaceInPara(doc, data);
        replaceInTable(doc, data);
        doc.write(out);
        in.close();
    }

    /**
     * 替换段落里面的变量
     *
     * @param doc  要替换的文档
     * @param data 替换的数据
     */
    private static void replaceInPara(XWPFDocument doc, Map<String, Object> data) {
        doc.getParagraphs().forEach(para -> replaceContent(para, data));
    }

    /**
     * 替换表格里面的变量
     *
     * @param doc  要替换的文档
     * @param data 替换的数据
     */
    private static void replaceInTable(XWPFDocument doc, Map<String, Object> data) {
        doc.getTables().forEach(table -> table.getRows()
                .forEach(row -> row.getTableCells()
                        .forEach(cell -> cell.getParagraphs()
                                .forEach(para -> replaceContent(para, data)))));
    }

    /**
     * 替换内容
     *
     * @param para 要替换的内容
     * @param data 替换的数据
     */
    private static void replaceContent(XWPFParagraph para, Map<String, Object> data) {
        List<XWPFRun> runs = para.getRuns();
        String key = "";
        boolean flag = false;
        for (int i = 0; i < runs.size(); i++) {
            XWPFRun run = runs.get(i);
            String runText = run.toString();
            //如果找到{{value}}这种的直接替换值
            if (runText.matches(reg)) {
                //处理得到key
                key = runText;
                flag = true;
            }
            //如果第一个字符为{
            else if (runText.matches(reg2)) {
                //如果为{{或者下一个run第一个字符也是{
                if (runText.matches(reg3)
                        || (i < runs.size() - 1 && runs.get(i + 1).toString().matches(reg2))) {
                    key = runText;
                    int start = i;
                    int end = i;
                    for (int f = i + 1; f < runs.size(); f++) {
                        //更改父循环的index，不再循环子循环已循环过的内容
                        i = f;
                        String runText1 = runs.get(i).toString();
                        key += runText1;
                        // 找到}}或者（找到}且下一个第一个字符为}）
                        // 说明有需要替换的内容
                        // 设置flag
                        // 设置需要去掉的无用内容index
                        // 并跳出子循环
                        if (runText1.matches(reg5)
                                || (f < runs.size() - 1 && runText1.matches(reg4) && '}' == runs.get(f + 1).toString().charAt(0))) {
                            flag = true;
                            end = f;
                            break;
                        }
                    }
                    //去掉无用内容
                    if (end > start) {
                        for (int f = end; f > start; f--) {
                            para.removeRun(f);
                        }
                        //因为去掉无用内容后runs长度有变，需更改父循环index
                        i = start;
                    }
                }
            }
            //替换值
            if (flag) {
                key = key.replace("{", "").replace("}", "").trim();
                if (data.containsKey(key))
                    if(data.get(key)==null){
                        run.setText("", 0);
                    }else {
                        run.setText(data.get(key).toString(), 0);
                    }

                //清空key
                key = "";
                //修改flag
                flag = false;
            }
        }
    }
}
