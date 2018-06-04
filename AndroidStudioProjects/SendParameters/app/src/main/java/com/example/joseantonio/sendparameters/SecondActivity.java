package com.example.joseantonio.sendparameters;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tv1 = (TextView)findViewById(R.id.textView);

        String name = getIntent().getStringExtra("name");
        tv1.setText("Hello " + name + "!");
    }

    // Method for Back button
    public void Back(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);

    }
}
