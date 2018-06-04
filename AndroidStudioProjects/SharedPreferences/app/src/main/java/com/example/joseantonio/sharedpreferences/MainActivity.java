package com.example.joseantonio.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
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

        et1 = (EditText)findViewById(R.id.txt_email);

        SharedPreferences preferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        et1.setText(preferences.getString("email", ""));
    }

    // Method for Save button
    public void Save(View view){
        SharedPreferences preferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        SharedPreferences.Editor obj_editor = preferences.edit();
        obj_editor.putString("email",et1.getText().toString());
        obj_editor.commit();
        finish();
    }
}
