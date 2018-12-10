package com.example.leonardo.eva_3_11_broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
Intent inServicio;
BroadcastReceiver brMiBroad;
TextView tvDatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        tvDatos=findViewById(R.id.tvDatos);
    inServicio=new Intent(this,MiServicio.class);
    brMiBroad=new MiBroad();
        IntentFilter iMiFiltro=new IntentFilter("MI_SERVICIO");
    registerReceiver(brMiBroad,iMiFiltro);

    }
public void clickIni(View v){
        startService(inServicio);

}
public void clickFin(View v){

        stopService(inServicio);
}
    class MiBroad extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
//AQUI SE LEE EL MENSAJE
            String sDatos=intent.getStringExtra("MENSAJE");
            tvDatos.append(sDatos);
        }
}


}
