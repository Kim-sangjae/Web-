package com.korea.ex_0714;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HandlerWhatActivity extends AppCompatActivity {

    Button btn0,btn1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_what);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);


        btn0.setOnClickListener(click);
        btn1.setOnClickListener(click);


    }




    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int id = view.getId();

            if(id == R.id.btn0){
                handler.sendEmptyMessage(0);

            } else if(id == R.id.btn1){
                handler.sendEmptyMessage(1);
            }
        }

    };




    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) { //msg가 what 데이터를 가지고있다
            if(msg.what == 0){
                Toast.makeText(HandlerWhatActivity.this,"0으로 호출",Toast.LENGTH_SHORT).show();
            }else if(msg.what == 1){
                Toast.makeText(HandlerWhatActivity.this,"1로 호출",Toast.LENGTH_SHORT).show();
            }

        }
    };







}