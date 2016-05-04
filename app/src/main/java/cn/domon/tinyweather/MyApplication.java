package cn.domon.tinyweather;

import android.app.Application;
import android.content.Context;
import android.util.Log;

/**
 * Created by Domon on 16-5-4.
 */
public class MyApplication extends Application {
    public static final String TAG = MyApplication.class.getSimpleName();

    private static MyApplication mInstance = null;

    private static Context mContext;

    public static MyApplication getInstance() {
        return mInstance;
    }

    public static Context getAppContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;

        mContext = getApplicationContext();

        init();

        Log.e(TAG, "APP is Init");
    }

    private void init() {
        //init volley
        VolleyRequestManager.init(mContext);
    }
}
