package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class listviewAdapther2 extends BaseAdapter {
    Activity activity;
    List<Milyoner> milyoners;
    LayoutInflater inflater;

    public listviewAdapther2(Activity activity, List<Milyoner> milyoners) {
        this.activity = activity;
        this.milyoners = milyoners;
    }

    @Override
    public int getCount() {
        return milyoners.size();
    }

    @Override
    public Object getItem(int i) {
        return milyoners.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        inflater=(LayoutInflater) activity.getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1=inflater.inflate(R.layout.milyoner_list,null);
        TextView milyoneradi=(TextView)view1.findViewById(R.id.txt_milyonpara);

        milyoneradi.setText(milyoners.get(i).getMilyoneradi());

        return view1;
    }
}
