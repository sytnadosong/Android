package com.sds.study.gametest;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by student on 2016-11-15.
 */

public class GameView extends View implements Runnable{
    Thread thread;
    ObjectManager objectManager;
    Handler handler;

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);

        handler = new Handler(){
            public void handleMessage(Message msg) {
                tick();
                invalidate();
            }
        };

        gameStart();
    }

    public void gameStart(){
        if(thread != null){
            return;
        }
        thread = new Thread(this);
        thread.start();

        objectManager = new ObjectManager();
        createPlayer();
    }

    public void createPlayer(){
        Player player = new Player(objectManager, ObjectId.Player, 0,0,100,60);
        objectManager.addObject(player);
    }

    public void tick(){
        objectManager.tick();
    }
    public void render(Canvas canvas){
        objectManager.render(canvas);
    }

    protected void onDraw(Canvas canvas) {
        render(canvas);
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            handler.sendEmptyMessage(0);
        }
    }
}
