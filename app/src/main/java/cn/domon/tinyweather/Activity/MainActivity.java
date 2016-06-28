package cn.domon.tinyweather.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.domon.tinyweather.Constant;
import cn.domon.tinyweather.Data.WeatherInfoData;
import cn.domon.tinyweather.R;
import cn.domon.tinyweather.Utils.CommUtil;
import cn.domon.tinyweather.VolleyRequestManager;

public class MainActivity extends BaseActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String WEATHER_REQ_URL = Constant.CITY_ID + "CN101010100" + Constant.W_KEY;
    private static final int HANDLER_OK = 1;
    private Context mContext;
    private StringRequest mRequest;
    private WeatherInfoData.HeBean.BasicBean mBasicBean;
    private List<WeatherInfoData.HeBean.DailyForecastBean> mDailyForecastBean;
    private List<WeatherInfoData.HeBean.HourlyForecastBean> mHourlyForecastBeen = new ArrayList<>();
    private WeatherInfoData.HeBean.NowBean mNowBeen;
    private WeatherInfoData.HeBean.SuggestionBean mSuggestionBean;
    private RecyclerViewAdapter mAdapter;
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

    @OnClick(R.id.title_add_iv)
    void OnClickAddBtn() {
        Intent intent = new Intent(this, CityListActivity.class);
        startActivity(intent);
    }

    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case HANDLER_OK:
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
//        KLog.e(intent.getStringExtra(NetUtil.IP_ADDRESS));

        ButterKnife.bind(this);
        mContext = this;
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 5));

        gson = new Gson();

        reqForWeatherInfo();
        mAdapter = new RecyclerViewAdapter(mContext, mHourlyForecastBeen);
        mRecyclerView.setAdapter(mAdapter);
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
                            mBasicBean = heBean.getBasic();
                            mDailyForecastBean = heBean.getDaily_forecast();
                            List<WeatherInfoData.HeBean.HourlyForecastBean> hourlyForecastBeens = heBean.getHourly_forecast();
                            mNowBeen = heBean.getNow();
                            mSuggestionBean = heBean.getSuggestion();
                            //TODO asyn
                            KLog.e("get url", WEATHER_REQ_URL);

                            mMainTmpTv.setText(mNowBeen.getTmp() + "℃");
                            mUpdateTimeTv.setText("最后更新时间：" + mBasicBean.getUpdate().getLoc());
                            mWindTv.setText(mNowBeen.getWind().getSc() + "级");
                            mHumidityTv.setText(mNowBeen.getHum() + "%");

                            //not used
                            Message message = Message.obtain();
                            message.what = HANDLER_OK;
                            mHandler.sendMessage(message);

                            mHourlyForecastBeen.clear();
                            mHourlyForecastBeen.addAll(hourlyForecastBeens);
                            mAdapter.notifyItemInserted(0);
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
