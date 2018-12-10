package com.example.leonardo.eva_3_examen_practico_15551438;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.MediaStore;

import java.util.ArrayList;

public class mediaServicio extends Service {
    Principal pObjeto=new Principal();
    MediaPlayer mServicio;


    ArrayList<MediaPlayer> aLista=new ArrayList<>();


    int iMedidor=Principal.index;

    public mediaServicio() {
    }

    @Override
    public void onCreate() {
        aLista.add(MediaPlayer.create(getApplicationContext(),R.raw.danicalifornia));
        aLista.add(MediaPlayer.create(getApplicationContext(),R.raw.love));
        aLista.add(MediaPlayer.create(getApplicationContext(),R.raw.nothingelsematters));
        aLista.add(MediaPlayer.create(getApplicationContext(),R.raw.sandstorm));
        aLista.add(MediaPlayer.create(getApplicationContext(),R.raw.withoutme));
        super.onCreate();


            mServicio =aLista.get(iMedidor);





        }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        if (mServicio!=null){
            mServicio.start();

        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mServicio!=null){
            mServicio.stop();
            mServicio.release();

        }
    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
