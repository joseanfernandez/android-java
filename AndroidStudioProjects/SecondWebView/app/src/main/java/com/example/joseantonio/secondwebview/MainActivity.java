package com.example.joseantonio.secondwebview;

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

        et1 = (EditText)findViewById(R.id.txt_web);
    }

    // Method for Go To button
    public void GoTo(View view){
        Intent i = new Intent(this, WebActivity.class);
        i.putExtra("url", et1.getText().toString());
        startActivity(i);
    }
}
