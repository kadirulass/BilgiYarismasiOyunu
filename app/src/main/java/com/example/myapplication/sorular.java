package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class sorular extends AppCompatActivity {
    EditText soru;
    EditText a;
    EditText b;
    EditText c;
    EditText d;
    EditText cevap;
    ListView lst_data;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;
    private List<User2> user=new ArrayList<>();
    private User2 secili;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorular);
        Toolbar toolbar=findViewById(R.id.toolbar_menu);
        soru = (EditText) findViewById(R.id.txtsoru);
        lst_data=(ListView) findViewById(R.id.list_data);
        a = (EditText) findViewById(R.id.txta);
        b = (EditText) findViewById(R.id.txtb);
        c = (EditText) findViewById(R.id.txtc);
        d = (EditText) findViewById(R.id.txtd);
        cevap=(EditText) findViewById(R.id.txtcevap);
        toolbar.setTitle("Sorular");
        setSupportActionBar(toolbar);
        FirebaseApp.initializeApp(this);
        firebaseDatabase=FirebaseDatabase.getInstance();
        reference=firebaseDatabase.getReference();
        reference.child("users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(user.size()>0)
                    user.clear();

                for(DataSnapshot postSnapshot : snapshot.getChildren()){
                        User2 user1=postSnapshot.getValue(User2.class);

                        user.add(user1);

                }
                listviewAdapther adapther=new listviewAdapther(sorular.this,user);
                lst_data.setAdapter(adapther);
                lst_data.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        User2 listedekiKullanici=(User2)adapterView.getItemAtPosition(i);
                        secili=listedekiKullanici;
                        soru.setText(listedekiKullanici.getSoru());
                        a.setText(listedekiKullanici.getA());
                        b.setText(listedekiKullanici.getB());
                        c.setText(listedekiKullanici.getC());
                        d.setText(listedekiKullanici.getD());
                        cevap.setText(listedekiKullanici.getCevap());
                    }

                });



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.ekleid){
            soruEkle();
        }
        else if(item.getItemId()==R.id.guncelid){
            soruGuncelle();
        }
        else if(item.getItemId()==R.id.silid){
            soruSil(secili);
        }
        else if(item.getItemId()==R.id.geriid){
            Intent intent = new Intent(sorular.this, KullaniciActivity.class);
            startActivity(intent);
        }
        return true;
    }

    private void soruSil(User2 secili) {
        reference.child("users").child(secili.getSoruid()).removeValue();
        temizle();

    }

    private void soruGuncelle() {
        User2 u2=new User2(secili.getSoruid(),soru.getText().toString(),a.getText().toString(),b.getText().toString(),c.getText().toString(),d.getText().toString(),cevap.getText().toString());
        reference.child("users").child(u2.getSoruid()).child("soru").setValue(u2.getSoru());
        reference.child("users").child(u2.getSoruid()).child("a").setValue(u2.getA());
        reference.child("users").child(u2.getSoruid()).child("b").setValue(u2.getB());
        reference.child("users").child(u2.getSoruid()).child("c").setValue(u2.getC());
        reference.child("users").child(u2.getSoruid()).child("d").setValue(u2.getD());
        reference.child("users").child(u2.getSoruid()).child("cevap").setValue(u2.getCevap());
    }

    private void soruEkle() {
        User2 u1=new User2(UUID.randomUUID().toString(),soru.getText().toString(),a.getText().toString(),b.getText().toString(),c.getText().toString(),d.getText().toString(),cevap.getText().toString());
        reference.child("users").child(u1.getSoruid()).setValue(u1);
        temizle();
    }

    private void temizle() {
        soru.setText("");
        a.setText("");
        b.setText("");
        c.setText("");
        d.setText("");
        cevap.setText("");
    }
}