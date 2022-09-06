package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.myapplication.modle.User;
import com.example.myapplication.retrofit.RetrofitService;
import com.example.myapplication.retrofit.UserApi;
import com.google.android.material.textfield.TextInputEditText;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        initializeCompoents();
    }

    private void initializeCompoents() {
        EditText inputId = findViewById(R.id.input_id);
        EditText inputPw = findViewById(R.id.input_pw);
        EditText inputPwCheck = findViewById(R.id.input_pw_check);
        EditText inputName = findViewById(R.id.input_name);
        EditText inputAddress = findViewById(R.id.input_address);
        EditText inputTel = findViewById(R.id.input_number);
        Switch inputType = findViewById(R.id.input_type);
        Button submitBtn = (Button) findViewById(R.id.sign_up_submit_btn);

        RetrofitService retrofitService = new RetrofitService();
        UserApi userApi = retrofitService.getRetrofit().create(UserApi.class);

        submitBtn.setOnClickListener(view -> {
            String id = String.valueOf(inputId.getText());
            String pw = String.valueOf(inputPw.getText());
            String checkPw = String.valueOf(inputPwCheck.getText());
            String name = String.valueOf(inputName.getText());
            String address = String.valueOf(inputAddress.getText());
            String tel = String.valueOf(inputTel.getText());
            int type = inputType.isChecked() ? 1 : 0;

            User user = new User();
            user.setId(id);
            user.setPw(pw);
            user.setName(name);
            user.setAddress(address);
            user.setTel(tel);
            user.setType(type);

            if(pw.equals(checkPw)){
                userApi.userSignUp(user)
                    .enqueue(new Callback<User>() {
                        @Override
                        public void onResponse(Call<User> call, Response<User> response) {
                            Toast.makeText(SignUpActivity.this, "회원가입이 완료 되었습니다.", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<User> call, Throwable t) {
                            Toast.makeText(SignUpActivity.this, "이미 존재하는 아이디 입니다.", Toast.LENGTH_SHORT).show();
                            Logger.getLogger(SignUpActivity.class.getName()).log(Level.SEVERE, "Error occurred",t);
                        }
                    });
            }
            else
                Toast.makeText(SignUpActivity.this, "비밀번호가 틀립니다.", Toast.LENGTH_SHORT).show();
        });
    }
}