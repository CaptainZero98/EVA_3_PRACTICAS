package com.example.leonardo.eva_3_5_cuenta_carac;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Principal extends AppCompatActivity   {

    EditText etDatos;
    TextView tvConteo;
    Thread miHilo;
    String sDatos;
    int iTama;
    String sCade;
    Runnable rMiHilo=new Runnable() {
        @Override
        public void run() {

            while(true){

      try{
          Message msg=hManejador.obtainMessage(iTama);
          hManejador.sendMessage(msg);
          Thread.sleep(1);


      }catch(InterruptedException e){
          e.printStackTrace();

      }


            }

        }
    };

Handler hManejador=new Handler(){
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);

        tvConteo.setText(String.valueOf(iTama));
    }
};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    etDatos=findViewById(R.id.etCaracteres);
    tvConteo=findViewById(R.id.tvNumero);
        miHilo= new Thread(rMiHilo);
        miHilo.start();
    etDatos.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        sCade=etDatos.getText().toString();
            iTama=sCade.length();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        miHilo.interrupt();
    }
}
