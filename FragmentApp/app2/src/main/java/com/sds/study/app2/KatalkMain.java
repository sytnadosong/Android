package com.sds.study.app2;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

/**
 * Created by student on 2016-11-16.
 */

public class KatalkMain extends Activity{
    Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.katalkmain_layout);
    }
    public void btnClick(View view){
        switch (view.getId()){
            case R.id.bt_a:
                fragment=new Fragment();
                transactional();
                ;
            case R.id.bt_b:
                fragment=new Fragment();
                transactional();
                ;
            case R.id.bt_c:
                fragment=new Fragment();
                transactional();
                ;
        }
    }

    public void transactional(){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
    }
}
