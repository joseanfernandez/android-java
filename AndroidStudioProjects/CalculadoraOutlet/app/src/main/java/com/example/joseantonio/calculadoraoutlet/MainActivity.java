package com.example.joseantonio.calculadoraoutlet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText et1;
    private EditText et2;
    private TextView tv1;
    private RadioButton rb1;
    private RadioButton rb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.txt_num1);
        et2 = (EditText)findViewById(R.id.txt_num2);
        tv1 = (TextView)findViewById(R.id.txt_resultado);
        rb1 = (RadioButton)findViewById(R.id.rb_dto);
        rb2 = (RadioButton)findViewById(R.id.rb_ori);
    }

    // Calcula el precio con descuento
    public void Calcular(View view){
        String precioInicial = et1.getText().toString();
        String descuento = et2.getText().toString();

        double pInicial = Double.parseDouble(precioInicial);
        double dto = Double.parseDouble(descuento);

        if (rb1.isChecked() == true) {
            double pFinal = pInicial * ((100 - dto)/100);

            DecimalFormat formateador = new DecimalFormat("####.##");

            String precioFinal = String.valueOf(formateador.format (pFinal));

            tv1.setText("Precio con descuento: \n \n" + precioFinal + "€");
        } else if (rb2.isChecked() == true) {
            double pFinal = pInicial / ((100 - dto)/100);

            DecimalFormat formateador = new DecimalFormat("####.##");

            String precioFinal = String.valueOf(formateador.format (pFinal));

            tv1.setText("Precio original: \n \n" + precioFinal + "€");
        }

    }
}
