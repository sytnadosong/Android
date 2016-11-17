package com.sds.study.threadapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * 자바의 그래픽 처리와 마찬가지로, 안드로이드에서
 * 그래픽의 주체는 컴포넌트 즉 뷰이다!!
 * 따라서 개발자가 그래픽을 재정의하려면, 뷰를 상속받아
 * 뷰가 보유한 메서드 중 onDraw() 메서드를 재정의하면 된다..
 */

public class MyView extends View{
    Paint paint;
    RectF rectf;
    int x=0;
    int y=0;
    int left=100;
    int bottom=100;


    public MyView(Context context) {
        super(context);
        init();
    }

    public void init(){
        //rectf=new RectF(0,0,100,100);
        this.setBackgroundColor(Color.YELLOW);
        paint = new Paint();
        paint.setColor(Color.RED);
    }

    //xml에서 호출할 것을 대비해서 한 것 뿐이다..
    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    //Canvas가 우리가 알던 자바의 Graphics 역할과 비슷
    @Override
    protected void onDraw(Canvas canvas) {
        rectf = new RectF(x,y,left+x,bottom+y);//canvas.drawOval(0,0,100,100);
        canvas.drawOval(rectf,paint);
    }

}
