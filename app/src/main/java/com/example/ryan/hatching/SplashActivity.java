package com.example.ryan.hatching;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SplashActivity extends AppCompatActivity {

    //下载完第一次进入会有导航页,第二次则不会有

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        SharedPreferences sharedPreferences=getSharedPreferences("app",0);
        Boolean isFirst=sharedPreferences.getBoolean("isFirst",true);

        if (isFirst){
            handler.postDelayed(runnable,600000);
        }
        else {
            handler.postDelayed(runnable,0);
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
            Intent intent=new Intent(SplashActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }

    public void tiaozhuan(View view) {
        Intent intent=new Intent(SplashActivity.this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
