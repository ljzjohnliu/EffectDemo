package com.ljz.effect.activity;

import android.animation.Animator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ljz.effect.R;

public class TweenAnimActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "TweenAnimActivity";
    private ImageView tweenImg;
    private Animation animation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_tween);
        tweenImg = findViewById(R.id.tween_anim);

        findViewById(R.id.translate_btn).setOnClickListener(this);
        findViewById(R.id.scale_btn).setOnClickListener(this);
        findViewById(R.id.rotate_btn).setOnClickListener(this);
        findViewById(R.id.alpha_btn).setOnClickListener(this);
        findViewById(R.id.all_tween_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.translate_btn:
                animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate_animation);
                break;
            case R.id.scale_btn:
                animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale_animation);
                break;
            case R.id.rotate_btn:
                animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_animation);
                break;
            case R.id.alpha_btn:
                animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha_animation);
                break;
            case R.id.all_tween_btn:
                animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.all_tween_animation);
                break;
            default:
                return;
        }
        if (animation != null) {
            animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    Log.d(TAG, "onAnimationStart: start!");
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    Log.d(TAG, "onAnimationEnd: end!");
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                    Log.d(TAG, "onAnimationRepeat: repeat!");
                }
            });
        }
        if (animation != null) {
            tweenImg.startAnimation(animation);
        } else {
            Toast.makeText(TweenAnimActivity.this, "没有选择任何补间动画类型", Toast.LENGTH_SHORT).show();
        }

    }
}
