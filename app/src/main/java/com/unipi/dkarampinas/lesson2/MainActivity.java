/*
package com.unipi.dkarampinas.lesson2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button;      // global variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // generic method to convert resource id to button
        button = findViewById(R.id.button);      // connecting Java code with existing button | Resources.id.button(id)
        button.setText("YoWhatUp");
        View textView = findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener(){   // single method interface called Functional Interface
            @Override
            public void onClick(View view) {
                textView.setText("You clicked the button!");
            }
        });

    }

}*/

package com.unipi.dkarampinas.lesson2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.unipi.dkarampinas.lesson2.R;

public class MainActivity extends AppCompatActivity {
    // instantiating objects to relate to controls
    Button button, button2;
    TextView textView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);         // creating relation to button object and button control
        button2 = findViewById(R.id.button2);
        button.setText("Press me!");
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editTextTextPersonName);


        // on click event through listener without lambda
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("You clicked the button!");
            }
        });

        // on click event through listener lambda | 2 listeners cannot listen to the same view
        button2.setOnClickListener(view -> {
            Toast.makeText(this, "This is a toast", Toast.LENGTH_LONG).show();
        });
    }


    // on click event | fastest way to create events through user interface instead of listener
    public void go2(View view) {
        Intent intent = new Intent(this, MainActivity2.class);      // asking OS to start new Activity
        startActivity(intent);
    }

    // on click method to go to activity3
    public void go3(View view) {
        String text = editText.getText().toString();        // getting edittext content into variable
        Intent intent = new Intent(this, MainActivity3.class);
        intent.putExtra("key1", text);      // providing the information to be relayed through key value method
        startActivity(intent);
    }

    // asking for gps permission
    public void gogps(View view){

        // checking if permission already granted | if permission is granted no pop-up appears
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 123);       // asking for gps permission
        }

    }

}
