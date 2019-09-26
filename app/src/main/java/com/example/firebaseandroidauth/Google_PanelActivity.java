package com.example.firebaseandroidauth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.firebaseandroidauth.vector.Lista;

public class Google_PanelActivity extends AppCompatActivity {

    TextView textView;
    Lista lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google__panel);
        getSupportActionBar().setTitle(R.string.panel_google);

        textView=(TextView)findViewById(R.id.menssge_txt);

        textView.setText(
                "Nombre :"+lista.lista_persona.get(0).getNombreCompleto()+
                "\nCorreo: "+lista.lista_persona.get(0).getCorreo()+
                "\nNomb Familia :"+lista.lista_persona.get(0).getNombreFamilia()+
                "\nNomb Pila :"+lista.lista_persona.get(0).getNombrePila()+
                "\nId :"+lista.lista_persona.get(0).getId()+
                "\nId Token :"+lista.lista_persona.get(0).getIdToken()+
                "\nServerAuthToken :"+lista.lista_persona.get(0).getServerAuthToken()+
                "\nZAB :"+lista.lista_persona.get(0).getZab()+
                "\nZAC :"+lista.lista_persona.get(0).getZac()+
                "\nFoto :"+lista.lista_persona.get(0).getFotoUrl());
    }
}
