package com.unipi.dkarampinas.lesson2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    TextView textView3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main3);

        // getting info from activity 1 and assigning it to textView3 view
        textView3 = findViewById(R.id.textView4);
        String textReceived = getIntent().getStringExtra("key1");
        textView3.setText(textReceived);

    }
}