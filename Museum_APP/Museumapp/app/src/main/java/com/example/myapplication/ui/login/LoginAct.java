package com.example.myapplication.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.os.Message;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import java.sql.*;

import com.bumptech.glide.Glide;
import com.example.myapplication.DB.DBConnect;
import com.example.myapplication.Global;
import com.example.myapplication.R;
import com.example.myapplication.ui.home.HomeAct;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class LoginAct extends AppCompatActivity {
    private Button myButtonsignup;
    private Button myButtonlogin;
    private EditText usernameEditText;
    private EditText passwordEditText;
    private String uid=new String("");
    private String names=new String("");
    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Log.v("good","build");
        usernameEditText=(EditText)findViewById(R.id.logInUsername);
        //usernameEditText.setText("123456780");
        passwordEditText=(EditText)findViewById(R.id.logInPassword);
        //passwordEditText.setText("1234567801");
        myButtonsignup=(Button)findViewById(R.id.btn_2);
        iv=(ImageView)findViewById(R.id.iv_1);
        //Glide.with(this).load("https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png").into(iv);
        myButtonsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginAct.this, SignupAct.class);
                startActivity(intent);
            }
        });
        myButtonlogin=(Button)findViewById(R.id.btn_1);
        myButtonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"Clicked",Toast.LENGTH_SHORT).show();
                new Thread(new Runnable(){
                    @Override
                    public void run() {
                        try{
                            Connection cn= DBConnect.GetConnection();
                            String sql="select * from users where username = '"+usernameEditText.getText().toString().trim()+"' and pwd=MD5('"+passwordEditText.getText().toString().trim()+"')";
                            Log.v("test",sql);
                            Statement stmt=cn.createStatement();
                            ResultSet rs=stmt.executeQuery(sql);
                            if(rs.next()) {
                                Global.sex=rs.getString("sex");
                                Global.age=rs.getString("age");
                                myhandler.sendEmptyMessage(1);
                            }
                            else{
                                myhandler.sendEmptyMessage(0);
                            }
                            stmt.close();
                            cn.close();
                        }catch(SQLException e) {
                            myhandler.sendEmptyMessage(0);
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });
        Toast.makeText(getApplicationContext(),"Click",Toast.LENGTH_SHORT).show();
    }
    private Handler myhandler = new Handler(){
        public void handleMessage(Message msg){
            switch(msg.what){
                case 1:
                    Intent intent=new Intent(LoginAct.this,HomeAct.class);
                    Global.name=usernameEditText.getText().toString().trim();
                    startActivity(intent);
                    finish();
                    break;
                case 0:
                    passwordEditText.setError("密码错误或用户名不存在！");
                    Log.v("log","bad");
            }
        }
    };
}