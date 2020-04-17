package com.example.deneme1;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class bilgilerim extends AppCompatActivity implements View.OnClickListener{

    private EditText ad, mail, boy;
    private Button kaydet, gor;
    private TextView kayitgör;

    FirebaseDatabase fr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilgilerim);
        sesgetir();


    }

    private void sesgetir() {

        fr = FirebaseDatabase.getInstance();
        ad = (EditText) findViewById(R.id.editText);
        mail = (EditText) findViewById(R.id.editText3);
        boy = (EditText) findViewById(R.id.editTextKilo);
        kaydet = (Button) findViewById(R.id.button3);
        gor = (Button) findViewById(R.id.button4);
        kayitgör = (TextView) findViewById(R.id.textView);

        kaydet.setOnClickListener(this);
        gor.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button3:
                String adınız, mailiniz;
                int boyunuz;
                adınız = ad.getText().toString().trim();
                mailiniz = mail.getText().toString().trim();
                boyunuz = Integer.valueOf(boy.getText().toString().trim());
                kullaniciKaydet(adınız, mailiniz, boyunuz);
                break;
            case R.id.button14:
                kayitlariGetir();
                break;
        }
    }

    private void kullaniciKaydet(String ad, String mail, int boyu) {

        DatabaseReference dbRef = fr.getReference("KayıtBilgi");
        String key = dbRef.push().getKey();
        DatabaseReference dbRefKeyli = fr.getReference("KayıtBilgi/" + key);

        dbRefKeyli.setValue(new Kullanici(ad, mail, boyu));

    }

    private void kayitlariGetir() {
        kayitgör.setText("");


        DatabaseReference dbGelenler = fr.getReference("KayıtBilgi");
        dbGelenler.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot gelenler : dataSnapshot.getChildren()) {

                    kayitgör.append(gelenler.getValue(klcnblgb.class).getAd() + "\n");
                    kayitgör.append(gelenler.getValue(klcnblgb.class).getMail() + "\n");
                    kayitgör.append(gelenler.getValue(klcnblgb.class).getBoy() + "\n");

                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}