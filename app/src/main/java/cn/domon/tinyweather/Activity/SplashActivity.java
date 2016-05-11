package cn.domon.tinyweather.Activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.domon.tinyweather.Constant;
import cn.domon.tinyweather.R;
import cn.domon.tinyweather.VolleyRequestManager;

/**
 * Created by Domon on 16-5-11.
 */
public class SplashActivity extends Activity {
    @Bind(R.id.loading_iv)
    ImageView mLoadingIv;

    private StringRequest mRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        initImage();
    }

    //TODO save img
    private void initImage() {
        File dir = getFilesDir();
        final File imgFile = new File(dir, "start.jpg");

        if (imgFile.exists()) {
            mLoadingIv.setImageBitmap(BitmapFactory.decodeFile(imgFile.getAbsolutePath()));
        } else {
            mLoadingIv.setImageResource(R.mipmap.start);
        }

        final ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.2f, 1.0f, 1.2f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(3000);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                final RequestQueue requestQueue = VolleyRequestManager.getRequestQueue();

                mRequest = new StringRequest(Constant.GET_ZHDAILY_SATRT, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String url = jsonObject.optString("img");

                            stratActivity();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

                requestQueue.add(mRequest);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mLoadingIv.startAnimation(scaleAnimation);
    }

    private void stratActivity() {
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
