package com.example.zaliczenie;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Wynik extends AppCompatActivity {

    TextView tv, tv2, tv3;
    Button btnRestart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tv = (TextView)findViewById(R.id.tvres);
        tv2 = (TextView)findViewById(R.id.tvres2);
        tv3 = (TextView)findViewById(R.id.tvres3);
        btnRestart = (Button) findViewById(R.id.btnRestart);

        StringBuffer sb = new StringBuffer();
        sb.append("Poprawane odpowiedzi: " + Pytania.correct + "\n");
        StringBuffer sb2 = new StringBuffer();
        sb2.append("Złe odpowiedzi: " + Pytania.wrong + "\n");
        StringBuffer sb3 = new StringBuffer();
        sb3.append("Wynik: " + Pytania.correct + "\n");
        tv.setText(sb);
        tv2.setText(sb2);
        tv3.setText(sb3);

        Pytania.correct=0;
        Pytania.wrong=0;

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(in);
            }
        });
    }
}
