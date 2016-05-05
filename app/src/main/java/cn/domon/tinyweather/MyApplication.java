package cn.domon.tinyweather;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Log;

import java.util.Stack;

/**
 * Created by Domon on 16-5-4.
 */
public class MyApplication extends Application {
    public static final String TAG = MyApplication.class.getSimpleName();

    private static MyApplication mInstance = null;

    private static Context mContext;

    private Stack<Activity> mActivityStack;

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

    public void addActivity(Activity activity) {
        if (mActivityStack == null) {
            mActivityStack = new Stack<>();
        }
        mActivityStack.add(activity);
    }

    public void removeActivity(Activity activity) {
        if (mActivityStack == null) {
            return;
        }
        mActivityStack.remove(activity);
        activity.finish();
        activity = null;
    }

    public Activity currentActivity() {
        if (mActivityStack == null) {
            return null;
        }
        return mActivityStack.lastElement();
    }

    public void finishLastActivity() {
        if (mActivityStack == null) {
            return;
        }
        Activity activity = mActivityStack.lastElement();
        removeActivity(activity);
    }

    public void finishAllActivity() {
        if (mActivityStack == null) {
            return;
        }

        for (int i = 0, size = mActivityStack.size(); i < size; i++) {
            if (null != mActivityStack.get(i)) {
                if (!mActivityStack.get(i).isFinishing()) {
                    mActivityStack.get(i).finish();
                }
            }
        }

        mActivityStack.clear();
    }

    private void init() {
        //init volley
        VolleyRequestManager.init(mContext);
    }
}
