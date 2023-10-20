package com.example.evaluaccion_ii;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class TerceraPantalla_Map extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    private Button bttn_regresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercera_pantalla_map);
        bttn_regresar =findViewById(R.id.bttn_regresar);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        bttn_regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        double Latidud1 = getIntent().getDoubleExtra("Latidud1", 0.0);
        double Longitud1 = getIntent().getDoubleExtra("Longitud1", 0.0);
        double Latidud2 = getIntent().getDoubleExtra("Latidud2", 0.0);
        double Longitud2 = getIntent().getDoubleExtra("Longitud2", 0.0);
        double Latidud3 = getIntent().getDoubleExtra("Latidud3", 0.0);
        double Longitud3 = getIntent().getDoubleExtra("Longitud3", 0.0);
        LatLng direcc1 = new LatLng(Latidud1, Longitud1);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(direcc1));
        mMap.addMarker(new MarkerOptions().position(direcc1).title("Punto 1"));
        LatLng direcc2 = new LatLng(Latidud2, Longitud2);
        mMap.addMarker(new MarkerOptions().position(direcc2).title("Punto 2"));
        LatLng direcc3 = new LatLng(Latidud3, Longitud3);
        mMap.addMarker(new MarkerOptions().position(direcc3).title("Punto 3"));

    }

}