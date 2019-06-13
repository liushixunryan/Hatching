package com.example.ryan.hatching;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.ryan.hatching.adapter.CompanyAdapter;
import com.example.ryan.hatching.adapter.MyPagerAdapter;
import com.example.ryan.hatching.fragment.index;
import com.example.ryan.hatching.pojo.Company;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

//    public void index_button(View view) {
//        Fragment fragment=new index();
//        FragmentManager manager=this.getSupportFragmentManager();
//        android.support.v4.app.FragmentTransaction transaction=manager.beginTransaction();
//        transaction.replace(R.id.lunbo,fragment);
//        transaction.commit();
//    }



    public void shouye(View view) {
        Fragment fragment=new index();
        FragmentManager manager=this.getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.lunbo,fragment);
        transaction.commit();
    }
}
