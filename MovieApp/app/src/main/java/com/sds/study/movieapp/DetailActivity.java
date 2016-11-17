package com.sds.study.movieapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;

import android.widget.TextView;
import android.widget.VideoView;

/**
 * Created by student on 2016-11-14.
 */

public class DetailActivity extends Activity {
    VideoView videoView;
    MediaController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.detail_layout);

        videoView=(VideoView)findViewById(R.id.videoView);
        TextView txt_filename=(TextView)findViewById(R.id.txt_filename);

        controller= new MediaController(this);

        Intent intent=getIntent();
        //String filename=intent.getStringExtra("filename");parcelable 이후
        Movie movie=intent.getParcelableExtra("dto");
        txt_filename.setText(movie.getTitle());

        videoView.setMediaController(controller);
        //videoView.setVideoPath(filename); //재생할 경로 등록
        //videoView.start();
    }

    public void stop(View view){
        videoView.seekTo(0);//단위 밀리세컨드 , 5초 5000
        videoView.pause();
    }
    public void pause(View view){
        videoView.pause();
    }
    public void play(View view){
        videoView.start();
    }
}
