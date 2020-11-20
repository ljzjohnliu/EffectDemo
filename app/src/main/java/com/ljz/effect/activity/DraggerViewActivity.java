package com.ljz.effect.activity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ljz.effect.R;

public class DraggerViewActivity extends AppCompatActivity {
    private static final String TAG = "DraggerViewActivity";
    private Button testBtn;

    private TextView clickTv;
    private ImageView guideImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_radius);

        final FrameLayout frameLayout = findViewById(R.id.frame);
        testBtn = findViewById(R.id.get_layout);
        clickTv = findViewById(R.id.test_click);
        guideImg = findViewById(R.id.test_guide);

        WebView webView = new WebView(this);
        webView.loadUrl("www.baidu.com");
        frameLayout.addView(webView);

        clickTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: ******************clickTv***************");
            }
        });
        
        testBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: 11 testBtn width = " + testBtn.getWidth() + ", height = " + testBtn.getHeight());
                Log.d(TAG, "onClick: 22 testBtn width = " + px2dip(DraggerViewActivity.this, testBtn.getWidth()) + ", height = " + px2dip(DraggerViewActivity.this, testBtn.getHeight()));

                Log.d(TAG, "onClick: 33 testBtn getParent = " + testBtn.getParent());
//                FrameLayout frameLayout = (FrameLayout)testBtn.getParent();

                //measure方法的参数值都设为0即可
//                frameLayout.measure(0,0);
                //获取组件宽度
                int width = frameLayout.getMeasuredWidth();
                //获取组件高度
                int height = frameLayout.getMeasuredHeight();
                Log.d(TAG, "onClick: frameLayout width = " + width + ", height = " + height);
            }
        });
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int)(pxValue / scale + 0.5f);
    }
}
