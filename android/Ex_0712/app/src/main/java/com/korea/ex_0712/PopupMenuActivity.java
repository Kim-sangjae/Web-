package com.korea.ex_0712;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class PopupMenuActivity extends AppCompatActivity {


    Button btn_show , anchor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_menu);

        btn_show = findViewById(R.id.btn_show);
        anchor = findViewById(R.id.anchor);
        
        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                PopupMenu popup = new PopupMenu(PopupMenuActivity.this , view);
                // anchor : 메뉴를 띄워줄 기준객체 (메뉴를 어디다 띄울것이냐 ... 현재는 view)

                PopupMenu popup = new PopupMenu(PopupMenuActivity.this , anchor);
                
                // 팝업메뉴에 띄워줄 메뉴xml 등록 
                // inflate() : xml을 view형태로 바꿔주는 메서드
                // popup.getMenu() : 메뉴가 들어갈 공간을 만들어주는 메서드
                getMenuInflater().inflate(R.menu.my_menu, popup.getMenu());

                // 메뉴아이템이 기능을 붙일건데 
                // popup.show() 를 하기전에 해야 오류가 안난다
                popup.setOnMenuItemClickListener(menu_click);
                



                popup.show();
            }
        });

    }



    PopupMenu.OnMenuItemClickListener menu_click = new PopupMenu.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            int itemId = menuItem.getItemId();

            if(itemId == R.id.menu1){
                Toast.makeText(PopupMenuActivity.this , " 앱소개 누름 ",Toast.LENGTH_SHORT).show();
            } else if(itemId == R.id.menu2){
                Toast.makeText(PopupMenuActivity.this , " 이메일 누름 ",Toast.LENGTH_SHORT).show();
            } else if(itemId == R.id.menu3){
                finish();
            }

            return false;
        }
    };








}