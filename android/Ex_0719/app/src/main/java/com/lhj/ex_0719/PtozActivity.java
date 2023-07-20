package com.lhj.ex_0719;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import uk.co.senab.photoview.PhotoViewAttacher;

public class PtozActivity extends AppCompatActivity {

    ImageView iv_photo;
    PhotoViewAttacher attacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ptoz);

        iv_photo = findViewById(R.id.iv_photo);

        //attacher 객체를 생성하고 생성자에 이미지뷰를 준다.
        attacher = new PhotoViewAttacher(iv_photo);
        attacher.update();
    }
}