package com.korea.ex_0707_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class LotActivity extends AppCompatActivity {

    TextView txt_result;
    Button btn1 , btn2 , btn3 , btn4, btn_reset;
    
    int rnd = 0; // 난수저장용 변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lot);

        txt_result = findViewById(R.id.txt_result);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);

        btn_reset = findViewById(R.id.btn_reset);

        setRandom(); // 난수생성 메서드

        btn1.setOnClickListener(btn_click);
        btn2.setOnClickListener(btn_click);
        btn3.setOnClickListener(btn_click);
        btn4.setOnClickListener(btn_click);

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_result.setText("result");
                setRandom();
            }
        });

    }//onCreate()



    // 버튼1234 공통 이벤트리스너
    View.OnClickListener btn_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // 클릭된 버튼에 쓰여진 text를 가져오는것이 우선
            // getText()는 TextView 나 , 버튼 editText와 같은 자식객체에서만 사용이 가능
            // view라는 부모에서는 사용할 수 없다

            // view 객체를 button으로 형변환 한다
            int str = Integer.parseInt(((Button)view).getText().toString());

            if(str == rnd){
                // 버튼 텍스트와 random 값이 같다면
                txt_result.setText("당첨!");
            }else {
                txt_result.setText("꽝");
            }

        }
    };




    // 난수생성 메서드
    public void setRandom(){
        rnd = new Random().nextInt(4)+1;
    }







}