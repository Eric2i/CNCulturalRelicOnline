package com.example.myapplication.ui.userMainPage;

import android.app.AppComponentFactory;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.DB.DBConnect;
import com.example.myapplication.Global;
import com.example.myapplication.R;
import com.example.myapplication.User;
import com.example.myapplication.ui.login.LoginAct;
import com.example.myapplication.ui.wenwuMainPage.comment.comment;
import com.example.myapplication.ui.wenwuMainPage.comment.commentAdapter;
import com.example.myapplication.ui.wenwuMainPage.comment.commentMainPage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class userMainPageAct extends AppCompatActivity implements View.OnClickListener{
    private User user;
    private Button ChangeIfoBtn;
    private Button ChangepwdBtn;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_home);
        initButton();
    }
    private void initButton(){
        ChangeIfoBtn=(Button)findViewById(R.id.change_ifo);
        ChangeIfoBtn.setOnClickListener(this);
        ChangepwdBtn=(Button)findViewById(R.id.change_pwd);
        ChangepwdBtn.setOnClickListener(this);
    }
    @Override
    public void onClick(View view){
        switch(view.getId()){
            case R.id.change_ifo:
                Intent ChangeIfoIntet=new Intent(userMainPageAct.this,changeInfoAct.class);
                startActivity(ChangeIfoIntet);
                break;
            case R.id.change_pwd:
                Intent ChangePwdIntent=new Intent(userMainPageAct.this,changePwdAct.class);
                startActivity(ChangePwdIntent);
                break;
        }
    }
    @Override
    public void onStart() {
        super.onStart();
        new Thread(new Runnable(){
            @Override
            public void run(){
                try {
                    Connection cn = DBConnect.GetConnection();
                    String sql = "select * from users where username='"+ Global.getName()+"'";
                    Statement st = (Statement)cn.createStatement();
                    ResultSet rs=st.executeQuery(sql);
                    while(rs.next()){
                        user=new User(rs.getString("username"),rs.getString("sex"),rs.getString("address"),rs.getString("age"));
                    }
                    st.close();
                    cn.close();
                    myhandler.sendEmptyMessage(1);
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
    private Handler myhandler = new Handler(){
        public void handleMessage(Message msg){
            switch(msg.what){
                case 1:
                    TextView zhangHao=(TextView)findViewById(R.id.userHome_zhangHao);
                    TextView sex=(TextView)findViewById(R.id.userHome_sex);
                    TextView age=(TextView)findViewById(R.id.userHome_age);
                    TextView address=(TextView)findViewById(R.id.userHome_address);
                    zhangHao.setText(user.getUsername());
                    sex.setText(user.getSex());
                    age.setText(user.getAge());
                    address.setText(user.getAddress());
                    break;
            }
        }
    };

}
