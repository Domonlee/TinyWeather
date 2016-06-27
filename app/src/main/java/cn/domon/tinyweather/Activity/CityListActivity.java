package cn.domon.tinyweather.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.socks.library.KLog;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.domon.tinyweather.Constant;
import cn.domon.tinyweather.Data.CityInfoListData;
import cn.domon.tinyweather.R;
import cn.domon.tinyweather.VolleyRequestManager;

/**
 * Created by Domon on 16-6-26.
 */
public class CityListActivity extends BaseActivity {
    private StringRequest mStringRequest;
    private Context mContext;
    public static final String CITYINFO_REQ_URL = Constant.CITY_ID + "CN101010100" + Constant.W_KEY;

    @Bind(R.id.citylist_rv)
    RecyclerView mCityListRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citylist);
        ButterKnife.bind(this);
        mContext = this;

        mCityListRv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        RequestQueue requestQueue = VolleyRequestManager.getRequestQueue();
        mStringRequest = new StringRequest(Request.Method.GET, Constant.GET_AC_CITYLIST,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        KLog.e(response);
                        Gson gson = new Gson();
                        CityInfoListData cityInfoListData = gson.fromJson(response, CityInfoListData.class);
                        mCityListRv.setAdapter(new RecyclerViewAdapter(mContext, cityInfoListData));

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        requestQueue.add(mStringRequest);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CityListViewHolder> {
        private Context context;
        private LayoutInflater layoutInflater;
        private CityInfoListData cityInfoListData;

        public RecyclerViewAdapter(Context context, CityInfoListData cityInfoListData) {
            this.context = context;
            this.layoutInflater = LayoutInflater.from(context);
            this.cityInfoListData = cityInfoListData;
        }

        @Override
        public CityListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new CityListViewHolder(layoutInflater.inflate(R.layout.cityinfo_item, parent, false));
        }

        @Override
        public void onBindViewHolder(CityListViewHolder holder, int position) {

            holder.mCityNametv.setText(cityInfoListData.getCity_info().toString());

        }

        @Override
        public int getItemCount() {
            return cityInfoListData.getCity_info().size();
        }

        public class CityListViewHolder extends RecyclerView.ViewHolder {
            @Bind(R.id.citylist_name_tv)
            TextView mCityNametv;

            public CityListViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }
        }

    }

}
