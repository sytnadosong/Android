package com.sds.study.movieapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    String TAG;
    static final int READ_REQUEST=1;

    //보여질 데이터가 단일 text일때 적절..
    //단, 복합위젯의 경우엔 우리가 재정의
    //ArrayAdapter<String> adapter;
    MyAdapter adapter;
    ListView listView;
    File dir;//타겟 디렉토리!!

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG=this.getClass().getName();
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.listView);
        //안드로이드의 외부 저장소에 접근해보자!!
        //각 디바이스의 종류에 따라 각각 경로가 틀리므로, 아래와 같은 코드가 유용하다.

        //현재 앱에 권한이 있는지부터 체크해본다
        int readPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        Log.d(TAG,"readPermission is "+readPermission);//값이 0이면 권한이 있는 것이다.

        if(readPermission== PackageManager.PERMISSION_DENIED){
            getInfo();
        }else{//권한이 없다면 유저에게 조른다..
            ActivityCompat.requestPermissions(this,
                    new String[]{
                            Manifest.permission.READ_EXTERNAL_STORAGE
                    },READ_REQUEST);
        }
    }

    //사용자의 권한 처리 여부를 피드백 받기  위한 메서드 재정의


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(requestCode){
            case READ_REQUEST:
                if(grantResults.length>0
                        &&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this,"권한 수락!!", Toast.LENGTH_SHORT).show();
                    getInfo();
                }else{
                    Toast.makeText(this,"권한 거부!!", Toast.LENGTH_SHORT).show();
                }
        }
    }

    //권한이 있을 때만 하위 디렉토리에 대한 접근을 시도하자
    //마쉬멜로 버전부터 권한 정책이 바뀌어 버렸다.
    public void getInfo(){
        dir= new File(Environment.getExternalStorageDirectory(), "iot_movie");
        Log.d(TAG,"외부저장소 루트 경로는"+dir.getAbsolutePath());
        File[] sub=dir.listFiles(); //하위의 디렉토리 및 파일을 배열로 반환

        //ArrayList<String> list = (ArrayList) Arrays.asList(sub); 왜 안됐는지 듣기 s2 첫번째 파일161114
        ArrayList<String> list= new ArrayList<String>();
        for(int i=0;i<sub.length;i++){
                 list.add(sub[i].getName());//디렉토리명만...
        }

        //adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
        adapter=new MyAdapter(this);
        /*for(int i=0; i<sub.length;i++){
            Log.d(TAG, sub[i].getAbsolutePath());
        }*/
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int index, long l) {
        /*//선택한 위젯..
        TextView txt=(TextView) view;
        Toast.makeText(this, index+"번째 파일명은 "+txt.getText(), Toast.LENGTH_SHORT).show();

        //상세 액티비티 호출!!
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("filename",dir.getAbsolutePath()+"/"+txt.getText());
        startActivity(intent);*/

        // 선택한 아이템으로부터 매칭되는 dto를 추출해본다.
        //dto 담은 후 Intent 전달해본다
        //일반적으로 Intent에는 기본형 데이터와 래퍼클래스만을
        //담을 수 있을 거 같지만, 일반 클래스의 인스턴스도 담을 수 있다..
        // 단, 그 클래스는 Parceable 인터페이스를 구현해야 한다.
        TextView txt_title=(TextView) view.findViewById(R.id.txt_title);
        TextView txt_regdate=(TextView) view.findViewById(R.id.txt_regdate);

        Movie movie=new Movie();
        movie.setTitle(txt_title.getText().toString());
        movie.setRegdate(txt_regdate.getText().toString());

        Intent intent=new Intent(this,DetailActivity.class);
        intent.putExtra("dto",movie);
        startActivity(intent);
    }
}
