package cn.domon.tinyweather;

/**
 * Created by Domon on 16-5-4.
 */
public class Constant {
    public static final String W_KEY = "&key=f15e8ad833184f8bb4de0babee5872b9";

    public static final String BASE_URL = "https://api.heweather.com/x3";
    public static final String BASE_CITY = BASE_URL + "/weather?";

    public static final String CITY_ID = BASE_CITY + "cityid=";
    public static final String CITY_IP = BASE_CITY + "cityip=";

    public static final String GET_AC_CITYLIST = BASE_URL + "/citylist?search=" + "allchina" + W_KEY;
    public static final String GET_AW_CITYLIST = BASE_URL + "/citylist?search=" + "allworld" + W_KEY;
    public static final String GET_HC_CITYLIST = BASE_URL + "/citylist?search=" + "hotworld" + W_KEY;


}
