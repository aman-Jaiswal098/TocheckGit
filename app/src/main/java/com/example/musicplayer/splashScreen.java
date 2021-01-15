package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class splashScreen extends AppCompatActivity {
    private static  int SPLASH_SCREEN_TIME = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        new Handler().postDelayed(new Runnable() {
                                      @Override
                                      public void run() {
                                          Intent iH=new Intent(splashScreen.this,Indro_screen.class);
                                          startActivity(iH);

                                          finish();
                                          Toast.makeText(getApplicationContext(),"Make sure your the device is connected to Internet",Toast.LENGTH_LONG).show();

                                      }
                                  }


                ,SPLASH_SCREEN_TIME);
    }
}