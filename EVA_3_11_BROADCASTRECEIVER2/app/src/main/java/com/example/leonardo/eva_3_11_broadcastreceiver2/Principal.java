package com.example.leonardo.eva_3_11_broadcastreceiver2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Principal extends AppCompatActivity {

    BroadcastReceiver brMiBroad;
    TextView tvMostrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        tvMostrar=findViewById(R.id.tvMostrar);

        brMiBroad=new MiBroad();
        IntentFilter iMiFiltro=new IntentFilter("MI_SERVICIO");
        registerReceiver(brMiBroad,iMiFiltro);

    }

    class MiBroad extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
//AQUI SE LEE EL MENSAJE
            String sDatos=intent.getStringExtra("MENSAJE");
            tvMostrar.append(sDatos);
        }
    }


}