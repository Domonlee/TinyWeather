package cn.domon.tinyweather.OKHttpTest;

import cn.domon.tinyweather.Constant;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Domon on 16-6-24.
 */
public class RestClient {
    private static RestClient instance = new RestClient();
    private ApiService api;

    private RestClient() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL+"/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(ApiService.class);
    }

    public static ApiService api() {
        return instance.api;
    }
}
