package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class splashScreen extends AppCompatActivity {

    private static int sure=3090;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Animation ani= AnimationUtils.loadAnimation(this,R.anim.animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent gecis=new Intent(splashScreen.this,MainActivity2.class);
                startActivity(gecis);
                finish();
            }
        },sure);
    }
}