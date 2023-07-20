package com.lhj.ex_0719;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class SwipeRefreshActivity extends AppCompatActivity {

    SwipeRefreshLayout swipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_refresh);

        swipe = findViewById(R.id.swipe);

        //디스크의 색깔의 배경색 변경
        swipe.setProgressBackgroundColorSchemeColor(Color.parseColor("#aaaaff"));

        //디스크의 사이즈 변경(DEFAULT가 기본값)
        swipe.setSize(SwipeRefreshLayout.LARGE);

        swipe.setColorSchemeResources(R.color.color1,R.color.color2,R.color.color3,R.color.color4);

        //setProgressViewEndTarget(점진적 커짐,당겨지는 위치)
        swipe.setProgressViewEndTarget(true,300);

        swipe.setOnRefreshListener(swipeListener);
    }

    SwipeRefreshLayout.OnRefreshListener swipeListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            //당겼다가 손을 떼는 순간 호출되는 메서드
            //만약 서버랑 실제로 통신을 한다면
            //new Aysnc().execute()

            //서버통신을 하는것이 아니기 때문에 handler를 만들어서 처리해보자.
            handler.sendEmptyMessageDelayed(0,3000);
        }
    };

    Handler handler = new Handler(){
        @Override
        public void handleMessage( Message msg) {
            //로딩이 완료된 시점에서 디스크를 제거
            swipe.setRefreshing(false);
        }
    };
}