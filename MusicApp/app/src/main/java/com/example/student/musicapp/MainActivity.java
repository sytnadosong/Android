package com.example.student.musicapp;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.IOException;
import java.net.URI;

public class MainActivity extends AppCompatActivity {
    String TAG;
    //음악, 영상 등의 미디어를 재생하려면 MediaPlayer 객체를 사용
    MediaPlayer mediaPlayer;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TAG=this.getClass().getName();

        setContentView(R.layout.activity_main);
    }

    public void btnClick(View view){

        if(view.getId()==R.id.bt_play){
            Log.d(TAG,"재생시작");
            //음원을 결정하자
            // Uri선언, Uri란? 자원의 위치정보를 가진 객체로서, 특정 자원을 접근하려면 일정한 정해진 형식을 알아야 한다..
            // ex) 인터넷상의 자원  url=>         http://서버주소/디렉토리

            Uri uri= Uri.parse("android.resource://com.example.student.musicapp/");
            try {
                if(mediaPlayer==null){//stop에 의해 null로 된 경우만
                    mediaPlayer = new MediaPlayer();
                    mediaPlayer.setDataSource(this, uri);
                    mediaPlayer.prepare();
                }
                mediaPlayer.start();//재생
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else if(view.getId()==R.id.bt_pause){
            Log.d(TAG,"잠시멈춥니다.");
            if(mediaPlayer!= null) {
                mediaPlayer.pause();
            }
        }else if(view.getId()==R.id.bt_stop){
            Log.d(TAG,"재생종료");
            if(mediaPlayer!=null){
                mediaPlayer.stop();
                mediaPlayer=null;
            }
        }
    }

   /* public void pause(View view){

    }

    public void stop(View view){

    }*/
}
