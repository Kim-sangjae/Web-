package com.korea.ex_0712;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class VisibleActivity extends AppCompatActivity {

    Button btn_back1,btn_back2,btn_bottom,bot;
    ImageView img_gunship,img_menu;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visible);


        btn_back1 = findViewById(R.id.btn_back1); // -> 비행기 보이기
        btn_back2 = findViewById(R.id.btn_back2); // -> 비행기 숨기기
        btn_bottom = findViewById(R.id.btn_bottom); // -> 아래에있는 버튼 숨기기,숨김해제

        bot = findViewById(R.id.bot);

        img_gunship =findViewById(R.id.img_gunship);
        img_menu =findViewById(R.id.img_menu);


        btn_back1.setOnClickListener(click);
        btn_back2.setOnClickListener(click);
        btn_bottom.setOnClickListener(click);



    }//onCreate


    //감지자로 처리하는 방법 3가지
    //1. view = R.id btn -> id를 통해 감지
    //2. view를 자식 클래스로 캐스팅하기  ->(ex getText속성을 쓰기위해 view를 (Button)으로 형변환
    //3. 주소가 같기 때문에 그냥 이름으로 비교하기

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            if(btn_back1 == view){
                // 비행기를 보여주고 동그라미 숨기기
                img_gunship.setVisibility(View.VISIBLE);
                img_menu.setVisibility(View.INVISIBLE);
            } else if(btn_back2 == view){
                // 동그라미 보여주고 비행기 숨기기
                img_gunship.setVisibility(View.INVISIBLE);
                img_menu.setVisibility(View.VISIBLE);
            } else if(btn_bottom == view){
                //getVisibility : 현재 객체의 visible 속성 가져오기
                if(bot.getVisibility() == View.VISIBLE){
                    bot.setVisibility(View.GONE);
                }else {
                    bot.setVisibility(View.VISIBLE);
                }
            }

        }

    };//click()







}