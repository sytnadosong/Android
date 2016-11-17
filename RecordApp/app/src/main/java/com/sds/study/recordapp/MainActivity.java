package com.sds.study.recordapp;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager=(ViewPager)findViewById(R.id.viewPager);
        myAdapter = new MyAdapter(getSupportFragmentManager());
        viewPager.setAdapter(myAdapter);
    }

    public void btnClick(View view){
        switch(view.getId()){
            case R.id.A:viewPager.setCurrentItem(0,true);break;
            case R.id.B:viewPager.setCurrentItem(1,true);break;
            case R.id.C:viewPager.setCurrentItem(2,false);break;
        }
    }

}
