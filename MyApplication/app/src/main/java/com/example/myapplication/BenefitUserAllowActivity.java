package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.retrofit.RetrofitService;
import com.example.myapplication.retrofit.UserApi;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BenefitUserAllowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_benefit_user_allow);

        EditText editText = findViewById(R.id.editTextTextPersonName);
        Button button = (Button) findViewById(R.id.allow_button);

        button.setOnClickListener(view -> {

            RetrofitService retrofitService = new RetrofitService();
            UserApi userApi = retrofitService.getRetrofit().create(UserApi.class);

            userApi.allowBenefitUser(editText.getText().toString().trim(), MainActivity.user.getId()).enqueue(new Callback<Map<String, String>>() {
                @Override
                public void onResponse(Call<Map<String, String>> call, Response<Map<String, String>> response) {
                    String code = response.body().get("code");
                    String message = response.body().get("message");
                    Toast.makeText(BenefitUserAllowActivity.this, String.format("[%s] %s", code, message), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<Map<String, String>> call, Throwable t) {
                    Toast.makeText(BenefitUserAllowActivity.this, "수혜자 변경에 실패했습니다.", Toast.LENGTH_SHORT).show();
                    Logger.getLogger(SignUpActivity.class.getName()).log(Level.SEVERE, "Error occurred",t);
                }
            });

        });

    }
}