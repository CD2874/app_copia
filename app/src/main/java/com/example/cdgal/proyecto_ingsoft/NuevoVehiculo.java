package com.example.cdgal.proyecto_ingsoft;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class NuevoVehiculo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_vehiculo);

        String [] valuesTipoLicencia = {"- # -","A", "B", "C", "M", "E"};
        Spinner spinnerT = (Spinner) findViewById(R.id.tipo_placa);
        ArrayAdapter<String> adapterT = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, valuesTipoLicencia);
        adapterT.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinnerT.setAdapter(adapterT);
    }

    public void llamarAgregarVehiculo(View view){
        Intent intent = new Intent(this, ActivityPrincipalParticular.class);
        startActivity(intent);
    }
}
