package com.iotek.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2018/5/3.
 */
public class Rewpun implements Serializable {
    private int rewpun_id;
    /*private Emp emps;*/
    private Date rewpun_time;
    private String rewpun_reason;
    private int rewpun_money;
    private int emp_id;

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public int getRewpun_id() {
        return rewpun_id;
    }

    public void setRewpun_id(int rewpun_id) {
        this.rewpun_id = rewpun_id;
    }


   /* public Emp getEmp() {
        return emps;
    }

    public void setEmp(Emp emp) {
        this.emps = emp;
    }
*/
    public Date getRewpun_time() {
        return rewpun_time;
    }

    public void setRewpun_time(Date rewpun_time) {
        this.rewpun_time = rewpun_time;
    }

    public String getRewpun_reason() {
        return rewpun_reason;
    }

    public void setRewpun_reason(String rewpun_reason) {
        this.rewpun_reason = rewpun_reason;
    }

    public int getRewpun_money() {
        return rewpun_money;
    }

    public void setRewpun_money(int rewpun_money) {
        this.rewpun_money = rewpun_money;
    }

    @Override
    public String toString() {
        return "RewpunMapper{" +
                "rewpun_id=" + rewpun_id +
                ", rewpun_time=" + rewpun_time +
                ", rewpun_reason='" + rewpun_reason + '\'' +
                ", rewpun_money=" + rewpun_money +
                '}';
    }
}
