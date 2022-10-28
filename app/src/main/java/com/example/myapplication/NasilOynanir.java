package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class NasilOynanir extends AppCompatActivity {
    ImageView geri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nasil_oynanir);
        FileInputStream fr= null;
        TextView tt=(TextView) findViewById(R.id.txtyazi);
        geri=(ImageView) findViewById(R.id.img_geri);
        geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(NasilOynanir.this,MainActivity2.class);
                startActivity(intent);
            }
        });
        ArrayList<String> array=new ArrayList<String>();
        try {
            InputStream is = getResources().openRawResource(R.raw.dosya);
            InputStreamReader isr=new InputStreamReader(is, Charset.forName("UTF-8"));
            BufferedReader bf=new BufferedReader(isr);
            String line=bf.readLine();
            String a = null;
            while(line!=null){
                array.add(line);
                line=bf.readLine();
            }
            for(int i=0;i<array.size();i++){
                tt.append("\n"+array.get(i));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}