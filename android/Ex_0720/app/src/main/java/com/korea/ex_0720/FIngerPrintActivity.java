package com.korea.ex_0720;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.github.ajalt.reprint.core.AuthenticationFailureReason;
import com.github.ajalt.reprint.core.AuthenticationListener;
import com.github.ajalt.reprint.core.Reprint;

public class FIngerPrintActivity extends AppCompatActivity {

    TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finger_print);

        text = findViewById(R.id.txt);
        
        //1. 지문사용을 위한 초기화
        Reprint.initialize(FIngerPrintActivity.this);
        
        if(checkSpec()){
            //지문인식이 가능한경우
            Reprint.authenticate(new AuthenticationListener() {
                @Override // 성공
                public void onSuccess(int moduleTag) {
                    // 원래는 텍스트말고 화면전환같은 기능을 여기에 구현한다
                    text.setText("인증성공");
                }

                @Override // 실패
                public void onFailure(AuthenticationFailureReason failureReason, boolean fatal, CharSequence errorMessage, int moduleTag, int errorCode) {
                    text.setText("인증실패,다시 시도하세요");
                }
            });
        }
        
        

    }//onCreate()
    
    
    
    //2. 지문인식이 가능한지 판단(휴대폰 스펙 확인)
    public boolean checkSpec(){
        // 참이면 지문인식 센서가 존재한다는 것
        boolean hardware = Reprint.isHardwarePresent();
//        Log.i("하드웨어존재", String.valueOf(hardware));
        
        // 센서가 존재해도 지문등록이 안되어있으면 사용불가 
        // 지문등록 되어있는지 확인 - 등록되어있으면 참
        boolean register = Reprint.hasFingerprintRegistered();
//        Log.i("등록존재", String.valueOf(register));
        
        if(!hardware){
            Toast.makeText(FIngerPrintActivity.this,"지문인식 센서가 존재하지 않습니다" , Toast.LENGTH_SHORT);
        }else{
            if(!register){
                Toast.makeText(FIngerPrintActivity.this,"지문등록정보가 없습니다\n 지문등록을 해주세요",Toast.LENGTH_SHORT);
            }
        }

        return hardware && register; //둘다 만족하면 true , 아니면 false반환
    };
    
    
    
    
    
}