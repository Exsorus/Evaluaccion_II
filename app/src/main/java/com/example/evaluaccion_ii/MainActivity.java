package com.example.evaluaccion_ii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.maps.OnMapReadyCallback;

public class MainActivity extends AppCompatActivity  {
    private EditText ediTxt_direccN1;
    private EditText ediTxt_direccN2;
    private EditText ediTxt_direccN3;
    private Button bttn_agregar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ediTxt_direccN1 = findViewById(R.id.ediTxt_direccN1);
        ediTxt_direccN2 = findViewById(R.id.ediTxt_direccN2);
        ediTxt_direccN3 = findViewById(R.id.ediTxt_direccN3);
        bttn_agregar = findViewById(R.id.bttn_agregar);

        bttn_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Direccion1 = ediTxt_direccN1.getText().toString();
                String Direccion2 = ediTxt_direccN2.getText().toString();
                String Direccion3 = ediTxt_direccN3.getText().toString();

                String[] Direcc1 = Direccion1.split(",");
                String[] Direcc2 = Direccion2.split(",");
                String[] Direcc3 = Direccion3.split(",");

                if (Direcc1.length == 2 && Direcc2.length == 2 && Direcc3.length == 2) {
                    double Latidud1 = Double.parseDouble(Direcc1[0].trim());
                    double Longitud1 = Double.parseDouble(Direcc1[1].trim());
                    double Latidud2 = Double.parseDouble(Direcc2[0].trim());
                    double Longitud2 = Double.parseDouble(Direcc2[1].trim());
                    double Latidud3 = Double.parseDouble(Direcc3[0].trim());
                    double Longitud3 = Double.parseDouble(Direcc3[1].trim());

                    Intent intent = new Intent(MainActivity.this,TerceraPantalla_Map.class);
                    intent.putExtra("Latidud1",Latidud1);
                    intent.putExtra("Longitud1",Longitud1);
                    intent.putExtra("Latidud2",Latidud2);
                    intent.putExtra("Longitud2",Longitud2);
                    intent.putExtra("Latidud3",Latidud3);
                    intent.putExtra("Longitud3",Longitud3);
                    startActivity(intent);
                }
            }
        });
    }

}