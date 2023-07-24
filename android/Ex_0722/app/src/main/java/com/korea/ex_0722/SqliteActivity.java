package com.korea.ex_0722;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class SqliteActivity extends AppCompatActivity {
    //안드로이드에서 기본으로 제공하는 클래스
    SQLiteDatabase mDatabase;

    // 처음에 한번 복사를 하고 나면 , 다음은 복사를 해줄 필요가 없기 떄문에
    // 변수를 하나만 만들어서 막아주자
    boolean isFirst = true;

    SharedPreferences pref;


    EditText et_name , et_phone , et_age;
    Button btn_all , btn_search , btn_del, btn_insert;
    TextView result_txt;

    // 개발자가 알맞은 코드를 썼지만 , 충돌 가능성이 있는 코드를 사용할 때 사용하는 어노테이션
    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        pref = PreferenceManager.getDefaultSharedPreferences(SqliteActivity.this);

        load();

        
        // 앱이 최초 실행 되었을 때 assets 폴더의 db를 휴대폰의 내부저장소에 저장
        copyAssets();


        save();

        mDatabase = openOrCreateDatabase(Environment.getExternalStorageDirectory() + "/database/myDB.db",SQLiteDatabase.CREATE_IF_NECESSARY,null);


        et_name = findViewById(R.id.et_name);
        et_phone = findViewById(R.id.et_phone);
        et_age = findViewById(R.id.et_age);

        btn_all = findViewById(R.id.btn_all);
        btn_search = findViewById(R.id.btn_search);
        btn_insert = findViewById(R.id.btn_insert);
        btn_del = findViewById(R.id.btn_del);

        result_txt = findViewById(R.id.result_txt);

        btn_all.setOnClickListener(click);
        btn_search.setOnClickListener(click);
        btn_insert.setOnClickListener(click);
        btn_del.setOnClickListener(click);

    }// onCreate


    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int id = view.getId();

            if(id == R.id.btn_all){
                // 전체 조회
                searchQuery("SELECT * FROM freind");
            }else if(id == R.id.btn_search){
                // 검색 조회
                String name = et_name.getText().toString().trim();
                if(name.length() == 0){
                    Toast.makeText(SqliteActivity.this,"검색할 이름을 입력하세요",Toast.LENGTH_SHORT).show();
                }else{
                    searchQuery(String.format("select * from freind where name like '%%%s%%'",name));
                }

            }else if(id == R.id.btn_insert){
                // 추가하기
                String iname = et_name.getText().toString().trim();
                String iphone = et_phone.getText().toString().trim();
                String iage = et_age.getText().toString().trim();

                if(iname.length() == 0 ){
                    Toast.makeText(SqliteActivity.this,"추가할 이름을 입력해주세요",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(iphone.length() == 0 ){
                    Toast.makeText(SqliteActivity.this,"추가할 번호를 입력해주세요",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(iage.length() == 0 ){
                    Toast.makeText(SqliteActivity.this,"추가할 나이를 입력해주세요",Toast.LENGTH_SHORT).show();
                    return;
                }

                int m_age = Integer.parseInt(iage);

                searchQuery(String.format("insert into freind values ('%s','%s',%d)",iname,iphone,m_age));
                searchQuery("SELECT * FROM freind");

            }else if(id == R.id.btn_del){
                // 삭제하기
                String dname = et_name.getText().toString().trim();
                searchQuery(String.format("delete from freind where name = '%s'",dname));
                searchQuery("SELECT * FROM freind");
            }
        }

    };


    // 쿼리문 수행을 위한 메서드
    public void searchQuery(String query){
        Cursor c = mDatabase.rawQuery(query,null);
        // 지금 db만 에뮬레이터에 복사해놓은 상태고 실제로는 어디에 연결 되는지 지정하지 않았다
        // mdatabase 를 통해서 rawQuery라는 메서드를 가지고 쿼리문을 요청해야한다.

        // c.getColumnCount : 테이블의 컬럼수(name,phone,age) - 3개
        String[] col = new String[c.getColumnCount()];

        col = c.getColumnNames();
        //col[0] : name
        //col[1] : phone
        //col[2] : age

        String[] str = new String[c.getColumnCount()];
        String result = ""; // 최종 결과를 저장해둘 변수


        Log.i("my" , Arrays.toString(col));

        //행 단위로 한줄씩 커서가 이동
        while(c.moveToNext()){
            for(int i = 0; i<col.length; i++){
                str[i] = ""; // 빈문자열을 넣지않으면 null값이 들어가서
                str[i] += c.getString(i); // null홍길동 이 되버린다
                result+= col[i] + ":" + str[i] +"\n";
            }
        }
        result_txt.setText(result);

    }





    
    
    
    //assets 폴더의 db를 휴대혼 내부 저장소에 저장하기 위한 메서드
    public void copyAssets(){
        //InputStream 으로 읽어서 OutputStream 으로 휴대폰 내부에 저장하기

        // getAssets() : assets폴더 아래 모든 파일 가져오기
        AssetManager assetManager = getAssets();
        String[] files = null;
        String mkdir = "";

        try{
            //files[0] -> "images" 폴더가 숨겨져 있다
            //files[1] -> "myDB.db" 파일 이름이 문자열로 들어온다.
            files = assetManager.list("");

            InputStream in = null;
            OutputStream out = null;

            //files[1] 의 값인 "myDB.db" 와 같은 이름의 파일을 찾아서
            //inputStream으로 읽어오기
            in = assetManager.open(files[1]);

            //내부 저장소에 폴더 생성하기
            //휴대폰 내부 저장소의 최상위(root)폴더에 접근
            String str = "" + Environment.getExternalStorageDirectory();
            mkdir = str + "/database"; // database라는 이름의 폴더도 같이 생성하기

            File mpath = new File(mkdir);
            if(!mpath.exists()){ //mpath가 존재하지 않으면
                isFirst = true;
            }
            if(isFirst){
                mpath.mkdir(); // database 폴더까지 생성
                // database 이름의 폴더까지 접근해서 myDB.db라는 이름으로 output 할 준비
                out = new FileOutputStream(mkdir+"/"+files[1]);

                //2mb
                byte[] buffer = new byte[2048];
                int read = 0;

                while((read = in.read(buffer))!= -1){
                    out.write(buffer,0,read);
                }
                out.close();
                in.close();
                isFirst = false;
            }

        }catch(Exception e){

        }
        
    }//copyAssets()
    


    public void save(){
        SharedPreferences.Editor edit = pref.edit();
        edit.putBoolean("save",isFirst); // save라는 이름으로isFirst를 저장한다
        edit.commit();
        // 카피에셋을 실행시키로 저장을 하기때문에 isFirst에 false가 저장된다.
    }

    //isFirst의 값 로드하기
    public void load (){
        isFirst = pref.getBoolean("save",true); //저장되어있는 값이 없다면 true를 기본으로 넣는다
    }


    
}