package com.example.map;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnMap;
    TextView tvCurrentLocation;
    TextView tvToLocation;
    double CurrentLongitude = 55.745719;
    double CurrentLatitude = 37.604337;

    double ToLongitude = 55.76009;
    double ToLatitude = 37.648801;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMap = findViewById(R.id.btnMap);
        tvCurrentLocation = findViewById(R.id.tvCurrentLocation);
        tvToLocation = findViewById(R.id.tvToLocation);
        btnMap.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, MapActivity.class);
        intent.putExtra("FromLongitude", CurrentLongitude);
        intent.putExtra("FromLatitude", CurrentLatitude);

        intent.putExtra("ToLongitude", ToLongitude);
        intent.putExtra("ToLatitude", ToLatitude);


        startActivity(intent);
    }

}
