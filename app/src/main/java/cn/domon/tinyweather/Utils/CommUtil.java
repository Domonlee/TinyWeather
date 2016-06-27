package cn.domon.tinyweather.Utils;

/**
 * Created by Domon on 16-6-26.
 */
public class CommUtil {

    public static String getTimeForDataString(String s) {
        String[] dataStrs = s.split(" ");
        return dataStrs[1];
    }
}
