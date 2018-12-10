package com.example.leonardo.eva_3_15_lista_clima_json;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ClimaAdapter extends ArrayAdapter<Clima> {


    Context cContexto;
    int iLayout;
    ArrayList<Clima> aCiudad;

    public ClimaAdapter(Context context, int resource, ArrayList<Clima> objects) {
        super(context, resource, objects);
        cContexto=context;
        iLayout=resource;
        aCiudad=objects;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView iImagen;
        TextView txtCiudad,txtDesc,txtTemp;
        View vFila= convertView;

        if(vFila==null){
            //PARA CFREAR VISTA USAMOS LAYOUTINFLATER
            LayoutInflater liVista=((Activity) cContexto).getLayoutInflater();
            vFila=liVista.inflate(iLayout,parent,false);

        }
        //VINCULAR WIDGETS
        iImagen=vFila.findViewById(R.id.imgClima);
        txtCiudad=vFila.findViewById(R.id.txtCiudad);
        txtDesc=vFila.findViewById(R.id.txtClima);
        txtTemp=vFila.findViewById(R.id.txtTemp);

        Clima cActual=aCiudad.get(position);
        iImagen.setImageResource(cActual.iIma);
        txtCiudad.setText(cActual.nombreCiudad);
        txtTemp.setText(cActual.iTemperatura+" ");
        txtDesc.setText(cActual.sDescripcion);
        return vFila;

    }
}
