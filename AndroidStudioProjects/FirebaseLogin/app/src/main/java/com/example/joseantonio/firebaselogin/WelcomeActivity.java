package com.example.joseantonio.firebaselogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {
public static final String user="names";
TextView txtWelcome;

    private Button btnSignout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        txtWelcome = (TextView)findViewById(R.id.txt_welcome);
        String user = getIntent().getStringExtra(("names"));
        txtWelcome.setText("Welcome "+ user + "!");

        btnSignout = (Button)findViewById(R.id.bt_signout);
        btnSignout.setOnClickListener(this);
    }

    public void SignOut(){
        FirebaseAuth.getInstance().signOut();
        Toast.makeText(this, "Signed Out", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplication(), MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        SignOut();
    }
}
