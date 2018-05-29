package com.mry.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by XY on 2017/4/14.
 */
public class CharReplaceUtil {

    public static  String charReplace(String sql,Map data){
        String regex = "\\{(.+?)\\}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sql);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            String name = matcher.group(1);//键名
            String value = (String) data.get(name);//键值
            if (value == null) {
                value = "";
            } else {
                value = value.replaceAll("\\$", "\\\\\\$");
            }
            matcher.appendReplacement(sb, value);
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    public static Map<String, String> parseJSONDataToMap(String data){
        GsonBuilder gb = new GsonBuilder();
        Gson g = gb.create();
        Map<String, String> map = g.fromJson(data, new TypeToken<Map<String, String>>() {}.getType());
        return map;
    }

}
