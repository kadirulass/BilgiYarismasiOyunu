package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class listviewAdapther extends BaseAdapter {
    Activity activity;
    List<User2> users;
    LayoutInflater inflater;

    public listviewAdapther(Activity activity, List<User2> users) {
        this.activity = activity;
        this.users = users;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int i) {
        return users.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        inflater=(LayoutInflater) activity.getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1=inflater.inflate(R.layout.sorulist,null);
        TextView tvsoru=(TextView)view1.findViewById(R.id.tvsoru);
        TextView tva=(TextView)view1.findViewById(R.id.tva);
        TextView tvb=(TextView)view1.findViewById(R.id.tvb);
        TextView tvc=(TextView)view1.findViewById(R.id.tvc);
        TextView tvd=(TextView)view1.findViewById(R.id.tvd);
        TextView tvcevap=(TextView)view1.findViewById(R.id.tvcevap);

        tvsoru.setText(users.get(i).getSoru());
        tva.setText(users.get(i).getA());
        tvb.setText(users.get(i).getB());
        tvc.setText(users.get(i).getC());
        tvd.setText(users.get(i).getD());
        tvcevap.setText(users.get(i).getCevap());
        return view1;
    }
}
