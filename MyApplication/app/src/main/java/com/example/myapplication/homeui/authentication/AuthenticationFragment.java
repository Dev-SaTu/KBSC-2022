package com.example.myapplication.homeui.authentication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.SignUpActivity;
import com.example.myapplication.retrofit.RetrofitService;
import com.example.myapplication.retrofit.UserApi;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthenticationFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_authentication, container, false);

        EditText editText = v.findViewById(R.id.change_type_userId_edit);
        Button button = (Button) v.findViewById(R.id.allow_button);

        button.setOnClickListener(view -> {

            RetrofitService retrofitService = new RetrofitService();
            UserApi userApi = retrofitService.getRetrofit().create(UserApi.class);

            userApi.allowBenefitUser(editText.getText().toString().trim(), MainActivity.user.getId()).enqueue(new Callback<Map<String, String>>() {

                @Override
                public void onResponse(Call<Map<String, String>> call, Response<Map<String, String>> response) {
                    String code = response.body().get("code");
                    String message = response.body().get("message");
                    Toast.makeText(getContext(), String.format("[%s] %s", code, message), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<Map<String, String>> call, Throwable t) {
                    Toast.makeText(getContext(), "수혜자 변경에 실패했습니다.", Toast.LENGTH_SHORT).show();
                    Logger.getLogger(SignUpActivity.class.getName()).log(Level.SEVERE, "Error occurred",t);
                }

            });

        });

        return v;
    }
}
