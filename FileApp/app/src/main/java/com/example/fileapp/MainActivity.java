package com.example.fileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2;
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        b2 = (Button) findViewById(R.id.bOpen);
//        b1 = (Button) findViewById(R.id.bSave);
    }
    public void onSave(View v){
        try{
            e1 = (EditText) findViewById(R.id.et1);
            e2 = (EditText) findViewById(R.id.et2);
            FileOutputStream fout = openFileOutput(e1.getText().toString(),0);
            OutputStreamWriter osw = new OutputStreamWriter(fout);
            osw.write(e2.getText().toString());
            osw.flush();
            osw.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void onOpen(View v){
        try{
            e1 = (EditText) findViewById(R.id.et1);
            e2 = (EditText) findViewById(R.id.et2);
            FileInputStream fin = openFileInput(e1.getText().toString());
            InputStreamReader isw = new InputStreamReader(fin);
            int l = (int)fin.available();
            char []b = new char[l];
            int n = isw.read(b,0,l);
            String str = new String(b,0,n);
            e2.setText(str);
            isw.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}