package com.example.deneme1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class onbir extends AppCompatActivity {

    private FirebaseDatabase fr;
    private FirebaseAuth yetki;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onbir);
        fr = FirebaseDatabase.getInstance();
        yetki = FirebaseAuth.getInstance();
        final String string ="Yumurta iyi bir protein deposudur. Bu durumdan dolayı yumurtanın iyi bir tok tutucu olduğu gerçektir. Yumurta yiyen insanlar hemen acıkmaz ve sürekli yemek yeme hissi duymazlar. Durum böyleyken yumurta ile yapılan diyet oldukça etkili olacaktır. Ancak yumurtanın fazla tüketildiği zaman zararlı olacağını da unutmamak lazım.";
        Button button = findViewById(R.id.button26);

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
