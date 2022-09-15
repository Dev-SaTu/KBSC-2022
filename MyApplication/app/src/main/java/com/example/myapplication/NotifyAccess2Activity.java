package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class NotifyAccess2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify_access2);

        Button buttonNext = this.findViewById(R.id.apply_next);
        buttonNext.setOnClickListener(view -> {
            Intent i = new Intent(this, HomeActivity.class);
            startActivity(i);
            finish();
        });

        Button buttonPrev = this.findViewById(R.id.apply_prev);
        buttonPrev.setOnClickListener(view -> {
            Intent i = new Intent(this, NotifyAccess1Activity.class);
            startActivity(i);
            finish();
        });

    }
}
