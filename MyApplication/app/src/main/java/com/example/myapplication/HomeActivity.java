package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import com.example.myapplication.databinding.ActivityHomeBinding;
import com.example.myapplication.homeui.donation.DonationFragment;
import com.example.myapplication.homeui.mypage.MyPageFragment;
import com.example.myapplication.homeui.notification.NotificationFragment;
import com.example.myapplication.homeui.point.PointFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {
    public static Activity _HomeActivity;
    ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        _HomeActivity = HomeActivity.this;
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new MyPageFragment());


        binding.navView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.navigation_my_page:
                    replaceFragment(new MyPageFragment());
                    break;
                case R.id.navigation_notification:
                    replaceFragment(new NotificationFragment());
                    break;
                case R.id.navigation_donation:
                    replaceFragment(new DonationFragment());
                    break;
                case R.id.navigation_point:
                    replaceFragment(new PointFragment());
                    break;
            }
            return true;
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.home_container, fragment);
        fragmentTransaction.commit();
    }
}