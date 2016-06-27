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
import com.cnxad.jar.jicommon.ToastUtil;
import com.google.gson.Gson;
import com.socks.library.KLog;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.domon.tinyweather.Constant;
import cn.domon.tinyweather.Data.CityInfoData;
import cn.domon.tinyweather.Data.CityInfoListData;
import cn.domon.tinyweather.R;
import cn.domon.tinyweather.VolleyRequestManager;

/**
 * Created by Domon on 16-6-26.
 */
public class CityListActivity extends BaseActivity {
    private StringRequest mStringRequest;
    private Context mContext;
    private RecyclerViewAdapter mAdapter;
    private List<CityInfoData> cityInfoDatas;

    @Bind(R.id.citylist_rv)
    RecyclerView mCityListRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citylist);

        ButterKnife.bind(this);
        mContext = this;

        mCityListRv.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new RecyclerViewAdapter(mContext, cityInfoDatas);
        mCityListRv.setAdapter(mAdapter);

        reqForCityListInfo();
    }

    private void reqForCityListInfo() {
        RequestQueue requestQueue = VolleyRequestManager.getRequestQueue();
        mStringRequest = new StringRequest(Request.Method.GET, Constant.GET_AC_CITYLIST,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        CityInfoListData cityInfoListData = gson.fromJson(response, CityInfoListData.class);
                        if (cityInfoListData.getStatus().equals("ok")) {
                            cityInfoDatas = cityInfoListData.getCity_info();
                            mAdapter.notifyDataSetChanged();
                        }
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
        private List<CityInfoData> cityInfoDatas;

        public RecyclerViewAdapter(Context context, List<CityInfoData> cityInfoListData) {
            this.context = context;
            this.layoutInflater = LayoutInflater.from(context);
            this.cityInfoDatas = cityInfoListData;
        }

        @Override
        public CityListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new CityListViewHolder(layoutInflater.inflate(R.layout.cityinfo_item, parent, false));
        }

        @Override
        public void onBindViewHolder(CityListViewHolder holder, int position) {
            holder.mCityNametv.setText(cityInfoDatas.get(position).getCity());
            KLog.e("cityId", cityInfoDatas.get(position).getId());
        }

        @Override
        public int getItemCount() {
            return cityInfoDatas == null ? 0 : cityInfoDatas.size();
        }

        public class CityListViewHolder extends RecyclerView.ViewHolder {
            @Bind(R.id.citylist_name_tv)
            TextView mCityNametv;

            public CityListViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);

                mCityNametv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ToastUtil.showToast(context, mCityNametv.getText().toString());
                    }
                });
            }
        }
    }
}
