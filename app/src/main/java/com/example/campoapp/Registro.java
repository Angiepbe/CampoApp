package com.example.campoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Registro extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText  email, password,password2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        email=(EditText) findViewById(R.id.IDe);
        password=(EditText) findViewById(R.id.IDc);
        password2=(EditText) findViewById(R.id.IDc2);
        mAuth = FirebaseAuth.getInstance();

    }

    public  void  Registrar(View view){

        //Metodo de registrar
        if(password.getText().equals(password2.getText())){
            mAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                //Log.d(TAG, "createUserWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();
                                Toast.makeText(getApplicationContext(),"Autenticación Exitosa",Toast.LENGTH_SHORT).show();
                                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(i);
                               // updateUI(user);
                            } else {
                                // If sign in fails, display a message to the user.
                               // Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                Toast.makeText(getApplicationContext(),"Autenticación Fallida",Toast.LENGTH_SHORT).show();
                                //updateUI(null);
                            }

                            // ...
                        }
                    });
        }else {
            Toast.makeText(this,"Las contraseñas no coinciden",Toast.LENGTH_SHORT).show();
        }



    }




    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }

    public void Next (View view ){
        Intent sig= new Intent(this,MenuprincipalActivity.class);//Generar instancia entre pantallar
        //Envio de info entre pantallas
        //sig.putExtra("info",Lista);//Generara un identificador que reconocera la siguiente pantalla
        startActivity(sig);//Inicializar objeto
    }

    public void  Anterior (View view ){

        Intent Ant= new Intent(Registro.this,MainActivity.class);
        //Ant.putExtra("otra",Lista);//Generara un identificador que reconocera la siguiente pantalla
        startActivity(Ant);

    }










}