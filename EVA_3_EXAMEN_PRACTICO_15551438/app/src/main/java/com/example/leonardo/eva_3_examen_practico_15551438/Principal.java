package com.example.leonardo.eva_3_examen_practico_15551438;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.Random;

public class Principal extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
RadioGroup rgTipoRepro;

 static int index=0;
// MediaPlayer mActual=mLista[index];
Intent inServicio;
    int iSeñal=0;
    RadioButton rbAleatoria,rbSecuencial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        rgTipoRepro=findViewById(R.id.rgRepro);
        rgTipoRepro.setOnCheckedChangeListener(this);
        rbAleatoria=findViewById(R.id.rbAleatoria);
        rbSecuencial=findViewById(R.id.rbSecuencial);
        inServicio=new Intent(this,mediaServicio.class);
    }


    public void clickReproducir(View v){

        startService(inServicio);

    }
    Random rNum=new Random();
    public void clickSig(View v){
    if (index == 4) {


        index = 0;
        stopService(inServicio);
        startService(inServicio);
    } else {

        index = index + 1;
        stopService(inServicio);
        startService(inServicio);
    }
}





    public void clickAnterior(View v){

            if (index == 0) {


                index = 4;
                stopService(inServicio);
                startService(inServicio);
            } else {

                index = index - 1;
                stopService(inServicio);
                startService(inServicio);
            }
        }





    public void clickPausa(View v){
stopService(inServicio);

    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

    if (rbSecuencial.isSelected()){

        Log.wtf("Valor de Señal entrando",iSeñal+"");
}else {
        iSeñal=1;
        Log.wtf("Valor de Señal",iSeñal+"");


    }
}


}