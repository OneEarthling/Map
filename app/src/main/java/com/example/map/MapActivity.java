package com.example.map;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Locale;

public class MapActivity extends AppCompatActivity {
    TextView tvFrom;
    TextView tvTo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        tvFrom = findViewById(R.id.tvFrom);
        tvTo = findViewById(R.id.tvTo);
        Intent intent = getIntent();
        double currentLongitude = intent.getExtras().getDouble("FromLongitude");
        double currentLatitude = intent.getExtras().getDouble("FromLatitude");
        double destLongitude = intent.getExtras().getDouble("ToLongitude");
        double destLatitude = intent.getExtras().getDouble("ToLatitude");

        tvFrom.setText("Current Location is: " + String.valueOf(currentLongitude) + " " + String.valueOf(currentLatitude));
        tvTo.setText("Destination is: " + String.valueOf(destLongitude) + " " + String.valueOf(destLatitude));

        Uri uri = Uri.parse(String.format(Locale.getDefault(),"yandexmaps://maps.yandex.ru/?rtext=%f,%f~%f,%f&rtt=mt",
                currentLongitude,currentLatitude,destLongitude,destLatitude ));
        Intent intent2 = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent2);
    }
}
