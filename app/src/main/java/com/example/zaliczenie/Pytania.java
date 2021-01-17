package com.example.zaliczenie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Pytania extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
            "KTÓRY Z TYCH MODELI NIE BYŁ PRODUKOWANY PRZEZ FORDA?",
            "KTÓRY POLSKI SAMOCHÓD BYŁ NAPĘDZANY DWUSUWOWYM SILNIKIEM?",
            "KTÓRY Z TYCH MODELI JEST REKLAMOWANY JAKO CZTERODRZWIOWE COUPE?",
            "DO KTÓREGO KONCERNU NALEŻY NIEMIECKA MARKA OPEL?",
            "KTÓRY Z TYCH MODELI NIE BYŁ FIATEM?",
            "JAK NAZYWA SIĘ FIRMA, KTÓRĄ STWORZYŁ ELON MUSK?",
            "W KTÓRYM ROKU ROZPOCZĘTO PRODUKCJĘ WSPÓŁCZESNEJ SKODY OCTAVII PIERWSZEJ GENERACJI?",
            "JAK SIĘ OZNACZA NAPĘD NA CZTERY KOŁA W SAMOCHODACH AUDI?",
            "W KTÓRYM POLSKIM MIEŚCIE FIAT PRODUKUJE SAMOCHODY?",
            "JAKIE AUTO POBIŁO REKOR DŚWIATA PRĘDKOŚCI Z WYNIKIEM 490KM/H?"
    };
    String answers[] = {"Scirocco","Syrena","MercedesCLS","Utopia","Tesla Motors","Quattro","W Tychach","Bugatti Chiron Super Sport"};
    String opt[] = {
            "Scorpio","Taurus","Cougar","Scirocco",
            "Fiat 126p","Syrena","Fiat 125p","Polonez",
            "Maserati Quattroporte","BMW X6","Mercedes CLS","Volvo S90",
            "Ford Motor Company","General Motors","Tata Group","PSA Peugeot Citroen",
            "Panda","Utopia","Linea","Idea",
            "Tesla Motors","Fisker Motors","Faraday Future","Mobileye",
            "1996","2001","1995","1998",
            "4Matic","X-Drive","Syncro","Quattro",
            "W Gliwicach","W Bielsku-Białej","W Tychach","We Wrześni",
            "Koenigsegg Agera RS","Hennessey Venom GT","Bugatti Chiron Super Sport","SSC Tuatara:"
    };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        final TextView score = (TextView)findViewById(R.id.textView4);
        TextView textView=(TextView)findViewById(R.id.DispName);

        Intent intent = getIntent();




        submitbutton=(Button)findViewById(R.id.button3);
        quitbutton=(Button)findViewById(R.id.buttonquit);
        tv=(TextView) findViewById(R.id.tvque);

        radio_g=(RadioGroup)findViewById(R.id.answersgrp);
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3);
        rb4=(RadioButton)findViewById(R.id.radioButton4);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int color = mBackgroundColor.getColor();
                //mLayout.setBackgroundColor(color);

                if(radio_g.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Prosze wybrac jedna odpowiedz", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
              Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if(ansText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Dobrze!", Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Zle :(", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (score != null)
                    score.setText(""+correct);

                if(flag<questions.length)
                {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4 +1]);
                    rb3.setText(opt[flag*4 +2]);
                    rb4.setText(opt[flag*4 +3]);
                }
                else
                {
                    marks=correct;
                    Intent in = new Intent(getApplicationContext(),Wynik.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Wynik.class);
                startActivity(intent);
            }
        });
    }

}
