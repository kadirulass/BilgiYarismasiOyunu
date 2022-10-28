package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class KullaniciActivity extends AppCompatActivity {

    ImageView iv,ileri,geri;
    EditText kullaniciadi,sifre;
    ArrayList<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kullanici);
        iv=(ImageView) findViewById(R.id.imageView2);
        ileri=(ImageView) findViewById(R.id.btn_giris);
        kullaniciadi=(EditText) findViewById(R.id.et_ad);
        geri=(ImageView) findViewById(R.id.btn_ana);
        sifre=(EditText) findViewById(R.id.et_sifre);
        //kullaniciadi.setText("kadir");
        //sifre.setText("4959");

        ileri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ad="admin";
                String sifretut="1234";
                String katut=kullaniciadi.getText().toString();
                String sifre2=sifre.getText().toString();
                if(kullaniciadi.getText().toString().trim().equals("") && sifre.getText().toString().trim().equals("")){
                    kullaniciadi.requestFocus();
                    sifre.requestFocus();
                    sifre.setError("Alanı doldurun");
                    kullaniciadi.setError("Alanı doldurun");
                }

                else if(katut.equals(ad) && sifre2.equals(sifretut)) {
                    Intent intent = new Intent(KullaniciActivity.this, sorular.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Kullanıcı adı veya parola hatalı",Toast.LENGTH_LONG).show();
                    kullaniciadi.setText("");
                    sifre.setText("");
                }
            }
        });
        geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(KullaniciActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}