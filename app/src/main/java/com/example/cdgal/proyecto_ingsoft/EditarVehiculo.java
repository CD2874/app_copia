package com.example.cdgal.proyecto_ingsoft;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class EditarVehiculo extends AppCompatActivity {

    String s1, s2, s3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_vehiculo);

        String [] valuesTipoLicencia = {"- # -","A", "B", "C", "M", "E"};
        Spinner spinnerT = (Spinner) findViewById(R.id.tipo_placa);
        ArrayAdapter<String> adapterT = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, valuesTipoLicencia);
        adapterT.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinnerT.setAdapter(adapterT);

        EditText alias = (EditText) findViewById(R.id.alias);
        Spinner tipoPlaca = (Spinner) findViewById(R.id.tipo_placa) ;
        EditText placa = (EditText) findViewById(R.id.numero);

        alias.setText(getIntent().getStringExtra("Vehiculo"));

        s1 = getIntent().getStringExtra("Placa");
        s2 = s1.substring(0,1);
        s3 = s1.substring(2);

        if("A".equals(s2)){
            tipoPlaca.setSelection(1);
        } else if("B".equals(s2)){
            tipoPlaca.setSelection(2);
        } else if("C".equals(s2)){
            tipoPlaca.setSelection(3);
        } else if("M".equals(s2)){
            tipoPlaca.setSelection(4);
        } else if("E".equals(s2)){
            tipoPlaca.setSelection(5);
        }

        placa.setText(s3);
    }

    public void llamarAgregarVehiculo(View view){
        Intent intent = new Intent(this, ActivityPrincipalParticular.class);
        startActivity(intent);
    }
}
