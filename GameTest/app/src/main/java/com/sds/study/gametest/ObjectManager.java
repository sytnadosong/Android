package com.sds.study.gametest;

import android.graphics.Canvas;

import java.util.ArrayList;

/**
 * Created by student on 2016-11-15.
 */

public class ObjectManager {
    ArrayList<GameObject> list;

    public ObjectManager() {
        list = new ArrayList<GameObject>();
    }

    public void addObject(GameObject obj){
        list.add(obj);
    }
    public void removeObject(GameObject obj){
        list.remove(obj);
    }
    public void tick(){
        for(int i=0;i<list.size();i++){
            list.get(i).tick();
        }
    }
    public void render(Canvas canvas){
        for(int i=0;i<list.size();i++){
            list.get(i).render(canvas);
        }
    }

}
