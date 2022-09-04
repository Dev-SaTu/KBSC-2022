package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class activity_benefit_user_allow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_benefit_user_allow);

        EditText editText = findViewById(R.id.input_name);
        Button button = (Button) findViewById(R.id.sign_up_submit_btn);

        button.setOnClickListener(view -> {



        });

    }
}