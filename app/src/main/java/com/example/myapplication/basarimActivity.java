package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class basarimActivity extends AppCompatActivity {

    ImageView geri;

    ArrayList<Milyoner> million = new ArrayList<>();

    ListView liste;
    GridAdapter2 gridAdapter;

    int top=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basarim);

        FirebaseDatabase db=FirebaseDatabase.getInstance();
        DatabaseReference ref=db.getReference();
        DatabaseReference dbref=db.getReference();

        liste=(ListView) findViewById(R.id.liste);

        geri=(ImageView) findViewById(R.id.img_geri);

        ref.child("milyoner").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(million.size()>0)
                    million.clear();

                for(DataSnapshot postSnapshot : snapshot.getChildren()){
                    Milyoner user1=postSnapshot.getValue(Milyoner.class);

                    million.add(user1);

                }
                listviewAdapther2 adapther2=new listviewAdapther2(basarimActivity.this,million);
                liste.setAdapter(adapther2);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(basarimActivity.this,MainActivity2.class);
                startActivity(i);
            }
        });

    }


}