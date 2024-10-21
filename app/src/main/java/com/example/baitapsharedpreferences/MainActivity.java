package com.example.baitapsharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText editTextTen, editTextTuoi;
    CheckBox checkBoxGhiNho;
    Button buttonXacNhan;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        editTextTen = findViewById(R.id.editTextTen);
        editTextTuoi = findViewById(R.id.editTextTuoi);
        checkBoxGhiNho = findViewById(R.id.checkBox);
        buttonXacNhan = findViewById(R.id.button);
        sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);

        editTextTen.setText(sharedPreferences.getString("ten", ""));
        editTextTuoi.setText(sharedPreferences.getString("tuoi", ""));
        checkBoxGhiNho.setChecked(sharedPreferences.getBoolean("ghiNho", false));

        buttonXacNhan.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String ten = editTextTen.getText().toString();
                 String tuoi = editTextTuoi.getText().toString();
                 if(checkBoxGhiNho.isChecked()){
                     SharedPreferences.Editor editor = sharedPreferences.edit();
                     editor.putString("ten", ten);
                     editor.putString("tuoi", tuoi);
                     editor.putBoolean("ghiNho", true);
                     editor.commit();
                 }else{
                     SharedPreferences.Editor editor = sharedPreferences.edit();
                     editor.remove("ten");
                     editor.remove("tuoi");
                     editor.remove("ghiNho");
                     editor.commit();
                 }
             }
         });

    }
}