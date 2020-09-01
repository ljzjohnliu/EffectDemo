package com.ljz.effect.activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ljz.effect.R;

public class ObjectAnimActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "ObjectAnimActivity";
    private ImageView objectImg;
    private ObjectAnimator animator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_object);
        objectImg = findViewById(R.id.object_anim);

        findViewById(R.id.translate_btn).setOnClickListener(this);
        findViewById(R.id.scale_btn).setOnClickListener(this);
        findViewById(R.id.rotate_btn).setOnClickListener(this);
        findViewById(R.id.alpha_btn).setOnClickListener(this);
        findViewById(R.id.all_object_btn).setOnClickListener(this);
        findViewById(R.id.time_object_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.translate_btn:
                //在2s内，沿x轴左移300个像素
//                animator = ObjectAnimator.ofFloat(objectImg, "translationX", 0f, -300f);
                //在2s内，沿x轴左移300个像素，然后再右移300个像素
                animator = ObjectAnimator.ofFloat(objectImg, "translationX", 0f, -300f, 0f);
                animator.setDuration(2000);
                break;
            case R.id.scale_btn:
                //在2s内，沿x轴放大成原来的两倍。
//                animator = ObjectAnimator.ofFloat(objectImg, "scaleX", 1f, 2f);
                //在2s内，沿x轴放大成原来的两倍，然后缩小会原样。
                animator = ObjectAnimator.ofFloat(objectImg, "scaleX", 1f, 2f, 1f);
                animator.setDuration(2000);
                break;
            case R.id.rotate_btn:
                //在2s内，顺时针旋转360度
//                animator = ObjectAnimator.ofFloat(objectImg, "rotation", 0f, 360f);
                //在2s内，顺时针旋转360度，然后再逆时针旋转360度。
                animator = ObjectAnimator.ofFloat(objectImg, "rotation", 0f, 360f, 0f);
                animator.setDuration(2000);
                break;
            case R.id.alpha_btn:
                //透明度起始为1，结束时为0
                animator = ObjectAnimator.ofFloat(objectImg, "alpha", 1f, 0f);
                //在2s内，将imageView的透明度从1变成0然后再变成1。
//                animator = ObjectAnimator.ofFloat(objectImg, "alpha", 1f, 0f, 1f);
                animator.setDuration(2000);//时间2s
                animator.setRepeatCount(-1);//count为重复次数，-1表示一直重复。
                break;
            case R.id.all_object_btn:
                //在3s内，沿x、y轴同时放大，然后缩小，在缩放的同时还要改变透明度。然后再完成3s的左右移动。
                //沿x轴放大
                ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(objectImg, "scaleX", 1f, 2f, 1f);
                //沿y轴放大
                ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(objectImg, "scaleY", 1f, 2f, 1f);
                //移动
                ObjectAnimator translationXAnimator = ObjectAnimator.ofFloat(objectImg, "translationX", 0f, 200f, 0f);
                //透明动画
                ObjectAnimator animator = ObjectAnimator.ofFloat(objectImg, "alpha", 1f, 0f, 1f);
                AnimatorSet set = new AnimatorSet();
                //同时沿X,Y轴放大，且改变透明度，然后移动
                set.play(scaleXAnimator).with(scaleYAnimator).with(animator).before(translationXAnimator);
                //都设置3s，也可以为每个单独设置
                set.setDuration(3000);
                set.start();
                return;
            case R.id.time_object_btn:
                //在3s内，沿x、y轴同时放大，然后缩小，在缩放的同时还要改变透明度。然后再完成3s的左右移动。
                //沿x轴放大
                ObjectAnimator scaleXAnimator2 = ObjectAnimator.ofFloat(objectImg, "scaleX", 1f, 2f, 1f);
                //沿y轴放大
                ObjectAnimator scaleYAnimator2 = ObjectAnimator.ofFloat(objectImg, "scaleY", 1f, 2f, 1f);
                //移动
                ObjectAnimator translationXAnimator2 = ObjectAnimator.ofFloat(objectImg, "translationX", 0f, 200f, 0f);
                //透明动画
                ObjectAnimator animator2 = ObjectAnimator.ofFloat(objectImg, "alpha", 1f, 0f, 1f);
                AnimatorSet set2 = new AnimatorSet();
                //先沿X轴放大，再沿着Y轴放大，同时改变透明度，同时移动(后三个动画都是基于X放大的，都是在X放大后执行);并不是按照先X 再Y 再透明度 再平移顺序执行
                set2.play(scaleXAnimator2).before(scaleYAnimator2).before(animator2).before(translationXAnimator2);
                //都设置3s，也可以为每个单独设置
//                set2.setDuration(3000);
                scaleXAnimator2.setDuration(1000);
                scaleYAnimator2.setDuration(1000);
                animator2.setDuration(2000);
                translationXAnimator2.setDuration(3000);
                set2.start();
                return;
            default:
                return;
        }
        if (animator != null) {
            animator.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                    Log.d(TAG, "onAnimationStart: ");
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    Log.d(TAG, "onAnimationEnd: ");
                }

                @Override
                public void onAnimationCancel(Animator animation) {
                    Log.d(TAG, "onAnimationCancel: ");
                }

                @Override
                public void onAnimationRepeat(Animator animation) {
                    Log.d(TAG, "onAnimationRepeat: ");
                }
            });
            animator.start();
        } else {
            Toast.makeText(ObjectAnimActivity.this, "没有选择任何补间动画类型", Toast.LENGTH_SHORT).show();
        }

    }
}
