package com.example.ryan.hatching.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ryan.hatching.R;
import com.example.ryan.hatching.pojo.Company;

import java.util.List;

public class CompanyAdapter extends ArrayAdapter<Company> {
    private Context context;
    private int resource;
    private List<Company> companies;
    private ListView listView;
    public CompanyAdapter(@NonNull Context context, int resource, List<Company> companies, ListView listView) {
        super(context, resource);
    this.context=context;
    this.resource=resource;
    this.companies=companies;
    this.listView=listView;
    }

    @Override
    public int getCount() {
        return companies.size() ;
    }

    @Nullable
    @Override
    public Company getItem(int position) {
        return companies.get(position);
    }

    @NonNull
    @Override
    public View getView(int position,@Nullable View convertView,@NonNull ViewGroup parent) {
        if (convertView==null){
            convertView=LayoutInflater.from(this.getContext()).inflate(resource,parent,false);
        }
        TextView companynameTv,shengTv,shiTv,quTv,idTv;
        ImageView logoImg;

        logoImg=convertView.findViewById(R.id.logoImg);
        companynameTv=convertView.findViewById(R.id.companynameTv);
        shengTv=convertView.findViewById(R.id.shengTv);
        shiTv=convertView.findViewById(R.id.shiTv);
        quTv=convertView.findViewById(R.id.quTv);
        idTv=convertView.findViewById(R.id.idTv);

        logoImg.setImageResource(companies.get(position).getImageid());
        companynameTv.setText(companies.get(position).getCompanyname());
        shengTv.setText(companies.get(position).getSheng());
        shiTv.setText(companies.get(position).getShi());
        quTv.setText(companies.get(position).getQu());
        idTv.setText(companies.get(position).getId()+"");
        return convertView;
    }
}
