package com.example.student.musicapp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
    리스트에 보여질 복합 위젯을 정의 한다.
    장점) 마치 하나의 위젯처럼 재사용이 가능하다.
 */

public class MusicItem extends LinearLayout implements View.OnClickListener{
    Music music;
    boolean flag=true; //play
    ImageView img;

     public MusicItem(Context context, Music music) {
        super(context);
        this.music=music;
        init(context);
    }

    public MusicItem(Context context) {
        super(context);
        init(context);
    }
//자바 코드나 xml 모두를 염두해두고 준비시켜놓기 위해...
    //개발자 취향에 따라
    public void init(Context context){
        //이 클래스가 참조할 xml을 인플레이션 시키자
        LayoutInflater inflater= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        inflater.inflate(R.layout.music_item,this);

        //각 뷰의 알맞는 데이터 대입!!
        TextView txt_title=(TextView)findViewById(R.id.txt_title);
        TextView txt_artist=(TextView)findViewById(R.id.txt_artist);
        img=(ImageView)findViewById(R.id.img);

        txt_title.setText(music.getTitle());
        txt_artist.setText(music.getArtist());

        this.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        flag=!flag;
        if(!flag){
            img.setImageResource(R.drawable.stop);
        }else{
            img.setImageResource(R.drawable.play);
        }
    }
}
