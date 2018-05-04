package com.iotek.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by Administrator on 2018/4/25.
 */
public class Dept implements Serializable{
    private int dept_id;
    private String dept_name;
    private int post_id;
    private Date dept_time;

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public Date getDept_time() {
        return dept_time;
    }

    public void setDept_time(Date dept_time) {
        this.dept_time = dept_time;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "dept_id=" + dept_id +
                ", dept_name='" + dept_name + '\'' +
                ", post_id=" + post_id +
                '}';
    }
}
