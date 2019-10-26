package com.example.firebaseandroidauth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firebaseandroidauth.objeto.Persona;
import com.example.firebaseandroidauth.vector.Lista;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResolvingResultCallbacks;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.net.URL;

public class GoogleActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener, View.OnClickListener {

    //Genero objeto de los componentes de lal layout
    SignInButton signInButton;
    Button signOutButton;
    TextView statusTextView;
    //genero variable globales
    private String email = "", password = "";
    //objeto del GoogleApiClient
    GoogleApiClient mGoogleApiClient;
    //objetos de FirebaseAuth
    FirebaseAuth firebaseAuth;
    //variable finales para la configuracion del layput y conexion de Google
    private static final String TAG = "SignInActivity";
    private static final int RC_SIGN_IN = 9001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google);
        this.setTitle(R.string.bienvenido_inicio_por_google);//Titulo del Layout
        //Instacion y genero espacion de memoria de FirebaseAuth
        firebaseAuth = FirebaseAuth.getInstance();

        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        //asigno y genero instacnia de la conexion a Google.
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
        //obtengo los valor del llayout asignandolo al a los objetos de la clase.
        statusTextView = (TextView) findViewById(R.id.status_textView);
        signInButton = (SignInButton) findViewById(R.id.sign_in_button);
        signInButton.setOnClickListener(this);
        signOutButton = (Button) findViewById(R.id.signOutButton);
        //genero un metodo por evento para mostrar un mensaje de inicio de sesion.
        signOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(new ResultCallback<Status>() {
                    @Override
                    public void onResult(@NonNull Status status) {
                        statusTextView.setText("Signed out");
                    }
                });
            }
        });

    }
    //Metodo por evento para determinar el boton ejeculado en el laoyut.
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sign_in_button:
                signIn();
                break;
            case R.id.signOutButton:
                signOut();
                break;
        }

    }

    //Metodo para generar el intent e iniciar sesion
    private void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
    //Metodo para la abstracion de los datos suministrados y permitir una transaccion positiva de los mismos
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
    }
    //Metodo para crear una cuenta o si no abrir una ya existente
    private void handleSignInResult(GoogleSignInResult result) {
        Log.d(TAG, "handleSignInResult:" + result.isSuccess());
        if (result.isSuccess()) {
            //trasfiero los datos de la cuenta ge google al objeto de GoogleSignInAccount
            GoogleSignInAccount acct = result.getSignInAccount();
            //Ademas de obtener los datos de la cuente de Goolge.
            statusTextView.setText("Hello, " + acct.getDisplayName());//Muestro los datos
            email = acct.getEmail();//paso los datos a las variable globales.
            password = acct.getId();
            //Ago una lista de una clase determinada para pasar los datos obtenidos.
            Lista.lista_persona.add(new Persona(
                    acct.getDisplayName(),
                    acct.getEmail(),
                    acct.getFamilyName(),
                    acct.getGivenName(),
                    acct.getId(),
                    acct.getIdToken(),
                    acct.getServerAuthCode(),
                    acct.zab(),
                    acct.zac()));
            //tranfieros los datos para su posteriro verificacion
            firebaseAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(GoogleActivity.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    //verifico la respueta si exite la cuenta de google
                    if (task.isSuccessful()) {//si pasa inicio sesion
                        //startActivity(new Intent(getApplicationContext(), Google_PanelActivity.class));
                        startActivity(new Intent(getApplicationContext(), MenuPrincipalActivity.class));
                        Toast.makeText(GoogleActivity.this, "Inicio de Sesion", Toast.LENGTH_SHORT).show();
                    } else {//si no
                        //Creo una cuenta
                        firebaseAuth.createUserWithEmailAndPassword(email, password)
                                .addOnCompleteListener(GoogleActivity.this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (task.isSuccessful()) {
                                            //startActivity(new Intent(getApplicationContext(), Google_PanelActivity.class));
                                            startActivity(new Intent(getApplicationContext(), MenuPrincipalActivity.class));
                                            Toast.makeText(GoogleActivity.this, "Registrations Complete", Toast.LENGTH_SHORT).show();
                                        } else {
                                            Toast.makeText(GoogleActivity.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                    }
                }
            });
        } else {

        }
    }
    //Metodo para emitir los errores
    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.d(TAG, "onConnectionFailed:" + connectionResult);
    }
    //Metodo para cerrar sesion.
    private void signOut() {
        Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(new ResultCallback<Status>() {
            @Override
            public void onResult(@NonNull Status status) {
                statusTextView.setText("Signed out");
            }
        });
    }
}
