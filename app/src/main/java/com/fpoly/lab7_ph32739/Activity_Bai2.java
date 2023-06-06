package com.fpoly.lab7_ph32739;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity_Bai2 extends AppCompatActivity {
    Button btnFast;
    Button btnMedium;
    Button btnSlow;
    Button btnOff;
    ImageView view;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = findViewById(R.id.fan);

        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation_fan);
        view.startAnimation(animation);
        animation.setInterpolator(new LinearInterpolator());


        btnFast = findViewById(R.id.btn_fast);
        btnMedium = findViewById(R.id.btn_medium);
        btnSlow = findViewById(R.id.btn_slow);
        btnOff = findViewById(R.id.btn_TurnOffFan);
        animation.setDuration(2000);
        btnFast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                animation.setDuration(100);
                view.startAnimation(animation);

            }
        });

        btnMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                animation.setDuration(1000);
                view.setAnimation(animation);

            }
        });

        btnSlow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                animation.setDuration(10000);
                view.setAnimation(animation);
            }
        });

        btnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CancelAni(view);
            }
        });

    }

    private void CancelAni(View view) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                view.getAnimation().cancel();
                view.clearAnimation();
                animation.setAnimationListener(null);

            }
        };
        runnable.run();
    }
}