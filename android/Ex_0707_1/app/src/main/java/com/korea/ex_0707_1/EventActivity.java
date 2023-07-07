package com.korea.ex_0707_1;

import androidx.appcompat.app.AppCompatActivity;


import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class EventActivity extends AppCompatActivity {


    Button btn_red, btn_green, btn_blue ,send,reset;

    EditText et;
    TextView txt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);


        // 이벤트 처리에 사용할 객체 검색
        // 자바에서는 Object가 최상위 클래스 였다면
        // 안드로이드에서는 R 클래스가 최상위 이다
        btn_red = findViewById(R.id.btn_red);
        btn_green = findViewById(R.id.btn_green);
        btn_blue = findViewById(R.id.btn_blue);
        txt = findViewById(R.id.txt);

        send = findViewById(R.id.send);
        reset = findViewById(R.id.reset);

        et = findViewById(R.id.et);


        send.setOnClickListener(click);
        reset.setOnClickListener(click);

        btn_red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 버튼 클릭시 호출되는 영역
                txt.setBackgroundColor(Color.RED);
                txt.setText("빨강");
            }
        });



        btn_green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 버튼 클릭시 호출되는 영역
                txt.setBackgroundColor(Color.GREEN);
                txt.setText("초록");
            }
        });



        btn_blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 버튼 클릭시 호출되는 영역
                txt.setBackgroundColor(Color.BLUE);
                txt.setText("파랑");
            }
        });


    }//onCreate()



    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            int id = view.getId();
            if(id == R.id.send){
                String str = et.getText().toString();
                txt.setText(str);
            } else if(id == R.id.reset){
                txt.setBackgroundColor(Color.BLACK);
                txt.setText("결과");
            }

        }
    };



}