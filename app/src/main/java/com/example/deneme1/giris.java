package com.example.deneme1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class giris extends AppCompatActivity {

              EditText edt_email_Giris, edt_Sifre_giris;

              Button btn_giris_Yap;

              TextView txt_kayitSayfasına_Git;

              FirebaseAuth girisYetkisi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);

        edt_email_Giris = findViewById(R.id.edt_Email_giris);
        edt_Sifre_giris = findViewById(R.id.edt_Sifre_giris);

        btn_giris_Yap = findViewById(R.id.btn_Giris_activity);

        girisYetkisi = FirebaseAuth.getInstance();

        btn_giris_Yap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog pdGiris = new ProgressDialog(giris.this);
                pdGiris.setMessage("Giriş yapılıyor...");
                pdGiris.show();

                String str_emailGiris = edt_email_Giris.getText().toString();
                String str_sifreGiris = edt_Sifre_giris.getText().toString();

                if (TextUtils.isEmpty(str_emailGiris)||TextUtils.isEmpty(str_sifreGiris))

                {
                    Toast.makeText(giris.this, "Bütün alakları doldurun...", Toast.LENGTH_LONG).show();
                }

                else
                {
                    //Giriş yapma kodları

                    girisYetkisi.signInWithEmailAndPassword(str_emailGiris,str_sifreGiris)
                            .addOnCompleteListener(giris.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful())
                                    {
                                        DatabaseReference yolGiris = FirebaseDatabase.getInstance().getReference().
                                                child("Kullanıcılar").child(girisYetkisi.getCurrentUser().getUid());

                                        yolGiris.addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                                pdGiris.dismiss();
                                                Intent intent = new Intent(giris.this,anasayfa.class);
                                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                                startActivity(intent);
                                                finish();
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                                pdGiris.dismiss();

                                            }
                                        });
                                    }
                                       else
                                    {
                                        pdGiris.dismiss();
                                        Toast.makeText(giris.this, "Giriş Başarısız!!!", Toast.LENGTH_LONG).show();
                                    }

                                }
                            });
                }




            }
        });
    }
}
