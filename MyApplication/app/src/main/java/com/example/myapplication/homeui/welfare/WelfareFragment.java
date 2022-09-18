package com.example.myapplication.homeui.welfare;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.modle.Store;
import com.example.myapplication.modle.Welfare;
import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraUpdate;
import com.naver.maps.map.MapFragment;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.overlay.Marker;

import java.io.IOException;
import java.util.List;

public class WelfareFragment extends Fragment implements OnMapReadyCallback {
    private NaverMap naverMap;
    private double x = 0, y = 0;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_welfare_manage, container, false);

        List<Address> list = null;
        TextView welfareNameText = view.findViewById(R.id.welfare_name_text1);
        TextView welfareAddress1Text = view.findViewById(R.id.welfare_address1_text1);
        final Geocoder geocoder = new Geocoder(view.getContext());
        String addressText = MainActivity.welfare.getAddress1();

        welfareNameText.setText(MainActivity.welfare.getName());
        welfareAddress1Text.setText(MainActivity.welfare.getAddress1() + " " + MainActivity.welfare.getAddress2());

        try {
            list = geocoder.getFromLocationName(addressText, 10);
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("test","입출력 오류 - 서버에서 주소변환시 에러발생");
        }

        if (list != null)
            if(list.size() != 0){
                x = list.get(0).getLatitude();
                y = list.get(0).getLongitude();
            }

        FragmentManager fm = getChildFragmentManager();
        MapFragment mapFragment = (MapFragment)fm.findFragmentById(R.id.welfare_map_fragment);
        if (mapFragment == null) {
            mapFragment = MapFragment.newInstance();
            fm.beginTransaction().add(R.id.welfare_map_fragment, mapFragment).commit();
        }
        mapFragment.getMapAsync(this);

        return  view;
    }

    @Override
    public void onMapReady(@NonNull NaverMap naverMap) {
        this.naverMap = naverMap;
        Marker marker = new Marker();
        CameraUpdate cameraUpdate = CameraUpdate.scrollTo(new LatLng(x, y));
        naverMap.moveCamera(cameraUpdate);
        marker.setPosition(new LatLng(x, y));
        marker.setMap(naverMap);
    }
}
