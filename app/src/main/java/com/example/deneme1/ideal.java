package com.example.deneme1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ideal extends AppCompatActivity {

    EditText editText8, editText9;
    Button button5;
    TextView textView17;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ideal);

        editText8 = findViewById(R.id.editText8);
        editText9 = findViewById(R.id.editText9);
        button5 = findViewById(R.id.button5);
        textView17 = findViewById(R.id.textView17);


        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double s1 = Double.parseDouble(editText8.getText().toString());
                double s2 = Double.parseDouble(editText9.getText().toString());
                double sonuc = s2 / (s1 * s1);

                if (sonuc <= 18)
                    textView17.setText(" 2 Kilo almalısınız... ");
                else if (sonuc <= 20)
                    textView17.setText("4 Kilo almalısınız... ");
                else if (sonuc <= 23)
                    textView17.setText(" Kilonuz ideal... ");
                else if (sonuc <= 26)
                    textView17.setText("6 Kilo almalısınız... ");
                else if (sonuc <= 30)
                    textView17.setText("8 Kilo almalısınız... ");
                else if (sonuc > 32)
                    textView17.setText("10 Kilo almalısınız...");
            }

        });
    }
}






