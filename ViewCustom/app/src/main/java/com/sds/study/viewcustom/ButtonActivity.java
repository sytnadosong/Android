package com.sds.study.viewcustom;

/**
 * Created by student on 2016-11-09.
 */

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

/*안드로이드에서 위젯을 생성하는 모든 방법을 다 동원해보자*/

public class ButtonActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.buttonactivity_layout);

        //자바코드에
        Button bt = new Button(this);
        bt.setText("자바코드에 의한 버튼");
        setLayoutParams(new ViewGroup.LayoutParams());

    }
}
