package com.example.student.musicapp;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class MusicAdapter extends BaseAdapter{
    Context context;//MusicListActivity를 넘겨받고자 함.
    String TAG;
    ArrayList<Music> list = new ArrayList<Music>();

    public MusicAdapter(Context context) {
        this.context = context;
        TAG=this.getClass().getName();

        //제이슨 가져오기
        AssetManager assetManager=context.getAssets();
        BufferedReader buffr=null;
        try {
            InputStream is=assetManager.open("music.data1");
            //스트림 버퍼단계까지 업그레이드
            buffr = new BufferedReader(new InputStreamReader(is));
            String data=null;

            //파싱하기 위한 데이터를 모으자
            StringBuffer sb= new StringBuffer();//String은 콘스탄트 풀이 꽉참

            while(true){
                data=buffr.readLine();
                if(data==null)break;
                sb.append(data);
                Log.d(TAG,data);
            }

            //제이슨 완성시점!!

            JSONObject jsonObject = new JSONObject(sb.toString());
            JSONArray jsonArray=jsonObject.getJSONArray("musicList");

            for(int i=0;i<jsonArray.length();i++){
                JSONObject obj=(JSONObject)jsonArray.get(i);
                Music music = new Music();
                music.setTitle(obj.getString("title"));
                music.setArtist(obj.getString("artist"));
                music.setFilename(obj.getString("filename"));
                list.add(music);

            }
        }catch (IOException e) {
            e.printStackTrace();
        }catch (JSONException e) {
            e.printStackTrace();
        }finally {
            if(buffr!=null){
                try {
                    buffr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //아이템 갯수
    public int getCount() {
        return list.size();//가정한 것임.
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    /*각 index에 보여질 뷰(버튼, 각종 뷰 .. but 복합위젯이 대부분)*/
    public View getView(int i, View view, ViewGroup viewGroup) {
        Music music = list.get(i);


        MusicItem item= new MusicItem(context,music);
        return item;
    }
}
