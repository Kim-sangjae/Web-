package com.korea.ex_0714;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HandlerActivity extends AppCompatActivity {


    TextView txt_count;
    Button btn_start, btn_stop , btn_reset;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        txt_count = findViewById(R.id.txt_count);
        btn_start = findViewById(R.id.btn_start);
        btn_stop = findViewById(R.id.btn_stop);
        btn_reset = findViewById(R.id.btn_reset);

        btn_start.setOnClickListener(click);
        btn_stop.setOnClickListener(click);
        btn_reset.setOnClickListener(click);


    }// oncreate()



    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
                int id = view.getId();
                if( id == R.id.btn_start){
                    //백그라운드에서 txt_count의 값을 1씩 증가시키는 핸들러 호출
                    //handler.handleMessage(); : 직접호출하면 일반 메서드처럼 작동한다

                    // 핸들러의 handleMessage 호출하는 방법
                        handler.sendEmptyMessage(0);

                        btn_start.setEnabled(false);
                    

                } else if(id == R.id.btn_stop){
                    // 핸들러 정지
                    handler.removeMessages(0);
                    btn_start.setEnabled(true);
                } else if(id == R.id.btn_reset){

                    count = 0;
                    txt_count.setText((String.valueOf(count)));
                }
        }

    };




    //핸들러 생성
    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            //계속증가시키기 위해서 핸들러안에서 또 자신을 호출한다
            //하지만 연산이 너무 빠르기 때문에 딜레이를 줘야한다.
//            handler.sendEmptyMessage(0);

            handler.sendEmptyMessageDelayed(0,1000);
            // 딜레이 시간동안 아래 있는 계산이 진행된다
            
            count++;
            txt_count.setText((String.valueOf(count)));
            

        }
    };











}