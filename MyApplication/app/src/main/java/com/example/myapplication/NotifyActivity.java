package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class NotifyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify_map);

        Button map = findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                map.setBackgroundColor(map.getResources().getColor(R.color.color1));
                startActivity(new Intent(NotifyActivity.this, NotifyActivity_store.class));
            }
        });

        Button store = findViewById(R.id.store);
        store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                map.setBackgroundColor(map.getResources().getColor(R.color.color1));
                startActivity(new Intent(NotifyActivity.this, NotifyActivity_store.class));
            }
        });

        Button welfare = findViewById(R.id.welfare);
        welfare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                map.setBackgroundColor(map.getResources().getColor(R.color.color1));
                startActivity(new Intent(NotifyActivity.this, NotifyActivity_welfare.class));
            }
        });
    }
}
