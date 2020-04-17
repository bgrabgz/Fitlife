package com.example.deneme1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class kayitol extends AppCompatActivity {

    EditText edt_kullaniciAdi,edt_soyAdi,edt_Ad,edt_Email,edt_Sifre;

    Button btn_Kaydol;

    FirebaseAuth yetki;
    DatabaseReference yol;

    ProgressDialog pd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayitol);

        edt_kullaniciAdi=findViewById(R.id.edt_kullaniciAdi);
        edt_Ad=findViewById(R.id.edt_Ad);
        edt_soyAdi=findViewById(R.id.edt_soyAdi);
        edt_Email=findViewById(R.id.edt_Email);
        edt_Sifre=findViewById(R.id.edt_Sifre);

        btn_Kaydol=findViewById(R.id.btn_Kaydol_activity);

        yetki=FirebaseAuth.getInstance();


        btn_Kaydol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd = new ProgressDialog(kayitol.this);
                pd.setMessage("Lütfen bekleyiniz..");
                pd.show();

                String str_kullaniciAdi = edt_kullaniciAdi.getText().toString().trim();
                String str_soyAdi = edt_soyAdi.getText().toString().trim();
                String str_Ad = edt_Ad.getText().toString().trim();
                String str_Email = edt_Email.getText().toString().trim();
                String str_Sifre = edt_Sifre.getText().toString().trim();

                if (TextUtils.isEmpty(str_kullaniciAdi) || TextUtils.isEmpty(str_Ad) || TextUtils.isEmpty(str_Email)
                        || TextUtils.isEmpty(str_Sifre)) {
                    Toast.makeText(kayitol.this, "Lütfen Tüm Alanları Doldurun...", Toast.LENGTH_SHORT).show();
                }
                else if (str_Sifre.length() < 6) {
                    Toast.makeText(kayitol.this, "Şifreniz minimum 6 karakter olmalı...", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    //Yeni kullanıcı kaydetme kodlarını çağır

                    kaydet(str_kullaniciAdi,str_Ad,str_soyAdi,str_Email,str_Sifre);
                }
            }
        });







    }



    private void kaydet (final String kullaniciadi, final String ad, final String soyadi, final String email, final String sifre)
    {
        //Yeni kullanıcı kaydetme kodları
        yetki.createUserWithEmailAndPassword(  email,sifre)
                .addOnCompleteListener(kayitol.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful())
                        {
                            FirebaseUser firebasekullanici = yetki.getCurrentUser();

                            String kullaniciId = firebasekullanici.getUid();

                            Kullanici kullanici = new Kullanici(kullaniciadi,ad,soyadi,email,sifre);

                            yol = FirebaseDatabase.getInstance().getReference()
                                    .child("Kullanıcılar").child(kullaniciId);

                            HashMap<String, Object> hashMap = new HashMap<>();

                            hashMap.put("id",kullaniciId);
                            hashMap.put("kullaniciadi",kullaniciadi.toLowerCase());
                            hashMap.put("ad",ad);
                            hashMap.put("soyad",soyadi);
                            hashMap.put("mail",email);
                            hashMap.put("sifre",sifre);

                            yol.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    if (task.isSuccessful())
                                    {

                                        pd.dismiss();

                                        Intent intent = new Intent(kayitol.this,anasayfa.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(intent);


                                    }

                                }
                            });
                        }

                         else
                             {
                                 Log.d(kayitol.class.getName(), "onFail: " +task.getException());
                                 pd.dismiss();
                                 Toast.makeText(kayitol.this, "Bu mail veya şifre ile kayıt başarısız... ", Toast.LENGTH_LONG).show();
                             }



                    }
                });


    }

    }


