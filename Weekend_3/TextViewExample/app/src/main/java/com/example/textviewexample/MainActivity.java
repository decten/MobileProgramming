package com.example.textviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv1,tv2,tv3,tv4,tv5;
        tv1 = (TextView) findViewById(R.id.textView1);
        tv2 = (TextView) findViewById(R.id.textView2);
        tv3 = (TextView) findViewById(R.id.textView3);
        tv4 = (TextView) findViewById(R.id.textView4);
        tv5 = (TextView) findViewById(R.id.textView5);

        tv1.setTextSize(30);
        tv2.setTextColor(Color.YELLOW);
        tv3.setTypeface(Typeface.SERIF, Typeface.BOLD_ITALIC);
        tv4.setText("메롱 메롱 메롱 메롱 메롱 메롱 메롱 메롱 메롱");
        tv5.setText("메롱 메롱 메롱 메롱 메롱 메롱 메롱 메롱 메롱");
        tv5.setSingleLine();
    }
}