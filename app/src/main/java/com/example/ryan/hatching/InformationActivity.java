package com.example.ryan.hatching;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class InformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
    }

    public void finash(View view) {
        Intent in =new Intent(InformationActivity.this,MainActivity.class);
        startActivity(in);
        finish();
    }
}
