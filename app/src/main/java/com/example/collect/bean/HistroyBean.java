package com.example.collect.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class HistroyBean {
    @Id
    public String  keyword;
    public  long time;
    @Generated(hash = 7321012)
    public HistroyBean(String keyword, long time) {
        this.keyword = keyword;
        this.time = time;
    }
    @Generated(hash = 1752986504)
    public HistroyBean() {
    }
    public String getKeyword() {
        return this.keyword;
    }
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    public long getTime() {
        return this.time;
    }
    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "HistroyBean{" +
                "keyword='" + keyword + '\'' +
                ", time=" + time +
                '}';
    }
}
