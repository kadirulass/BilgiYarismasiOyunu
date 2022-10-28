package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class GridAdapter2 extends BaseAdapter {
    ArrayList<User1> moneys;
    LayoutInflater layoutInflater;
    Context context;

    public GridAdapter2(Activity activity, ArrayList<User1> moneys){
        this.moneys=moneys;
        this.context=activity;
        this.layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return moneys.size();
    }

    @Override
    public Object getItem(int position) {
        return moneys.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=layoutInflater.inflate(R.layout.gridview,null);

        TextView tv_money=(TextView)view.findViewById(R.id.txt_money);

        tv_money.setText(moneys.get(position).getPara());
        return view;
    }



}
