package com.example.leonardo.eva_3_4_banner;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

public class Principal extends AppCompatActivity {






    Runnable rMiHilo=new Runnable() {

        @Override
    public void run() {

        int i = 0;

        while (true) {
            i++;
            try {

        int iPro=sbMedida.getProgress();
                Thread.sleep(3100-iPro);
                Message msg = hManejador.obtainMessage();
                hManejador.sendMessage(msg);

            } catch (InterruptedException e) {
                e.printStackTrace();
                return;


            }
        }
    }

}  ;

    ImageView imgC;
    SeekBar sbMedida;
    int iCont=1;


    Handler hManejador=new Handler(){
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
//RECIBE MENSAJE
        //CAMBIA UIMAGEN
        switch(iCont){
            case 1:
                imgC.setImageResource(R.drawable.sunny);
                iCont++;
                break;
                case 2:
                imgC.setImageResource(R.drawable.cloudy);
                iCont++;
                break;
                case 3:
                imgC.setImageResource(R.drawable.rainy);
                iCont++;
                break;
                default:
                    imgC.setImageResource(R.drawable.sunny);
                    iCont=1;
                    break;

        }


       }

};

    Thread miHilo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        imgC=findViewById(R.id.imgClima);
        sbMedida=findViewById(R.id.seekBar);
    miHilo =new Thread(rMiHilo);
        miHilo.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
       miHilo.interrupt();
    }
}
