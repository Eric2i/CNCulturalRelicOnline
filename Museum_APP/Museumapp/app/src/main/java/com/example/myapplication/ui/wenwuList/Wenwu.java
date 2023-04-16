package com.example.myapplication.ui.wenwuList;

public class Wenwu {
    private String name;
    private String visNum;
    private String wid;
    private String myurl;
    public Wenwu(String name,String visNum,String wid,String myurl){
        if(name==null)this.name=new String("未爬取到");
        else this.name=name;
        this.visNum=visNum;
        this.wid=wid;
        this.myurl=myurl;
    }
    public String getName(){
        return name;
    }
    public String getVisNum() { return visNum; }
    public void setVisNum(String s) { this.visNum=s; }
    public String getWid() { return wid; }
    public String getUrl(){return myurl;}
}
