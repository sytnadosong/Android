package com.sds.study.fragmentapp.katalk;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.sds.study.fragmentapp.R;

/**
 * Created by student on 2016-11-16.
 */

public class KatalkMain extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.Katalkmain_layout);
    }
    public void btnClick(View view){
        switch (view.getId()){
            case R.id.bt_a:;
            case R.id.bt_b:;
            case R.id.bt_c:;
        }
    }
}
