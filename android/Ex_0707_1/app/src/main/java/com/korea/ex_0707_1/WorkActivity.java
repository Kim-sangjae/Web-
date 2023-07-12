package com.korea.ex_0707_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class WorkActivity extends AppCompatActivity {

    Button send;
    EditText edit;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);


        edit = findViewById(R.id.edit);
        txt = findViewById(R.id.txt);
        send = findViewById(R.id.send);


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ori = edit.getText().toString();
                String re = "";

                for(int i = ori.length()-1 ; i >= 0 ; i--){

                   re += String.valueOf(ori.charAt(i));

                }

                Log.i("re",re);

                if(ori.equals(re)){

                    txt.setText("'" + ori + "'" +"\n 회문입니다");
                }else {

                txt.setText("'" + edit.getText() + "'" + "\n회문이아닙니다");

                }


            }
        });



    }
}