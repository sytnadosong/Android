package com.sds.study.galleryappencore;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
/*
개발자가 주도하여 뷰의 그림을 그려야 한다..
onDraw 메서드 재정의해야 한다.. javaSE 의 paint 와 비슷함
*/
public class MyView extends View {
    private Bitmap bitmap;

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    protected void onDraw(Canvas canvas) {
        if(bitmap!=null) {
            canvas.drawBitmap(bitmap, 0, 0, null);
        }
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}







