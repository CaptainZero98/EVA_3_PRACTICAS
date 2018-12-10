package com.example.leonardo.eva_3_10_servicios;

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
    inServicio=new Intent(this,MiServicio.class);
    }

    public void ClickIni(View v){
        startService(inServicio);


    }
    public void ClickFin(View v){
        stopService(inServicio);

    }
}
