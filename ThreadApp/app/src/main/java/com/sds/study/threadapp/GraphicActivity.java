package com.sds.study.threadapp;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by student on 2016-11-15.
 */

public class GraphicActivity extends Activity{
    MyView myView;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myView=new MyView(this);
        //전체레이아웃=LinearLayout
        LinearLayout layout=new LinearLayout(this);
        layout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        layout.setOrientation(LinearLayout.VERTICAL);

        //버튼 생성하고
        Button bt = new Button(this);
        bt.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        bt.setText("동작하기");

        //핸들러의 메서드는 메인 쓰레드에 의해 동작한다.
        //따라서 UI제어가 가능하다.
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                //빨간 사각형을 움직여보자.
                myView.x+=2;
                myView.y+=2;
                myView.invalidate();//자바 그래픽의  repaint와 비슷
            }
        };

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                move();
            }
        });

        layout.addView(bt);
        layout.addView(myView);

        setContentView(layout);
    }

    public void move(){
        Thread thread = new Thread(){
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    handler.sendEmptyMessage(0);
                }
            }
        };
        thread.start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Toast.makeText(this,"나 건드렸어?",Toast.LENGTH_SHORT).show();

        /*
        //빨간 사각형을 움직여보자.
        myView.x+=50;
        myView.y+=50;
        myView.invalidate();//자바 그래픽의  repaint와 비슷*/
        return super.onTouchEvent(event);

    }

}
