package com.example.deneme1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ikinci extends AppCompatActivity {

    private FirebaseDatabase fr;
    private FirebaseAuth yetki;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ikinci);
        fr = FirebaseDatabase.getInstance();
        yetki = FirebaseAuth.getInstance();
        final String string = "5 günde 1 kilo vermek demek sağlıklı ve yavaş kilo vermek demektir. Sağlıklı kilo vermenin püf noktalarından biride budur. Diğer şok diyetler gibi  çok fazla tehlike içermeyen bir diyet yöntemidir. Ama her diyette olduğu gibi bu diyette dikkat etmemiz gereken önemli nokta sağlığımızdır.";

        Button button = findViewById(R.id.button18);

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
        DatabaseReference dbRefKeyli = fr.getReference("Kullanıcılar").child(kullaniciId).child("KayitliNotlar" +key);

        dbRefKeyli.setValue(new KullaniciKayitliNotlar(string));

    }
}
