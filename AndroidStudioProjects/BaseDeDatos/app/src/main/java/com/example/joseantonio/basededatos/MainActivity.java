package com.example.joseantonio.basededatos;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etCode, etDesc, etPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCode = (EditText)findViewById(R.id.txt_code);
        etDesc = (EditText)findViewById(R.id.txt_description);
        etPrice = (EditText)findViewById(R.id.txt_price);
    }

    // Method for Register button
    public void Register(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administration", null, 1);
        SQLiteDatabase DataBase =  admin.getWritableDatabase();

        String code = etCode.getText().toString();
        String desc = etDesc.getText().toString();
        String price = etPrice.getText().toString();

        if(!code.isEmpty() && !desc.isEmpty() && !price.isEmpty()){
            ContentValues record = new ContentValues();
            record.put("codArt", code);
            record.put("DescArt", desc);
            record.put("Price", price);

            DataBase.insert("article", null, record);

            DataBase.close();
            etCode.setText("");
            etDesc.setText("");
            etPrice.setText("");

            Toast.makeText(this, "Registered successfully", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "You must fill in all of the fields", Toast.LENGTH_SHORT).show();
        }
    }

    // Method for Search button
    public void Search(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administration", null, 1);
        SQLiteDatabase DataBase = admin.getWritableDatabase();

        String code = etCode.getText().toString();

        if(!code.isEmpty()){
            Cursor row = DataBase.rawQuery("select descArt, price from article where codArt =" + code, null);

            if(row.moveToFirst()){
                etDesc.setText(row.getString(0));
                etPrice.setText(row.getString(1));
                DataBase.close();
            }else {
                Toast.makeText(this, "Does not exists", Toast.LENGTH_SHORT).show();
                DataBase.close();
            }
        }else{
            Toast.makeText(this, "You must enter a code", Toast.LENGTH_SHORT).show();
        }
    }

    // Method for Delete button
    public void Deelete(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administration", null, 1);
        SQLiteDatabase DataBase =admin.getWritableDatabase();

        String code = etCode.getText().toString();

        if(!code.isEmpty()){
            int number = DataBase.delete("article", "codArt=" + code, null);
            DataBase.close();

            etCode.setText("");
            etDesc.setText("");
            etPrice.setText("");

            if(number > 0){
                Toast.makeText(this, "Deleted successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Does not exists", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "You must enter a code", Toast.LENGTH_SHORT).show();
        }

    }

    // Method for Modify button
    public void Modify(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administration", null, 1);
        SQLiteDatabase DataBase = admin.getWritableDatabase();

        String code = etCode.getText().toString();
        String desc = etDesc.getText().toString();
        String price = etPrice.getText().toString();

        if(!code.isEmpty() && !desc.isEmpty() && !price.isEmpty()){
            ContentValues record = new ContentValues();
            record.put("codArt", code);
            record.put("DescArt", desc);
            record.put("Price", price);

            int number = DataBase.update("article", record, "codArt=" + code, null);
            DataBase.close();

            if(number == 1){
                Toast.makeText(this, "Modified successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Does not exists", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "You must fill in all of the fields", Toast.LENGTH_SHORT).show();

        }
    }
}
