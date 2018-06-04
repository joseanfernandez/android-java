package com.example.joseantonio.imagebutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //  Método para el botón cuadrado
    public void MensajeCuadrado(View view){
        Toast.makeText(this, "Logo Cuadrado", Toast.LENGTH_SHORT).show();
    }

    //  Método para el botón redondo
    public void MensajeRedondo(View view){
        Toast.makeText(this, "Logo Redondo", Toast.LENGTH_SHORT).show();
    }
}
