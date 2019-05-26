package com.example.ryan.hatching;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    //下载完第一次进入会有3秒的广告,第二次则不会有

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        SharedPreferences sharedPreferences=getSharedPreferences("app",0);
        Boolean isFirst=sharedPreferences.getBoolean("isFirst",true);

        if (isFirst){
            handler.postDelayed(runnable,3000);
        }
        else {
            handler.postDelayed(runnable,3000);
        }
        sharedPreferences.edit().putBoolean("isFirst",false).commit();
    }
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            Intent intent=new Intent(SplashActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }
}
