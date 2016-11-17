package com.sds.study.galleryapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by student on 2016-11-15.
 */

public class MyView extends View {
    Paint paint;
    private Bitmap bitmap;

    public MyView(Context context) {
        super(context);
        init();
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void init(){
        paint = new Paint();
    }

    @Override
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










