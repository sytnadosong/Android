package com.sds.study.gametest;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * Created by student on 2016-11-15.
 */

public class Player extends GameObject{
    Paint paint;

    public Player(ObjectManager objectManager, ObjectId objectId, int x, int y, int width, int height) {
        super(objectManager, objectId, x, y, width, height);
        paint= new Paint();
        paint.setColor(Color.RED);
    }

    @Override
    public void tick() {
        velX+=5;
        velY+=5;

        this.x+=velX;
        this.y+=velY;
    }

    @Override
    public void render(Canvas canvas) {
        rect.set(x,y, width+x, height+y);
        canvas.drawOval(rect, paint);
    }

}
