package com.example.leonardo.eva_3_15_lista_clima_json;

import android.app.Activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Principal extends Activity {

    ListView lstClima;
ArrayList<Clima> cCiudades=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
new Conexion().execute();

        lstClima=findViewById(R.id.lstCiudades);
        lstClima.setAdapter(new ClimaAdapter(this,R.layout.layout_clima,cCiudades));

    }

    class Conexion extends AsyncTask<Void,Void,String>{

String sLink="";
        @Override
        protected String doInBackground(Void... voids) {
            String sResu="";
            try{

                URL url=new URL(sLink);
                HttpURLConnection httpCon=(HttpURLConnection) url.openConnection();
                if (httpCon.getResponseCode()==HttpURLConnection.HTTP_OK){
                    //COMO LEER ARCHIVO DE TEXTO

                    BufferedReader brDatos=new BufferedReader(new InputStreamReader(httpCon.getInputStream()));

                    sResu=brDatos.readLine();

                }


            }catch(Exception e){
                e.printStackTrace();


            }


            return sResu;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

         for (int i=0; i<cCiudades.size();i++){

             cCiudades.add(new Clima();
         }
        }
    }


}


