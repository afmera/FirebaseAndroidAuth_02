package com.example.firebaseandroidauth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.firebaseandroidauth.objeto.Persona;
import com.example.firebaseandroidauth.vector.Lista;

import java.util.List;

public class MenuPrincipalActivity extends AppCompatActivity {

    TextView textView_NombreUsuario;
    List<Persona>lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        getSupportActionBar().setTitle("Bienvenidos al Menu Principal");

lista= Lista.lista_persona;
        textView_NombreUsuario=(TextView)findViewById(R.id.NombreUsuarioTextView);
        textView_NombreUsuario.setText(lista.get(0).getNombreCompleto());
    }
}
