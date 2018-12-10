package com.example.leonardo.eva_3_13_media_servicios;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Principal extends AppCompatActivity {
Intent inServicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        inServicio=new Intent(this,ServicioPlayer.class);
    }


    public void clickIni(View v){
startService(inServicio);

    }


    public void clickFin(View v){
stopService(inServicio);

    }
}
