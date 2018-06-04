package com.example.joseantonio.sd;

import android.app.Activity;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText etName, etData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText)findViewById(R.id.txt_name);
        etData = (EditText)findViewById(R.id.txt_data);
    }


    // Method for Save button
    public void Save(View view){
        String name = etName.getText().toString();
        String data = etData.getText().toString();

        try {
            File SDcard = Environment.getExternalStorageDirectory();
            Toast.makeText(this, SDcard.getPath(), Toast.LENGTH_SHORT).show();
            File filePath = new File(SDcard.getPath(), name);
            OutputStreamWriter createFile = new OutputStreamWriter(openFileOutput(name, Activity.MODE_PRIVATE));

            createFile.write(data);
            createFile.flush();
            createFile.close();

            Toast.makeText(this, "Saved Successfully", Toast.LENGTH_SHORT).show();
            etName.setText("");
            etData.setText("");
        } catch (IOException e){
            Toast.makeText(this, "Has not been saved", Toast.LENGTH_SHORT).show();
        }

    }

    // Method for View button
    public void View(View view) {
       String name = etName.getText().toString();

       try{
           File SDcard = Environment.getExternalStorageDirectory();
           File filePath = new File(SDcard.getPath(), name);
           InputStreamReader openFile = new InputStreamReader(openFileInput(name));

           BufferedReader readFile = new BufferedReader(openFile);
           String line = readFile.readLine();
           String data = "";

           while(line != null){
               data = data + line + "\n";
               line = readFile.readLine();
           }

           readFile.close();
           openFile.close();
           etData.setText(data);

       } catch(IOException e){
           Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
       }
    }
}
