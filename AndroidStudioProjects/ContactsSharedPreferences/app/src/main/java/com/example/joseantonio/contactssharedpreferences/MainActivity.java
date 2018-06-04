package com.example.joseantonio.contactssharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etName, etInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText)findViewById(R.id.txt_name);
        etInfo = (EditText)findViewById(R.id.txt_info);
    }

    // Method for Save button
    public void Save(View view){
        String name = etName.getText().toString();
        String info = etInfo.getText().toString();

        SharedPreferences preferences = getSharedPreferences("contact", Context.MODE_PRIVATE);
        SharedPreferences.Editor obj_editor = preferences.edit();
        obj_editor.putString(name, info);
        obj_editor.commit();
        Toast.makeText(this, "Contact saved", Toast.LENGTH_SHORT).show();
    }

    // Method for Search button
    public void Search(View view){
        String name = etName.getText().toString();

        SharedPreferences preferences = getSharedPreferences("contact", Context.MODE_PRIVATE);
        String info = preferences.getString(name, "");

        if(info.length() == 0){
            Toast.makeText(this, "Not found", Toast.LENGTH_SHORT).show();
        } else {
            etInfo.setText(info);
        }
    }
}
