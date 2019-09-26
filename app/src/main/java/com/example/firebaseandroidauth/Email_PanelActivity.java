package com.example.firebaseandroidauth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Email_PanelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email__panel);
        getSupportActionBar().setTitle(R.string.panel_correo);
    }
}
