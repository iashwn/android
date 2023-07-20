package com.example.alc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("ALC","OnCreate()");

    }

        @Override
        public void onStart(){
            super.onStart();
            Log.d("ALC","OnStart()");
        }
        @Override
        public void onStop(){
            super.onStop();
            Log.d("ALC","OnStop()");
        }
        @Override
        public void onDestroy(){
            super.onDestroy();
            Log.d("ALC","OnDestroy()");
        }
        @Override
        public void onPause(){
            super.onPause();
            Log.d("ALC","OnPause()");
        }
        @Override
        public void onResume(){
            super.onResume();
            Log.d("ALC","OnResume()");
        }
}