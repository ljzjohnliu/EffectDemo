package com.ljz.effect.activity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.ljz.effect.R;

public class FrameAnimActivity extends AppCompatActivity {
    private Button testBtn;
    private ImageView framImg;
    private AnimationDrawable animDrawable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_frame);
        testBtn = findViewById(R.id.start_work);
        framImg = findViewById(R.id.fram_anim);
        animDrawable = (AnimationDrawable) framImg.getBackground();

        testBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animDrawable.start();
            }
        });
    }

}
