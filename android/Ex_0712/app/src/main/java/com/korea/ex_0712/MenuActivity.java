package com.korea.ex_0712;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }


    @Override // 이메서드가 없으면 ActionBar 오른쪽위에 메뉴바가 활성화되지않는다
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.my_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }


    // 메뉴바 각 메뉴의 이벤트 처리를 위한 메서드
    // 매개변수인 item이 어떤 메뉴가 눌러졌는지 알 수 있다
    @Override 
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        
        if(itemId == R.id.menu1){
//            Toast.makeText(메뉴객체 , 텍스트 , 알림띄울 시간)
            Toast.makeText(MenuActivity.this,"앱 소개 누름",Toast.LENGTH_SHORT).show();
        } else if(itemId == R.id.menu2){
            Toast.makeText(MenuActivity.this,"이메일 누름",Toast.LENGTH_SHORT).show();
        }else {
            finish(); // 현재 띄워져있는 Activity 한개를 종료
        }

        return true;

    }
}