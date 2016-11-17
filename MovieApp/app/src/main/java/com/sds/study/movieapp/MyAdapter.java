package com.sds.study.movieapp;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * ListView를 이루는 아이템이 복잡하거나, 안드로이드 자체에서 지원하지 않을 경우엔
 * 개발자가 직접 어댑터를 재정의해야 한다
 */

public class MyAdapter extends BaseAdapter{
    String TAG;
    Context context;
    ArrayList<Movie> list= new ArrayList<Movie>();

    //getCount 등이 호출되기 전에 이미 데이터를 처리해놓아야 한다.
    public MyAdapter(Context context) {
        this.context=context;
        TAG=this.getClass().getName();

        AssetManager assetManager = context.getAssets();
        BufferedReader buffr =null;
        StringBuffer sb = new StringBuffer();

        try {
            InputStream is = assetManager.open("movie.json");
            buffr=new BufferedReader(new InputStreamReader(is));
            String data=null;
            while(true){
                data=buffr.readLine();
                if(data==null)break;
                sb.append(data);
            }
            //파싱시작!!
            try {
                JSONObject jsonObject=new JSONObject(sb.toString());
                JSONArray jsonArray=jsonObject.getJSONArray("movieList");

                for(int i=0;i<jsonArray.length();i++){
                    JSONObject obj=jsonArray.getJSONObject(i);
                    Movie movie = new Movie();
                    movie.setTitle(obj.getString("title"));
                    movie.setRegdate(obj.getString("regdate"));
                    movie.setImg(obj.getString("img"));

                    list.add(movie);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
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

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    //선택한 아이템의 유일성을 확보해야 할때,
    //웹연동시 사용
    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View view=null;
        Log.d(TAG, i+"번째 뷰는 "+convertView);
        //최초에 아무것도 없이 비워져 있는 상태라면..
        Movie movie = list.get(i);
        if(convertView==null){
            MovieItem item=new MovieItem(context);
            item.setData(movie);
            view=item;
        }else{// 이미 채워진 경우라면, 같은 뷰로 대체
            MovieItem item=(MovieItem)convertView;
            item.setData(movie);
            view=convertView;
        }
        /*Movie movie = list.get(i);
        MovieItem movieItem= new MovieItem(context, movie);
        return movieItem;*/
        return view;
    }
}
