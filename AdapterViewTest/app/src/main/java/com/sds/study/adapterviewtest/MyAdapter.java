package com.sds.study.adapterviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by student on 2016-11-10.
 */

public class MyAdapter extends BaseAdapter {
    Context context;

    String[] arr={
            "사과","딸기","바나나","4","5","6","7","8"
    };

    String[] arr_phone={
            "111","222","333","444","555","666","777","888"
    };
    int[] photo={
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

    public MyAdapter(Context context) {
        this.context = context;
    }

    //총 아이템 갯수
    public int getCount() {
        return arr.length;
    }


    public Object getItem(int i) {
        return null;
    }

    //오라클에서 시퀀스 값과 일치 시킴
    public long getItemId(int i) {
        return 0;
    }

    //선택한 위치의 view를 반환
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        /*Button bt=new Button(context);
        bt.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));

        bt.setText(arr[i]);

        return bt;*/

        //복합위젯을 인플레이션하여, 반환해준다.

        LayoutInflater inflater = null;
        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        LinearLayout itemLayout = (LinearLayout) inflater.inflate(R.layout.hero_item,null);
        TextView txt_name=(TextView) itemLayout.findViewById(R.id.txt_name);
        TextView txt_phone=(TextView)itemLayout.findViewById(R.id.txt_phone);
        ImageView img=(ImageView)itemLayout.findViewById(R.id.img);

        txt_name.setText(arr[i]);
        txt_phone.setText(arr_phone[i]);
        img.setImageResource(photo[i]);

        return itemLayout;
    }
}
