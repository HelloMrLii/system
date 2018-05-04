package com.iotek.model;

import java.io.Serializable;
import java.util.Date;


/**
 * Created by Administrator on 2018/5/2.
 */
public class Train implements Serializable {
    private int t_id;
    private Date t_start_time;
    private Date t_over_time;
    private String t_site;
    private String t_dept;
    private String t_content;
    private String t_ps;

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public Date getT_start_time() {
        return t_start_time;
    }

    public void setT_start_time(Date t_start_time) {
        this.t_start_time = t_start_time;
    }

    public Date getT_over_time() {
        return t_over_time;
    }

    public void setT_over_time(Date t_over_time) {
        this.t_over_time = t_over_time;
    }

    public String getT_site() {
        return t_site;
    }

    public void setT_site(String t_site) {
        this.t_site = t_site;
    }

    public String getT_dept() {
        return t_dept;
    }

    public void setT_dept(String t_dept) {
        this.t_dept = t_dept;
    }

    public String getT_content() {
        return t_content;
    }

    public void setT_content(String t_content) {
        this.t_content = t_content;
    }

    public String getT_ps() {
        return t_ps;
    }

    public void setT_ps(String t_ps) {
        this.t_ps = t_ps;
    }

    @Override
    public String toString() {
        return "Train{" +
                "t_id=" + t_id +
                ", t_start_time=" + t_start_time +
                ", t_over_time=" + t_over_time +
                ", t_site='" + t_site + '\'' +
                ", t_dept='" + t_dept + '\'' +
                ", t_content='" + t_content + '\'' +
                ", t_ps='" + t_ps + '\'' +
                '}';
    }
}
