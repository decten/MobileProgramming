package com.example.test;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Switch chkSwitch ;
    TextView menuTxt, storeTxt,reserveTxt;
    RadioGroup radioGroup;
    Button searchButton,reserveButton;
    TimePicker timePicker;
    /*onCreate 전에 다른거 하면 에러 생김*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("커피 주문하기");

        chkSwitch = (Switch) findViewById(R.id.switch1);
        menuTxt = (TextView) findViewById(R.id.menuTxt);
        radioGroup = (RadioGroup) findViewById(R.id.rGroup);
        searchButton = (Button) findViewById(R.id.searchButton);
        storeTxt = (TextView) findViewById(R.id.storeTxt);
        final String[] storeArray = new String[] {"화랑대역점","태릉입구역점","석계역점"};
        reserveButton = (Button) findViewById(R.id.reserveButton);
        reserveTxt = (TextView) findViewById(R.id.reserveTxt);
        timePicker = (TimePicker) findViewById(R.id.timePicker);

        chkSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

                if(isChecked){
                    menuTxt.setVisibility(View.VISIBLE);
                    radioGroup.setVisibility(View.VISIBLE);

                    radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup radioGroup, int checkedID) {
                            switch (checkedID){
                                case R.id.americano:
                                    Toast.makeText(getApplicationContext(),"아메리카노",Toast.LENGTH_LONG).show();
                                    break;
                                case R.id.latte:
                                    Toast.makeText(getApplicationContext(),"카페라떼",Toast.LENGTH_LONG).show();
                                    break;
                                case R.id.cappu:
                                    Toast.makeText(getApplicationContext(),"카푸치노",Toast.LENGTH_LONG).show();
                                    break;
                            }
                        }
                    });
                }else{
                    menuTxt.setVisibility(View.INVISIBLE);
                    radioGroup.setVisibility(View.INVISIBLE);
                }
            }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*대화 상자*/
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity.this);
                dialogBuilder.setTitle("매장을 선택하세요");
                dialogBuilder.setSingleChoiceItems(storeArray, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int select) {
                        storeTxt.setText(storeArray[select]);
                    }
                });
                dialogBuilder.setIcon(R.mipmap.ic_launcher);
                dialogBuilder.setPositiveButton("닫기",null);
                dialogBuilder.show();
            }
        });

        reserveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
                    @Override
                    public void onTimeChanged(TimePicker timePicker, int hour, int minute) {
                        reserveTxt.setText(hour+"시"+minute+"분 예약됨");
                    }
                });
            }
        });

    }
}