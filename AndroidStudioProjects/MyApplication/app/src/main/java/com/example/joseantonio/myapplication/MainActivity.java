package com.example.joseantonio.myapplication;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et1;
    private EditText et2;
    private EditText et3;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.txt_num1);
        et2 = (EditText)findViewById(R.id.txt_num2);
        et3 = (EditText)findViewById(R.id.txt_num3);
        tv1 = (TextView)findViewById(R.id.txt_resultado);
    }

    // Calcula la media de las tresasignaturas
    public void Media(View view){
        String valor1 = et1.getText().toString();
        String valor2 = et2.getText().toString();
        String valor3 = et3.getText().toString();

        int num1 = Integer.parseInt(valor1);
        int num2 = Integer.parseInt(valor2);
        int num3 = Integer.parseInt(valor3);

        int media = (num1 + num2 + num3)/3;

        String result = String.valueOf(media);

        if (media < 5) {
            tv1.setText("Calificación final: Suspenso con " + result);
        } else {
            tv1.setText("Calificación final: Aprobado con " + result);
        }

    }
}
