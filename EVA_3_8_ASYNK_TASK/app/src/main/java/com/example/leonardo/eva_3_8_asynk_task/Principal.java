package com.example.leonardo.eva_3_8_asynk_task;

import android.os.AsyncTask;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
TextView tvDatos;
int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    tvDatos=findViewById(R.id.tvDatos);
    MiClaseAsincrona miObjeto=new MiClaseAsincrona();
    miObjeto.execute(100);
    }

    class MiClaseAsincrona extends AsyncTask<Integer,Integer,Void>{

        //DOINBACKGROUND ES EL ÚNICO METODO QUE NO INTERACTUA CON INTERFAZ GRÁFICA
        @Override
        protected Void doInBackground(Integer... Integers) {
i=Integers[0];
            while(true){

            try{
                Thread.sleep(1000);
                publishProgress(i++);

            }catch(InterruptedException e){

                e.printStackTrace();
            }

            }
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            tvDatos.setText("Iniciando tarea asincrona");
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        tvDatos.append(i+" - ");
        }
    }
}

