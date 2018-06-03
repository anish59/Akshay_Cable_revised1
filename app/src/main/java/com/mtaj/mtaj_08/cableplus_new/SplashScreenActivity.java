package com.mtaj.mtaj_08.cableplus_new;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.mtaj.mtaj_08.cableplus_new.helpers.Utils;

public class SplashScreenActivity extends AppCompatActivity {

    private android.widget.ImageView imageView;
    private static final String PREF_NAME = "LoginPref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        this.imageView = (ImageView) findViewById(R.id.imageView);
        setLayoutAnimations();

    }

    private void setLayoutAnimations() {
        Utils.animateFadeView(this, imageView, 3, new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {


            }


            @Override
            public void onAnimationEnd(Animation animation) {
                SharedPreferences pref = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
                //  SharedPreferences.Editor editor=pref.edit();

                if (pref.getString("LoginStatus", "").toString().equals("login")) {
                    Intent i = new Intent(getApplicationContext(), DashBoard.class);
                    startActivity(i);
                    finish();
                } else {
                    imageView.setTransitionName("appLogo");
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SplashScreenActivity.this, imageView, "appLogo");
                    Intent i = new Intent(SplashScreenActivity.this, LoginActivity.class);
                    startActivity(i, options.toBundle());

                }

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

}