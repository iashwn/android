package com.example.loancalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText t1,t2,t3;
    TextView tot;
    float total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = (EditText) findViewById(R.id.et1);
        t2 = (EditText) findViewById(R.id.et2);
        t3 = (EditText) findViewById(R.id.et3);
        tot = (TextView) findViewById(R.id.tota);
    }

    public void loanCalc(View view){
        int i;
        float la = Float.parseFloat(t1.getText().toString());
        float in = Float.parseFloat(t2.getText().toString());
        float yrs = Float.parseFloat(t3.getText().toString());
        for(i=1;i<=yrs;i++){
            if(i==1){
                total = (la*in)/yrs;
                la = la + total;
            }
            else{
                total = (la*in)/yrs;
                la = la + total;
            }
        }
        tot.setText("Total Amount = "+total);
    }
}