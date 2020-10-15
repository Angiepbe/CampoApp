 package com.example.campoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

 public class MenuprincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuprincipal);

    }

     public void AsisVirtual (View view ){
         Intent siri= new Intent(this,AsistenteVirtual.class);//Generar instancia entre pantallar
         //Envio de info entre pantallas
         startActivity(siri);//Inicializar objeto
     }
}