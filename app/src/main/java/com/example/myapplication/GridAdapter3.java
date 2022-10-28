package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class GridAdapter3 extends BaseAdapter {
    ArrayList<Zaman> zamans;
    LayoutInflater layoutInflater;
    Context context;

    public GridAdapter3(Activity activity, ArrayList<Zaman>zamans){
        this.zamans=zamans;
        this.context=activity;
        this.layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return zamans.size();
    }

    @Override
    public Object getItem(int position) {
        return zamans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=layoutInflater.inflate(R.layout.gridview,null);

        TextView tv_money=(TextView)view.findViewById(R.id.tv_para);

        tv_money.setText(zamans.get(position).getZaman());
        return view;
    }
}
