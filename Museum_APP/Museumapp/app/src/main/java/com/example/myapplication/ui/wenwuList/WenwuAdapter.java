package com.example.myapplication.ui.wenwuList;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.DB.DBConnect;
import com.example.myapplication.Global;
import com.example.myapplication.R;
import com.example.myapplication.ui.wenwuMainPage.comment.comment;
import com.example.myapplication.ui.wenwuMainPage.wenwuMainPage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class WenwuAdapter extends RecyclerView.Adapter<WenwuAdapter.ViewHolder>{
    private List<Wenwu> mWenwuList;
    private Context mContext;
    private String myVisNum=new String("0");
    class ViewHolder extends RecyclerView.ViewHolder{
        View wenwuView;
        private ImageView wenwuImage;
        private TextView wenwuName;
        private TextView wenwuVisNum;
        public ViewHolder(@NonNull View view){
            super(view);
            wenwuView = view;
            wenwuImage=(ImageView)view.findViewById(R.id.wenwu_image);
            wenwuName=(TextView)view.findViewById(R.id.wenwu_name);
            wenwuVisNum=(TextView)view.findViewById(R.id.wenwu_visnum);
        }
    }
    public WenwuAdapter(Context mContext,List<Wenwu> WenwuList){
        this.mContext=mContext;
        mWenwuList=WenwuList;
    }
    public void removeData(int position){
        mWenwuList.remove(position);
        notifyDataSetChanged();
    }
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.wenwu_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,int position){
        Wenwu wenwu=mWenwuList.get(position);
        holder.wenwuName.setText(wenwu.getName());
        holder.wenwuVisNum.setText("浏览量" + String.valueOf(wenwu.getVisNum()));
        Glide.with(mContext).load(wenwu.getUrl()).into(holder.wenwuImage);
        holder.wenwuView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                myVisNum=String.valueOf(Integer.parseInt(wenwu.getVisNum())+1);
                wenwu.setVisNum(myVisNum);
                holder.wenwuVisNum.setText("浏览量" + myVisNum);
                Intent intent=new Intent(mContext, wenwuMainPage.class);
                intent.putExtra("wid",wenwu.getWid());
                Global.wenWuUrl=wenwu.getUrl();
                Global.wenWuid=wenwu.getWid();
                mContext.startActivity(intent);
                new Thread(new Runnable(){
                    @Override
                    public void run() {
                        while(Global.genWuInit()==1)continue;
                        int u=0;
                        try{
                            Connection cn=DBConnect.GetConnection();
                            String sql="update wenwu set visnum=visnum+1 where id="+wenwu.getWid();
                            Log.v("test",sql);
                            PreparedStatement pst;
                            pst=(PreparedStatement)cn.prepareStatement(sql);
                            u=pst.executeUpdate();
                            pst.close();
                            cn.close();
                        }catch (SQLException e){
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });
    }
    @Override
    public int getItemCount(){
        return mWenwuList.size();
    }
}
