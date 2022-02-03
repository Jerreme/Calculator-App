package com.jii.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

//Toast.makeText(MainActivity.this,e.toString(), Toast.LENGTH_SHORT).show();
public class MainActivity extends AppCompatActivity {
    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TODO your application logic here:

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent val = new Intent(MainActivity.this, AppActivity.class);
                startActivity((Intent) val);
                finish();
            }
        }, 2000);

    }

}