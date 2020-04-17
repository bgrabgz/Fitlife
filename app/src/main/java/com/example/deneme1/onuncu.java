package com.example.deneme1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class onuncu extends AppCompatActivity {

    private FirebaseDatabase fr;
    private FirebaseAuth yetki;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onuncu);
        fr = FirebaseDatabase.getInstance();
        yetki = FirebaseAuth.getInstance();
        final String string ="Portakal diyetini egzersizlerle destekleyerek sizde ideal kilonuza ulaşabilirsiniz. Diyetin ara vermeden 3 hafta uygulanması ve bu dönem boyunca her gün en az 2 litre su içmeye dikkat edilmesi gerekir. 3 haftalık süreçte aynı program devam ettirilmeli ve harfiyen uymaya özen gösterilmeli. ";
        Button button = findViewById(R.id.button25);

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
