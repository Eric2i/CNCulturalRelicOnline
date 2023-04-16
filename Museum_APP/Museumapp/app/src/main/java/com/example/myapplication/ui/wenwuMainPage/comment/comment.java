package com.example.myapplication.ui.wenwuMainPage.comment;

import com.example.myapplication.Global;

public class comment {
    private String wid;
    private String name;
    private String comment;
    private String time;
    public comment(String name,String wid,String comment,String time){
        this.wid=wid;
        this.name=name;
        this.comment=comment;
        this.time=time;
    }
    public String getWid(){
        return wid;
    }
    public String getName(){
        return name;
    }
    public String getComment(){
        return comment;
    }
    public String getTime(){
        return time;
    }
}
