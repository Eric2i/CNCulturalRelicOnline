package com.example.myapplication.ui.userMainPage;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.DB.DBConnect;
import com.example.myapplication.Global;
import com.example.myapplication.R;
import com.example.myapplication.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static java.lang.Thread.sleep;

public class changeInfoAct extends Activity implements View.OnClickListener {
    private String[] sexArry = {"男", "待选", "女"};
    private TextView changeSex;
    private EditText age;
    private Button baoCunButton;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_ifo);
        initButton();
        initEditText();
        initTextView();
    }

    private void initEditText() {
        age = (EditText) findViewById(R.id.change_age);
    }

    private void initTextView() {
        changeSex = (TextView) findViewById(R.id.change_sex);
        changeSex.setOnClickListener(v -> {//性别点击后弹出性别选择框
            AlertDialog.Builder builder3 = new AlertDialog.Builder(this);// 自定义对话框
            // checkedItem默认的选中 setSingleChoiceItems设置单选按钮组
            builder3.setSingleChoiceItems(sexArry, 1, (dialog, which) -> {// which是被选中的位置
                // showToast(which+"");
                changeSex.setText(sexArry[which]);
                dialog.dismiss();// 随便点击一个item消失对话框，不用点击确认取消
            });
            builder3.show();// 让弹出框显示
        });
    }

    private void initButton() {
        baoCunButton = (Button) findViewById(R.id.change_baocun);
        baoCunButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.change_baocun:
                new Thread(new Runnable(){
                    @Override
                    public void run(){
                        String Sex=changeSex.getText().toString().trim();
                        String Age=age.getText().toString().trim();
                        if(Sex.equals(""))Sex=Global.getSex();
                        if(Age.equals(""))Age=Global.getAge();
                        try{
                            Connection cn= DBConnect.GetConnection();
                            String sql="update users set age='"+Age+"',sex='"+Sex+"' where username='"+Global.getName()+"'";
                            Log.v("test",sql);
                            PreparedStatement pst=(PreparedStatement)cn.prepareStatement(sql);
                            pst.executeUpdate();
                            pst.close();
                            myhandler.sendEmptyMessage(1);
                            Global.sex=Sex;
                            Global.age=Age;
                            cn.close();
                        }catch (SQLException e){
                            e.printStackTrace();
                        }
                    }
                }).start();
                break;
        }
    }
    private Handler myhandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    Toast.makeText(getApplicationContext(),"修改成功!",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };
}
