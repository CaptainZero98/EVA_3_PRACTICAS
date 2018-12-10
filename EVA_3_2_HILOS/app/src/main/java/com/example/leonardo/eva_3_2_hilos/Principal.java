package com.example.leonardo.eva_3_2_hilos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
TextView txtHola;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        MiHilo mhPerpetuo=new MiHilo();
        txtHola=findViewById(R.id.txtDatos);


        Runnable rHilo=new Runnable() {
            @Override
            public void run() {
                while(true){
                    try{

                        txtHola.setText("Hola");
                        Thread.sleep(500);


                    }catch(Exception e){
                        e.printStackTrace();


                    }


                }
            }
        };
        mhPerpetuo.start();
        //mhPerpetuo.run();
        Thread tHilo=new Thread(rHilo);
        tHilo.start();
    }
}
