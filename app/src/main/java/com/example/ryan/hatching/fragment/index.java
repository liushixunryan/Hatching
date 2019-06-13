package com.example.ryan.hatching.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.ryan.hatching.MainActivity;
import com.example.ryan.hatching.R;
import com.example.ryan.hatching.adapter.CompanyAdapter;
import com.example.ryan.hatching.adapter.MyPagerAdapter;
import com.example.ryan.hatching.pojo.Company;

import java.util.ArrayList;
import java.util.List;

public class index extends Fragment {
    private View view;
    private DrawerLayout drawerLayout;
    private ImageView userhead;
    private ViewPager view_pager;
    private ArrayList<View> aList;
    private MyPagerAdapter mAdapter;
    private ListView ComLv;
    private List<Company> companies;
    private CompanyAdapter companyAdapter;

    //虚拟数据
    private Integer id []={1,2,3,4};
    private Integer[] img = {R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo};
    private String Comname [] ={ "创孵","共享悦生活","酷狗","关乎"};
    private String[] sheng={"辽宁","北京","山东","成都"};
    private String[] shi={"鞍山","中山","廊坊","四川"};
    private String[] qu={"岫岩","关中","莲花","嘟嘟"};
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_index,container,false);

        init();
        onclick();
        Slideshow();
        Companyshow();

        final DrawerLayout drawerLayout=view.findViewById(R.id.drawer_layout);

        ImageView userhead=view.findViewById(R.id.userhead);
        userhead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        return view;


}

    private void init() {
        userhead=view.findViewById(R.id.userhead);
        drawerLayout=view.findViewById(R.id.drawer_layout);
        view_pager=view.findViewById(R.id.view_pager);
        ComLv=view.findViewById(R.id.ComLv);
    }
    private void Companyshow() {
        companies=new ArrayList<>();
        companyAdapter=new CompanyAdapter(getActivity(),R.layout.company_adapter,companies,ComLv);
        for (int i=0; i<id.length;i++){
            Company c=new Company();
            c.setId(i);
            c.setImageid(img[i]);
            c.setCompanyname(Comname[i]);
            c.setSheng(sheng[i]);
            c.setShi(shi[i]);
            c.setQu(qu[i]);
            companies.add(c);
        }
        ComLv.setAdapter(companyAdapter);

    }



    private void onclick() {
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
}
