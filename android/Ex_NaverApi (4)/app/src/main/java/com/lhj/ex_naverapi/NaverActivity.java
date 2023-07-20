package com.lhj.ex_naverapi;

import androidx.appcompat.app.AppCompatActivity;

import android.net.LinkAddress;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

import parser.Parser;
import vo.BookVO;

public class NaverActivity extends AppCompatActivity {

    public static EditText search;

    ListView myListView;
    Button search_btn;
    Parser parser; //connectNaver메서드를 호출하려면 parser객체가 있어야 한다.

    LinearLayout loading; //로딩화면을 표시하는 리니어레이아웃

    ViewModelAdapter adapter;//adapter객체 준비하기

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_naver);

        search = findViewById(R.id.search);
        myListView = findViewById(R.id.myListView);
        search_btn = findViewById(R.id.search_btn);
        loading = findViewById(R.id.loading);
        parser = new Parser();


        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //parser.connectNaver();
                //connectNaver()도 메서드이기 때문에 메서드가 완전히 마무리 되어야
                //다음 작업을 할 수 있다. 데이터가 많으면 로딩이 완료되는 동안
                //다른작업을 할 수 가 없다. 뒤로가기도 안되고, 터치도 안되고
                //클릭도 안되고 아무것도 안된다.
                new NaverAsync().execute("홍","길","동");

                //로딩시작
                loading.setVisibility(View.VISIBLE);




                //검색을 하고나면 키보드가 내려가게 하자.
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(search.getWindowToken(),0);




            }
        });

        //가상키보드에서 검색 버튼을 누른 경우 실제 ok버튼이 눌리도록 강제로 클릭
        search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
               if(i == EditorInfo.IME_ACTION_SEARCH){
                   search_btn.performClick();//ok버튼 누르기.
               }
               return true;
            }
        });

    }//onCreate

    //AsyncTask : 백그라운드에서의 서버통신을 위해 반드시 필요한 클래스
    //AsyncTask는 세 개의 제너릭타입을 가지고 있다.
    //  -  doinBackground의 파라미터 타입
    //  -  onProgressUpdate가 오버라이딩 되어있다면 이 베서드에서 사용할 타입
    //  -  doinBackground의 반환형이자, 작업의 최종결과를 차지하는 onPostExecute()의 파라미터 타입
    class NaverAsync extends AsyncTask<String, Void, ArrayList<BookVO>>{

        //(String...strings) : String타입의 strings배열을 만들되 들어온 요소의
        //개수를 신경쓰지말고 들어오는대로 만들어라
        //strings[0] = "홍";
        //strings[1] = "길";
        //strings[2] = "동";
        @Override
        protected ArrayList<BookVO> doInBackground(String... strings) {
            //필수메서드!!
            //각종 반복이나 제어등의 백그라운드에서 필요한 처리코드를 담당하는 메서드
            return parser.connectNaver();
        }

        @Override
        protected void onPostExecute(ArrayList<BookVO> bookVOS) {
            //doInBackground에서 return된 최종 작업 결과를 bookVOS가 받게 된다.
            Log.i("my",""+bookVOS.size());

            adapter = new ViewModelAdapter(NaverActivity.this,R.layout.book_item,bookVOS, myListView);

            //준비된 어댑터를 ListView에 탑재
            myListView.setAdapter(adapter);

            //로딩종료
            loading.setVisibility(View.GONE);

        }
    }











}