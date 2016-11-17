package com.sds.study.threadapp;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Runnable{
    String TAG;
    int count;
    Thread thread;
    TextView txt_count;

    //안드로이드에서는 개발자가 정의한 쓰레드 즉 메인쓰레드 아닌 자가 UI를 제어할 수 없다.
    //해결책-Handler에 의한 간접 제어방식을 허용한다.
    //          개발자가 정의한 쓰레드로 UI를 제어하고 싶다면
    //          Handler에 예약하면 된다.
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG=this.getClass().getName();

        setContentView(R.layout.activity_main);
        txt_count=(TextView)findViewById(R.id.txt_count);
        handler =new Handler(){
            //핸들러에게 다른 객체가 업무처리를 부탁하면, 아래의 메서드가 동작하게 된다.
            // 우리의 경우UI처리를 여기서 하면 된다.
            public void handleMessage(Message msg) {
                count++;//방법3
                txt_count.setText(Integer.toString(count));//3
            }
        };
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //2count++;
            //2txt_count.setText(Integer.toString(count));

            //1Log.d(TAG,"count:"+count++);
            handler.sendEmptyMessage(0);//이 메서드에 의해
            // Handler의 handleMessage가 동작하게 된다.
        }
    }

    public void btnClick(View view){
        thread = new Thread(this);
        thread.start();
    }
}
