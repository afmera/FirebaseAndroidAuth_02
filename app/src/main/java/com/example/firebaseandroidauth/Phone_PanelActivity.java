package com.example.firebaseandroidauth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Phone_PanelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone__panel);
        this.setTitle(R.string.bienvenido_inicio_por_phone);
    }
}
