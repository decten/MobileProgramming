package com.example.baseapp;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button button1;
    Button button2;
    Button button3;
    Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button1);
        button1.setBackgroundColor(Color.DKGRAY);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "버튼을 눌렀어요", Toast.LENGTH_SHORT).show();
            }
        });

        button2 = (Button) findViewById(R.id.button2);
        button2.setBackgroundColor(Color.GREEN);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent mintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.naver.com"));
                startActivity(mintent);
            }
        });

        button3 = (Button) findViewById(R.id.button3);
        button3.setBackgroundColor(Color.RED);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent mintent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:/119"));
                startActivity(mintent);
            }
        });

        button4 = (Button) findViewById(R.id.button4);
        button4.setBackgroundColor(Color.DKGRAY);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();
            }
        });
    }
}