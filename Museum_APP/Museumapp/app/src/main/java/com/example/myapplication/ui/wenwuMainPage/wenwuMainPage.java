package com.example.myapplication.ui.wenwuMainPage;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.myapplication.DB.DBConnect;
import com.example.myapplication.Global;
import com.example.myapplication.R;
import com.example.myapplication.ui.login.LoginAct;
import com.example.myapplication.ui.login.SignupAct;
import com.example.myapplication.ui.wenwuMainPage.comment.commentMainPage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class wenwuMainPage extends AppCompatActivity {
    private String intro=new String("");
    private Button pl;
    private TextView tv;
    private String wid;
    private ImageView iv;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_main_page);
        iv=(ImageView)findViewById(R.id.wenWu_image_mainPage);
        Glide.with(this).load(Global.getWenWuUrl()).into(iv);
        Intent intent = getIntent();
        wid = intent.getStringExtra("wid");
        new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    Connection cn= DBConnect.GetConnection();
                    String sql="select wname,date,description from wenwu where id ="+wid;
                    Log.v("test",sql);
                    Statement st=cn.createStatement();
                    ResultSet rs=st.executeQuery(sql);
                    rs.next();
                    String temp=new String("");

                    if(rs.getString("wname")!=null){
                        intro=rs.getString("wname");
                        temp=temp+intro;
                        temp=temp+',';
                    }
                    if(rs.getString("date")!=null){
                        intro=rs.getString("date");
                        temp=temp+intro;
                        temp=temp+'。';
                    }
                    if(rs.getString("description")!=null){
                        intro=rs.getString("description");
                        temp=temp+intro;
                        temp=temp+',';
                    }
                    if(temp.equals("")){
                        temp="未爬取到任何信息。";
                    }
                    intro=temp;
                    myhandler.sendEmptyMessage(1);
                    st.close();
                    cn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }).start();
        pl=(Button)findViewById(R.id.comment_btn);
        pl.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent=new Intent(wenwuMainPage.this, commentMainPage.class);
                intent.putExtra("wid",wid);
                startActivity(intent);
                finish();
            }
        });
        btn=(Button)findViewById(R.id.dianZan);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable(){
                    public void run(){
                        int flag=0;
                        int u=0;
                        try {
                            Connection cn= DBConnect.GetConnection();
                            String sql="select * from wenwulikes where username='"+Global.getName()+"' and wid = "+Global.getWenWuid();
                            Log.v("test",sql);
                            Statement st=cn.createStatement();
                            ResultSet rs=st.executeQuery(sql);
                            if(rs.next())flag=1;
                            st.close();
                            if(flag==1){
                                sql = "delete from wenwulikes where username='" + Global.getName() + "' and wid=" + Global.getWenWuid() ;
                                Log.v("test", sql);
                                PreparedStatement pst;
                                pst = (PreparedStatement) cn.prepareStatement(sql);
                                u = pst.executeUpdate();
                                pst.close();
                                cn.close();
                                myhandler.sendEmptyMessage(2);
                            }
                            else{
                                sql = "insert into wenwulikes(username,wid) values('" + Global.getName() + "'," + Global.getWenWuid() + ")";
                                Log.v("test", sql);
                                PreparedStatement pst;
                                pst = (PreparedStatement) cn.prepareStatement(sql);
                                u = pst.executeUpdate();
                                pst.close();
                                cn.close();
                                myhandler.sendEmptyMessage(0);
                            }
                            cn.close();
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                }).start();

            }
        });
        initDianZan();
    }
    public void initDianZan(){
        new Thread(new Runnable(){
            @Override
            public void run(){
                try {
                    Connection cn= DBConnect.GetConnection();
                    String sql="select * from wenwulikes where username='"+Global.getName()+"' and wid = "+Global.getWenWuid();
                    Log.v("test",sql);
                    Statement st=cn.createStatement();
                    ResultSet rs=st.executeQuery(sql);
                    if(rs.next())myhandler.sendEmptyMessage(0);
                    st.close();
                    cn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }).start();
    }
    private Handler myhandler = new Handler(){
        public void handleMessage(Message msg){
            switch(msg.what){
                case 2:
                    btn.setBackgroundResource(R.drawable.dianzan);
                    break;
                case 1:
                    Log.v("test",intro);
                    tv=(TextView)findViewById(R.id.introduce);
                    tv.setText(intro);
                    break;
                case 0:
                    btn.setBackgroundResource(R.drawable.liked);
                    break;
            }
        }
    };
}
