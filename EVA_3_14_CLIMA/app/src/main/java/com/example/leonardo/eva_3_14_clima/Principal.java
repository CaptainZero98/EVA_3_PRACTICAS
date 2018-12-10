package com.example.leonardo.eva_3_14_clima;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class Principal extends AppCompatActivity {
TextView tvDatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        tvDatos=findViewById(R.id.tvDatos);
    }

    public void OnClick(View v){
new Conexion().execute();

    }

class Conexion extends AsyncTask<Void,Void,String>{

String sLink="http://api.openweathermap.org/data/2.5/group?id=524901,703448,2643743&units=metric";
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
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        JSONArray jCiudades=null;
        if (!s.equals("")){

            try{
                JSONObject jsDatos=new JSONObject(s);
                jCiudades=jsDatos.getJSONArray("list");
                for (int i=0;i<jCiudades.length();i++){
                    JSONObject jCiudad=jCiudades.getJSONObject(i);
                    tvDatos.append("Ciudad: "+ jCiudad.get("name")+" \n");

                }
            }catch(Exception e){
                e.printStackTrace();


            }

        }
    }
}
}
