package com.example.ryan.hatching;

import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.ryan.hatching.adapter.MyPagerAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ImageView userhead;
    private ViewPager view_pager;
    private ArrayList<View> aList;
    private MyPagerAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        Slideshow();
        userhead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

    }

    private void Slideshow() {
        aList = new ArrayList<View>();
        LayoutInflater li = getLayoutInflater();
        aList.add(li.inflate(R.layout.slideshow_one,null,false));
        aList.add(li.inflate(R.layout.slideshow_two,null,false));
        aList.add(li.inflate(R.layout.slideshow_three,null,false));
        mAdapter=new MyPagerAdapter(aList);
        view_pager.setAdapter(mAdapter);
    }

    private void init() {
        userhead=findViewById(R.id.userhead);
        drawerLayout=findViewById(R.id.drawer_layout);
        view_pager=findViewById(R.id.view_pager);
    }
}
