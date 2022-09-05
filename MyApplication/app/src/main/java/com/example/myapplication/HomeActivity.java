package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.retrofit.RetrofitService;
import com.example.myapplication.retrofit.UserApi;
import com.google.zxing.integration.android.IntentIntegrator;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button button = findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this, BenefitUserAllowActivity.class);
                startActivity(i);
            }
        });

        Button buttonQR = findViewById(R.id.buttonQR);

        buttonQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this, StorePointActivity.class);
                startActivity(i);
            }
        });

        Button buttonCamera = findViewById(R.id.buttonCamera);

        buttonCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                IntentIntegrator qrScan = new IntentIntegrator(HomeActivity.this);
                qrScan.setOrientationLocked(false); // default가 세로모드인데 휴대폰 방향에 따라 가로, 세로로 자동 변경됩니다.
                qrScan.setCameraId(1); //후방카메라=0, 전면카메라=1
                qrScan.setPrompt("<<QR 코드를 스캔하여 주세요>>");
                qrScan.initiateScan();

            }
        });

    }
}