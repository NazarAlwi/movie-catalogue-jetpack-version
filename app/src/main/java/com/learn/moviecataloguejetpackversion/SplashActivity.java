package com.learn.moviecataloguejetpackversion;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    ImageView imgLogoSplash;
    TextView tvGetStarted;
    Animation fromBottom;
    Animation fromTop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        imgLogoSplash = findViewById(R.id.img_logo_splash);
        tvGetStarted = findViewById(R.id.tv_get_started);
        fromBottom = AnimationUtils.loadAnimation(this, R.anim.from_bottom);
        fromTop = AnimationUtils.loadAnimation(this, R.anim.from_top);

        tvGetStarted.setAnimation(fromBottom);
        imgLogoSplash.setAnimation(fromTop);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 4000);
    }
}
