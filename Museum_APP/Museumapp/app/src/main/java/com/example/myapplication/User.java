package com.example.myapplication;

public class User {
    private String username;
    private String sex;
    private String address;
    private String age;
    private String type;
    private String review_permission;
    public User(String username,String sex,String address,String age){
        this.username=username;
        if(sex==null)this.sex=new String("待选");
        else this.sex=sex;
        if(address==null)this.address=new String("未填写地址");
        else this.address=address;
        if(age==null||age.equals("-1"))this.age=new String("未填写年龄");
        else this.age=age;
    }
    public String getUsername(){
        return username;
    }
    public String getSex(){
        return sex;
    }
    public String getAddress(){
        return address;
    }
    public String getAge(){
        return age;
    }
}
