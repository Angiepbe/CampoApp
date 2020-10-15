package com.example.campoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Registrate (View view ){
        Intent registrate= new Intent(this,Registro.class);//Generar instancia entre pantallar
        //Envio de info entre pantallas
        startActivity(registrate);//Inicializar objeto
    }
}