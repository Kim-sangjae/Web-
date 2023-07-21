package com.korea.ex_0720;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ontbee.legacyforks.cn.pedant.SweetAlert.SweetAlertDialog;

public class SweetAlertActivity extends AppCompatActivity {
    
    Button btn_warning, btn_error , btn_success;
    SweetAlertDialog sweetAlertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sweet_alert);
        
        btn_warning = findViewById(R.id.btn_warning);
        btn_error = findViewById(R.id.btn_error);
        btn_success = findViewById(R.id.btn_success);
        
        btn_warning.setOnClickListener(click);
        btn_error.setOnClickListener(click);
        btn_success.setOnClickListener(click);
        
    }// onCreate
    
    
    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int id = view.getId();
            
            if(id == R.id.btn_warning){
                sweetAlert("!!WARNING!!",getString(R.string.alert_warning),SweetAlertDialog.WARNING_TYPE,SweetAlertActivity.this);
            }else if (id == R.id.btn_error){
                sweetAlert("!!ERROR!!",getString(R.string.alert_error),SweetAlertDialog.ERROR_TYPE,SweetAlertActivity.this);
            }else if (id == R.id.btn_success){
                sweetAlert("!!SUCCESS!!",getString(R.string.alert_success),SweetAlertDialog.SUCCESS_TYPE,SweetAlertActivity.this);
            }
            
        }// Onclick()
    };
    
    
    
    // 타입별 다이얼로그 호출 메서드
    public void sweetAlert(String message, String title , int type , Context context){
        sweetAlertDialog = new SweetAlertDialog(context,type);
        sweetAlertDialog.setTitleText(title); // 제목
        sweetAlertDialog.setContentText(message); // 내용
        sweetAlertDialog.setConfirmText("OK"); // 확인버튼

        sweetAlertDialog.show();
    }
    
    
    
    
    
}