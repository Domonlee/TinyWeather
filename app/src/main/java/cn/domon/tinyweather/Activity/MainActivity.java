package cn.domon.tinyweather.Activity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.socks.library.KLog;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.domon.tinyweather.Constant;
import cn.domon.tinyweather.R;
import cn.domon.tinyweather.VolleyRequestManager;

public class MainActivity extends BaseActivity {
    public static final String TAG = MainActivity.class.getSimpleName();

    @Bind(R.id.myBtn1)
    Button mTestBtn1;
    @Bind(R.id.myBtn2)
    Button mTestBtn2;
    @Bind(R.id.myBtn3)
    Button mTestBtn3;
    @Bind(R.id.myBtn4)
    Button mTestBtn4;

    @OnClick(R.id.myBtn1)
    void onClickBtn1() {
        RequestQueue requestQueue = VolleyRequestManager.getRequestQueue();

        mRequest = new StringRequest(Request.Method.GET, Constant.CITY_ID + "CN101010100" + Constant.W_KEY,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        KLog.json(TAG, response);
                        KLog.e(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "request Error");
            }
        });

        requestQueue.add(mRequest);
    }

    @OnClick(R.id.myBtn2)
    void onClickBtn2() {
        RequestQueue requestQueue = VolleyRequestManager.getRequestQueue();

        mRequest = new StringRequest(Request.Method.GET, Constant.GET_AC_CITYLIST,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e(TAG, response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "request Error");
            }
        });

        requestQueue.add(mRequest);
    }

    @OnClick(R.id.myBtn3)
    void onClickBtn3() {
        RequestQueue requestQueue = VolleyRequestManager.getRequestQueue();

        mRequest = new StringRequest(Request.Method.GET, Constant.GET_AW_CITYLIST,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e(TAG, response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "request Error");
            }
        });

        requestQueue.add(mRequest);
    }

    @OnClick(R.id.myBtn4)
    void onClickBtn4() {
        RequestQueue requestQueue = VolleyRequestManager.getRequestQueue();

        mRequest = new StringRequest(Request.Method.GET, Constant.GET_HC_CITYLIST,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e(TAG, response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "request Error");
            }
        });

        requestQueue.add(mRequest);
    }


    private Context mContext;
    private StringRequest mRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;

        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
