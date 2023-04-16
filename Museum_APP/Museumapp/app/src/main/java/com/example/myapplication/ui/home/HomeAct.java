package com.example.myapplication.ui.home;

import android.app.Activity;
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
import android.widget.TextView;

import com.example.myapplication.DB.DBConnect;
import com.example.myapplication.Global;
import com.example.myapplication.R;
import com.example.myapplication.ui.daohang.daoHangFra;
import com.example.myapplication.ui.home.search.search;
import com.example.myapplication.ui.login.LoginAct;
import com.example.myapplication.ui.userMainPage.userMainPageAct;
import com.example.myapplication.ui.wenwuList.Wenwu;
import com.example.myapplication.ui.wenwuList.WenwuAdapter;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HomeAct extends Activity implements View.OnClickListener{
    private List<Wenwu> wenwuList=new ArrayList<>();
    private List<String> wenwuNameList=new ArrayList<>();
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private WenwuAdapter mWenwuAdapter;
    private Context con;
    private AutoCompleteTextView et;
    //private TextView tv;
    private String uid;
    private TextView username;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        initButton();
        con=this;
        //tv=(TextView)findViewById(R.id.uid);
        //initWenWuList();
        recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        layoutManager=new LinearLayoutManager(con);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        et=(AutoCompleteTextView) findViewById(R.id.search_et_input);
        Intent intent=getIntent();
        uid=intent.getStringExtra("uid");
        //tv.setText(Global.getname());
        initWenWuList();
        //initFragment();
        initWenWuNameList();
    }
    public void initWenWuNameList(){
        new Thread(new Runnable(){
            @Override
            public void run(){
                wenwuNameList.clear();
                try {
                    Connection conn = DBConnect.GetConnection();
                    String sql = "select distinct wname from wenwu where wname is not null order by visnum";
                    Statement st = (Statement) conn.createStatement();
                    ResultSet rs=st.executeQuery(sql);
                    while(rs.next()){
                        String s=new String(rs.getString("wname"));
                        wenwuNameList.add(s);
                    }
                    Global.initWenWuName(wenwuNameList);
                    st.close();
                    conn.close();
                    myhandler.sendEmptyMessage(2);
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }).start();
    };
    private void initButton(){
        Button LogOutButton=(Button)findViewById(R.id.LogOut);
        LogOutButton.setOnClickListener(this);
        Button searchButton=(Button)findViewById(R.id.search_btn_back);
        searchButton.setOnClickListener(this);
        Button userHomeButton=(Button)findViewById(R.id.user_home);
        userHomeButton.setOnClickListener(this);
    }
//    private daoHangFra mFragment;
//    private void initFragment(){
//        mFragment=new daoHangFra();
//        getFragmentManager().beginTransaction().
//                add(R.id.fl_container,mFragment).commitAllowingStateLoss();
//    }
    @Override
    public void onStart() {
        super.onStart();
        username=(TextView)findViewById(R.id.home_userName);
        username.setText("欢迎，"+Global.getName());
    }
    @Override
    public void onClick(View view){
        switch(view.getId()){
            case R.id.LogOut:
                Intent intentLogOut=new Intent(HomeAct.this, LoginAct.class);
                startActivity(intentLogOut);
                finish();
                break;
            case R.id.search_btn_back:
                Intent intentSearch=new Intent(HomeAct.this, search.class);
                intentSearch.putExtra("word",et.getText().toString().trim());
                intentSearch.putExtra("uid",uid);
                startActivity(intentSearch);
                break;
            case R.id.user_home:
                Intent UserHomeIntent=new Intent(HomeAct.this, userMainPageAct.class);
                startActivity(UserHomeIntent);
                break;
        }
    }
    public void initWenWuList(){
        new Thread(new Runnable(){
            @Override
            public void run(){
                wenwuList.clear();
                try {
                    Connection conn = DBConnect.GetConnection();
                    String sql = "select * from wenwu order by visnum desc";
                    Statement st = (Statement) conn.createStatement();
                    ResultSet rs=st.executeQuery(sql);
                    while(rs.next()){
                        Log.v("test",rs.getString("id"));
                        Wenwu wenwu=new Wenwu(rs.getString("wname"),rs.getString("visnum"),rs.getString("id"),rs.getString("website"));
                        wenwuList.add(wenwu);
                    }
                    myhandler.sendEmptyMessage(1);
                    st.close();
                    conn.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }).start();
    };
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent home = new Intent(Intent.ACTION_MAIN);
            home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            home.addCategory(Intent.CATEGORY_HOME);
            startActivity(home);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    private Handler myhandler = new Handler(){
        public void handleMessage(Message msg){
            switch(msg.what){
                case 2:
                    ArrayAdapter<String> adapter=new ArrayAdapter<String>(HomeAct.this,android.R.layout.simple_dropdown_item_1line, Global.getWenWuNames());
                    et.setAdapter(adapter);
                case 1:
                    mWenwuAdapter=new WenwuAdapter(con,wenwuList);
                    recyclerView.setAdapter(mWenwuAdapter);
                    break;
                case 0:
                    break;
            }
        }
    };
}
