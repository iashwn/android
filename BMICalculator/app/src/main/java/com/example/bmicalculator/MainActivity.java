package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText t1,t2,t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = (EditText) findViewById(R.id.et1);
        t2 = (EditText) findViewById(R.id.et2);
        t3 = (EditText) findViewById(R.id.et3);
    }

    public void BMICalc(View view){
        float BMIindex;
        System.out.println(t1.getText().toString());
        if(t1.getText().toString()==null && t2.getText().toString()==null){
            Toast.makeText(this,"Empty Fields",Toast.LENGTH_LONG).show();
        }
        else {
            float ht = Float.parseFloat(t2.getText().toString());
            float weight = Float.parseFloat(t1.getText().toString());
            float htMeter = ht/100;
            float htSquare = htMeter * htMeter;
            System.out.println(htSquare);
            System.out.println(weight);
            BMIindex = weight/htSquare;
            System.out.println(BMIindex);

            if(BMIindex < 18.4 && BMIindex <=18.5){
                Toast.makeText(this,"UnderWeight",Toast.LENGTH_LONG).show();
                t3.setText("UnderWeight : BMI Value ="+BMIindex);
            }else if(BMIindex > 18.6 && BMIindex <=24.9){
                Toast.makeText(this,"Normal",Toast.LENGTH_LONG).show();
                t3.setText("Normal : BMI Value ="+BMIindex);
            }else if(BMIindex > 25.0 && BMIindex <=39.9){
                Toast.makeText(this,"OverWeight",Toast.LENGTH_LONG).show();
                t3.setText("Overweight : BMI Value ="+BMIindex);
            }else if (BMIindex >=40.0){
                Toast.makeText(this,"Obese",Toast.LENGTH_LONG).show();
                t3.setText("Obese : BMI Value ="+BMIindex);
            }
        }
    }

    public void clearScreen(View view){
        t1.setText("");
        t2.setText("");
        t3.setText("");
    }
}