package com.korea.ex_0714;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class IntentSubActivity extends AppCompatActivity {

    TextView txt_name,txt_age,txt_tel,txt_birth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_sub);

        // 인텐트로 넘겨받은 데이터
        Intent i = getIntent();

        String name = i.getStringExtra("m_name");
        String age = i.getStringExtra("m_age");
        String tel = i.getStringExtra("m_tel");
        String birth = i.getStringExtra("m_birth");


        txt_name = findViewById(R.id.txt_name);
        txt_age = findViewById(R.id.txt_age);
        txt_tel = findViewById(R.id.txt_tel);
        txt_birth = findViewById(R.id.txt_birth);


        txt_name.setText("이름 : " + name);
        txt_age.setText("나이 : " +age);
        txt_tel.setText("전화번호 : " + tel);
        txt_birth.setText("생일 : " + birth);




    }
}