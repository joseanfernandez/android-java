package com.example.joseantonio.textfile;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.txt_note);
        String files [] = fileList();

        if(ExistsFile(files, "note.txt")){
            try {
                InputStreamReader file = new InputStreamReader(openFileInput("note.txt"));
                BufferedReader br = new BufferedReader(file);
                String line = br.readLine();
                String completeNote = "";

                while (line != null){
                    completeNote = completeNote + line + "\n";
                    line = br.readLine();
                }
                br.close();
                file.close();
                et1.setText(completeNote);
            }catch (IOException e){

            }
        }
    }
    // No hace falta usar llaves porque es un método boolean
    private boolean ExistsFile(String files [], String FilesName){
        for(int i = 0; i < files.length; i++)
            if(FilesName.equals(files[i]))
                return true;
        return false;
    }

    // Method for Save button
    public  void Save(View view){
        try {
            OutputStreamWriter file = new OutputStreamWriter(openFileOutput("note.txt", Activity.MODE_PRIVATE));
            file.write(et1.getText().toString());
            file.flush();
            file.close();
        }catch (IOException e){

        }
        Toast.makeText(this, "Saved Successfully", Toast.LENGTH_SHORT).show();
        finish();
    }
}
