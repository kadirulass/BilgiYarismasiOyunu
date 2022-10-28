package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.CountDownTimer;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.media.MediaPlayer;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Timer;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {
    final Context context = this;
    public Button a, b, c, d, sure, kapat, soru, evet, hayir;
    timer t;
    int i=0;
    public TextView kac, dogru,saatTut;
    ArrayList<User> users;
    GridAdapter gridAdapter;
    ImageView yuzde, tel, uzman, cekil, durumum, degis,ses;
    int sayac = -1, value = 0,sayac2=1;
    //final Context context = this;
    public CountDownTimer countDownTimer1, countDownTimer2, countDownTimer3;
    public MediaPlayer mp, mp1, mp2, mp3, mp4, mp5, mp6, mpalkis, mpgeri, saat, tiklama, gerilim, ilkler, birIki, baraj;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void soruYenile() {
        mp.stop();
        sureTut();
        Collections.shuffle(users);
        a.setBackground(getDrawable(R.drawable.hyhy));
        b.setBackground(getDrawable(R.drawable.hyhy));
        c.setBackground(getDrawable(R.drawable.hyhy));
        d.setBackground(getDrawable(R.drawable.hyhy));
        a.setEnabled(true);
        b.setEnabled(true);
        c.setEnabled(true);
        d.setEnabled(true);
        cekil.setEnabled(true);
        mp5.start();
        sayac += 1;
        for (int i = 0; i < users.size(); i++) {
            if (sayac == 0) {
                ilkler.start();
                soru.setText(users.get(i).getSoru());
                a.setText(users.get(i).getA());
                b.setText(users.get(i).getB());
                c.setText(users.get(i).getC());
                d.setText(users.get(i).getD());
                dogru.setText(users.get(i).getCevap());
                kac.setText("1/12");
            } else if (sayac == 1) {
                ilkler.start();
                cekil.setEnabled(true);
                soru.setText(users.get(i).getSoru());
                a.setText(users.get(i).getA());
                b.setText(users.get(i).getB());
                c.setText(users.get(i).getC());
                d.setText(users.get(i).getD());
                dogru.setText(users.get(i).getCevap());
                kac.setText("2/12");
            } else if (sayac == 2) {
                ilkler.start();
                soru.setText(users.get(i).getSoru());
                a.setText(users.get(i).getA());
                b.setText(users.get(i).getB());
                c.setText(users.get(i).getC());
                d.setText(users.get(i).getD());
                dogru.setText(users.get(i).getCevap());
                kac.setText("3/12");
            } else if (sayac == 3) {
                mp6.start();
                soru.setText(users.get(i).getSoru());
                a.setText(users.get(i).getA());
                b.setText(users.get(i).getB());
                c.setText(users.get(i).getC());
                d.setText(users.get(i).getD());
                dogru.setText(users.get(i).getCevap());
                kac.setText("4/12");
            } else if (sayac == 4) {
                mp6.start();
                ilkler.stop();
                soru.setText(users.get(i).getSoru());
                a.setText(users.get(i).getA());
                b.setText(users.get(i).getB());
                c.setText(users.get(i).getC());
                d.setText(users.get(i).getD());
                dogru.setText(users.get(i).getCevap());
                kac.setText("5/12");
            } else if (sayac == 5) {
                mp6.start();
                soru.setText(users.get(i).getSoru());
                a.setText(users.get(i).getA());
                b.setText(users.get(i).getB());
                c.setText(users.get(i).getC());
                d.setText(users.get(i).getD());
                dogru.setText(users.get(i).getCevap());
                kac.setText("6/12");
            } else if (sayac == 6) {
                mp6.start();
                soru.setText(users.get(i).getSoru());
                a.setText(users.get(i).getA());
                b.setText(users.get(i).getB());
                c.setText(users.get(i).getC());
                d.setText(users.get(i).getD());
                dogru.setText(users.get(i).getCevap());
                kac.setText("7/12");
            } else if (sayac == 7) {
                sure.setText("");
                gerilim.start();
                ilkler.stop();
                mp6.stop();
                soru.setText(users.get(i).getSoru());
                a.setText(users.get(i).getA());
                b.setText(users.get(i).getB());
                c.setText(users.get(i).getC());
                d.setText(users.get(i).getD());
                dogru.setText(users.get(i).getCevap());
                kac.setText("8/12");
            } else if (sayac == 8) {
                gerilim.start();
                sure.setText("");
                soru.setText(users.get(i).getSoru());
                a.setText(users.get(i).getA());
                b.setText(users.get(i).getB());
                c.setText(users.get(i).getC());
                d.setText(users.get(i).getD());
                dogru.setText(users.get(i).getCevap());
                kac.setText("9/12");
            } else if (sayac == 9) {
                gerilim.start();
                sure.setText("");
                soru.setText(users.get(i).getSoru());
                a.setText(users.get(i).getA());
                b.setText(users.get(i).getB());
                c.setText(users.get(i).getC());
                d.setText(users.get(i).getD());
                dogru.setText(users.get(i).getCevap());
                kac.setText("10/12");
            } else if (sayac == 10) {
                gerilim.start();
                sure.setText("");
                soru.setText(users.get(i).getSoru());
                a.setText(users.get(i).getA());
                b.setText(users.get(i).getB());
                c.setText(users.get(i).getC());
                d.setText(users.get(i).getD());
                dogru.setText(users.get(i).getCevap());
                kac.setText("11/12");
            } else if (sayac == 11) {
                gerilim.start();
                sure.setText("");
                soru.setText(users.get(i).getSoru());
                a.setText(users.get(i).getA());
                b.setText(users.get(i).getB());
                c.setText(users.get(i).getC());
                d.setText(users.get(i).getD());
                dogru.setText(users.get(i).getCevap());
                kac.setText("12/12");
            } else {
                sayac = 11;
            }
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference ref = db.getReference();
        users = new ArrayList<>();
        gridAdapter = new GridAdapter(this, users);
        mp = MediaPlayer.create(MainActivity.this, R.raw.ses);
        mp1 = MediaPlayer.create(MainActivity.this, R.raw.ikisans);
        mp2 = MediaPlayer.create(MainActivity.this, R.raw.uzman);
        mp3 = MediaPlayer.create(MainActivity.this, R.raw.dogru);
        mp4 = MediaPlayer.create(MainActivity.this, R.raw.yanlis);
        mp5 = MediaPlayer.create(MainActivity.this, R.raw.sonra);
        mp6 = MediaPlayer.create(MainActivity.this, R.raw.anlik);
        mpalkis = MediaPlayer.create(MainActivity.this, R.raw.alkis);
        mpgeri = MediaPlayer.create(MainActivity.this, R.raw.geriye);
        saat = MediaPlayer.create(MainActivity.this, R.raw.saat);
        tiklama = MediaPlayer.create(MainActivity.this, R.raw.tiklama);
        gerilim = MediaPlayer.create(MainActivity.this, R.raw.gerilim);
        ilkler = MediaPlayer.create(MainActivity.this, R.raw.ilkler);
        birIki = MediaPlayer.create(MainActivity.this, R.raw.ilkiki);
        baraj = MediaPlayer.create(MainActivity.this, R.raw.ucdort);
        kac = (TextView) findViewById(R.id.txtkac);
        dogru = (TextView) findViewById(R.id.txtdogrucevap);
        saatTut = (TextView) findViewById(R.id.saattut);
        a = (Button) findViewById(R.id.btn_a);
        b = (Button) findViewById(R.id.btn_b);
        c = (Button) findViewById(R.id.btn_c);
        d = (Button) findViewById(R.id.btn_d);
        tel = (ImageView) findViewById(R.id.btn_tel);
        uzman = (ImageView) findViewById(R.id.btn_uzman);
        cekil = (ImageView) findViewById(R.id.btn_cekil);
        yuzde = (ImageView) findViewById(R.id.btn_yuzde);
        degis = (ImageView) findViewById(R.id.btn_degis);
        ses = (ImageView) findViewById(R.id.iv_seskontrol);
        durumum = (ImageView) findViewById(R.id.btn_anlikpara);
        sure = (Button) findViewById(R.id.txt_sayac);
        soru = (Button) findViewById(R.id.txtSorular);
        mpgeri.start();
        t=new timer(1000000,1000);
        t.start();
        a.setEnabled(false);
        b.setEnabled(false);
        c.setEnabled(false);
        d.setEnabled(false);
        saatTut.setVisibility(View.INVISIBLE);
        dbGetir();
        telJoker();
        uzmanJoker();
        yuzdeJoker();
        degistir();
        cekil();
        ses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sayac2++;
                if(sayac2%2==0 ){
                  if(sayac==0 || sayac==1 ||sayac==2){
                    ses.setImageResource(R.drawable.seakapat);
                    ilkler.pause();
                }
                  else if(sayac==3 || sayac==4 || sayac==5 || sayac==6){
                      ses.setImageResource(R.drawable.seakapat);
                      mp6.pause();
                  }
                  else{
                      ses.setImageResource(R.drawable.seakapat);
                      gerilim.pause();
                  }
                }
                else{
                    if(sayac==0 || sayac==1 ||sayac==2) {
                        ses.setImageResource(R.drawable.sesac);
                        ilkler.start();
                    }
                    else if(sayac==3 || sayac==4 || sayac==5 || sayac==6){
                        ses.setImageResource(R.drawable.sesac);
                        mp6.start();
                    }
                    else{
                        ses.setImageResource(R.drawable.sesac);
                        gerilim.start();
                    }

                }

            }
        });

        durumum();
        AlertDialog.Builder alertDialogBuilder1 = new AlertDialog.Builder(context);
        alertDialogBuilder1.setTitle("");
        // alert dialog özelliklerini oluşturuyoruz.
        alertDialogBuilder1
                .setMessage("Maalesef Kaybettiniz")
                .setCancelable(false)
                .setIcon(R.mipmap.ic_launcher_round)
                .setNegativeButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
        AlertDialog alertDialog1 = alertDialogBuilder1.create();
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setTitle("Para Bizde Karar Sizde");
        // alert dialog özelliklerini oluşturuyoruz.
        alertDialogBuilder
                .setMessage("Çekilmek İstediğinizden Emin misiniz?")
                .setCancelable(false)
                .setIcon(R.mipmap.ic_launcher_round)
                .setPositiveButton("Hayır", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("Evet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        a.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                a.setBackground(getDrawable(R.drawable.sarili));
                b.setEnabled(false);
                c.setEnabled(false);
                d.setEnabled(false);
                ilkler.pause();
                cekil.setEnabled(false);
                saat.stop();
                tiklama.start();
                countDownTimer1.cancel();
                aVoid();
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                b.setBackground(getDrawable(R.drawable.sarili));
                a.setEnabled(false);
                c.setEnabled(false);
                d.setEnabled(false);
                ilkler.pause();
                saat.stop();
                cekil.setEnabled(false);
                tiklama.start();
                countDownTimer1.cancel();
                bVoid();


            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                c.setBackground(getDrawable(R.drawable.sarili));
                ilkler.pause();
                a.setEnabled(false);
                b.setEnabled(false);
                d.setEnabled(false);
                cekil.setEnabled(false);
                saat.stop();
                tiklama.start();
                countDownTimer1.cancel();
                cVoid();
            }

        });
        d.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                d.setBackground(getDrawable(R.drawable.sarili));
                ilkler.pause();
                a.setEnabled(false);
                b.setEnabled(false);
                cekil.setEnabled(false);
                c.setEnabled(false);
                saat.stop();
                tiklama.start();
                countDownTimer1.cancel();
                dVoid();


            }
        });

        ShowPopup();
    }

    public void degistir() {
        degis.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                degis.setEnabled(false);
                degis.setImageResource(R.drawable.image);
                mp.stop();
                Collections.shuffle(users);
                a.setBackground(getDrawable(R.drawable.hyhy));
                b.setBackground(getDrawable(R.drawable.hyhy));
                c.setBackground(getDrawable(R.drawable.hyhy));
                d.setBackground(getDrawable(R.drawable.hyhy));
                a.setEnabled(true);
                b.setEnabled(true);
                c.setEnabled(true);
                d.setEnabled(true);
                cekil.setEnabled(true);
                for (int i = 0; i < users.size(); i++) {

                    soru.setText(users.get(i).getSoru());
                    a.setText(users.get(i).getA());
                    b.setText(users.get(i).getB());
                    c.setText(users.get(i).getC());
                    d.setText(users.get(i).getD());
                    dogru.setText(users.get(i).getCevap());

                }
            }
        });
    }

    public void ShowPopup() {
        final Dialog dialog = new Dialog(context);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setContentView(R.layout.yaris_basliyor);
        countDownTimer2 = new CountDownTimer(4000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onFinish() {
                dialog.hide();
                soruYenile();
            }
        };
        countDownTimer2.start();
        dialog.show();

    }

    public void ShowDialog() {
        int para = 0;
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        View view = getLayoutInflater().inflate(R.layout.alert_dialog, null);
        builder.setView(view);
        countDownTimer1.cancel();
        ((Button) view.findViewById(R.id.btn_evet)).setText(getResources().getString(R.string.succesful));
        ((Button) view.findViewById(R.id.btn_hayir)).setText(getResources().getString(R.string.error));
        TextView tv2 = view.findViewById(R.id.txt_nekadar);
        final AlertDialog dialog = builder.create();
        if (sayac == 0) {
            tv2.setText("0");
        } else if (sayac == 1) {
            tv2.setText("500");
        } else if (sayac == 2) {
            tv2.setText("1000");
        } else if (sayac == 3) {
            tv2.setText("2000");
        } else if (sayac == 4) {
            tv2.setText("3000");
        } else if (sayac == 5) {
            tv2.setText("5000");
        } else if (sayac == 6) {
            tv2.setText("7500");
        } else if (sayac == 7) {
            tv2.setText("15000");
        } else if (sayac == 8) {
            tv2.setText("30000");
        } else if (sayac == 9) {
            tv2.setText("60000");
        } else if (sayac == 10) {
            tv2.setText("125000");
        } else if (sayac == 11) {
            tv2.setText("250000");
        }
        view.findViewById(R.id.btn_evet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t.cancel();
                if (sayac == 0) {
                    ilkler.stop();
                    mpalkis.start();
                    DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("moneys");
                    dbRef.push().setValue(
                            new User1(
                                    tv2.getText().toString()
                            )

                    );
                    Toast.makeText(getApplicationContext(), "Kazandığınız Para: 0 TL ", Toast.LENGTH_LONG).show();

                    DatabaseReference dbRef2 = FirebaseDatabase.getInstance().getReference().child("times");
                    dbRef2.push().setValue(
                            new Zaman(
                                    saatTut.getText().toString()

                            )

                    );
                } else if (sayac == 1) {
                    ilkler.stop();
                    mpalkis.start();
                    DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("moneys");
                    dbRef.push().setValue(
                            new User1(
                                    tv2.getText().toString()
                            )

                    );
                    Toast.makeText(getApplicationContext(), "Kazandığınız Para: 500 TL ", Toast.LENGTH_LONG).show();
                    DatabaseReference dbRef2 = FirebaseDatabase.getInstance().getReference().child("times");
                    dbRef2.push().setValue(
                            new Zaman(
                                    saatTut.getText().toString()

                            )

                    );
                } else if (sayac == 2) {
                    ilkler.stop();
                    mpalkis.start();
                    DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("moneys");
                    dbRef.push().setValue(
                            new User1(
                                    tv2.getText().toString()
                            )

                    );
                    Toast.makeText(getApplicationContext(), "Kazandığınız Para: 1.000 TL ", Toast.LENGTH_LONG).show();
                    DatabaseReference dbRef2 = FirebaseDatabase.getInstance().getReference().child("times");
                    dbRef2.push().setValue(
                            new Zaman(
                                    saatTut.getText().toString()

                            )

                    );
                } else if (sayac == 3) {
                    ilkler.stop();
                    mpalkis.start();
                    DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("moneys");
                    dbRef.push().setValue(
                            new User1(
                                    tv2.getText().toString()
                            )

                    );
                    Toast.makeText(getApplicationContext(), "Kazandığınız Para: 2.000 TL ", Toast.LENGTH_LONG).show();
                    DatabaseReference dbRef2 = FirebaseDatabase.getInstance().getReference().child("times");
                    dbRef2.push().setValue(
                            new Zaman(
                                    saatTut.getText().toString()

                            )

                    );
                } else if (sayac == 4) {
                    mp6.stop();
                    mpalkis.start();
                    DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("moneys");
                    dbRef.push().setValue(
                            new User1(
                                    tv2.getText().toString()
                            )

                    );
                    Toast.makeText(getApplicationContext(), "Kazandığınız Para: 3.000 TL ", Toast.LENGTH_LONG).show();
                    DatabaseReference dbRef2 = FirebaseDatabase.getInstance().getReference().child("times");
                    dbRef2.push().setValue(
                            new Zaman(
                                    saatTut.getText().toString()

                            )

                    );
                } else if (sayac == 5) {
                    mp6.stop();
                    mpalkis.start();
                    DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("moneys");
                    dbRef.push().setValue(
                            new User1(
                                    tv2.getText().toString()
                            )

                    );
                    Toast.makeText(getApplicationContext(), "Kazandığınız Para: 5.000 TL ", Toast.LENGTH_LONG).show();
                    DatabaseReference dbRef2 = FirebaseDatabase.getInstance().getReference().child("times");
                    dbRef2.push().setValue(
                            new Zaman(
                                    saatTut.getText().toString()

                            )

                    );
                } else if (sayac == 6) {
                    mp6.stop();
                    mpalkis.start();
                    DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("moneys");
                    dbRef.push().setValue(
                            new User1(
                                    tv2.getText().toString()
                            )

                    );
                    Toast.makeText(getApplicationContext(), "Kazandığınız Para: 7.500 TL ", Toast.LENGTH_LONG).show();
                    DatabaseReference dbRef2 = FirebaseDatabase.getInstance().getReference().child("times");
                    dbRef2.push().setValue(
                            new Zaman(
                                    saatTut.getText().toString()

                            )

                    );
                } else if (sayac == 7) {
                    mp6.stop();
                    mpalkis.start();
                    DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("moneys");
                    dbRef.push().setValue(
                            new User1(
                                    tv2.getText().toString()
                            )

                    );
                    Toast.makeText(getApplicationContext(), "Kazandığınız Para: 15.000 TL ", Toast.LENGTH_LONG).show();
                    DatabaseReference dbRef2 = FirebaseDatabase.getInstance().getReference().child("times");
                    dbRef2.push().setValue(
                            new Zaman(
                                    saatTut.getText().toString()

                            )

                    );
                } else if (sayac == 8) {
                    gerilim.stop();
                    mpalkis.start();
                    DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("moneys");
                    dbRef.push().setValue(
                            new User1(
                                    tv2.getText().toString()
                            )

                    );
                    Toast.makeText(getApplicationContext(), "Kazandığınız Para: 30.000 TL ", Toast.LENGTH_LONG).show();
                    DatabaseReference dbRef2 = FirebaseDatabase.getInstance().getReference().child("times");
                    dbRef2.push().setValue(
                            new Zaman(
                                    saatTut.getText().toString()

                            )

                    );
                } else if (sayac == 9) {
                    gerilim.stop();
                    mpalkis.start();
                    DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("moneys");
                    dbRef.push().setValue(
                            new User1(
                                    tv2.getText().toString()
                            )

                    );
                    Toast.makeText(getApplicationContext(), "Kazandığınız Para: 60.000 TL ", Toast.LENGTH_LONG).show();
                    DatabaseReference dbRef2 = FirebaseDatabase.getInstance().getReference().child("times");
                    dbRef2.push().setValue(
                            new Zaman(
                                    saatTut.getText().toString()

                            )

                    );
                } else if (sayac == 10) {
                    gerilim.stop();
                    mpalkis.start();
                    DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("moneys");
                    dbRef.push().setValue(
                            new User1(
                                    tv2.getText().toString()
                            )

                    );
                    Toast.makeText(getApplicationContext(), "Kazandığınız Para: 125.000 TL ", Toast.LENGTH_LONG).show();
                    DatabaseReference dbRef2 = FirebaseDatabase.getInstance().getReference().child("times");
                    dbRef2.push().setValue(
                            new Zaman(
                                    saatTut.getText().toString()

                            )

                    );
                } else if (sayac == 11) {
                    gerilim.stop();
                    mpalkis.start();
                    DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("moneys");
                    dbRef.push().setValue(
                            new User1(
                                    tv2.getText().toString()
                            )

                    );
                    Toast.makeText(getApplicationContext(), "Kazandığınız Para: 250.000 TL ", Toast.LENGTH_LONG).show();
                    DatabaseReference dbRef2 = FirebaseDatabase.getInstance().getReference().child("times");
                    dbRef2.push().setValue(
                            new Zaman(
                                    saatTut.getText().toString()

                            )

                    );
                }
                finish();
            }
        });
        view.findViewById(R.id.btn_hayir).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gerilim.start();
                mp6.start();
                ilkler.start();
                dialog.dismiss();
                countDownTimer1.start();
            }
        });
        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }

        dialog.show();
    }



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void paraEkrani() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        View view = getLayoutInflater().inflate(R.layout.para_ekrani, null);
        builder.setView(view);
        Button btn1 = view.findViewById(R.id.btn1);
        Button btn2 = view.findViewById(R.id.btn2);
        Button btn3 = view.findViewById(R.id.btn3);
        Button btn4 = view.findViewById(R.id.btn4);
        Button btn5 = view.findViewById(R.id.btn5);
        Button btn6 = view.findViewById(R.id.btn6);
        Button btn7 = view.findViewById(R.id.btn7);
        Button btn8 = view.findViewById(R.id.btn8);
        Button btn9 = view.findViewById(R.id.btn9);
        Button btn10 = view.findViewById(R.id.btn10);
        Button btn11 = view.findViewById(R.id.btn11);
        Button btn12 = view.findViewById(R.id.btn12);
        final AlertDialog dialog = builder.create();
        if (sayac == 0) {
            btn1.setBackground(getDrawable(R.drawable.greeen));
        } else if (sayac == 1) {
            btn2.setBackground(getDrawable(R.drawable.greeen));
        } else if (sayac == 2) {
            btn3.setBackground(getDrawable(R.drawable.greeen));
        } else if (sayac == 3) {
            btn4.setBackground(getDrawable(R.drawable.greeen));
        } else if (sayac == 4) {
            btn5.setBackground(getDrawable(R.drawable.greeen));
        } else if (sayac == 5) {
            btn6.setBackground(getDrawable(R.drawable.greeen));
        } else if (sayac == 6) {
            btn7.setBackground(getDrawable(R.drawable.greeen));
        } else if (sayac == 7) {
            btn8.setBackground(getDrawable(R.drawable.greeen));
        } else if (sayac == 8) {
            btn9.setBackground(getDrawable(R.drawable.greeen));
        } else if (sayac == 9) {
            btn10.setBackground(getDrawable(R.drawable.greeen));
        } else if (sayac == 10) {
            btn11.setBackground(getDrawable(R.drawable.greeen));
        }
        dialog.show();
    }

    public void ShowUzman() {
        String dC = dogru.getText().toString();
        String aa = a.getText().toString();
        String bb = b.getText().toString();
        String cc = c.getText().toString();
        String dd = d.getText().toString();
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        View view = getLayoutInflater().inflate(R.layout.popup, null);
        builder.setView(view);
        ((TextView) view.findViewById(R.id.txtkonu)).setText(getResources().getString(R.string.cevap));
        ((Button) view.findViewById(R.id.btn_ok)).setText("teşekkürler");
        final AlertDialog dialog = builder.create();
        if (dC.equals(aa)) {
            ((TextView) view.findViewById(R.id.txtkonu)).setText("Kesinlikle cevap A");
        } else if (dC.equals(bb)) {
            ((TextView) view.findViewById(R.id.txtkonu)).setText("Eminim cevap B");
        } else if (dC.equals(cc)) {
            ((TextView) view.findViewById(R.id.txtkonu)).setText("Üzgünüm cevabı bilmiyorum.");
        } else if (dC.equals(dd)) {
            ((TextView) view.findViewById(R.id.txtkonu)).setText("Kararsızım ama D diyorum");
        }

        view.findViewById(R.id.btn_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp2.pause();
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void openWinDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        View view = getLayoutInflater().inflate(R.layout.win_dialog, null);
        builder.setView(view);

        Button btn = view.findViewById(R.id.btn_milyoncu);
        String para = "1000000";
        final AlertDialog dialog = builder.create();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("moneys");
                dbRef.push().setValue(
                        new User1(
                                para.toString()
                        )

                );
                MilyonerKayit();
            }
        });
        dialog.show();

    }

    public void  MilyonerKayit(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        View view = getLayoutInflater().inflate(R.layout.milyoner, null);
        builder.setView(view);

        Button btn = view.findViewById(R.id.btn_kayit);
        TextView kuladi= view.findViewById(R.id.txt_milyonadi);
        final AlertDialog dialog = builder.create();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("milyoner");
                dbRef.push().setValue(
                        new Milyoner(
                                kuladi.getText().toString()
                        )

                );
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
        dialog.show();
    }

    public void sureTut() {

        dogru.setVisibility(View.INVISIBLE);
        countDownTimer1 = new CountDownTimer(46000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                sure.setText(String.valueOf(millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                sureGetir();
                mp6.stop();
                mp4.start();
                ilkler.stop();
            }
        };
        countDownTimer1.start();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void durumum() {
        durumum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paraEkrani();
            }
        });

    }

    public void cekil() {
        cekil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gerilim.pause();
                ilkler.pause();
                mp6.pause();
                ShowDialog();

            }
        });
    }

    public void telJoker() {
        tel.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                mp2.start();
                tel.setEnabled(false);
                ShowUzman();
                tel.setImageResource(R.drawable.teliptal);
            }
        });
    }

    public void uzmanJoker() {
        uzman.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                String dC = dogru.getText().toString();
                uzman.setImageResource(R.drawable.iptalseyirci);
                uzman.setEnabled(false);
                mp1.start();
                if (dC.equals(a.getText().toString()) && c.getText().equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    View view = getLayoutInflater().inflate(R.layout.a_yuzde, null);
                    builder.setView(view);
                    final AlertDialog dialog = builder.create();
                    dialog.show();
                }
                else if(dC.equals(a.getText().toString())){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    View view = getLayoutInflater().inflate(R.layout.joker_a, null);
                    builder.setView(view);
                    final AlertDialog dialog = builder.create();
                    dialog.show();
                }
                    if (dC.equals(b.getText().toString()) && a.getText().equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    View view = getLayoutInflater().inflate(R.layout.b_yuzde, null);
                    builder.setView(view);
                    final AlertDialog dialog = builder.create();
                    dialog.show();
                }
                    else if(dC.equals(b.getText().toString())){
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        View view = getLayoutInflater().inflate(R.layout.joker_b, null);
                        builder.setView(view);
                        final AlertDialog dialog = builder.create();
                        dialog.show();
                }
                    if (dC.equals(c.getText().toString()) && d.getText().equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    View view = getLayoutInflater().inflate(R.layout.c_yuzde, null);
                    builder.setView(view);
                    final AlertDialog dialog = builder.create();
                    dialog.show();
                } else if(dC.equals(c.getText().toString())){
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        View view = getLayoutInflater().inflate(R.layout.joker_c, null);
                        builder.setView(view);
                        final AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                    if (dC.equals(d.getText().toString()) && c.getText().equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    View view = getLayoutInflater().inflate(R.layout.d_yuzde, null);
                    builder.setView(view);
                    final AlertDialog dialog = builder.create();
                    dialog.show();
                }
                    else if(dC.equals(d.getText().toString())){
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        View view = getLayoutInflater().inflate(R.layout.joker_d, null);
                        builder.setView(view);
                        final AlertDialog dialog = builder.create();
                        dialog.show();
                    }

            }
        });
    }

    public void yuzdeJoker() {
        yuzde.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                String dd = dogru.getText().toString();
                yuzde.setImageResource(R.drawable.iptalelli);
                if (dd.equals(a.getText().toString())) {
                    c.setText("");
                    d.setText("");
                } else if (dd.equals(b.getText().toString())) {
                    c.setText("");
                    a.setText("");
                } else if (dd.equals(c.getText().toString())) {
                    a.setText("");
                    d.setText("");
                } else {
                    a.setText("");
                    c.setText("");
                }
                yuzde.setEnabled(false);
            }
        });
    }
    public void dbGetir() {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference ref = db.getReference();
        ref.child("users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    User user = postSnapshot.getValue(User.class);

                    users.add(
                            new User(
                                    user.getSoru(),
                                    user.getA(),
                                    user.getB(),
                                    user.getC(),
                                    user.getD(),
                                    user.getCevap()
                            )
                    );
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void aVoid() {
        String aa = a.getText().toString();
        String dC = dogru.getText().toString();
        Thread thread = new Thread() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            public void run() {
                try {
                    sleep(3000);
                    if (aa.equals(dC)) {
                        if (sayac == 0) {
                            birIki.start();
                            a.setBackground(getDrawable(R.drawable.greeen));
                            yeniSorular();
                        } else if (sayac == 1) {
                            birIki.start();
                            a.setBackground(getDrawable(R.drawable.greeen));
                            yeniSorular();
                        } else if (sayac == 2) {
                            mp3.start();
                            a.setBackground(getDrawable(R.drawable.greeen));
                            yeniSorular();
                        } else if (sayac == 3) {
                            mp3.start();
                            a.setBackground(getDrawable(R.drawable.greeen));
                            yeniSorular();
                        } else if (sayac == 4) {
                            mp3.start();
                            a.setBackground(getDrawable(R.drawable.greeen));
                            yeniSorular();
                        } else if (sayac == 5) {
                            mp3.start();
                            a.setBackground(getDrawable(R.drawable.greeen));
                            yeniSorular();
                        } else if (sayac == 6) {
                            mp3.start();
                            a.setBackground(getDrawable(R.drawable.greeen));
                            yeniSorular();
                        } else if (sayac == 7) {
                            mp3.start();
                            a.setBackground(getDrawable(R.drawable.greeen));
                            yeniSorular();
                        } else if (sayac == 8) {
                            mp3.start();
                            a.setBackground(getDrawable(R.drawable.greeen));
                            yeniSorular();
                        } else if (sayac == 9) {
                            mp3.start();
                            a.setBackground(getDrawable(R.drawable.greeen));
                            yeniSorular();
                        } else if (sayac == 10) {
                            mp3.start();
                            a.setBackground(getDrawable(R.drawable.greeen));
                            yeniSorular();
                        } else if (sayac == 11) {
                            mpalkis.start();
                            a.setBackground(getDrawable(R.drawable.greeen));
                            milyoner();
                            gerilim.stop();
                        }
                    } else {
                        if (sayac == 0) {
                            if (b.getText().equals(dC)) {
                                mp4.start();
                                t.cancel();
                                a.setBackground(getDrawable(R.drawable.k));
                                b.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else if (c.getText().equals(dC)) {
                                mp4.start();
                                t.cancel();
                                a.setBackground(getDrawable(R.drawable.k));
                                c.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else {
                                mp4.start();
                                t.cancel();
                                a.setBackground(getDrawable(R.drawable.k));
                                d.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            }
                        } else if (sayac == 1) {
                            if (b.getText().equals(dC)) {
                                mp4.start();
                                t.cancel();
                                a.setBackground(getDrawable(R.drawable.k));
                                b.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else if (c.getText().equals(dC)) {
                                mp4.start();
                                t.cancel();
                                a.setBackground(getDrawable(R.drawable.k));
                                c.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else {
                                mp4.start();
                                t.cancel();
                                a.setBackground(getDrawable(R.drawable.k));
                                d.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            }
                        } else if (sayac == 2) {
                            if (b.getText().equals(dC)) {
                                mp4.start();
                                t.cancel();
                                a.setBackground(getDrawable(R.drawable.k));
                                b.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else if (c.getText().equals(dC)) {
                                mp4.start();
                                t.cancel();
                                a.setBackground(getDrawable(R.drawable.k));
                                c.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else {
                                mp4.start();
                                t.cancel();
                                a.setBackground(getDrawable(R.drawable.k));
                                d.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            }
                        } else if (sayac == 3) {
                            if (b.getText().equals(dC)) {
                                mp4.start();
                                mp6.stop();
                                t.cancel();
                                a.setBackground(getDrawable(R.drawable.k));
                                b.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else if (c.getText().equals(dC)) {
                                mp4.start();
                                mp6.stop();
                                t.cancel();
                                a.setBackground(getDrawable(R.drawable.k));
                                c.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else {
                                mp4.start();
                                mp6.stop();
                                t.cancel();
                                a.setBackground(getDrawable(R.drawable.k));
                                d.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            }
                        } else if (sayac == 4) {
                            if (b.getText().equals(dC)) {
                                mp4.start();
                                t.cancel();
                                a.setBackground(getDrawable(R.drawable.k));
                                b.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else if (c.getText().equals(dC)) {
                                mp4.start();
                                t.cancel();
                                a.setBackground(getDrawable(R.drawable.k));
                                c.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else {
                                mp4.start();
                                t.cancel();
                                a.setBackground(getDrawable(R.drawable.k));
                                d.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            }
                        } else if (sayac == 5) {
                            if (b.getText().equals(dC)) {
                                mp4.start();
                                t.cancel();
                                a.setBackground(getDrawable(R.drawable.k));
                                b.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else if (c.getText().equals(dC)) {
                                mp4.start();
                                t.cancel();
                                a.setBackground(getDrawable(R.drawable.k));
                                c.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else {
                                mp4.start();
                                t.cancel();
                                a.setBackground(getDrawable(R.drawable.k));
                                d.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            }
                        } else if (sayac == 6) {
                            if (b.getText().equals(dC)) {
                                mp4.start();
                                t.cancel();
                                a.setBackground(getDrawable(R.drawable.k));
                                b.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else if (c.getText().equals(dC)) {
                                mp4.start();
                                t.cancel();
                                a.setBackground(getDrawable(R.drawable.k));
                                c.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else {
                                mp4.start();
                                t.cancel();
                                a.setBackground(getDrawable(R.drawable.k));
                                d.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            }
                        } else if (sayac == 7) {

                            if (b.getText().equals(dC)) {
                                gerilim.stop();
                                mp4.start();
                                t.cancel();
                                a.setBackground(getDrawable(R.drawable.k));
                                b.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else if (c.getText().equals(dC)) {
                                gerilim.stop();
                                mp4.start();
                                t.cancel();
                                a.setBackground(getDrawable(R.drawable.k));
                                c.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else {
                                gerilim.stop();
                                mp4.start();
                                t.cancel();
                                a.setBackground(getDrawable(R.drawable.k));
                                d.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            }
                        } else if (sayac == 8) {
                            if (b.getText().equals(dC)) {
                                gerilim.stop();
                                mp4.start();
                                t.cancel();
                                a.setBackground(getDrawable(R.drawable.k));
                                b.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else if (c.getText().equals(dC)) {
                                gerilim.stop();
                                mp4.start();
                                t.cancel();
                                a.setBackground(getDrawable(R.drawable.k));
                                c.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else {
                                gerilim.stop();
                                mp4.start();
                                t.cancel();
                                a.setBackground(getDrawable(R.drawable.k));
                                d.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            }
                        } else if (sayac == 9) {
                            if (b.getText().equals(dC)) {
                                gerilim.stop();
                                mp4.start();
                                t.cancel();
                                a.setBackground(getDrawable(R.drawable.k));
                                b.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else if (c.getText().equals(dC)) {
                                gerilim.stop();
                                mp4.start();
                                t.cancel();
                                a.setBackground(getDrawable(R.drawable.k));
                                c.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else {
                                gerilim.stop();
                                mp4.start();
                                t.cancel();
                                a.setBackground(getDrawable(R.drawable.k));
                                d.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            }
                        } else if (sayac == 10) {
                            if (b.getText().equals(dC)) {
                                gerilim.stop();
                                mp4.start();
                                t.cancel();
                                a.setBackground(getDrawable(R.drawable.k));
                                b.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else if (c.getText().equals(dC)) {
                                gerilim.stop();
                                mp4.start();
                                t.cancel();
                                a.setBackground(getDrawable(R.drawable.k));
                                c.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else {
                                gerilim.stop();
                                mp4.start();
                                t.cancel();
                                a.setBackground(getDrawable(R.drawable.k));
                                d.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            }
                        } else {
                            if (b.getText().equals(dC)) {
                                gerilim.stop();
                                mp4.start();
                                t.cancel();
                                a.setBackground(getDrawable(R.drawable.k));
                                b.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else if (c.getText().equals(dC)) {
                                gerilim.stop();
                                mp4.start();
                                t.cancel();
                                a.setBackground(getDrawable(R.drawable.k));
                                c.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else {
                                gerilim.stop();
                                mp4.start();
                                t.cancel();
                                a.setBackground(getDrawable(R.drawable.k));
                                d.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            }
                        }


                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();

    }

    public void bVoid() {
        String bb = b.getText().toString();
        String dC = dogru.getText().toString();
        Thread thread = new Thread() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            public void run() {
                try {
                    sleep(3000);
                    if (bb.equals(dC)) {
                        if (sayac == 0) {
                            birIki.start();
                            b.setBackground(getDrawable(R.drawable.greeen));
                            yeniSorular();
                        } else if (sayac == 1) {
                            birIki.start();
                            b.setBackground(getDrawable(R.drawable.greeen));
                            yeniSorular();
                        } else if (sayac == 2) {
                            mp3.start();
                            b.setBackground(getDrawable(R.drawable.greeen));
                            yeniSorular();
                        } else if (sayac == 3) {
                            mp3.start();
                            b.setBackground(getDrawable(R.drawable.greeen));
                            yeniSorular();
                        } else if (sayac == 4) {
                            mp3.start();
                            b.setBackground(getDrawable(R.drawable.greeen));
                            yeniSorular();
                        } else if (sayac == 5) {
                            mp3.start();
                            b.setBackground(getDrawable(R.drawable.greeen));
                            yeniSorular();
                        } else if (sayac == 6) {
                            mp3.start();
                            b.setBackground(getDrawable(R.drawable.greeen));
                            yeniSorular();
                        } else if (sayac == 7) {
                            mp3.start();
                            b.setBackground(getDrawable(R.drawable.greeen));
                            yeniSorular();
                        } else if (sayac == 8) {
                            mp3.start();
                            b.setBackground(getDrawable(R.drawable.greeen));
                            yeniSorular();
                        } else if (sayac == 9) {
                            mp3.start();
                            b.setBackground(getDrawable(R.drawable.greeen));
                            yeniSorular();
                        } else if (sayac == 10) {
                            mp3.start();
                            b.setBackground(getDrawable(R.drawable.greeen));
                            yeniSorular();
                        } else if (sayac == 11) {
                            mpalkis.start();
                            b.setBackground(getDrawable(R.drawable.greeen));
                            milyoner();
                            gerilim.stop();
                        }
                    } else {
                        if (sayac == 0) {
                            if (a.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                b.setBackground(getDrawable(R.drawable.k));
                                a.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else if (c.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                b.setBackground(getDrawable(R.drawable.k));
                                c.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else {
                                mp4.start();t.cancel();
                                b.setBackground(getDrawable(R.drawable.k));
                                d.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            }
                        } else if (sayac == 1) {
                            if (a.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                b.setBackground(getDrawable(R.drawable.k));
                                a.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else if (c.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                b.setBackground(getDrawable(R.drawable.k));
                                c.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else {
                                mp4.start();t.cancel();
                                b.setBackground(getDrawable(R.drawable.k));
                                d.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            }
                        } else if (sayac == 2) {
                            if (a.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                b.setBackground(getDrawable(R.drawable.k));
                                a.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else if (c.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                b.setBackground(getDrawable(R.drawable.k));
                                c.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else {
                                mp4.start();t.cancel();
                                b.setBackground(getDrawable(R.drawable.k));
                                d.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            }
                        } else if (sayac == 3) {
                            if (a.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                b.setBackground(getDrawable(R.drawable.k));
                                a.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else if (c.getText().equals(dC)) {

                                mp4.start();t.cancel();
                                b.setBackground(getDrawable(R.drawable.k));
                                c.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else {
                                mp4.start();t.cancel();
                                b.setBackground(getDrawable(R.drawable.k));
                                d.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            }
                        } else if (sayac == 4) {
                            if (a.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                b.setBackground(getDrawable(R.drawable.k));
                                a.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else if (c.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                b.setBackground(getDrawable(R.drawable.k));
                                c.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else {
                                mp4.start();t.cancel();
                                b.setBackground(getDrawable(R.drawable.k));
                                d.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            }
                        } else if (sayac == 5) {
                            if (a.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                b.setBackground(getDrawable(R.drawable.k));
                                a.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else if (c.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                b.setBackground(getDrawable(R.drawable.k));
                                c.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else {
                                mp4.start();t.cancel();
                                b.setBackground(getDrawable(R.drawable.k));
                                d.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            }
                        } else if (sayac == 6) {
                            if (a.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                b.setBackground(getDrawable(R.drawable.k));
                                a.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else if (c.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                b.setBackground(getDrawable(R.drawable.k));
                                c.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else {
                                mp4.start();t.cancel();
                                b.setBackground(getDrawable(R.drawable.k));
                                d.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            }
                        } else if (sayac == 7) {
                            if (a.getText().equals(dC)) {
                                mp4.start();
                                gerilim.stop();t.cancel();
                                b.setBackground(getDrawable(R.drawable.k));
                                a.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else if (c.getText().equals(dC)) {
                                mp4.start();
                                gerilim.stop();t.cancel();
                                b.setBackground(getDrawable(R.drawable.k));
                                c.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else {
                                mp4.start();
                                gerilim.stop();t.cancel();
                                b.setBackground(getDrawable(R.drawable.k));
                                d.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            }
                        } else if (sayac == 8) {
                            if (a.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                gerilim.stop();
                                b.setBackground(getDrawable(R.drawable.k));
                                a.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else if (c.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                gerilim.stop();
                                b.setBackground(getDrawable(R.drawable.k));
                                c.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else {
                                mp4.start();t.cancel();
                                gerilim.stop();
                                b.setBackground(getDrawable(R.drawable.k));
                                d.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            }
                        } else if (sayac == 9) {
                            if (a.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                gerilim.stop();
                                b.setBackground(getDrawable(R.drawable.k));
                                a.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else if (c.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                gerilim.stop();
                                b.setBackground(getDrawable(R.drawable.k));
                                c.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else {
                                mp4.start();t.cancel();
                                gerilim.stop();
                                b.setBackground(getDrawable(R.drawable.k));
                                d.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            }
                        } else if (sayac == 10) {
                            if (a.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                gerilim.stop();
                                b.setBackground(getDrawable(R.drawable.k));
                                a.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else if (c.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                gerilim.stop();
                                b.setBackground(getDrawable(R.drawable.k));
                                c.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else {
                                mp4.start();t.cancel();
                                gerilim.stop();
                                b.setBackground(getDrawable(R.drawable.k));
                                d.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            }
                        } else {
                            if (a.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                gerilim.stop();
                                b.setBackground(getDrawable(R.drawable.k));
                                a.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else if (c.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                gerilim.stop();
                                b.setBackground(getDrawable(R.drawable.k));
                                c.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else {
                                mp4.start();t.cancel();
                                gerilim.stop();
                                b.setBackground(getDrawable(R.drawable.k));
                                d.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            }
                        }

                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }

    public void cVoid() {
        String cc = c.getText().toString();
        String dC = dogru.getText().toString();
        Thread thread = new Thread() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            public void run() {
                try {
                    sleep(3000);
                    if (cc.equals(dC)) {
                        if (sayac == 0) {
                            birIki.start();
                            c.setBackground(getDrawable(R.drawable.greeen));
                            yeniSorular();
                        } else if (sayac == 1) {
                            birIki.start();
                            c.setBackground(getDrawable(R.drawable.greeen));
                            yeniSorular();
                        } else if (sayac == 2) {
                            mp3.start();
                            c.setBackground(getDrawable(R.drawable.greeen));
                            yeniSorular();
                        } else if (sayac == 3) {
                            mp3.start();
                            c.setBackground(getDrawable(R.drawable.greeen));
                            yeniSorular();
                        } else if (sayac == 4) {
                            mp3.start();
                            c.setBackground(getDrawable(R.drawable.greeen));
                            yeniSorular();
                        } else if (sayac == 5) {
                            mp3.start();
                            c.setBackground(getDrawable(R.drawable.greeen));
                            yeniSorular();
                        } else if (sayac == 6) {
                            mp3.start();
                            c.setBackground(getDrawable(R.drawable.greeen));
                            yeniSorular();
                        } else if (sayac == 7) {
                            mp3.start();
                            c.setBackground(getDrawable(R.drawable.greeen));
                            yeniSorular();
                        } else if (sayac == 8) {
                            mp3.start();
                            c.setBackground(getDrawable(R.drawable.greeen));
                            yeniSorular();
                        } else if (sayac == 9) {
                            mp3.start();
                            c.setBackground(getDrawable(R.drawable.greeen));
                            yeniSorular();
                        } else if (sayac == 10) {
                            mp3.start();
                            c.setBackground(getDrawable(R.drawable.greeen));
                            yeniSorular();
                        } else if (sayac == 11) {
                            mpalkis.start();
                            c.setBackground(getDrawable(R.drawable.greeen));
                            milyoner();
                            gerilim.stop();
                        }
                    } else {
                        if (sayac == 0) {
                            if (b.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                c.setBackground(getDrawable(R.drawable.k));
                                b.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else if (a.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                c.setBackground(getDrawable(R.drawable.k));
                                a.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();

                            } else {
                                mp4.start();t.cancel();
                                c.setBackground(getDrawable(R.drawable.k));
                                d.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            }
                        } else if (sayac == 1) {
                            if (b.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                c.setBackground(getDrawable(R.drawable.k));
                                b.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else if (a.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                c.setBackground(getDrawable(R.drawable.k));
                                a.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();

                            } else {
                                mp4.start();t.cancel();
                                c.setBackground(getDrawable(R.drawable.k));
                                d.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            }
                        } else if (sayac == 2) {
                            if (b.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                c.setBackground(getDrawable(R.drawable.k));
                                b.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else if (a.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                c.setBackground(getDrawable(R.drawable.k));
                                a.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();

                            } else {
                                mp4.start();t.cancel();
                                c.setBackground(getDrawable(R.drawable.k));
                                d.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            }
                        } else if (sayac == 3) {
                            if (b.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                c.setBackground(getDrawable(R.drawable.k));
                                b.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else if (a.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                c.setBackground(getDrawable(R.drawable.k));
                                a.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();

                            } else {
                                mp4.start();t.cancel();
                                c.setBackground(getDrawable(R.drawable.k));
                                d.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            }
                        } else if (sayac == 4) {
                            if (b.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                c.setBackground(getDrawable(R.drawable.k));
                                b.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else if (a.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                c.setBackground(getDrawable(R.drawable.k));
                                a.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();

                            } else {
                                mp4.start();t.cancel();
                                c.setBackground(getDrawable(R.drawable.k));
                                d.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            }
                        } else if (sayac == 5) {
                            if (b.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                c.setBackground(getDrawable(R.drawable.k));
                                b.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else if (a.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                c.setBackground(getDrawable(R.drawable.k));
                                a.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();

                            } else {
                                mp4.start();t.cancel();
                                c.setBackground(getDrawable(R.drawable.k));
                                d.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            }
                        } else if (sayac == 6) {
                            if (b.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                c.setBackground(getDrawable(R.drawable.k));
                                b.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else if (a.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                c.setBackground(getDrawable(R.drawable.k));
                                a.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();

                            } else {
                                mp4.start();t.cancel();
                                c.setBackground(getDrawable(R.drawable.k));
                                d.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            }
                        } else if (sayac == 7) {
                            if (b.getText().equals(dC)) {
                                gerilim.stop();t.cancel();
                                mp4.start();
                                c.setBackground(getDrawable(R.drawable.k));
                                b.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else if (a.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                c.setBackground(getDrawable(R.drawable.k));
                                a.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();

                            } else {
                                mp4.start();t.cancel();
                                c.setBackground(getDrawable(R.drawable.k));
                                d.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            }
                        } else if (sayac == 8) {
                            if (b.getText().equals(dC)) {
                                gerilim.stop();t.cancel();
                                mp4.start();
                                c.setBackground(getDrawable(R.drawable.k));
                                b.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else if (a.getText().equals(dC)) {
                                mp4.start();
                                c.setBackground(getDrawable(R.drawable.k));
                                a.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();

                            } else {
                                mp4.start();t.cancel();
                                c.setBackground(getDrawable(R.drawable.k));
                                d.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            }
                        } else if (sayac == 9) {
                            if (b.getText().equals(dC)) {
                                gerilim.stop();t.cancel();
                                mp4.start();
                                c.setBackground(getDrawable(R.drawable.k));
                                b.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else if (a.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                c.setBackground(getDrawable(R.drawable.k));
                                a.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();

                            } else {
                                mp4.start();
                                c.setBackground(getDrawable(R.drawable.k));
                                d.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            }
                        } else if (sayac == 10) {
                            if (b.getText().equals(dC)) {
                                gerilim.stop();t.cancel();
                                mp4.start();
                                c.setBackground(getDrawable(R.drawable.k));
                                b.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else if (a.getText().equals(dC)) {
                                mp4.start();
                                c.setBackground(getDrawable(R.drawable.k));
                                a.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();

                            } else {
                                mp4.start();t.cancel();
                                c.setBackground(getDrawable(R.drawable.k));
                                d.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            }
                        } else {
                            if (b.getText().equals(dC)) {
                                gerilim.stop();
                                mp4.start();t.cancel();
                                c.setBackground(getDrawable(R.drawable.k));
                                b.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else if (a.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                c.setBackground(getDrawable(R.drawable.k));
                                a.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();

                            } else {
                                mp4.start();t.cancel();
                                gerilim.stop();
                                c.setBackground(getDrawable(R.drawable.k));
                                d.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            }
                        }

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        thread.start();

    }

    public void dVoid() {
        String dd = d.getText().toString();
        String dC = dogru.getText().toString();
        Thread thread = new Thread() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            public void run() {
                try {
                    sleep(3000);
                    if (dd.equals(dC)) {
                        if (sayac == 0) {
                            birIki.start();
                            d.setBackground(getDrawable(R.drawable.greeen));
                            yeniSorular();
                        } else if (sayac == 1) {
                            birIki.start();
                            d.setBackground(getDrawable(R.drawable.greeen));
                            yeniSorular();
                        } else if (sayac == 2) {
                            mp3.start();
                            d.setBackground(getDrawable(R.drawable.greeen));
                            yeniSorular();
                        } else if (sayac == 3) {
                            mp3.start();
                            d.setBackground(getDrawable(R.drawable.greeen));
                            yeniSorular();
                        } else if (sayac == 4) {
                            mp3.start();
                            d.setBackground(getDrawable(R.drawable.greeen));
                            yeniSorular();
                        } else if (sayac == 5) {
                            mp3.start();
                            d.setBackground(getDrawable(R.drawable.greeen));
                            yeniSorular();
                        } else if (sayac == 6) {
                            mp3.start();
                            d.setBackground(getDrawable(R.drawable.greeen));
                            yeniSorular();
                        } else if (sayac == 7) {
                            mp3.start();
                            d.setBackground(getDrawable(R.drawable.greeen));
                            yeniSorular();
                        } else if (sayac == 8) {
                            mp3.start();
                            d.setBackground(getDrawable(R.drawable.greeen));
                            yeniSorular();
                        } else if (sayac == 9) {
                            mp3.start();
                            d.setBackground(getDrawable(R.drawable.greeen));
                            yeniSorular();
                        } else if (sayac == 10) {
                            mp3.start();
                            d.setBackground(getDrawable(R.drawable.greeen));
                            yeniSorular();
                        } else if (sayac == 11) {
                            mpalkis.start();
                            d.setBackground(getDrawable(R.drawable.greeen));
                            milyoner();
                            gerilim.stop();
                        }
                    } else {
                        if (sayac == 0) {
                            if (b.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                d.setBackground(getDrawable(R.drawable.k));
                                b.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else if (c.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                d.setBackground(getDrawable(R.drawable.k));
                                c.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else {
                                mp4.start();
                                d.setBackground(getDrawable(R.drawable.k));
                                a.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();t.cancel();
                            }
                        } else if (sayac == 1) {
                            if (b.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                d.setBackground(getDrawable(R.drawable.k));
                                b.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else if (c.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                d.setBackground(getDrawable(R.drawable.k));
                                c.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else {
                                mp4.start(); t.cancel();
                                d.setBackground(getDrawable(R.drawable.k));
                                a.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();

                            }
                        } else if (sayac == 2) {
                            if (b.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                d.setBackground(getDrawable(R.drawable.k));
                                b.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else if (c.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                d.setBackground(getDrawable(R.drawable.k));
                                c.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else {
                                mp4.start();t.cancel();
                                d.setBackground(getDrawable(R.drawable.k));
                                a.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            }
                        } else if (sayac == 3) {
                            if (b.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                d.setBackground(getDrawable(R.drawable.k));
                                b.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else if (c.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                d.setBackground(getDrawable(R.drawable.k));
                                c.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else {
                                mp4.start();t.cancel();
                                d.setBackground(getDrawable(R.drawable.k));
                                a.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            }
                        } else if (sayac == 4) {
                            if (b.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                d.setBackground(getDrawable(R.drawable.k));
                                b.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else if (c.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                d.setBackground(getDrawable(R.drawable.k));
                                c.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else {
                                mp4.start();t.cancel();
                                d.setBackground(getDrawable(R.drawable.k));
                                a.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            }
                        } else if (sayac == 5) {
                            if (b.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                d.setBackground(getDrawable(R.drawable.k));
                                b.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else if (c.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                d.setBackground(getDrawable(R.drawable.k));
                                c.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else {
                                mp4.start();t.cancel();
                                d.setBackground(getDrawable(R.drawable.k));
                                a.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            }
                        } else if (sayac == 6) {
                            if (b.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                d.setBackground(getDrawable(R.drawable.k));
                                b.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else if (c.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                d.setBackground(getDrawable(R.drawable.k));
                                c.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else {
                                mp4.start();t.cancel();
                                d.setBackground(getDrawable(R.drawable.k));
                                a.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            }
                        } else if (sayac == 7) {
                            if (b.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                gerilim.stop();
                                d.setBackground(getDrawable(R.drawable.k));
                                b.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else if (c.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                d.setBackground(getDrawable(R.drawable.k));
                                c.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else {
                                mp4.start();t.cancel();
                                d.setBackground(getDrawable(R.drawable.k));
                                a.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            }
                        } else if (sayac == 8) {
                            if (b.getText().equals(dC)) {
                                gerilim.stop();t.cancel();
                                mp4.start();
                                d.setBackground(getDrawable(R.drawable.k));
                                b.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else if (c.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                d.setBackground(getDrawable(R.drawable.k));
                                c.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else {
                                mp4.start();t.cancel();
                                d.setBackground(getDrawable(R.drawable.k));
                                a.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            }
                        } else if (sayac == 9) {
                            if (b.getText().equals(dC)) {
                                gerilim.stop();t.cancel();
                                mp4.start();
                                d.setBackground(getDrawable(R.drawable.k));
                                b.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else if (c.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                d.setBackground(getDrawable(R.drawable.k));
                                c.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else {
                                mp4.start();t.cancel();
                                d.setBackground(getDrawable(R.drawable.k));
                                a.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            }
                        } else if (sayac == 10) {
                            if (b.getText().equals(dC)) {
                                gerilim.stop();t.cancel();
                                mp4.start();
                                d.setBackground(getDrawable(R.drawable.k));
                                b.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else if (c.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                d.setBackground(getDrawable(R.drawable.k));
                                c.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else {
                                mp4.start();t.cancel();
                                d.setBackground(getDrawable(R.drawable.k));
                                a.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            }
                        } else {
                            if (b.getText().equals(dC)) {
                                gerilim.stop();
                                mp4.start();t.cancel();
                                d.setBackground(getDrawable(R.drawable.k));
                                b.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else if (c.getText().equals(dC)) {
                                mp4.start();t.cancel();
                                d.setBackground(getDrawable(R.drawable.k));
                                c.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            } else {
                                mp4.start();t.cancel();
                                d.setBackground(getDrawable(R.drawable.k));
                                a.setBackground(getDrawable(R.drawable.greeen));
                                paraMiktari();
                            }
                        }

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        thread.start();
    }

    public void yeniSorular() {
        runOnUiThread(new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            public void run() {
                try {
                    sleep(2000);
                    soruYenile();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void paraMiktari() {
        runOnUiThread(new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            public void run() {
                try {
                    sleep(2000);
                    paramNekadar();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public void paramNekadar() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        View view = getLayoutInflater().inflate(R.layout.paralar, null);
        builder.setView(view);
        Button btn = view.findViewById(R.id.btn_anasayfa);
        TextView tv = view.findViewById(R.id.txt_pere);
        final AlertDialog dialog = builder.create();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("moneys");
                dbRef.push().setValue(
                        new User1(
                                tv.getText().toString()
                        )

                );

                DatabaseReference dbRef2 = FirebaseDatabase.getInstance().getReference().child("times");
                dbRef2.push().setValue(
                        new Zaman(
                                saatTut.getText().toString()

                        )

                );
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        if (sayac == 0 || sayac == 1) {
            tv.setText("0");
        } else if (sayac == 2 || sayac == 3 || sayac == 4 || sayac == 5 || sayac == 6) {
            tv.setText("1000");
        } else {
            tv.setText("15000");
        }

        dialog.show();
    }

    public void milyoner() {
        runOnUiThread(new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            public void run() {
                try {
                    sleep(2000);
                    openWinDialog();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void sureGetir() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        View view = getLayoutInflater().inflate(R.layout.surefinish, null);
        builder.setView(view);
        Button btn = view.findViewById(R.id.btn_paraEkle);
        Button btn2 = view.findViewById(R.id.btn_surepara);
        final AlertDialog dialog = builder.create();
        if (sayac == 0 || sayac == 1) {
            btn2.setText("0");
        } else if (sayac == 2 || sayac == 3 || sayac == 4 || sayac == 5 || sayac == 6) {
            btn2.setText("1000");
        } else {
            btn2.setText("15000");
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("moneys");
                dbRef.push().setValue(
                        new User1(
                                btn2.getText().toString()
                        )

                );

                DatabaseReference dbRef2 = FirebaseDatabase.getInstance().getReference().child("times");
                dbRef2.push().setValue(
                        new Zaman(
                                saatTut.getText().toString()

                        )

                );
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
        dialog.show();

    }
    public void gecenSure(){

    }
    class timer extends CountDownTimer {
        public timer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) { //metodu ile ne yapacağını yazıcaz,sayaç çalıştıkça çalışan metod
            i++;
            saatTut.setText(Integer.toString(i));
        }

        @Override
        public void onFinish() { //sayma işlemi bittiğinde
        }
    }

}





