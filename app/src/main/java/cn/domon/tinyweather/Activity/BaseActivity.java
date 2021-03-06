package cn.domon.tinyweather.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;

import cn.domon.tinyweather.MyApplication;

/**
 * Created by Domon on 16-5-5.
 */
public class BaseActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        MyApplication.getInstance().addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MyApplication.getInstance().removeActivity(this);
    }
}
