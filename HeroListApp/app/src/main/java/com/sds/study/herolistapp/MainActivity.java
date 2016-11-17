package com.sds.study.herolistapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    String[] arr_name={
            "배트맨1",
            "캡틴아메리카2",
            "데드풀3",
            "플래시맨4",
            "아이언맨5",
            "헐크6",
            "후레쉬맨7",
            "우뢰매8",
            "홍길동9",
            "일지매0"
    };

    String[] arr_phone={
            "010-3259-1234",
            "010-3259-2234",
            "010-3259-3234",
            "010-3259-4234",
            "010-3259-5234",
            "010-3259-6234",
            "010-3259-7234",
            "010-3259-8234",
            "010-3259-9234",
            "010-3259-0234"
    };

    int[] thumb={
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6,
            R.drawable.img7,
            R.drawable.img8,
            R.drawable.img9,
            R.drawable.img10
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.hero_list);

        //layout을 얻어와서, 동적으로 아이템들을 채워넣자
        LinearLayout layout=(LinearLayout)findViewById(R.id.layout);

        //item xml을 인플레이션 시켜서 자식으로 등록!!
        LayoutInflater inflater=null;

        inflater=(LayoutInflater)this.getSystemService(LAYOUT_INFLATER_SERVICE);

        for(int i=0;i<10;i++){
            /*LinearLayout itemLayout=(LinearLayout) inflater.inflate(R.layout.hero_item, null);//최상단의 layout 객체를 가리켜야 하나 아직 메모리에 올라오지 않아서 null로 둠. 오늘의 수업 주제이기도 함.
            layout.addView(itemLayout);

            TextView txt_name=(TextView)itemLayout.findViewById(R.id.txt_name);
            TextView txt_phone=(TextView)itemLayout.findViewById(R.id.txt_phone);
            ImageView img=(ImageView)itemLayout.findViewById(R.id.img);

            txt_name.setText(arr_name[i]);
            txt_phone.setText(arr_phone[i]);
            img.setI(thumb[i]);

            itemLayout.setOnClickListener(this);//리스너와 연결*/

            //데이터 생성
            Hero hero = new Hero();
            hero.setName(arr_name[i]);
            hero.setPhone(arr_phone[i]);
            hero.setImg(thumb[i]);

            //복합위젯 생성
            HeroItem item=new HeroItem(this,hero);
            layout.addView(item);

            item.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(this,"히어로이름",Toast.LENGTH_SHORT).show();
    }
}
