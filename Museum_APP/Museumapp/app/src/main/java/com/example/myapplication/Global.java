package com.example.myapplication;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import android.app.Application;
import android.widget.Toast;

public class Global extends Application {
    public static String name;
    public static int wenWuInit=0;
    public static String wenWuUrl;
    public static String wenWuid;
    public static String age;
    public static String sex;
    public static String[] wenwuName;
    public static int genWuInit(){return wenWuInit;}
    public static String getName(){
        return name;
    }
    public static String getWenWuUrl(){return wenWuUrl;}
    public static String getWenWuid(){return wenWuid;}
    public static String getAge(){
        return age;
    }
    public static String getSex(){
        return sex;
    }
    public static String checkPwd(String s){
        if(s.isEmpty()) {
            return "密码不能为空!";
        }
        if(s.length()<6){
            return "密码不能少于6位!";
        }
        if(s.length()>16){
            return "密码不能多于16位!";
        }
        return "ok";
    }
    public static void initWenWuName(List<String> names){
        wenwuName=names.toArray(new String[names.size()]);
    }
    public static String[] getWenWuNames(){
        return wenwuName;
    }
}
