package com.app.demo.beans;

import org.litepal.crud.DataSupport;

import java.io.Serializable;

public class GSRecordBean extends DataSupport implements Serializable {
    public String sc_id;
    public String userId;
    public String ids;

    public int  pic;
    public String name;
    public String theme;
    public String content;


}
