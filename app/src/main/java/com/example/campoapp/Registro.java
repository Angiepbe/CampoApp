package com.example.campoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Registro extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText ECC, ENombre, Eprofesion, ECel, Email, Econtra;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        ECC=(EditText) findViewById(R.id.IDcc);
        ENombre=(EditText) findViewById(R.id.IDn);
        Eprofesion=(EditText) findViewById(R.id.IDp);
        ECel=(EditText) findViewById(R.id.IDd);
        Email=(EditText) findViewById(R.id.IDe);
        Econtra=(EditText) findViewById(R.id.IDc);
        mAuth = FirebaseAuth.getInstance();

    }

    //Metodo de registrar
    public void Registrar (View view ){
        AdministradorSQLite adm = new AdministradorSQLite(this, "Empresa",null, 1 );
        SQLiteDatabase BaseDatos= adm.getWritableDatabase();

        String cedula = ECC.getText().toString();
        String nombre = ENombre.getText().toString();
        String profesion = Eprofesion.getText().toString();
        String direccion = ECel.getText().toString();
        String email = Email.getText().toString();
        String contra = Econtra.getText().toString();

        //Verificar Informacion
        if(!cedula.isEmpty() && !nombre.isEmpty() && !profesion.isEmpty() && !direccion.isEmpty() && !email.isEmpty() && !contra.isEmpty()  ){
            ContentValues registro=new ContentValues();//Organizar informacion
            registro.put("cedula",cedula);
            registro.put("nombre",nombre);
            registro.put("profesion",profesion);
            registro.put("direccion",direccion);
            registro.put("email",email);
            registro.put("contraseña",contra);
            BaseDatos.insert("usuarios",null,registro);
            BaseDatos.close();

            ECC.setText("");
            ENombre.setText("");
            Eprofesion.setText("");
            ECel.setText("");
            Email.setText("");
            Econtra.setText("");
            Toast.makeText(this, "Usuario Registrado",Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "Digitar todos los campos",Toast.LENGTH_SHORT).show();
        }
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