 package com.example.campoapp;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

 public class MenuprincipalActivity extends AppCompatActivity {

     DrawerLayout drawerLayout;
     NavigationView navigationView;
     //Toolbar toolbar;
     //private Toolbar supportActionBar;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuprincipal);
        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.nav_view);
        //toolbar=findViewById(R.id.toolbar2);


        //setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle= new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null) {
            String personName = acct.getDisplayName();
            String personGivenName = acct.getGivenName();
            String personFamilyName = acct.getFamilyName();
            String personEmail = acct.getEmail();
            String personId = acct.getId();
            Uri personPhoto = acct.getPhotoUrl();

        }

    }

     /*private void setSupportActionBar(Toolbar toolbar2) {
     }*/


     public void Perfil (View view ){
         //Intent perfil= new Intent(this,AsistenteVirtual.class);//Generar instancia entre pantallar
         //Envio de info entre pantallas
         //startActivity(perfil);//Inicializar objeto
     }
     public void Calendario (View view ){
         //Intent cld= new Intent(this,AsistenteVirtual.class);//Generar instancia entre pantallar
         //Envio de info entre pantallas
         //startActivity(cld);//Inicializar objeto

     }
     public void Relaciones (View view ){
         //Intent relacion= new Intent(this,AsistenteVirtual.class);//Generar instancia entre pantallar
         //Envio de info entre pantallas
         //startActivity(relacion);//Inicializar objeto
         //Acceso a menuslide
         //Intent intencion =new Intent(this,MenuSlideActivity.class);
        // startActivity(intencion);
     }

     public void AsisVirtual (View view ){
         Intent siri= new Intent(this,AsistenteVirtual.class);//Generar instancia entre pantallar
         //Envio de info entre pantallas
         startActivity(siri);//Inicializar objeto
         //Intent intencion =new Intent(this,MenuSlideActivity.class);
        // startActivity(intencion);
     }

     public void Noticias (View view ){
         //Intent news= new Intent(this,AsistenteVirtual.class);//Generar instancia entre pantallar
         //Envio de info entre pantallas
         //startActivity(news);//Inicializar objeto

     }

     public void Tienda (View view ){
         //Intent news= new Intent(this,AsistenteVirtual.class);//Generar instancia entre pantallar
         //Envio de info entre pantallas
         //startActivity(news);//Inicializar objeto

     }

 }