package cn.domon.tinyweather.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.socks.library.KLog;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.domon.tinyweather.Constant;
import cn.domon.tinyweather.Data.WeatherInfoData;
import cn.domon.tinyweather.R;
import cn.domon.tinyweather.Utils.CommUtil;
import cn.domon.tinyweather.Utils.NetUtil;
import cn.domon.tinyweather.VolleyRequestManager;

public class MainActivity extends BaseActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    public static final String WEATHER_REQ_URL = Constant.CITY_ID + "CN101010100" + Constant.W_KEY;
    private Context mContext;
    private StringRequest mRequest;
    private WeatherInfoData.HeBean.BasicBean basicBean;
    private List<WeatherInfoData.HeBean.DailyForecastBean> dailyForecastBean;
    private List<WeatherInfoData.HeBean.HourlyForecastBean> hourlyForecastBeen;
    private WeatherInfoData.HeBean.NowBean nowBeen;
    private WeatherInfoData.HeBean.SuggestionBean suggestionBean;
    Gson gson;

    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @Bind(R.id.left_drawer)
    ListView mDrawerList;
    @Bind(R.id.hours_rv)
    RecyclerView mRecyclerView;
    @Bind(R.id.main_tmp_tv)
    TextView mMainTmpTv;
    @Bind(R.id.main_updatetime_tv)
    TextView mUpdateTimeTv;
    @Bind(R.id.humidity_tv)
    TextView mHumidityTv;
    @Bind(R.id.wind_tv)
    TextView mWindTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        KLog.e(intent.getStringExtra(NetUtil.IP_ADDRESS));

        ButterKnife.bind(this);
        mContext = this;
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 5));

        gson = new Gson();

        reqForWeatherInfo();
        mRecyclerView.setAdapter(new RecyclerViewAdapter(mContext, hourlyForecastBeen));
//        mMainTmpTv.setText(nowBeen.getTmp());
    }

    private void reqForWeatherInfo() {
        RequestQueue requestQueue = VolleyRequestManager.getRequestQueue();
        mRequest = new StringRequest(Request.Method.GET, WEATHER_REQ_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        WeatherInfoData weatherInfoData = gson.fromJson(response, WeatherInfoData.class);
                        List<WeatherInfoData.HeBean> hebeans = weatherInfoData.getHe();
                        WeatherInfoData.HeBean heBean = hebeans.get(0);

                        if (heBean.getStatus().equals("ok")) {
                            basicBean = heBean.getBasic();
                            dailyForecastBean = heBean.getDaily_forecast();
                            hourlyForecastBeen = heBean.getHourly_forecast();
                            nowBeen = heBean.getNow();
                            suggestionBean = heBean.getSuggestion();
                            KLog.e("status", heBean.getStatus());
                            //TODO asyn
                            KLog.e("get url", WEATHER_REQ_URL);
                            mMainTmpTv.setText(nowBeen.getTmp() + "℃");
                            mUpdateTimeTv.setText("最后更新时间：" + basicBean.getUpdate().getLoc());
                            mWindTv.setText(nowBeen.getWind().getSc() + "级");
                            mHumidityTv.setText(nowBeen.getHum() + "%");
                            KLog.e("time", CommUtil.getTimeForDataString(hourlyForecastBeen.get(0).getDate()));
                            mRecyclerView.setAdapter(new RecyclerViewAdapter(mContext, hourlyForecastBeen));


                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "request Error");
            }
        });

        requestQueue.add(mRequest);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.HourItemViewHolder> {

        private Context context;
        private LayoutInflater layoutInflater;
        private List<WeatherInfoData.HeBean.HourlyForecastBean> hourlyForecastBeans;

        public RecyclerViewAdapter(Context context, List<WeatherInfoData.HeBean.HourlyForecastBean> hourlyForecastBean) {
            this.context = context;
            this.layoutInflater = LayoutInflater.from(context);
            this.hourlyForecastBeans = hourlyForecastBean;
        }

        @Override
        public HourItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new HourItemViewHolder(layoutInflater.inflate(R.layout.hours_item, parent, false));
        }

        @Override
        public void onBindViewHolder(HourItemViewHolder holder, int position) {
            //TODO
            holder.dailyHourTv.setText(CommUtil.getTimeForDataString(hourlyForecastBeans.get(position).getDate()));
            holder.dailyTempTv.setText(hourlyForecastBeans.get(position).getTmp() + "℃");


        }

        @Override
        public int getItemCount() {
            return hourlyForecastBeans == null ? 0 : hourlyForecastBeans.size();
        }

        public class HourItemViewHolder extends RecyclerView.ViewHolder {
            @Bind(R.id.daily_hour_tv)
            TextView dailyHourTv;
            @Bind(R.id.daily_temp_tv)
            TextView dailyTempTv;
            @Bind(R.id.daily_weather_iv)
            ImageView dailyWeatherIv;

            public HourItemViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }
        }
    }
}
