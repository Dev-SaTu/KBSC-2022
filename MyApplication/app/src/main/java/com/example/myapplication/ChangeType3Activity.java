package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ChangeType3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_type3);

        EditText name = findViewById(R.id.welfare_name_text_edit);
        EditText address1 = findViewById(R.id.welfare_address1_text_edit);
        EditText address2 = findViewById(R.id.welfare_address2_text_edit);
        EditText tel = findViewById(R.id.welfare_tel_text_edit);
        Button changeTypeSubmitBtn = findViewById(R.id.change_type3_submit_btn);
    }
}