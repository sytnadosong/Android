package com.sds.study.adapterviewtest.data;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.sds.study.adapterviewtest.R;

/**
 * Created by student on 2016-11-10.
 */

public class ActivityB extends Activity {
    EditText send_msg;
    EditText receive_msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b_layout);

        Intent intent=getIntent();
        String data = (String) intent.getStringExtra("data");

        EditText receive_msg=(EditText) findViewById(R.id.receive_msg);
        send_msg=(EditText) findViewById(R.id.send_msg);
        receive_msg.setText(data);

        System.out.println("넘겨 받은 데이터는"+data);
    }

    //다시 A로 메세지를 보내자..
    public void btnClick(View view){
        //Intent intent= new Intent(this, ActivityA.class); 3개의 화면이 구성됨..따라서 불가능한 방법
        Intent intent = new Intent();
        intent.putExtra("data", receive_msg.getText().toString());
        setResult(2016,intent);
        finish();
    }
}
