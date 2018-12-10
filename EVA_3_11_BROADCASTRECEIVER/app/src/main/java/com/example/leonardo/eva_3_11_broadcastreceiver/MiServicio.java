package com.example.leonardo.eva_3_11_broadcastreceiver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MiServicio extends Service {

    Thread tHilo;
            Intent inDatosS;
    public MiServicio() {
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        inDatosS=new Intent("MI_SERVICIO");
        inDatosS.putExtra("MENSAJE","Hola Mundo");
        sendBroadcast(inDatosS);
        tHilo.interrupt();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        inDatosS=new Intent("MI_SERVICIO");
        inDatosS.putExtra("MENSAJE","Hola Mundo");
        sendBroadcast(inDatosS);
    Runnable rMiHilo=new Runnable() {
        @Override
        public void run() {
            while(true){
                try {
                    Thread.sleep(1000);
                    Log.wtf("MI_SERVICIO","HOLA MUNDO");
                    inDatosS=new Intent("MI_SERVICIO");
                    inDatosS.putExtra("MENSAJE","Hola Mundo");
                    sendBroadcast(inDatosS);
                }catch(InterruptedException e){
                    e.printStackTrace();
                    break;
                }
            }
        }
    };
    tHilo=new Thread(rMiHilo);

    tHilo.start();

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
