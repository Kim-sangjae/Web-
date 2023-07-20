package com.lhj.ex_0719;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class DrawerLayoutActivity extends AppCompatActivity {

    DrawerLayout drawer_layout;
    Button btn_open, btn_close;

    LinearLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_layout);

        drawer_layout = findViewById(R.id.drawer_layout);
        btn_open = findViewById(R.id.btn_open);
        btn_close = findViewById(R.id.btn_close);
        drawer = findViewById(R.id.drawer);

        btn_open.setOnClickListener(click);
        btn_close.setOnClickListener(click);

        //드래그로 서랍열지 못하게 하기
        drawer_layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
    }

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int id = view.getId();
            if(id == R.id.btn_open){
                drawer_layout.openDrawer(drawer);
            } else if(id == R.id.btn_close){
                drawer_layout.closeDrawer(drawer);
            }
        }
    };
}