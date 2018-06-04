package com.example.joseantonio.sendparameters;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.txt_name);
    }

    // Method for Send button
    public void Send(View view){
        Intent i = new Intent(this, SecondActivity.class);
        i.putExtra("name", et1.getText().toString());
        startActivity(i);
    }
}
