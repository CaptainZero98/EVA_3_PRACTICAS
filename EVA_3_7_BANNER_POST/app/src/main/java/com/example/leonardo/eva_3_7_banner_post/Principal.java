package com.example.leonardo.eva_3_7_banner_post;

import android.media.Image;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Switch;

public class Principal extends AppCompatActivity {
    Handler hManejador = new Handler();
    int iCont=1;
    ImageView imgClima;
    Runnable rPesado=new Runnable() {
        @Override
        public void run() {
            while(true) {
                hManejador.post(rLigero);
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){

                e.printStackTrace();
            }

            }

            }
    };

    Runnable rLigero=new Runnable() {
        @Override
        public void run() {
            switch(iCont){
                case 1:
                    imgClima.setImageResource(R.drawable.sunny);
                    iCont++;
                    break;
                case 2:
                    imgClima.setImageResource(R.drawable.cloudy);
                    iCont++;
                    break;
                case 3:
                    imgClima.setImageResource(R.drawable.rainy);
                    iCont++;
                    break;
                default:
                    imgClima.setImageResource(R.drawable.sunny);
                    iCont=1;
                    break;

            }

            }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    imgClima=findViewById(R.id.imageView);
    Thread tMiHilo=new Thread(rPesado);
    tMiHilo.start();

    }
}
