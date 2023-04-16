package com.example.myapplication.ui.home.search;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.DB.DBConnect;
import com.example.myapplication.Global;
import com.example.myapplication.R;
import com.example.myapplication.ui.wenwuList.Wenwu;
import com.example.myapplication.ui.wenwuList.WenwuAdapter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class search extends AppCompatActivity {
    private List<Wenwu> wenwuList=new ArrayList<>();
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private WenwuAdapter mWenwuAdapter;
    private AutoCompleteTextView et;
    private Context con;
    private String word=new String("");
    private Button btn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_page);
        init();
        Intent intent=getIntent();
        et.setText(intent.getStringExtra("word"));
        word=et.getText().toString().trim();
        layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        initWenWuList();
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                initWenWuList();
            }
        });
    }
    private void init(){
        et=(AutoCompleteTextView) findViewById(R.id.search_input);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(search.this,android.R.layout.simple_dropdown_item_1line, Global.getWenWuNames());
        et.setAdapter(adapter);
        con=this;
        recyclerView=(RecyclerView)findViewById(R.id.search_recycle);
        btn=(Button)findViewById(R.id.search_btn_search_page);
    }
    public void initWenWuList(){
        word=et.getText().toString().trim();
        wenwuList.clear();
        new Thread(new Runnable(){
            @Override
            public void run(){
                try {
                    Connection cn = DBConnect.GetConnection();
                    String sql = "select * from wenwu where wname like '%"+word+"%'";
                    Log.v("test",sql);
                    Statement st = cn.createStatement();
                    Log.v("test",sql);
                    ResultSet rs=st.executeQuery(sql);
                    Log.v("test",sql);
                    while(rs.next()){
                        Wenwu wenwu=new Wenwu(rs.getString("wname"),rs.getString("visnum"),rs.getString("id"),rs.getString("website"));
                        wenwuList.add(wenwu);
                    }
                    myhandler.sendEmptyMessage(1);
                    st.close();
                    cn.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }).start();
    };

    private Handler myhandler = new Handler(){
        public void handleMessage(Message msg){
            switch(msg.what){
                case 1:
                    mWenwuAdapter=new WenwuAdapter(con,wenwuList);
                    Log.v("test","1");
                    recyclerView.setAdapter(mWenwuAdapter);
                    Log.v("test","1");
                    break;
                case 0:
                    break;
            }
        }
    };
}
