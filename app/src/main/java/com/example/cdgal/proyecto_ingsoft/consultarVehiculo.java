package com.example.cdgal.proyecto_ingsoft;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class consultarVehiculo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_vehiculo);

        cargarDatos();
    }

    private void cargarDatos(){
        ExpandableListView expLV;
        ExpLVAdapter adapter;
        ArrayList<String> listCategorias;
        Map<String, ArrayList<String>> mapChild;

        expLV = (ExpandableListView) findViewById(R.id.expLV);
        listCategorias = new ArrayList<>();
        mapChild = new HashMap<>();

        ArrayList<String> listContSM = new ArrayList<>();
        ArrayList<String> listContSP = new ArrayList<>();

        listCategorias.add("SAN MARCOS");
        listCategorias.add("SAN PEDRO SAC.");

        listContSM.add("Descripcion numero 1... \f\f\f (Q.100.00)");
        listContSM.add("Descripcion numero 2... \f\f\f (Q.200.00)");
        listContSM.add("Descripcion numero 3... \f\f\f (Q.300.00)");

        listContSP.add("Descripcion numero 4... \f\f\f (Q.800.00)");
        listContSP.add("Descripcion numero 5... \f\f\f (Q.900.00)");
        listContSP.add("Descripcion numero 6... \f\f\f (Q.1000.00)");

        mapChild.put(listCategorias.get(0), listContSM);
        mapChild.put(listCategorias.get(1), listContSP);

        adapter = new ExpLVAdapter(this, listCategorias, mapChild);
        expLV.setAdapter(adapter);
    }
}
