package com.example.deneme1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class anasayfa extends AppCompatActivity {

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anasayfa);
        mAuth = FirebaseAuth.getInstance();
        Button button = findViewById(R.id.buttonCikis);

        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                Intent cikisYap = new Intent(anasayfa.this,MainActivity.class);
                startActivity(cikisYap);
            }
        });
    }

    public void git3(View view) {
        Intent gecisYap = new Intent(anasayfa.this,ideal.class);
        startActivity(gecisYap);
    }

    public void git4(View view) {
        Intent gecisYap = new Intent(anasayfa.this,bazal.class);
        startActivity(gecisYap);
    }

    public void git5(View view) {
        Intent gecisYap = new Intent(anasayfa.this,diyethata.class);
        startActivity(gecisYap);
    }

    public void git6(View view) {
        Intent gecisYap = new Intent(anasayfa.this,diyetlisteri.class);
        startActivity(gecisYap);
    }

    public void git7(View view) {
        Intent gecisYap = new Intent(anasayfa.this,bilgilerim.class);
        startActivity(gecisYap);
    }
    public void git8(View view) {
        Intent gecisYap = new Intent(anasayfa.this,not.class);
        startActivity(gecisYap);
    }

    public void git9(View view) {
        Intent gecisYap = new Intent(anasayfa.this,cetvel.class);
        startActivity(gecisYap);
    }

    public void git10(View view) {
        Intent gecisYap = new Intent(anasayfa.this,aktiviteler.class);
        startActivity(gecisYap);
    }
}
