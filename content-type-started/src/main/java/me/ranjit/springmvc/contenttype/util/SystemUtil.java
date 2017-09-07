package me.ranjit.springmvc.contenttype.util;

/**
 * Created by suzh on 9/7/2017.
 */
public class SystemUtil {

    public static String echoSystemDefaultEncoding() {
        String encoding = System.getProperty("file.encoding");
        System.out.println("Default System Encoding:" + encoding);
        return encoding;
    }
}
