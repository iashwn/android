package com.example.empdbapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpResponse;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.HttpClient;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods.HttpGet;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.client.DefaultHttpClient;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    EditText e1;
    TextView t1,t2,t3,t4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText)findViewById(R.id.et1);
        t1 = (TextView)findViewById(R.id.tv1);
        t2 = (TextView)findViewById(R.id.tv2);
        t3 = (TextView)findViewById(R.id.tv3);
        t4 = (TextView)findViewById(R.id.tv4);
    }

    public void onGetData(View v){
        if(e1.getText().toString() == "" || e1.getText().length() == 0)
            return;
        else
        {
            class CData  extends AsyncTask<String, String, String>
            {

                @Override
                protected String doInBackground(String... arg0) {
                    // TODO Auto-generated method stub
                    try{

                        String link = "http://172.16.2.26/test.php?eno=" + e1.getText().toString();

                        URL url = new URL(link);
                        HttpClient client = new DefaultHttpClient();
                        HttpGet request = new HttpGet();
                        request.setURI(new URI(link));
                        HttpResponse response = client.execute(request);

                        BufferedReader in = new BufferedReader(new
                                InputStreamReader(response.getEntity().getContent()));

                        StringBuffer sb = new StringBuffer("");
                        String line="";

                        while ((line = in.readLine()) != null) {
                            sb.append(line);
                            break;
                        }
                        in.close();

                        return sb.toString();

                    } catch(Exception e){
                        Toast.makeText(getApplicationContext(),"error" + e.getMessage(),2).show();
                        return new String("Exception: " + e.getMessage());
                    }
                }
                protected void onPreExecute()
                {
                    super.onPreExecute();
                }
                protected void onPostExecute(String result)
                {
                    try
                    {
                        JSONObject jobj = new JSONObject(result);
                        t1.setText(jobj.getString("eno"));
                        t2.setText(jobj.getString("ename"));
                        t3.setText(jobj.getString("esal"));
                    }
                    catch(Exception ee)
                    {
                        Toast.makeText(getApplicationContext(),"error2" + ee.getMessage(),2).show();
                    }
                }
            }
            CData obj = new CData();
            obj.execute();
        }
    }
    public void onShowAll(View v){
        class CData  extends AsyncTask<String, String, String>
        {

            @Override
            protected String doInBackground(String... arg0) {
// TODO Auto-generated method stub
                try{

                    String link = "http://172.16.2.22/showall.php";

                    URL url = new URL(link);
                    HttpClient client = new DefaultHttpClient();
                    HttpGet request = new HttpGet();
                    request.setURI(new URI(link));
                    HttpResponse response = client.execute(request);

                    BufferedReader in = new BufferedReader(new
                            InputStreamReader(response.getEntity().getContent()));

                    StringBuffer sb = new StringBuffer("");
                    String line="";

                    while ((line = in.readLine()) != null) {
                        sb.append(line);
                        break;
                    }
                    in.close();

                    return sb.toString();

                } catch(Exception e){
                    Toast.makeText(getApplicationContext(),"error" + e.getMessage(),2).show();
                    return new String("Exception: " + e.getMessage());
                }
            }
            protected void onPreExecute()
            {
                super.onPreExecute();
            }
            protected void onPostExecute(String result)
            {
                String str = "";
                try
                {
                    JSONArray jsonArray = new JSONArray(result);

                    if (jsonArray!=null) {
                        int i = 0;
                        while (i < jsonArray.length()) {
                            JSONObject jobj = jsonArray.getJSONObject(i);
                            str = str + jobj.getString("eno");
                            str = str + "   ";
                            str = str + jobj.getString("ename");
                            str = str + "   ";
                            str = str + jobj.getString("esal");
                            str = str + "\n";
                            i++;
                        }
                        t4.setText(str);
                    }
                }
                catch(Exception ee)
                {
                    Toast.makeText(getApplicationContext(),"error2" + ee.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        }
        CData obj = new CData();
        obj.execute();
    }
}