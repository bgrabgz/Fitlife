package com.example.deneme1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class dokuzuncu extends AppCompatActivity {
    private FirebaseDatabase fr;
    private FirebaseAuth yetki;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dokuzuncu);
        fr = FirebaseDatabase.getInstance();
        yetki = FirebaseAuth.getInstance();
        final String string ="Yoğurt diyeti içerisindeki yüksek kolesterol ve fosfor sebebiyle yüksek kolesterol ve böbrek taşı sorunu olan kişiler için uygun değildir. Bu diyeti 2 haftadan fazla uygulamamaya özen gösteriniz. 2 adet domates mantar ve az yağlı peynirli bir kase bulgur pilavı ile 2 kasa yoğurt tüketiniz. ";
        Button button = findViewById(R.id.button24);

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
