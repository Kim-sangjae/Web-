package com.lhj.ex_naverapi;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.BufferedInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.BitSet;

import vo.BookVO;

public class ViewModelAdapter extends ArrayAdapter<BookVO> {

    Context context;
    int resource;
    BookVO vo;

    ArrayList<BookVO> list;

    public ViewModelAdapter(Context context, int resource, ArrayList<BookVO> list, ListView myListView) {
        super(context, resource, list);
        this.context = context;
        this.resource = resource;
        this.list = list;

        //메인에서 넘어온 listView에게 이벤트 감지자를 등록
        myListView.setOnItemClickListener(click);
    }//생성자

    AdapterView.OnItemClickListener click = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            //int i는 책에 대한 자세한 내용을 보기 위해 항목을 누를 때, (맨 위에걸 누르면 i가 0)
            String title = list.get(i).getB_title();
            String author = list.get(i).getB_author();
            String price = list.get(i).getB_price();

            //이미지 경로를 가지고 있음
            String img = list.get(i).getB_img();
            Log.i("my",""+list.get(6).getB_img());
            Intent intent = new Intent(context,SubActivity.class);
            intent.putExtra("title",title);
            intent.putExtra("author",author);
            intent.putExtra("price",price);
            intent.putExtra("img",img);


            context.startActivity(intent);
        }
    };

    
    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        //myListView.setAdapter(adapter)를 하는 순간 호출되는 메서드
        //생성자의 파라미터를 받은 list의 사이즈만큼 getView()메서드가 알아서 반복 호출

        //position: 처음 1회전 할 때 포지션은 0부터 호출이 되서 100번이 돌면 포지션이 99가 된다.

        //xml파일을 View형태의 객체로 만들기
        //일반 액티비티에서는 LayoutInflater linf = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //가능하다. 하지만 일반클래스에서는 context가 필요하다.
        LayoutInflater linf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //convertView -> book_item.xml 짝궁이 없는 xml파일을 view형태로 변경
        convertView = linf.inflate(resource,null);

        vo = list.get(position);
        TextView title = convertView.findViewById(R.id.book_title);
        TextView author = convertView.findViewById(R.id.book_author);
        TextView price = convertView.findViewById(R.id.book_price);
        ImageView img = convertView.findViewById(R.id.book_img);

        title.setText(vo.getB_title());
        author.setText(vo.getB_author());
        price.setText(vo.getB_price()+"원");
        
        new ImgAsync(img,vo).execute();//doInBackground 호출
        
        return convertView;
    }

    class ImgAsync extends AsyncTask<Void, Void, Bitmap>{
        Bitmap bm;
        ImageView img;
        BookVO vo;

        public ImgAsync(ImageView img, BookVO vo) {
            this.img = img;
            this.vo = vo;
        }

        @Override
        protected Bitmap doInBackground(Void... voids) {
            try {
                //vo가 가지고 있는 vo.getB_img()를 통해
                //이미지 경로를 따라 들어가자.
                URL img_url = new URL(vo.getB_img());

                BufferedInputStream bis = new BufferedInputStream(img_url.openStream());
                //img_url을통해서 얻어온 이미지 경로가 있다.
                //InputStream을 통해서 데이터를 읽어올 수 있다.
                //bis가 이미지의 정보를 데이터 단위로 저장을 해놓는다.
                //그래서 바로 ImageView 형태로 넣을 수가 없다.
                //1바이트 단위데이터를 이미지 형태로 쓸 수 있도록 하는 클래스가 bitmap이다.

                //bis가 읽어온 데이터를 이미지로 변환하기 위해
                //bitmap 형태로 변경
                bm = BitmapFactory.decodeStream(bis);

                bis.close();

            } catch (Exception e) {

            }

            if(bm != null){
                return bm;
            }

            //불러올 이미지가 없을 때 기본이미지로 bitmap 설정
            Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.rabbit);

            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            //비트맵 객체를 ImageView로 전환
            img.setImageBitmap(bitmap);
        }
    }
}
