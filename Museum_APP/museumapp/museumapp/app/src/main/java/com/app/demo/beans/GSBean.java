package com.app.demo.beans;

import org.litepal.crud.DataSupport;

import java.io.Serializable;

public class GSBean extends DataSupport implements Serializable {

    public String ids;

    public int  pic;
    public String name;
    public String theme;
    public String content;


}
