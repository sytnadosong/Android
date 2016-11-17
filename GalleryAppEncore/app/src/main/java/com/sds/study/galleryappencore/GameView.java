package com.sds.study.galleryappencore;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.Random;

/*
  화면을 가득 채우고 원하는 그래픽 처리를 하게 될 뷰 재정의
*/

public class GameView extends View implements Runnable{
    String TAG;
    ObjectManager objectManager;
    Thread thread;
    Handler handler;//동생쓰레드가 UI를 제어할 수 있도록
    int[] color={Color.GREEN,Color.BLACK,Color.BLUE,Color.CYAN};
    Bitmap[] bitmaps=new Bitmap[3];
    public GameView(Context context) {
        super(context);
        TAG=this.getClass().getName();

        this.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        this.setBackgroundColor(Color.YELLOW);
        init();
        //총알로 사용될 이미지를 준비해놓자
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize=4;
        Bitmap temp= BitmapFactory.decodeResource(getResources(),R.drawable.bullet,options);
        bitmaps[0]=Bitmap.createBitmap(temp,0,0,50,50);

        /*총알발사 버튼 등장*/

        bitmaps[1]=BitmapFactory.decodeResource(getResources(),R.drawable.button);
        Button btn=new Button(1000,700,50,50,bitmaps[1]);
        objectManager.addObject(btn);
    }

    //게임 시작 직전에 해줘야 할 업무를 여기서 처리하자
    public void init(){
        handler=new Handler(){
            //메인쓰레드에 의해 아래의 메서드가 호출되므로, 결국 UI제어가 가능하다..
            public void handleMessage(Message msg) {
                //모든 오브젝트의 tick,render
                tick();//objectManager.tick();
                invalidate();
            }
        };
        thread=new Thread(this);
        thread.start();

        objectManager=new ObjectManager();


    }

    public void tick(){
        objectManager.tick();
    }



    @Override
    protected void onDraw(Canvas canvas) {
       objectManager.render(canvas);
        /*if(bullet!=null) {
            bullet.render(canvas); //총알 스스로 그릴것이다...
        }*/
    }

    public boolean onTouchEvent(MotionEvent event) {
        /* 게임 오브젝트 생성하여 동작시키자!*/
        Random random = new Random();
        int r=random.nextInt(color.length);

        Bullet bullet = new Bullet(0,200,50,50,bitmaps[0]);//0,200,50,50,color[r]);
        objectManager.addObject(bullet);//등록
        //this.invalidate();

        /*화면을 터치한 좌표 얻어오기*/
        float posX=event.getX();
        float posY=event.getY();
        Toast.makeText(getContext(),"x:"+posX+",y:"+posY,Toast.LENGTH_SHORT).show();

        return true;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //모든 게임 오브젝트들의 tick(), render() : 그런데 render는 ui를 움직이므로 금기시됨
            handler.sendEmptyMessage(0);
        }

    }
}
