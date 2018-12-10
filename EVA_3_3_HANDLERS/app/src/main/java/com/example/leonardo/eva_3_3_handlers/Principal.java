package com.example.leonardo.eva_3_3_handlers;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Principal extends AppCompatActivity  {

    Runnable rMiHilo =new Runnable() {
        @Override
        public void run() {
            int i=0;

            while(true){
                i++;
                try {
                    Message msg=hManejador.obtainMessage(1,i);
                    hManejador.sendMessage(msg);
                    Log.wtf("Hilo",i+"");
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                    return;


                }
            }

        }
    };
    Handler hManejador=new Handler(){

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            //aqui se puede interactuar con interfaz grafica
          if (msg.what==1){
              int i=(int)msg.obj;
              tvHilo.append(i+" - ");

          }
        }
    };
    TextView tvHilo;
    Thread miHilo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    tvHilo=findViewById(R.id.tvHilo);
        miHilo=new Thread(rMiHilo);
    miHilo.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        miHilo.interrupt();

    }
}
