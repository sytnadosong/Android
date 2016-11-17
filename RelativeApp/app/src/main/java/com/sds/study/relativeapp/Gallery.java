package com.sds.study.relativeapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static android.R.attr.onClick;

/**
 * Created by student on 2016-11-08.
 */

//Activity란 화면 관리자 이다..(화면 Controller
public class Gallery extends Activity {
    Button bt_prev,bt_next;
    //서블릿의 init이 클래스의 초기화를 담당한다면,
    //안드로이드에서의 클래스 초기화는 onCreate 메서드가 담당..

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lineargallery2);

        //버튼과 리스너와 연결!!
        bt_prev=(Button)this.findViewById(R.id.bt_prev);
        bt_next=(Button)this.findViewById(R.id.bt_prev);

        bt_prev.setOnClickListener(this);
        bt_next.setOnClickListener(this);
    }


}
