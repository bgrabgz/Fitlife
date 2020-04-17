package com.example.deneme1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class birinci extends AppCompatActivity {

    private FirebaseDatabase fr;
    private FirebaseAuth yetki;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birinci);
        fr = FirebaseDatabase.getInstance();
        yetki = FirebaseAuth.getInstance();
        final String string = "Yalnızca 1 haftada fazlalıklarınızdan kurtulmak ister misiniz? O zaman doğru yerdesiniz! 1 haftada 10 kilo vermenin formülü açıklayacağım. Oldukça etkili olan bu diyet hızlı kilo vermek isteyenler için iyi bir motivasyon kaynağı.  Yalnızca 1 haftada bedeninizi inceltme imkanınız varken neden olmasın.";

        Button button = findViewById(R.id.button7);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kaydet(string);
            }
        });
    }

    private void kaydet(String string) {

        DatabaseReference dbRef = fr.getReference("KayitliNotlar");
        String key = dbRef.push().getKey();

        FirebaseUser firebasekullanici = yetki.getCurrentUser();
        String kullaniciId = firebasekullanici.getUid();
        DatabaseReference dbRefKeyli = fr.getReference("Kullanıcılar").child(kullaniciId).child("KayitliNotlar"+key);

        dbRefKeyli.setValue(new KullaniciKayitliNotlar(string));

    }
}
