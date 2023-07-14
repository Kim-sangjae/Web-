package com.korea.ex_0714;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class IntentMainActivity extends AppCompatActivity {

    EditText edit_name ,edit_age , edit_tel , edit_b_day;
    Button btn_date , btn_send;

    Dialog dialog;

    int num = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_main);

        edit_name = findViewById(R.id.edit_name);
        edit_age = findViewById(R.id.edit_age);
        edit_tel = findViewById(R.id.edit_tel);
        edit_b_day = findViewById(R.id.edit_b_day);
        btn_date = findViewById(R.id.btn_date);
        btn_send = findViewById(R.id.btn_send);

        btn_send.setOnClickListener(send_click);
        btn_date.setOnClickListener(date_click);


    }





    View.OnClickListener send_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
              String name = edit_name.getText().toString();
              if(name.trim().length() == 0){
                  Toast.makeText(IntentMainActivity.this,"이름을 입력하세요" ,Toast.LENGTH_SHORT);
              }

              String age = edit_age.getText().toString();
            if(age.trim().length() == 0){
                Toast.makeText(IntentMainActivity.this,"나이를 입력하세요" ,Toast.LENGTH_SHORT);
            }

              String tel = edit_tel.getText().toString();
            if(tel.trim().length() == 0){
                Toast.makeText(IntentMainActivity.this,"전화번호를 입력하세요" ,Toast.LENGTH_SHORT);
            }

              String birth = edit_b_day.getText().toString();



            Intent i = new Intent(IntentMainActivity.this, IntentSubActivity.class);

            // 값 전달을 위해 Intent 객체에 저장
            i.putExtra("m_name",name);
            i.putExtra("m_age",age);
            i.putExtra("m_tel",tel);
            i.putExtra("m_birth",birth);


            startActivity(i);

        }
    };


    View.OnClickListener date_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // 달력에 최초로 표기될 오늘 날짜를 구한다
            Calendar now = Calendar.getInstance();

            int y = now.get(Calendar.YEAR);
            int m = now.get(Calendar.MONTH);
            int d = now.get(Calendar.DAY_OF_MONTH);

            dialog = new DatePickerDialog(IntentMainActivity.this,dateSetListener,y,m,d);



            dialog.show();
        }
    };


    DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override // int i = 년  i1 = 월  i2= 일
        public void onDateSet(DatePicker datePicker, int y , int m, int d) {

            String result = String.format("%d-%02d-%02d",y,m+1,d);

            edit_b_day.setText(result);
            edit_b_day.setTextColor(Color.BLACK);

        }
    };
    
    // 앱을 하나 켜고 뒤로가기를 눌렀을 때 ' 뒤로가기를 한번 더 눌러야 종료됩니다' 라고 토스트띄우고
    // 토스트가 떴을때 3초이내에 다시 누르면 종료 , 3초가 지나면 두번 누른걸 인정 x 토스트 다시띄우기


    @Override
    public void onBackPressed() {

        exitHandler.sendEmptyMessage(0);
        if(num != 2){
            finish();
        } else {
            Toast.makeText(IntentMainActivity.this,"두번눌러야 종료됩니다",Toast.LENGTH_SHORT).show();
            exitHandler.sendEmptyMessage(0);

        }

    }



    Handler exitHandler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            //2초카운팅을 위한 핸들러
            exitHandler.sendEmptyMessageDelayed(0,1000);

            if(num>0){
                --num;
            }else{
                num = 2;
                exitHandler.removeMessages(0);
            }
        }
    };


}