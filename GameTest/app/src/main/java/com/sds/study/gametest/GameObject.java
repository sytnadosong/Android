package com.sds.study.gametest;

import android.graphics.Canvas;
import android.graphics.RectF;

/**
 * Created by student on 2016-11-15.
 */

public abstract class GameObject {
    ObjectManager objectManager;
    ObjectId objectId;
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected int velX;
    protected int velY;
    protected  RectF rect;

    public GameObject(ObjectManager objectManager, ObjectId objectId, int x, int y, int width, int height) {
        this.objectManager = objectManager;
        this.objectId = objectId;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        rect = new RectF(x,y, width+x, height+y);
    }

    public abstract void tick();

    public abstract void render(Canvas canvas);

    public ObjectManager getObjectManager() {
        return objectManager;
    }

    public void setObjectManager(ObjectManager objectManager) {
        this.objectManager = objectManager;
    }

    public ObjectId getObjectId() {
        return objectId;
    }

    public void setObjectId(ObjectId objectId) {
        this.objectId = objectId;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getVelX() {
        return velX;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public int getVelY() {
        return velY;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }

    public RectF getRect() {
        return rect;
    }

    public void setRect(RectF rect) {
        this.rect = rect;
    }
}
