package com.sds.study.viewcustom;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 리니어 생성
        LinearLayout layout = new LinearLayout(this);//this 의 의미는 context?
        LinearLayout.LayoutParams layoutParams=null;
        layoutParams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        layout.setBackgroundColor(Color.YELLOW);
        layout.setLayoutParams(layoutParams);

        //버튼 생성하여 붙이자!!
        MyButton bt = new MyButton(this);
        bt.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.addView(bt);

        //setContentView(R.layout.activity_main);
    }
}
