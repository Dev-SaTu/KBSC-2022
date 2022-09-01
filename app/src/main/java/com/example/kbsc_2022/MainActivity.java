package com.example.kbsc_2022;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.sign_up_btn);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                new Thread(() -> {

                    try {

                        HttpURLConnection urlConnection = null;
                        URL url = new URL("http://www.bitoma.me/api/hello");

                        urlConnection = (HttpURLConnection) url.openConnection();
                        urlConnection.setRequestMethod("GET");
                        urlConnection.setConnectTimeout(5000);
                        urlConnection.setReadTimeout(5000);

                        BufferedReader bufreader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
                        StringBuffer stb = new StringBuffer();
                        String line = null;
                        while ((line = bufreader.readLine()) != null) {
                            stb.append(line);
                        }
                        bufreader.close();

                        Handler handler = new Handler(Looper.getMainLooper());
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run()
                            {
                                Toast myToast = Toast.makeText(getApplicationContext(), stb.toString(), Toast.LENGTH_SHORT);
                                myToast.show();
                            }
                        }, 0);


                    } catch (Exception e) {

                        e.printStackTrace();

                    }

                }).start();

            }

        });


    }
}