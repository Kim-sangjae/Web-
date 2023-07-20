package com.korea.ex_0720;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.andrognito.patternlockview.PatternLockView;
import com.andrognito.patternlockview.listener.PatternLockViewListener;
import com.andrognito.patternlockview.utils.PatternLockUtils;

import java.util.List;

public class PatternActivity extends AppCompatActivity {
    PatternLockView patternLockView;
    TextView passwordTextView;

    //패턴상태
    String restorePassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pattern);

        passwordTextView = findViewById(R.id.password_text_view);
        patternLockView = findViewById(R.id.pattern_lock_view);
        patternLockView.addPatternLockListener(new PatternLockViewListener() {
            @Override
            public void onStarted() {
                Log.i("my","패턴그리기 시작");
            }

            @Override
            public void onProgress(List<PatternLockView.Dot> progressPattern) {
                Log.i("my","패턴 그리는중: "+ PatternLockUtils.patternToString(patternLockView, progressPattern));
            }

            @Override
            public void onComplete(List<PatternLockView.Dot> pattern) {
                Log.i("my","패턴완성: "+PatternLockUtils.patternToString(patternLockView,pattern));
                //입력한 패스워드
                String password = PatternLockUtils.patternToString(patternLockView,pattern);
                //1-1 저장된 패스워드가 있다면
                if(!restorePassword.equals("")){
                    //2-1 입력된 패턴과 저장된 패스워드가 같다면
                    if(password.equals(restorePassword)){
                        passwordTextView.setText("패턴 성공");
                        //패턴 색상 변경
                        patternLockView.setCorrectStateColor(Color.parseColor("#0000FF"));
                    } else { //2-2 입력된 패턴과 저장된 비밀번호가 다를 때
                        passwordTextView.setText("잘못된 패턴");
                        //패턴 색상 변경
                        patternLockView.setCorrectStateColor(Color.parseColor("#FF0000"));
                    }
                } else {//1-2 저장된 패스워드가 없다면
                    //현재 패스워드 저장
                    SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("password",password);
                    editor.commit();
                    passwordTextView.setText("저장되었습니다.");
                    patternLockView.clearPattern();//패턴 지우기
                }
            }
            @Override
            public void onCleared() {
                Log.i("my","패턴지워짐");
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        restorePassword();
    }

    public void restorePassword(){
        SharedPreferences pref = getSharedPreferences("pref",Activity.MODE_PRIVATE);
        //저장된 패스워드 변수에 담기
        restorePassword = pref.getString("password","");
        //등록한 비밀번호가 있을 때
        if(pref != null && !restorePassword.equals("")){
            passwordTextView.setText("등록한 패턴을 입력해주세요");
        } else { //비밀번호가 없을 때
            passwordTextView.setText("저장된 패턴이 없습니다.");
        }
    }
}