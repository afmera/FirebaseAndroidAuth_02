package com.example.firebaseandroidauth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.firebaseandroidauth.objeto.Persona;
import com.example.firebaseandroidauth.vector.Lista;

import java.util.List;

public class MenuPrincipalActivity extends AppCompatActivity {
    //Genero un Objeto de la Layout.
    TextView textView_NombreUsuario;
    Button btn_googlePlay,btn_qr,btn_geo,btn_config;
    //Genero una lista local de l clase determinda.
    List<Persona>lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        getSupportActionBar().setTitle("Bienvenidos al Menu Principal");//titulo del Layout
        //Asigno la lista a la lista loscal.
        lista= Lista.lista_persona;
        textView_NombreUsuario=(TextView)findViewById(R.id.NombreUsuarioTextView);
        textView_NombreUsuario.setText(lista.get(0).getNombreCompleto());

        btn_googlePlay=(Button)findViewById(R.id.btnGooglePay);
        btn_qr=(Button)findViewById(R.id.btnQR);
        btn_geo=(Button)findViewById(R.id.btnGeoLocalizacion);
        btn_config=(Button)findViewById(R.id.btnCofiguracion);
        //Metodo por eventos del boton...
        btn_googlePlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btn_qr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btn_geo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btn_config.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
