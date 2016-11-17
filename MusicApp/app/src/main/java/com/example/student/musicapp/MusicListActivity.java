package com.example.student.musicapp;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.ListView;

import java.io.File;
import java.io.IOException;

/**
 * Created by student on 2016-11-11.
 */

public class MusicListActivity extends Activity{
    String TAG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG=this.getClass().getName();

        setContentView(R.layout.music_list);

        //리스트뷰와 어댑터와 연결
        ListView listView=(ListView)findViewById(R.id.listView);
        MusicAdapter adapter = new MusicAdapter(this);
        listView.setAdapter(adapter);
        //안드로이드의 일반 자원을 두는 곳중 raw,asset이라는
        //디렉토리가 있는데, raw안의 데이터는 R.java에 등록되므로
        // 상수취급 되고, asset는 그냥 일반 디렉토리로 간주



        /*/삭제AssetManager manager=this.getAssets();

        try {
            String dir[]=manager.list("/");
            Log.d(TAG, "dir은"+dir.length);

            for(int i=0;i<dir.length;i++){
                Log.d(TAG,dir[i]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }*/

        //스마트폰의 external storage에 놓아둔, 파일을 접근해보자
       //File dir=Environment.getExternalStorageDirectory();
    }
}
