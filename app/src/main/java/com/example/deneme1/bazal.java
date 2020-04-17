package com.example.deneme1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class bazal extends AppCompatActivity {

    EditText editText11,editText12;
    Button button6;
    TextView textView25;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bazal);

        editText11 = findViewById(R.id.editText11);
        editText12 = findViewById(R.id.editText12);
        button6 = findViewById(R.id.button6);
        textView25 = findViewById(R.id.textView25);

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double s1 = Double.parseDouble(editText11.getText().toString());
                double s2 = Double.parseDouble(editText12.getText().toString());
                double sonuc = s2/(s1*s1);

                if (sonuc<=18)
                    textView25.setText(" 2 Kilo almalısınız... ");
                else if (sonuc<=25)
                    textView25.setText("4 Kilo almalısınız... ");
                else if (sonuc<=30)
                    textView25.setText(" Kilonuz ideal... ");
                else if (sonuc<=35)
                    textView25.setText("6 Kilo almalısınız... ");
                else if (sonuc<=45)
                    textView25.setText("8 Kilo almalısınız... ");
                else if (sonuc >45)
                    textView25.setText("10 Kilo almalısınız...");
            }
        });
    }
}
