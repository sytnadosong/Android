package com.sds.study.activitystudy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by student on 2016-11-09.
 */

public class RedActivity extends Activity {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.red_layout);
        //intent에 심어진 데이터를 끄집어 내기!
        intent = getIntent(); //나에게 전달된 인텐트 얻기
        String data=intent.getStringExtra("data");

        TextView txt=(TextView)findViewById(R.id.txt);
        txt.setText(data);
    }
    public void btnClick(View view){
        Toast.makeText(this,"나눌렀어?",Toast.LENGTH_SHORT).show();
        this.finish();
    }

}
