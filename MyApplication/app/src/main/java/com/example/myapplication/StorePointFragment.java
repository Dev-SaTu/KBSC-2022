package com.example.myapplication;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplication.modle.Store;
import com.example.myapplication.retrofit.RetrofitService;
import com.example.myapplication.retrofit.StoreApi;
import com.example.myapplication.retrofit.UserApi;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StorePointFragment extends Fragment {

    public static StorePointFragment newInstance(String param1, String param2) {

        StorePointFragment fragment = new StorePointFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_store_point, container, false);

        Button button = v.findViewById(R.id.create_qr_button);
        button.setOnClickListener(view -> {

            StoreApi userApi = new RetrofitService().getRetrofit().create(StoreApi.class);
            userApi.findStore(MainActivity.user.getId()).enqueue(new Callback<Store>() {
                @Override
                public void onResponse(Call<Store> call, Response<Store> response) {

                    Store store = response.body();

                    QRCodeWriter writer = new QRCodeWriter();

                    try {

                        BitMatrix bitMatrix = writer.encode(store.getName(), BarcodeFormat.QR_CODE, 512, 512);
                        int width = bitMatrix.getWidth();
                        int height = bitMatrix.getHeight();
                        Bitmap bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
                        for (int x = 0; x < width; x++) {
                            for (int y = 0; y < height; y++) {
                                bmp.setPixel(x, y, bitMatrix.get(x, y) ? Color.BLACK : Color.WHITE);
                            }
                        }

                        ((ImageView) v.findViewById(R.id.qr_space)).setImageBitmap(bmp);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

                @Override
                public void onFailure(Call<Store> call, Throwable t) {
                    Toast toast = new Toast(getContext());
                    toast.setText("아이디에 해당하는 가게가 없습니다.");
                    toast.setDuration(Toast.LENGTH_SHORT);
                    toast.show();
                }
            });

        });

        return v;
    }
}