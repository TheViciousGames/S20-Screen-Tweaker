package com.theviciousgames.s20screentweaker.UI;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.theviciousgames.s20screentweaker.R;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SplashScreen extends AppCompatActivity {
    private TextView splashScreenTitleText, websiteText, appVerText;
    private WindowInsetsController insetsController;
    private Animation topAnimation, bottomAnimation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        forceFullscreen();
        declareVars();
        startMainActivity();
        setAnim();

    }

    protected void declareVars() {

        splashScreenTitleText = findViewById(R.id.splashScreenTitle);
        websiteText = findViewById(R.id.splashScreenWebsiteText);
        appVerText = findViewById(R.id.splashScreenAppVer);
        topAnimation = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);


    }

    protected void forceFullscreen() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            final WindowInsetsController insetsController = getWindow().getInsetsController();
            if (insetsController != null) {
                insetsController.hide(WindowInsets.Type.statusBars());
            }
        } else {
            getWindow().setFlags(
                    WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN
            );
        }
    }
    
    protected void setAnim() {
        splashScreenTitleText.setAnimation(bottomAnimation);
        websiteText.setAnimation(topAnimation);
        appVerText.setAnimation(topAnimation);
    }

    protected void startMainActivity() {
        final ScheduledExecutorService worker = Executors.newSingleThreadScheduledExecutor();
        Runnable runnable = new Runnable() {
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        };
        worker.schedule(runnable, 1, TimeUnit.SECONDS);
    }
}