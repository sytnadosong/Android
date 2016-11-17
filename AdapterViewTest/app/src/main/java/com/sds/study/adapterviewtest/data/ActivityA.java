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

public class ActivityA extends Activity {
    EditText receive_msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_layout);
    }
    public void btnClick(View view){
        //안드로이드의 4대 컴포넌트는 개발자가 생성할 수 없으므로
        //시스템에게 요청해야 한다. 이때 요청 행위는 인텐트라는 객체로 해야 한다.
        Intent intent = new Intent(this, ActivityB.class);

        //데이터를 심어서 가지고 가자!!

        //입력한 데이터
        EditText send_msg=(EditText)findViewById(R.id.send_msg);
        receive_msg=(EditText)findViewById(R.id.receive_msg);

        intent.putExtra("data", send_msg.getText().toString());

        //다른 액티비티 호출시 그 결과를 다시 받아올 경우엔

        startActivityForResult(intent, 2016);
        //startActivityForResult(intent);
    }

    // 호출한 액티비티가 응답할 경우 아래의 메서드가 호출
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==2016 && resultCode==Activity.RESULT_OK){
            String result = data.getStringExtra("data");
            receive_msg.setText(result);
        }
    }
}
