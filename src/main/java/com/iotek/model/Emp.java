package com.iotek.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/4/26.
 */
public class Emp implements Serializable {
    private int emp_id;
    private String emp_name;
    private String emp_sex;
    private String emp_pass;
    private int dept_id;
    private int post_id;
    private int u_id;
    private Date emp_time;
    private String emp_state;
    private String emp_real_name;
   /* private List<Rewpun> rewpuns;*/

   /* public List<Rewpun> getRewpuns() {
        return rewpuns;
    }

    public void setRewpuns(List<Rewpun> rewpuns) {
        this.rewpuns = rewpuns;
    }*/

    public String getEmp_real_name() {
        return emp_real_name;
    }

    public void setEmp_real_name(String emp_real_name) {
        this.emp_real_name = emp_real_name;
    }

    public int getU_id() {
        return u_id;
    }

    public Date getEmp_time() {
        return emp_time;
    }

    public void setEmp_time(Date emp_time) {
        this.emp_time = emp_time;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getEmp_sex() {
        return emp_sex;
    }

    public void setEmp_sex(String emp_sex) {
        this.emp_sex = emp_sex;
    }

    public String getEmp_pass() {
        return emp_pass;
    }

    public void setEmp_pass(String emp_pass) {
        this.emp_pass = emp_pass;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public String getEmp_state() {
        return emp_state;
    }

    public void setEmp_state(String emp_state) {
        this.emp_state = emp_state;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "emp_id=" + emp_id +
                ", emp_name='" + emp_name + '\'' +
                ", emp_sex='" + emp_sex + '\'' +
                ", emp_pass='" + emp_pass + '\'' +
                ", dept_id=" + dept_id +
                ", post_id=" + post_id +
                ", u_id=" + u_id +
                ", emp_time=" + emp_time +
                '}';
    }
}