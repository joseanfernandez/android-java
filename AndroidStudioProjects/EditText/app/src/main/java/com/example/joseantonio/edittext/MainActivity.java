package com.example.joseantonio.edittext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etu, etp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etu = (EditText)findViewById(R.id.txt_user);
        etp = (EditText)findViewById(R.id.txt_password);
    }

    // Método para el botón
    public void SignIn(View view){

        String user = etu.getText().toString();
        String password = etp.getText().toString();

        if(user.length() == 0){
            Toast.makeText(this, "You must enter a username", Toast.LENGTH_LONG).show();
        }

        if(password.length() == 0){
            Toast.makeText(this, "You must enter a password", Toast.LENGTH_LONG).show();
        }

        if(user.length() != 0 && password.length() != 0) {
            Toast.makeText(this, "Sign Up Complete!", Toast.LENGTH_LONG).show();
        }
    }
}
