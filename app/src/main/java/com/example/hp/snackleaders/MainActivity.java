package com.example.hp.snackleaders;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int counter=0;
    TextView[] txtv; int count = 0;
    LinearLayout lLayout;
    LinearLayout Llayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout parent = (LinearLayout) findViewById(R.id.parent);


        txtv = new TextView[64];
        for (int j = 0; j < 8; j++) {
            Llayer = new LinearLayout(this);
            Llayer.setOrientation(LinearLayout.HORIZONTAL);

            for(int i = 0; i < 8; i++){
                int item = j * 8 + i;
                txtv[item] = new TextView(this);
                txtv[item].setLayoutParams(new ViewGroup.LayoutParams(80, 80));
                txtv[item].setBackgroundResource(R.drawable.stroke);
                txtv[item].setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                txtv[item].setPadding(2,7,2,2);
                count++;
                txtv[item].setText(String.valueOf(count-1));
                txtv[item].setTag(item);
               // txtv[1].setText("Start");
               // txtv[64].setText("END");

                Llayer.addView(txtv[item]);
            }
            parent.addView(Llayer);


        }
        //parent.addView(lLayout);

        Button dice = (Button) findViewById(R.id.dice);
        dice.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {


                Random rnd = new Random();
                int home = counter;
                String temp = txtv[counter].getText().toString();
                txtv[counter].setText(String.valueOf(txtv[counter].getTag()));

                int key = rnd.nextInt(6);

                counter+=key;
                txtv[counter].setText(String.valueOf("hamed"));
                TextView dicetxt = (TextView) findViewById(R.id.dice_number);
                //counter++;


                dicetxt.setText(String.valueOf(key));
            }
        });
    }

    }

