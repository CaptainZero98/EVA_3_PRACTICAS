package com.example.leonardo.eva_3_6_handler_post;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Principal extends AppCompatActivity {


    Handler hManejador=new Handler();
    int iNum=1;
    TextView tvNumeros;
    //Runnable trabajo pesado en segundo plano
    Runnable rPesado=new Runnable() {
        @Override
        public void run() {


            while(true){
                hManejador.post(rLigero);
                try{

                    Thread.sleep(1000);
                }catch(InterruptedException e) {
                    e.printStackTrace();

                }


            }
        }
    };
    //Runnable trabajo ligero
    Runnable rLigero=new Runnable() {
        @Override
        public void run() {

tvNumeros.append((iNum++)+" - ");
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        tvNumeros=findViewById(R.id.tvNumeros);
    Thread tHilo=new Thread(rPesado);
    tHilo.start();
    //Thread tHilo2=new Thread(rLigero);
    }
}
