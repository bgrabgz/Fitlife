package com.example.deneme1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class sekizinci extends AppCompatActivity {
    private FirebaseDatabase fr;
    private FirebaseAuth yetki;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sekizinci);
        fr = FirebaseDatabase.getInstance();
        yetki = FirebaseAuth.getInstance();
        final String string ="Metabolizmayı hızlandıran diyet listesinde her yemeği istediğiniz gibi yiyebilir ama hazırlarken büyük özen göstermeniz gerekir. Örneğin bir börek yaparken yağsız bir şekilde yapıp az kalorili hale getirmek mümkündür. Sabahları ılık ballı limonlu su ve 2 adet elma ile başlayabilirsiniz…";
        Button button = findViewById(R.id.button23);

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
