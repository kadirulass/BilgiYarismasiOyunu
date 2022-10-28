package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static com.example.myapplication.R.string.kod;


public class  MainActivity2 extends AppCompatActivity {
    private AdView mAdView;
    Button basla,cikis,basari,admin,nasil;
    TextView toppara,topsurem;
    ArrayList<Zaman> zamans=new ArrayList<>();
    int top=0,top2=0;
    GridAdapter3 gridAdapter3;
    ArrayList<User1> moneys;
    GridAdapter2 gridAdapter2;
    public MediaPlayer mp1,mp2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        MobileAds.initialize(MainActivity2.this);

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        basla=(Button) findViewById(R.id.btnBasla);
        moneys= new ArrayList<>();
        gridAdapter2=new GridAdapter2(this,moneys);
        admin=(Button) findViewById(R.id.btnAdmin);
        toppara=(TextView) findViewById(R.id.paraciklar);
        topsurem=(TextView) findViewById(R.id.topsurem);
        cikis=(Button) findViewById(R.id.btnCikis);
        basari=(Button) findViewById(R.id.btn_ayarlar);
        gridAdapter3=new GridAdapter3(this,zamans);
        nasil=(Button) findViewById(R.id.btnnasil);
        mp2=MediaPlayer.create(MainActivity2.this,R.raw.anlik);
        basari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this,basarimActivity.class);
                startActivity(intent);
            }
        });
        nasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this,NasilOynanir.class);
                startActivity(intent);
            }
        });
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this,KullaniciActivity.class);
                startActivity(intent);
            }
        });

        basla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this,MainActivity.class);
                startActivity(intent);

            }
        });
        cikis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        TopPara();
        timeGoster();
    }
    public void TopPara(){
        FirebaseDatabase db=FirebaseDatabase.getInstance();
        DatabaseReference dbref=db.getReference();
        dbref.child("moneys").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot1) {
                for (DataSnapshot postSnapshot1 : snapshot1.getChildren()) {
                    User1 user1 = postSnapshot1.getValue(User1.class);

                    moneys.add(
                            new User1(
                                    user1.getPara()
                            )
                    );
                }

                for (int t = 0; t < moneys.size(); t++) {
                    top+=Integer.valueOf(moneys.get(t).getPara());
                }

                toppara.setText(top+" TL");

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public void timeGoster(){
        FirebaseDatabase db=FirebaseDatabase.getInstance();
        DatabaseReference dbref=db.getReference();
        dbref.child("times").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot1) {
                for (DataSnapshot postSnapshot1 : snapshot1.getChildren()) {
                    Zaman zaman = postSnapshot1.getValue(Zaman.class);

                    zamans.add(
                            new Zaman(
                                    zaman.getZaman()
                            )
                    );
                }

                for (int t = 0; t < zamans.size(); t++) {
                    top2+=Integer.valueOf(zamans.get(t).getZaman());
                }
                int saat=top2/3600;
                int dk=top2/60;
                int sn=top2%60;
                if(dk<60){
                    topsurem.setText(Integer.toString(dk)+" dk"+" "+Integer.toString(sn)+" sn");
                }
                else{
                    topsurem.setText(Integer.toString(saat)+" s"+" "+Integer.toString(dk)+" dk"+" "+Integer.toString(sn)+" sn");
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}