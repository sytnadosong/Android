package com.sds.study.relativeapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by student on 2016-11-08.
 */

public class LoginActivity extends Activity{
    /*LinearLayout layout;
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);

        //setContentView(뷰넣으면됨);
        layout= new LinearLayout(this);

        LinearLayout.LayoutParams params=null;
        params= new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        layout.setOrientation(LinearLayout.VERTICAL);

        layout.setLayoutParams(params);

        TextView tv = new TextView(this);
        ViewGroup.LayoutParams tv_params =null;
        tv_params=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT
                ,ViewGroup.LayoutParams.WRAP_CONTENT);
        tv.setLayoutParams();
        tv.setText("로그인");


        Button bt = new Button(this);
        ViewGroup.LayoutParams bt_params=null;
        bt_params=new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        bt.setLayoutParams(bt_params);//파라미터 적용!!
        bt.setText("나버튼");


    }*/
    TextView txt;
    LinearLayout outer; //가장 바깥쪽
    LinearLayout inner; // 안쪽
    EditText edit;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //로그인 제목
        txt = new TextView(this);
        txt.setText("로그인");
        ViewGroup.LayoutParams txtParams=null;
        txtParams = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        txt.setGravity(Gravity.CENTER_HORIZONTAL);
        txt.setTextSize(30);
        txt.setLayoutParams(txtParams);


    }
}
