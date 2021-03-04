package com.learning.android.seoguidesimplifiedversion;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class LaunchActivity extends AppCompatActivity {

    private ImageView im_logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        im_logo = findViewById(R.id.logo);
        im_logo.setAlpha(0f);
        // 1.0 means fully opaque and 0.0 means fully transparent
        im_logo.animate().setDuration(2500).alpha(1f).withEndAction(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(com.learning.android.seoguidesimplifiedversion.LaunchActivity.this,WelcomeActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();
            }
        });

        /*
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        })
        */

    }
}