package com.example.myapplication.ui.userMainPage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.DB.DBConnect;
import com.example.myapplication.Global;
import com.example.myapplication.R;
import com.example.myapplication.ui.wenwuList.WenwuAdapter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class changePwdAct extends Activity {
    private Button changePwdButton;
    private EditText pwd;
    private EditText repwd;
    private String ErrorText;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.changepwd);
        changePwdButton=(Button)findViewById(R.id.change_pwd_baocun);
        pwd=(EditText)findViewById(R.id.change_pwd);
        repwd=(EditText)findViewById(R.id.change_newpwd);
        changePwdButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                 new Thread(new Runnable(){
                     @Override
                     public void run(){
                         String mypwd=pwd.getText().toString().trim();
                         String mynewpwd=repwd.getText().toString().trim();
                         String temp=Global.checkPwd(mynewpwd);
                         if(!temp.equals("ok")){
                             ErrorText=temp;
                             myhandler.sendEmptyMessage(2);
                             return;
                         }
                         try{
                             Connection cn= DBConnect.GetConnection();
                             String sql="select * from users where username='"+ Global.getName()+"' and pwd=MD5('"+mypwd+"')";
                             Log.v("test",sql);
                             Statement st=(Statement)cn.createStatement();
                             ResultSet rs=st.executeQuery(sql);
                             if(rs.next()){
                                 st.close();
                                 sql="update users set pwd=MD5('"+mynewpwd+"') where username='"+Global.getName()+"'";
                                 Log.v("test",sql);
                                 PreparedStatement pst=(PreparedStatement)cn.prepareStatement(sql);
                                 pst.executeUpdate();
                                 pst.close();
                                 myhandler.sendEmptyMessage(1);
                             }
                             else{
                                 myhandler.sendEmptyMessage(0);
                             }
                             cn.close();
                         }catch (SQLException e){
                             e.printStackTrace();
                         }
                     }
                 }).start();
            }
        });
    }
    private Handler myhandler = new Handler(){
        @SuppressLint("HandlerLeak")
        public void handleMessage(Message msg){
            switch(msg.what){
                case 2:
                    repwd.setError(ErrorText);
                    break;
                case 1:
                    Toast.makeText(getApplicationContext(),"修改成功！",Toast.LENGTH_SHORT).show();
                    finish();
                    break;
                case 0:
                    pwd.setError("密码错误！");
                    break;
            }
        }
    };
}
