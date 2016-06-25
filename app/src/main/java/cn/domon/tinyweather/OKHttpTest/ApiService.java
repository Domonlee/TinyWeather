package cn.domon.tinyweather.OKHttpTest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Domon on 16-6-24.
 */
public interface ApiService {

    //https://api.heweather.com/x3/weather?cityid=CN101010100&key=f15e8ad833184f8bb4de0babee5872b9

    @GET("weather")
    Call<ReceiveData.WeatherInfoResponse> weatherInfo(@Query("cityid") String cityId,
                                                      @Query("key") String key);

    @GET("weather")
    Call<String> test(@Query("cityid") String cityId,
                      @Query("key") String key);

}
