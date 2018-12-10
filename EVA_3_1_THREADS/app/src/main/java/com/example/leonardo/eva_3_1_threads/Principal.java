package com.example.leonardo.eva_3_1_threads;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Principal extends AppCompatActivity {

    Runnable rMiHilo=new Runnable() {
        @Override
        public void run() {
      for (int i=0; i<20; i++){

          Log.wtf("Runnable",i+" ");
          try {
              Thread.sleep(1000);
          }catch(Exception e){



          }

      }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        //RUNNABLE (Interfaz)
       Thread tHilo=new Thread(rMiHilo);
        tHilo.start();//EL RUN SE EJECUTA COMO TAREA , EL START COMO UN HILO DE EJECUCIÓN
        //THREAD (Clase)
        MiHilo tMiHilo=new MiHilo();
        tMiHilo.start();
    }
}

class MiHilo extends Thread{

    @Override
    public void run() {
        super.run();
        for (int i=0; i<20; i++){

            Log.wtf("Thread",i+" ");
            try {

                Thread.sleep(1000);
            }catch(Exception e){



            }

        }

    }
        }
