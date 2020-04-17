package com.example.deneme1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class diyetlisteri extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diyetlisteri);
    }

    public void asd1(View view) {
        Intent gecisYap = new Intent(diyetlisteri.this,birinci.class);
        startActivity(gecisYap);
    }
    public void asd2(View view) {
        Intent gecisYap = new Intent(diyetlisteri.this,ikinci.class);
        startActivity(gecisYap);
    }
    public void asd3(View view) {
        Intent gecisYap = new Intent(diyetlisteri.this,ucuncu.class);
        startActivity(gecisYap);
    }
    public void asd4(View view) {
        Intent gecisYap = new Intent(diyetlisteri.this,dort.class);
        startActivity(gecisYap);
    }
    public void asd5(View view) {
        Intent gecisYap = new Intent(diyetlisteri.this,besinci.class);
        startActivity(gecisYap);
    }
    public void asd6(View view) {
        Intent gecisYap = new Intent(diyetlisteri.this,altinci.class);
        startActivity(gecisYap);
    }
    public void asd7(View view) {
        Intent gecisYap = new Intent(diyetlisteri.this,yedinci.class);
        startActivity(gecisYap);
    }
    public void asd8(View view) {
        Intent gecisYap = new Intent(diyetlisteri.this,sekizinci.class);
        startActivity(gecisYap);
    }
    public void asd9(View view) {
        Intent gecisYap = new Intent(diyetlisteri.this,dokuzuncu.class);
        startActivity(gecisYap);
    }
    public void asd10(View view) {
        Intent gecisYap = new Intent(diyetlisteri.this,onuncu.class);
        startActivity(gecisYap);
    }
    public void asd11(View view) {
        Intent gecisYap = new Intent(diyetlisteri.this,onbir.class);
        startActivity(gecisYap);
    }
    public void asd12(View view) {
        Intent gecisYap = new Intent(diyetlisteri.this,oniki.class);
        startActivity(gecisYap);
    }

}

