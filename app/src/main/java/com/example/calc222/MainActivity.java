package com.example.calc222;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Random random = new Random();
    private TextView maxNum;
    private TextView buttonNumber;
    private TextView answer;
    private TextView False,True;
    int s1=0,s2=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        maxNum = findViewById(R.id.maxNum);
        buttonNumber = findViewById(R.id.buttonNum);
        answer = findViewById(R.id.result);
        False = findViewById(R.id.False);
        True = findViewById(R.id.True);

        Button basicButton = findViewById(R.id.base);
        Button mediumButton = findViewById(R.id.middle);
        Button professionalButton = findViewById(R.id.hard);

        basicButton.setOnClickListener(view -> generateRandomNumbers("BASIC"));
        mediumButton.setOnClickListener(view -> generateRandomNumbers("MEDIUM"));
        professionalButton.setOnClickListener(view -> generateRandomNumbers("PROFESSIONAL"));

    }

    private void generateRandomNumbers(String level) {
        int maxRange;
        int minRange;
        if(level.equals("BASIC")){

            maxRange=(int)(Math.random()*11);
            minRange=(int)(Math.random()*11);
            maxNum.setText(String.valueOf(maxRange));
            buttonNumber.setText(String.valueOf(minRange));
        }
        if(level.equals("MEDIUM")){
            maxRange=(int)((Math.random()*11)+10);
            minRange=(int)(Math.random()*11);
            maxNum.setText(String.valueOf(maxRange));
            buttonNumber.setText(String.valueOf(minRange));
        }
        if(level.equals("PROFESSIONAL")){
            maxRange=(int)((Math.random()*100)+10);
            minRange=(int)((Math.random()*100)+10);
            maxNum.setText(String.valueOf(maxRange));
            buttonNumber.setText(String.valueOf(minRange));

        }
    }

    public void check(View view) {

        int userA = Integer.parseInt(answer.getText().toString());
        int trueAnswer = Integer.parseInt(maxNum.getText().toString()) * Integer.parseInt(buttonNumber.getText().toString());
        if(userA == trueAnswer){
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
            s1++;
            True.setText(String.valueOf(s1));
        }
        else {

            Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
            s2++;
            False.setText(String.valueOf(s2));
        }
    }


}
