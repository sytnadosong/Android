package com.sds.study.viewcustom;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Button;

/**
 * Created by student on 2016-11-09.
 */

public class MyButton2ndTest extends Button{
    String TAG;
    public MyButton2ndTest(Context context) {
        super(context);
        TAG=this.getClass().getName();
        this.setText("내가 정의한 버튼");
        Log.d("MyButton","인수 1개짜리 생성자 호출!!");
    }

    //xml을 이용하여 위젯을 메모리에 올릴때는 반드시
    //AttributeSet을 인수로 갖는 생성자를 정의해야 한다.
    public MyButton2ndTest(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.d(TAG,"인수 두개짜리 생성자 호출!!");
    }
}
