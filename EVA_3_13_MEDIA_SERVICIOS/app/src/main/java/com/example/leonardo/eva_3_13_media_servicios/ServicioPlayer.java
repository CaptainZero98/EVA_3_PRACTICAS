package com.example.leonardo.eva_3_13_media_servicios;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class ServicioPlayer extends Service {

    MediaPlayer mPlayer;
    public ServicioPlayer() {
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPlayer!=null){
            mPlayer.stop();
            mPlayer.release();

        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mPlayer=MediaPlayer.create(getApplicationContext(),R.raw.blue);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        if (mPlayer!=null){
            mPlayer.start();

        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
