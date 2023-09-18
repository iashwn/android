package com.example.smssender;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText phn,mesg;
    Button snd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phn = (EditText)findViewById(R.id.editTextNumber);
        mesg = (EditText)findViewById(R.id.editTextText);
        snd = (Button)findViewById(R.id.button);
        snd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num = phn.getText().toString();
                String msg = mesg.getText().toString();
                try{
                    SmsManager sms = SmsManager.getDefault();
                    sms.sendTextMessage(num,null,msg,null,null);
                    Toast.makeText(MainActivity.this, "Message sent.", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}