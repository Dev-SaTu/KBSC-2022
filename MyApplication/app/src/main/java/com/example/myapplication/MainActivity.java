package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.modle.User;
import com.example.myapplication.retrofit.RetrofitService;
import com.example.myapplication.retrofit.UserApi;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public static User user = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText inputId = findViewById(R.id.idEditText);
        EditText inputPw = findViewById(R.id.pwEditText);

        Button signUpBtn = findViewById(R.id.sign_up_btn);
        Button loginBtn = findViewById(R.id.login_btn);

        RetrofitService retrofitService = new RetrofitService();
        UserApi userApi = retrofitService.getRetrofit().create(UserApi.class);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(i);
            }
        });

        loginBtn.setOnClickListener(view -> {
            String id = String.valueOf(inputId.getText());
            String pw = String.valueOf(inputPw.getText());

            userApi.findUser(id)
                    .enqueue(new Callback<User>() {
                        @Override
                        public void onResponse(Call<User> call, Response<User> response) {
                            user = response.body();
                        }
                        @Override
                        public void onFailure(Call<User> call, Throwable t) {
                            Toast.makeText(MainActivity.this, "아이디/ 비밀번호가 틀렸습니다.1", Toast.LENGTH_SHORT).show();
                            Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, "Error accurred",t);
                        }
                    });

            if(user != null){
                if(user.getId().equals(id) && user.getPw().equals(pw)){
                    Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(MainActivity.this, "아이디/ 비밀번호가 틀렸습니다.2", Toast.LENGTH_SHORT).show();
                }
            }
            else
                Toast.makeText(MainActivity.this, "아이디/ 비밀번호가 틀렸습니다.3", Toast.LENGTH_SHORT).show();
        });
    }
}