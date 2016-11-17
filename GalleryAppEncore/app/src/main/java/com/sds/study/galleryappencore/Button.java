package com.sds.study.galleryappencore;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by student on 2016-11-16.
 */

public class Button extends GameObject{
    public Button(int x, int y, int width, int height, Bitmap bitmap) {
        super(x, y, width, height, bitmap);
    }
    public void tick(){

    }
    public void render(Canvas canvas){
        canvas.drawBitmap(bitmap,x,y,null);
    }
}
