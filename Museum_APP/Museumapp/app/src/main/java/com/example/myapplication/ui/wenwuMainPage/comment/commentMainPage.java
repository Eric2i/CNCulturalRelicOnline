package com.example.myapplication.ui.wenwuMainPage.comment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.DB.DBConnect;
import com.example.myapplication.Global;
import com.example.myapplication.R;
import com.example.myapplication.ui.wenwuList.Wenwu;
import com.example.myapplication.ui.wenwuList.WenwuAdapter;
import com.example.myapplication.ui.wenwuMainPage.wenwuMainPage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class commentMainPage extends AppCompatActivity {
    private EditText et;
    private Button bt;
    private String wid;
    private List<comment> commentList=new ArrayList<>();
    private Context con;
    private int flag=1;
    private Button jjbtn;
    private ImageView iv;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comment_page);
        flag=1;
        con=this;
        et=(EditText)findViewById(R.id.comment_edittext);

        bt=(Button)findViewById(R.id.push_comment);
        iv=(ImageView)findViewById(R.id.wenWu_image_comment);
        Glide.with(this).load(Global.getWenWuUrl()).into(iv);
        Intent intent=getIntent();
        wid=intent.getStringExtra("wid");
        init();
        initWenWuList();
        jjbtn=(Button)findViewById(R.id.jianjie);
        jjbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent=new Intent(commentMainPage.this, wenwuMainPage.class);
                intent.putExtra("wid",wid);
                startActivity(intent);
                finish();
            }
        });
    }
    private void init(){
        bt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String s=et.getText().toString().trim();
                if(s.equals("")) {
                    myhandler.sendEmptyMessage(3);
                    return;
                }
                et.setText("");
                new Thread(new Runnable(){
                    @Override
                    public void run(){
                        int u=0;
                        try{
                            Connection cn=DBConnect.GetConnection();
                            String sql="insert into comments(username,wid,content) values('"+Global.getName()+"',"+wid+",'"+s+"')";
                            PreparedStatement pst;
                            pst=(PreparedStatement)cn.prepareStatement(sql);
                            u=pst.executeUpdate();
                            pst.close();
                            cn.close();
                            myhandler.sendEmptyMessage(0);
                        }catch (SQLException e){
                            myhandler.sendEmptyMessage(2);
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });
    }
    public void initWenWuList(){
        new Thread(new Runnable(){
            @Override
            public void run(){
                try {
                    commentList.clear();
                    Connection cn = DBConnect.GetConnection();
                    String sql = "select * from comments,users where wid="+wid+" and comments.username=users.username";
                    Statement st = (Statement)cn.createStatement();
                    ResultSet rs=st.executeQuery(sql);
                    while(rs.next()){
                        comment comt=new comment(rs.getString("username"),rs.getString("wid"),rs.getString("content"),rs.getString("time"));
                        commentList.add(comt);
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
                case 3:
                    Toast.makeText(commentMainPage.this,"发送内容不能为空!",Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    Toast.makeText(commentMainPage.this,"发送失败",Toast.LENGTH_SHORT).show();
                    break;
                case 1:
                    RecyclerView recyclerView=(RecyclerView)findViewById(R.id.comment_area);
                    LinearLayoutManager layoutManager=new LinearLayoutManager(con);
                    layoutManager.setOrientation(RecyclerView.VERTICAL);
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    commentAdapter mCommentAdapter=new commentAdapter(commentList);
                    recyclerView.setAdapter(mCommentAdapter);
                    if(flag==1)flag=0;
                    else Toast.makeText(commentMainPage.this,"发送成功",Toast.LENGTH_SHORT).show();
                    break;
                case 0:
                    initWenWuList();
                    break;
            }
        }
    };
}
