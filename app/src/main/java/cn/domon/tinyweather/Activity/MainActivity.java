package cn.domon.tinyweather.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Window;
import android.widget.ListView;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import butterknife.Bind;
import butterknife.ButterKnife;
import cn.domon.tinyweather.R;

public class MainActivity extends BaseActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    private Context mContext;
    private StringRequest mRequest;
    Gson gson;

    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @Bind(R.id.left_drawer)
    ListView mDrawerList;

//    @OnClick(R.id.myBtn1)
//    void onClickBtn1() {
//        final RequestQueue requestQueue = VolleyRequestManager.getRequestQueue();
//
//        mRequest = new StringRequest(Request.Method.GET, Constant.CITY_ID + "CN101010100" + Constant.W_KEY,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
////                        KLog.json(TAG, response);
//                        WeatherInfoData weatherInfoData = gson.fromJson(response, WeatherInfoData.class);
//                        List<WeatherInfoData.HeBean> hebean = weatherInfoData.getHe();
//                        WeatherInfoData.HeBean.BasicBean basicBean = hebean.get(0).getBasic();
//                        String city = basicBean.getCity();
//                        KLog.e(TAG, weatherInfoData.toString());
//
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.e(TAG, "request Error");
//            }
//        });
//
//        requestQueue.add(mRequest);
//    }
//
//    @OnClick(R.id.myBtn2)
//    void onClickBtn2() {
//        RequestQueue requestQueue = VolleyRequestManager.getRequestQueue();
//
//        mRequest = new StringRequest(Request.Method.GET, Constant.GET_AC_CITYLIST,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        CityInfoListData cityInfoListData = gson.fromJson(response, CityInfoListData.class);
//                        List<CityInfoData> cityInfoData = cityInfoListData.getCity_info();
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.e(TAG, "request Error:" + error);
//            }
//        });
//
//        requestQueue.add(mRequest);
//    }
//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        mContext = this;

        ButterKnife.bind(this);
        gson = new Gson();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
