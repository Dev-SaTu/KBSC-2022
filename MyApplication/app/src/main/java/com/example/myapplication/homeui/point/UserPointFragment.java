package com.example.myapplication.homeui.point;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.HomeActivity;
import com.example.myapplication.R;
import com.google.zxing.integration.android.IntentIntegrator;

import java.util.concurrent.atomic.AtomicReference;

public class UserPointFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_user_point, container, false);

        /* QR Code Scan */
        ImageButton imageButton = v.findViewById(R.id.imageButton);

        if (imageButton == null) {

            Toast toast = new Toast(getActivity().getApplicationContext());
            toast.setText("imageButton is null");
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.show();

        } else {

            imageButton.setOnClickListener(view -> new IntentIntegrator(getActivity()).initiateScan());

        }

        return v;
    }
}
