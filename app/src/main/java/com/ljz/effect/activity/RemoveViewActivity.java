package com.ljz.effect.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.ljz.effect.R;

public class RemoveViewActivity extends AppCompatActivity implements View.OnClickListener {
    private Button rightBtn;
    private Button downBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_view);
        rightBtn = findViewById(R.id.remove_right);
        downBtn = findViewById(R.id.remove_down);

        rightBtn.setOnClickListener(this);
        downBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        LinearLayout.LayoutParams layoutParams;
        switch (id) {
            case R.id.remove_right:
                layoutParams = (LinearLayout.LayoutParams) rightBtn.getLayoutParams();
                layoutParams.leftMargin = rightBtn.getLeft()+100;
                rightBtn.setLayoutParams(layoutParams);
                break;
            case R.id.remove_down:
                layoutParams = (LinearLayout.LayoutParams) downBtn.getLayoutParams();
                layoutParams.topMargin = downBtn.getTop()+100;
                downBtn.setLayoutParams(layoutParams);
                break;
            default:
                break;
        }
    }
}
