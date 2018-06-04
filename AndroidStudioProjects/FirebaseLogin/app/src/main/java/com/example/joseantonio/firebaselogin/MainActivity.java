package com.example.joseantonio.firebaselogin;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etEmail;
    private EditText etPass;
    private Button btnSignup;
    private Button btnSignin;

    // Barra de progreso mientras carga
    private ProgressDialog progressDialog;
    // Declaramos un objeto firebaseAuth
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializa el objeto firebaseAuth
        firebaseAuth = FirebaseAuth.getInstance();

        etEmail = (EditText)findViewById(R.id.txt_email);
        etPass = (EditText)findViewById(R.id.txt_password);

        btnSignup = (Button)findViewById(R.id.bt_signup);
        btnSignin = (Button)findViewById(R.id.bt_signin);

        progressDialog = new ProgressDialog(this);

        btnSignup.setOnClickListener(this);
        btnSignin.setOnClickListener(this);
    }

    private void SignUp(){
        String email = etEmail.getText().toString().trim(); // trim() para quitar espacios en blanco
        String pass = etPass.getText().toString().trim();

        // Verificamos que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"You must enter an email", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(pass)){
            Toast.makeText(this,"You must enter a password", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Sign Up in progress...");
        progressDialog.show();

        // Crea usuario
        firebaseAuth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(MainActivity.this,"Signed Up", Toast.LENGTH_SHORT).show();
                        } else {
                            if(task.getException() instanceof FirebaseAuthUserCollisionException){
                                Toast.makeText(MainActivity.this, "Email already exists.",
                                        Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(MainActivity.this, "Error.",
                                        Toast.LENGTH_SHORT).show();
                            }

                        }
                        progressDialog.dismiss();
                    }
                });
    }

    private void SignIn(){
        final String email = etEmail.getText().toString().trim(); // trim() para quitar espacios en blanco
        String pass = etPass.getText().toString().trim();

        // Verificamos que las cajas de texto no esten vacias
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"You must enter an email", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(pass)){
            Toast.makeText(this,"You must enter a password", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Sign In in progress...");
        progressDialog.show();

        // Loguear
        firebaseAuth.signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            int pos = email.indexOf("@");
                            String user = email.substring(0, pos);
                            Toast.makeText(MainActivity.this,"Welcome", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplication(), WelcomeActivity.class);
                            intent.putExtra(WelcomeActivity.user, user);
                            startActivity(intent);
                        } else {
                            if(task.getException() instanceof FirebaseAuthUserCollisionException){
                                Toast.makeText(MainActivity.this, "Email already exists.",
                                        Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(MainActivity.this, "Error.",
                                        Toast.LENGTH_SHORT).show();
                            }

                        }
                        progressDialog.dismiss();
                    }
                });
    }


    public void onClick(View view) {

        switch (view.getId()){
            case R.id.bt_signup:
                SignUp();
                break;
            case R.id.bt_signin:
                SignIn();
        }

    }
}
