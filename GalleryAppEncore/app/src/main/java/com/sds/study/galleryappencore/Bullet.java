package com.sds.study.galleryappencore;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.os.Environment;
import android.util.Log;

import java.io.File;

/**
 * Created by student on 2016-11-16.
 */

public class Bullet extends GameObject{

    public Bullet(int x, int y, int widht, int height, Bitmap bitmap) {
        super(x, y, widht, height, bitmap);
        velX=5;
    }

    @Override
    public void tick() {
        x+=velX;
    }

    @Override
    public void render(Canvas canvas) {
        rect.set(x,y,x+width,y+height);
        canvas.drawBitmap(bitmap,x,y,null);
        /*canvas.drawOval(rect, paint);*/
    }
}
