package com.ljz.effect.activity;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.rastermill.FrameSequenceDrawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.humrousz.sequence.view.AnimatedImageView;
import com.ljz.effect.R;

import java.io.IOException;
import java.io.InputStream;

public class WebpAnimActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "WebpAnimActivity";
    AnimatedImageView mGoogleImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_webp);

        mGoogleImage = findViewById(R.id.google_sequence_image);

        findViewById(R.id.asset_btn).setOnClickListener(this);
        findViewById(R.id.drawable_btn).setOnClickListener(this);
        findViewById(R.id.uri_btn).setOnClickListener(this);
        findViewById(R.id.google_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.asset_btn:
                setImage(TYPE_ASSETS);
                break;
            case R.id.drawable_btn:
                setImage(TYPE_DRAWABLE);
                break;
            case R.id.uri_btn:
                setImage(TYPE_URI);
                break;
            case R.id.google_btn:
                playWebpUseGoogle();
                break;
            case R.id.all_tween_btn:
                break;
            case R.id.time_tween_btn:
                return;
            default:
                return;
        }
    }

    private static final int TYPE_ASSETS = 0;
    private static final int TYPE_DRAWABLE = 1;
    private static final int TYPE_URI = 2;

    private void setImage(@NonNull int type) {
        //设置重复次数
        mGoogleImage.setLoopCount(1);
        //重复行为默认 根据webp图片循环次数决定
        mGoogleImage.setLoopDefault();
        //重复行为无限
        mGoogleImage.setLoopInf();
        //重复行为为指定  跟setLoopCount有关
        mGoogleImage.setLoopFinite();
        switch (type) {
            case TYPE_ASSETS:
                //设置Assets下的图片
//                mGoogleImage.setImageResourceFromAssets("newyear.webp");
                mGoogleImage.setImageResourceFromAssets("donghua.gif");
                break;
            case TYPE_DRAWABLE:
                //设置图片通过drawable
                mGoogleImage.setImageResource(R.drawable.dainiqukanyinghuayu);
                break;
            case TYPE_URI:
//                Uri uri = Uri.parse("file:" + Environment.getExternalStorageDirectory().toString() + "/dainiqukanyinghuayu.webp");
                //通过添加"file:"协议，可以展示指定路径的图片，如例子中的本地资源
                Uri uri = Uri.parse("http://10.5.150.132/dainiqukanyinghuayu.webp");
                Log.d(TAG, "setImage: uri = " + uri);
                mGoogleImage.setImageURI(uri);
                break;
        }
    }

    private void playWebpUseGoogle() {
        ImageView mImage = findViewById(R.id.webp_img);
        InputStream in = null;
        try {
//            in = getResources().getAssets().open("dainiqukanyinghuayu.webp");
            in = getResources().getAssets().open("donghua.gif");
        } catch (IOException e) {
            e.printStackTrace();
        }
        final FrameSequenceDrawable drawable = new FrameSequenceDrawable(in);
        drawable.setLoopCount(1);
        drawable.setLoopBehavior(FrameSequenceDrawable.LOOP_FINITE);
        drawable.setOnFinishedListener(new FrameSequenceDrawable.OnFinishedListener() {
            @Override
            public void onFinished(FrameSequenceDrawable frameSequenceDrawable) {

            }
        });
        mImage.setImageDrawable(drawable);
    }
}
