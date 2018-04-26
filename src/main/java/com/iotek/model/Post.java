package com.iotek.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/4/25.
 */
public class Post implements Serializable {
    private int post_id;
    private String post_name;
    private int emp_id;
    private int dept_id;

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public String getPost_name() {
        return post_name;
    }

    public void setPost_name(String post_name) {
        this.post_name = post_name;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    @Override
    public String toString() {
        return "Post{" +
                "post_id=" + post_id +
                ", post_name='" + post_name + '\'' +
                ", emp_id=" + emp_id +
                ", dept_id=" + dept_id +
                '}';
    }
}
