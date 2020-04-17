package com.example.deneme1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class yedinci extends AppCompatActivity {
    private FirebaseDatabase fr;
    private FirebaseAuth yetki;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yedinci);
        fr = FirebaseDatabase.getInstance();
        yetki = FirebaseAuth.getInstance();
        final String string ="20 günde 9 kilo vermek gayet başarılı bir diyet ve egzersiz yapma sonucunda gerçekleşir. Sabahları 1 bardak şekersiz limonata, 1 dilim kepek ekmeği, 1 dilim peynir. Gün içerisinde 1 bardak elma suyu, 1 kaşık krem peynir(kepek ekmeği ile ),  1 kase salata. 20 gün bu şekilde ilerlerseniz başarabilirsiniz.";
        Button button = findViewById(R.id.button22);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
