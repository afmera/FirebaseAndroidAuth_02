package com.example.firebaseandroidauth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    EditText txtEmail, txtPassword, txtConfirmPassword;
    Button btn_register;
    ProgressBar progressBar;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().setTitle("Signup Form");

        txtEmail = (EditText) findViewById(R.id.txt_email);
        txtPassword = (EditText) findViewById(R.id.txt_password);
        txtConfirmPassword = (EditText) findViewById(R.id.txt_confirm_password);
        btn_register = (Button) findViewById(R.id.buttonRegister);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        firebaseAuth = FirebaseAuth.getInstance();
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = txtEmail.getText().toString().trim();
                String password = txtPassword.getText().toString().trim();
                String confirmPassword = txtConfirmPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(SignUpActivity.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(SignUpActivity.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(confirmPassword)) {
                    Toast.makeText(SignUpActivity.this, "Please Enter ConfirmPassword", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6) {
                    Toast.makeText(SignUpActivity.this, "Password too short", Toast.LENGTH_SHORT).show();
                }

                progressBar.setVisibility(View.VISIBLE);

                if (password.equals(confirmPassword)) {
                    firebaseAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    progressBar.setVisibility(View.GONE);
                                    if (task.isSuccessful()) {
                                        startActivity(new Intent(getApplicationContext(), Email_PanelActivity.class));
                                        Toast.makeText(SignUpActivity.this, "Registrations Complete", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(SignUpActivity.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                                    }

                                    // ...
                                }
                            });
                }
            }
        });
    }
}
