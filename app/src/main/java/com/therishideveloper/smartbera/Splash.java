package com.therishideveloper.smartbera;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {

    ProgressBar progressBar;
    public int progress;
    ImageView logo;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_splash);

        progressBar = findViewById(R.id.pro);
        logo = findViewById(R.id.b_logo);

        animation = AnimationUtils.loadAnimation(Splash.this, R.anim.fade_in);
        logo.startAnimation(animation);

        Thread thread = new Thread(() -> {
            dowork();
            startapp();
        });
        thread.start();
    }

    public void dowork() {

        for (progress = 30; progress <= 100; progress = progress + 30) {


            try {
                Thread.sleep(1000);
                progressBar.setProgress(progress);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    public void startapp() {
        Intent myIntent = new Intent(Splash.this, MainActivity.class);
        startActivity(myIntent);
    }
}