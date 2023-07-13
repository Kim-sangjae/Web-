package com.korea.ex_0713;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class IntentActivity extends AppCompatActivity {

    Button btn_call,btn_sms,btn_camera,btn_gallery,btn_next,btn_link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);


        btn_call = findViewById(R.id.btn_call);
        btn_sms = findViewById(R.id.btn_sms);
        btn_camera = findViewById(R.id.btn_camera);
        btn_gallery = findViewById(R.id.btn_gallery);
        btn_next = findViewById(R.id.btn_next);
        btn_link = findViewById(R.id.btn_link);


        btn_call.setOnClickListener(click);
        btn_sms.setOnClickListener(click);
        btn_camera.setOnClickListener(click);
        btn_gallery.setOnClickListener(click);
        btn_next.setOnClickListener(click);
        btn_link.setOnClickListener(click);


    }// onCreate()






    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i = null; // 화면전환을 위해 반드시 필요한 클래스

            int id = view.getId();

            if(id == R.id.btn_call){
//                // 다이얼 화면으로 전환
//                i = new Intent(Intent.ACTION_DIAL);
//
//                i.setData(Uri.parse("tel:010-1111-1111"));
//                // tel : -> 전화번호라는걸 판단한다
//
//                startActivity(i);


                AlertDialog.Builder dialog1 = new AlertDialog.Builder(IntentActivity.this);
                dialog1.setTitle("통화연결");
                dialog1.setMessage("통화를 연결 하시겠습니까? ");
                dialog1.setPositiveButton("네", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // 전화를 즉시 걸어주는 작업 (권한이 필요하다)
                        Intent i1 = new Intent(Intent.ACTION_CALL);
                        i1.setData(Uri.parse("tel:01011111111"));

                        startActivity(i1); //그냥 하면 앱이 멈춘다

                        // 권한주기 (Manifest.xml에서 설정)
                    }
                });

                dialog1.setNegativeButton("아니오",null);
                dialog1.show();
                

            } else if(id == R.id.btn_sms){
                i = new Intent(Intent.ACTION_SENDTO);
                i.setData(Uri.parse("smsto:010-1234-1234"));
                // smsto : 메세지보낼 번호로 인식
                
                // putExtra : 내용을 지정해줄 수 있다
                // 파라미터는 키와 벨류로 저장을 해야하는데 키는 sms_body로 고정되어있다
                i.putExtra("sms_body", "안녕~");

                startActivity(i);
                
            }else if(id == R.id.btn_camera){

                //카메라인 척 하는 내장 화면
//                i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                //바로 동영상 촬영으로 연결
                i = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);


                startActivity(i);
                
            }else if(id == R.id.btn_gallery){

                i = new Intent(Intent.ACTION_GET_CONTENT);
                i.setType("*/*"); //모든 타입을 호출

                startActivity(i);
                
            }else if(id == R.id.btn_link){

                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.naver.com"));

                startActivity(i);
                
            }else if(id == R.id.btn_next){
                
            }



        }
    };










}