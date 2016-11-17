package com.sds.study.viewcustom;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridLayout;
import android.widget.RelativeLayout;

/**
 * 히어로 한세트(복합위젯)를 xml로 정의해놓고
 * 해당 xml을 읽어들여 반복문 돌려보자
 */

public class HeroActivity extends Activity {

    int[] photo={
       R.drawable.img1,
               R.drawable.img1,
               R.drawable.img1,
            R.drawable.img1,

    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //setContentView는 하나의 화면 전체를 차지하게 되므로,
        //히어로 하나만 생성하는 목적으로는 적당하지 않음....

        //개발자가 특정 xml을 로드하는 코드를 작성해야 한다.
        //xml에 명시한 태그를 실제 안드로이드 객체화 시켜
        // 메모리에 올리는 과정을 inflation이라 한다.
        LayoutInflater inflater = this.getSystemService(LAYOUT_INFLATER_SERVICE)


        /*그리드 레이아웃 안에 원하는 갯수만큼 반복문 돌려서 추가한다. 아래에서 해야함*/
        //setContentView에는 내부적으로 inflation이 일어남..
        setContentView(R.layout.gallery_layout);

        /*그리드 레이아웃 안에 원하는 갯수만큼 반복문 돌려서 추가한다.*/
        GridLayout grid = (GridLayout) findViewById(R.id.name);

        }

    }
}
