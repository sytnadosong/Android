package com.sds.study.galleryapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity implements Runnable{
    String TAG;
    static final int REQUEST_READ_PERMISSION=1;
    Bitmap[] bitmaps;
    MyView myView;
    int current;
    Thread thread;
    Handler handler;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TAG=this.getClass().getName();
        setContentView(R.layout.activity_main);
        myView = (MyView)findViewById(R.id.myView);

        handler = new Handler(){
            public void handleMessage(Message msg) {
                current++;

                if(current > bitmaps.length-1){
                    current=0;
                }
                showImg();
            }
        };

        int readPermission=ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        if(readPermission == PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.READ_EXTERNAL_STORAGE
            }, REQUEST_READ_PERMISSION);
        }else{
            readFile();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case REQUEST_READ_PERMISSION :
                if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_DENIED){
                    Toast.makeText(this,"권한을 허락해야 사용가능합니다", Toast.LENGTH_SHORT).show();
                }
        }
    }

    public void readFile(){
        File dir=Environment.getExternalStorageDirectory();
        File file = new File(dir, "iot_images");
        File[] images=file.listFiles();
        bitmaps = new Bitmap[images.length];

        for(int i=0;i<images.length;i++){
            //Log.d(TAG, images[i].getAbsolutePath());
            bitmaps[i]= BitmapFactory.decodeFile( images[i].getAbsolutePath());
            //bitmaps[i].set

            Log.d(TAG, "bitmaps["+i+"] = "+bitmaps[i]);
        }

        myView.setBitmap(bitmaps[current]);
        myView.invalidate();
    }

    public void prev(View view){
        current--;
        showImg();
    }
    public void auto(View view){
        thread = new Thread(this);
        thread.start();
    }
    public void next(View view){
        current++;
        showImg();
    }
    public void showImg(){
        Bitmap bitmap=bitmaps[current];
        myView.setBitmap(bitmap);
        myView.invalidate();
    }
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            handler.sendEmptyMessage(0);
        }
    }
}
