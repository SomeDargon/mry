package com.mry.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author vito
 * @version 1.0 2016/12/18
 */
public class ExceptionUtil {
    public static String getExceptionMessage(Throwable throwable) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        throwable.printStackTrace(pw);
        pw.flush();
        sw.flush();
        String res = sw.toString();
        try {
            pw.close();
            sw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
}
