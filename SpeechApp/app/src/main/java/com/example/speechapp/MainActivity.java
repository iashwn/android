package com.example.speechapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextToSpeech t1;
    EditText e1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1 = new TextToSpeech(getApplicationContext(),new TextToSpeech.OnInitListener(){
            public void onInit(int status){
                if(status != TextToSpeech.ERROR){
                    t1.setLanguage(Locale.UK);
                }
            }
        });
    }
    public void onSpeak(View v){
        e1 = (EditText) findViewById(R.id.et1);
        String str = e1.getText().toString();
        t1.speak(str,TextToSpeech.QUEUE_FLUSH,null);
    }
}