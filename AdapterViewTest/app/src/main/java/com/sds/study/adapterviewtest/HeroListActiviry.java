package com.sds.study.adapterviewtest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

/**
 * 오전에 자체 제작한 List와 안드로이드 api에서 지원하는
 * AdapterView 결정적 차이점?? 메모리 효율성이 극대화 됨.
 *
 */

public class HeroListActiviry extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ListView는 껍데기에 불과하므로, 적절한 어댑터를 사용해보자
        //ArrayAdapter는 단순히 TextView 하나로 구현시만 사용가능하므로,
        //개발자가 정의한 복합위젯은 사용이 불가능 하다.
        // 따라서 Adapter를 직접 재정의해서 구현해야 한다...Swing에서
        //TableModel을 상속받아 재정의 하는 것과 완전 동일...
        setContentView(R.layout.activity_list);

        //ListView listView = (ListView)findViewById(R.id.listView);
        GridView listView = (GridView) findViewById(R.id.listView);

        MyAdapter myAdapter = new MyAdapter(this);
        listView.setAdapter(myAdapter);//어댑터와 연결
    }
}
