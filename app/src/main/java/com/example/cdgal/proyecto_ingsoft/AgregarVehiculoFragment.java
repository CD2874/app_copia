package com.example.cdgal.proyecto_ingsoft;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class AgregarVehiculoFragment extends Fragment {

    List<DataItemAgregarVehiculos> lsData;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_agregarvehiculo, container, false);

        FloatingActionButton masV = (FloatingActionButton) v.findViewById(R.id.masVehiculos);
        masV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), NuevoVehiculo.class));
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });

        lsData = new ArrayList<>();
        lsData.add(new DataItemAgregarVehiculos("Vehiculo 1","M-123ABA",R.drawable.ic_keyboard_arrow_right_black_24dp));
        lsData.add(new DataItemAgregarVehiculos("Vehiculo 2","M-456ABB",R.drawable.ic_keyboard_arrow_right_black_24dp));
        lsData.add(new DataItemAgregarVehiculos("Vehiculo 3","M-789ABC",R.drawable.ic_keyboard_arrow_right_black_24dp));

        final ListView listView = (ListView)v.findViewById(R.id.listaMenu);

        CustomAdapterAgregarVehiculos  adapterAgregarVehiculos = new CustomAdapterAgregarVehiculos(this.getActivity(), R.layout.item_fil_agregar_vehiculos,lsData);

        listView.setAdapter(adapterAgregarVehiculos);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), consultarVehiculo.class);
                startActivity(intent);
            }
        });

        this.registerForContextMenu(listView);

        return v;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if (v.getId()==R.id.listaMenu){
            getActivity().getMenuInflater().inflate(R.menu.menu_opciones, menu);
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int selectItemId = item.getItemId();
        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (selectItemId){
            case R.id.editar:
                Intent intent = new Intent();
                intent.putExtra("Vehiculo", lsData.get(info.position).v);
                intent.putExtra("Placa", lsData.get(info.position).p);
                intent.setClass(getActivity(), EditarVehiculo.class);
                startActivity(intent);
                break;
            case R.id.eliminar:
                AlertDialog.Builder builder = new AlertDialog.Builder(this.getActivity());
                builder./*setIcon(R.drawable.ic_add_black_24dp).
                        setTitle("Dialogo Simple").*/
                        setMessage("¿Desea eliminar Vehículo?...").
                        setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getActivity(), "Aquí elimino vehiculo", Toast.LENGTH_SHORT).show();
                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                break;
        }
        return super.onContextItemSelected(item);
    }
}