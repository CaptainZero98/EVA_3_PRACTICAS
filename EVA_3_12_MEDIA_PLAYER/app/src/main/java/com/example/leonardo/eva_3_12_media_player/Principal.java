package com.example.leonardo.eva_3_12_media_player;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Principal extends AppCompatActivity {
MediaPlayer mPlayer=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
   mPlayer=MediaPlayer.create(this,R.raw.blue);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(mPlayer!=null){
            mPlayer.start();

        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mPlayer!=null){
            mPlayer.stop();
            mPlayer.release();

        }
    }
}
