package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Second extends AppCompatActivity {

    EditText et1,et2;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        et1 = (EditText) findViewById(R.id.editext1);
        et2 = (EditText) findViewById(R.id.editext2);
        sp = getSharedPreferences("SD", Context.MODE_PRIVATE);
        et1.setText(sp.getString("un","").toString());
        et2.setText(sp.getString("up","").toString());
    }
    public void onClose(View v){
        SharedPreferences.Editor ed = sp.edit();
        ed.clear();
        ed.commit();
        finish();
    }
}