package com.ljz.effect.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ljz.effect.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        findViewById(R.id.frame_anim_btn).setOnClickListener(this);
        findViewById(R.id.tween_anim_btn).setOnClickListener(this);
        findViewById(R.id.object_anim_btn).setOnClickListener(this);
        findViewById(R.id.async_btn).setOnClickListener(this);
        findViewById(R.id.handle_btn).setOnClickListener(this);
        findViewById(R.id.thread_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        Intent intent = new Intent();
        switch (id) {
            case R.id.frame_anim_btn:
                intent.setClassName("com.ljz.effect", "com.ljz.effect.activity.FrameAnimActivity");
                break;
            case R.id.tween_anim_btn:
                intent.setClassName("com.ljz.effect", "com.ljz.effect.activity.TweenAnimActivity");
                break;
            case R.id.object_anim_btn:
                intent.setClassName("com.ljz.effect", "com.ljz.effect.activity.ObjectAnimActivity");
                break;
            case R.id.async_btn:
                break;
            case R.id.handle_btn:
                break;
            case R.id.thread_btn:
                break;
            default:
                return;
        }
        try {
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(mContext, "没有有效的跳转页面", Toast.LENGTH_SHORT).show();
        }
    }
}
