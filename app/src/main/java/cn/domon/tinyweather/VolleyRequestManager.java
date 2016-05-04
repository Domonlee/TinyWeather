package cn.domon.tinyweather;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Domon on 16-5-4.
 */
public class VolleyRequestManager {
    private static RequestQueue mRequestQueue;

    private VolleyRequestManager() {

    }

    public static void init(Context context) {
        mRequestQueue = Volley.newRequestQueue(context);
    }

    public static RequestQueue getRequestQueue() {
        if (mRequestQueue != null) {
            return mRequestQueue;
        } else {
            throw new IllegalStateException("Volley Not initialized");
        }
    }
}
