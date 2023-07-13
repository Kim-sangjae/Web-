package com.korea.ex_0713;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AlertDialogActivity extends AppCompatActivity {

    Button btn_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);


        btn_show = findViewById(R.id.btn_show);

        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 버튼눌렀을 때 다이얼로그 띄우기
                AlertDialog.Builder dialog = new AlertDialog.Builder(AlertDialogActivity.this);

                //AlertDialog 의 객체를 Builder클래스가 대신 만들어준다
                //Builder 패턴
                //별도의 Builder 객체에서 복잡한 객체의 일부를 만들고 조합하는것을 캡슐화 한다
                // 클래스는 객체를 직접 생성하는 대신에 Builder객체에 객체 생성을 위임한다.

                // builder 패턴의 장점
                // 제품의 내부 표현을 변경할 수 있다.
                // 구성 및 표현을 위한 코드를 캡슐화 한다.
                // AlertDialog의 내부의 Builder클래스는 여러가지 메서드를 제공한다.



                dialog.setTitle("다이얼로그 타이틀");
                dialog.setMessage("다이얼로그 본문(컨텐츠)");



                // 다이얼로그 버튼 추가하기
                dialog.setPositiveButton("네", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(AlertDialogActivity.this,"평가하기",Toast.LENGTH_SHORT).show();
                    }
                });

                // 똑같은 positiveButton 을 또 만들면 최근에 만들걸로 갱신된다 (여러개 사용 불가능)

//                dialog.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
//
//                    @Override                                       // int i : 클릭한 버튼의 정보
//                    public void onClick(DialogInterface dialogInterface, int i) {
//
//                    }
//                });

                // 아니오 버튼을 누르면 다시 앱으로 돌아온다
                // 이벤트 처리를 따로 만들 필요가 없으면
                // 감지자를 만들지말고 null을 넣어주자
                dialog.setNegativeButton("아니오",null);


                dialog.setNeutralButton("나중에", null);

                // 버튼은 총 3개 밖에 쓰지 못한다
                // positive , negative , neutral
                // 버튼 은 따로 역할 우리가 정해주기 때문에
                // 위치를 바꾸고 싶으면 안에 문자를 바꿔 주면 된다.
                // 실제 부정 , 긍정의 동작을 하는 것은 아니다


                // 다이얼로그가 뒤로가기 버튼 , 빈공간 터치시 사라지는 것을 방지
                dialog.setCancelable(false);





                // 메뉴 , 토스트 같은 팝업,위젯들은 기존의 레이아웃 위에 띄우기 위해서는
                // show() 를 써서 보여줘야한다
                dialog.show();


            }
        });

    };


    @Override
    public void onBackPressed() {
        // 뒤로 가기 버튼을 눌렀을 때 호출되는 메서드
        //super.onBackPressed(); -> 이 호출이 없으면 종료가 안됨

//        Toast.makeText(AlertDialogActivity.this,"뒤로가기누름",Toast.LENGTH_SHORT).show();

        //뒤로 가기 눌렀을때 다이얼로그 '종료하시겠습니까' 띄우고 '네' 누르면 종료하기

        AlertDialog.Builder dialog1 = new AlertDialog.Builder(AlertDialogActivity.this);


        dialog1.setTitle("종료");
        dialog1.setMessage(" 종료 하시겠습니까? ");

        dialog1.setPositiveButton("네", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        dialog1.setNegativeButton("아니오",null);

        dialog1.show();

    };




}