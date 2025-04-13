package com.example.android;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Counter extends AppCompatActivity {


    Button resetButton , plusButton, maiButton;
    TextView numberTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_counter);

        resetButton = findViewById(R.id.resetButton);
        plusButton = findViewById(R.id.plusButton);
        maiButton = findViewById(R.id.maiButton);
        numberTextView = findViewById(R.id.numberTextView);

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = numberTextView.getText().toString();
                int num = Integer.parseInt(str) + 1;
                numberTextView.setText(String.valueOf(num));

            }





        });
        maiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    String str = numberTextView.getText().toString();
                    if (Integer.parseInt(str) != 0) {
                    int num = Integer.parseInt(str) - 1;
                    numberTextView.setText(String.valueOf(num));}
            }
        });
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberTextView.setText("0");
            }
        });

    }
}