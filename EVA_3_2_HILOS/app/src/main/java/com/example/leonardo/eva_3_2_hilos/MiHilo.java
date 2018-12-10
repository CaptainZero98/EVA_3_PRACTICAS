package com.example.leonardo.eva_3_2_hilos;

import android.util.Log;

public class MiHilo extends Thread {

    @Override
    public void run(){
        super.run();

        while(true){
            Log.wtf("Hilo","HOLA");
            try{

                Thread.sleep(1000);
            }catch(Exception e){
                e.printStackTrace();


            }

        }
    }
}
