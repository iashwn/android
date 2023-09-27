package com.example.lviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ListActivity implements AdapterView.OnItemClickListener {
    static final String []list = new String[]{
            "One","Two","Three"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setListAdapter(new ArrayAdapter<String>(this,R.layout.activity_main,list));
        ListView listView = getListView();
        listView.setTextFilterEnabled(true);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String s;
        TextView tv = (TextView) view;
        s = (String) tv.getText().toString();
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}