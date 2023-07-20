package com.lhj.ex_0719;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NumberActivity extends AppCompatActivity {

    TextView show_num , question;
    Button btn_yes, btn_no , btn_restart;


    int result = 0; // 결과를 출력할 변수
    int phase = 1; // 현재 스테이지

    boolean check = true;

    final int YES = 1;
    final int NO = 0;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);

        show_num = findViewById(R.id.show_num);
        question = findViewById(R.id.question);

        btn_yes = findViewById(R.id.btn_yes);
        btn_no = findViewById(R.id.btn_no);
        btn_restart = findViewById(R.id.btn_restart);



        btn_yes.setOnClickListener(click);
        btn_no.setOnClickListener(click);
        btn_restart.setOnClickListener(click);

    }




    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int id = view.getId();
            if(id == R.id.btn_yes){
                phase++;
                result+=Integer.parseInt((String) show_num.getText().subSequence(0,2));
                show_num.setText("16 17 18 19 20\n21 22 23 24 25\n26 27 28 29 30");

                if(phase == 2){
                    Log.i("2:누를 숫자" , (String) show_num.getText().subSequence(0,2));
                    result+=Integer.parseInt((String) show_num.getText().subSequence(0,2));
                }else if(phase == 3){
                    show_num.setText("01 03 05 07 09\n11 13 15 17 19\n21 23 25 27 29");
                    Log.i("누를 숫자" , (String) show_num.getText().subSequence(0,2));
                    Log.i("더한 숫자" , String.valueOf(result));
                    result+=Integer.parseInt((String) show_num.getText().subSequence(0,2));
                }else if(phase == 4){
                    show_num.setText("08 09 10 11 12\n13 14 15 24 25\n26 27 28 29 30");
                    Log.i("누를 숫자" , (String) show_num.getText().subSequence(0,2));
                    Log.i("더한 숫자" , String.valueOf(result));
                    result+=Integer.parseInt((String) show_num.getText().subSequence(0,2));
                }else if(phase == 5){
                    show_num.setText("02 03 06 07 10\n11 14 15 18 19\n22 23 26 27 30");
                    Log.i("누를 숫자" , (String) show_num.getText().subSequence(0,2));
                    Log.i("더한 숫자" , String.valueOf(result));
                    result+=Integer.parseInt((String) show_num.getText().subSequence(0,2));
                }else if(phase == 6){
                    show_num.setText("당신이 생각한 숫자는 \n" + result);
                    btn_restart.setVisibility(View.VISIBLE);
                }


            } else if(id == R.id.btn_no){
                phase++;

                if(phase == 2){
                    show_num.setText("16 17 18 19 20\n21 22 23 24 25\n26 27 28 29 30");
                }else if(phase == 3){
                    show_num.setText("01 03 05 07 09\n11 13 15 17 19\n21 23 25 27 29");
                }else if(phase == 4){
                    show_num.setText("08 09 10 11 12\n13 14 15 24 25\n26 27 28 29 30");
                }else if(phase == 5){
                    show_num.setText("02 03 06 07 10\n11 14 15 18 19\n22 23 26 27 30");
                }else if(phase == 6){
                    show_num.setText("당신이 생각한 숫자는 \n" + result);
                    btn_restart.setVisibility(View.VISIBLE);
                }

            } else if(id == R.id.btn_restart){
                phase = 1;
                result = 0;
                show_num.setText("04 05 06 07 12\n13 14 15 20 21\n22 23 28 29 30");
                btn_restart.setVisibility(View.GONE);
            }




        }
    };


    public void showPhase(int select){
        String str = "";
        switch (phase){
            case 1 :
                if(select == YES){
                    result += 4;
                }
                str = "16 17 18 19 20\n21 22 23 24 25\n26 27 28 29 30";
                break;
            case 2 :
                if(select == YES){
                    result += 16;
                }
                str = "01 03 05 07 09\n11 13 15 17 19\n21 23 25 27 29";
                break;
            case 3 :
                if(select == YES){
                    result += 01;
                }
                str = "08 09 10 11 12\n13 14 15 24 25\n26 27 28 29 30";
                break;
            case 4 :
                if(select == YES){
                    result += 8;
                }
                str = "02 03 06 07 10\n11 14 15 18 19\n22 23 26 27 30";
                break;
            case 5 :
                if(select == YES){
                    result += 2;
                }
                //결과가 0dlrjsk 31일 경우
                if(result == 0 || result==31){
                    str="잘못 선택한 문항이 있습니다";

                }else {
                    str = "당신이 생각한 숫자는 \n\""+result+"\"입니다.";
                }
                btn_yes.setVisibility(View.GONE);
                btn_no.setVisibility(View.GONE);
                btn_restart.setVisibility(View.VISIBLE);
                question.setVisibility(View.GONE);
                break;
        }

        show_num.setText(str);
        phase++;
    }







}