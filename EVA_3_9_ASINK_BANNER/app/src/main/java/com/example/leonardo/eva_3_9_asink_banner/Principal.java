package com.example.leonardo.eva_3_9_asink_banner;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Principal extends AppCompatActivity {
ImageView imgClima;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        imgClima=findViewById(R.id.imgClima);
        Asincrona aObje=new Asincrona();
        aObje.execute(0);
    }

    class Asincrona extends AsyncTask<Integer,Integer,Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            imgClima.setImageResource(R.drawable.cloudy);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            if(i==0){
        imgClima.setImageResource(R.drawable.sunny);

            }else if (i==1){
        imgClima.setImageResource(R.drawable.cloudy);
            }else if(i==2){

imgClima.setImageResource(R.drawable.rainy);
            }else{

                i=-1;
            }


        }

        @Override
        protected Void doInBackground(Integer... integers) {
            i=-1;

            while(true){

                try{
                    Thread.sleep(1000);
                    publishProgress(i++);

                }catch(InterruptedException e){

                    e.printStackTrace();
                }

        }
    }
}

}
