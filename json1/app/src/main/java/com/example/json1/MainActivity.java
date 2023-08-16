package com.example.json1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView t1;
    public static final String JSON_STRING = "{\"employee\":{\"name\":\"Sachin\",\"salary\":56000}}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = (TextView) findViewById(R.id.textView);

        try{
            JSONObject emp = (new JSONObject(JSON_STRING)).getJSONObject("employee");
            String empname = emp.getString("name");
            int empsalary = emp.getInt("salary");
            String str = "Employee Name : "+empname+"\nEmployee Salary : "+empsalary;
            t1.setText(str);

        }catch (Exception e){
            System.out.println(e);
        }
    }



}