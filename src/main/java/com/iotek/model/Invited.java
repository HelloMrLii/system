package com.iotek.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2018/4/25.
 */
public class Invited implements Serializable {
    private int inv_id;
    private Date inv_time;
    private String inv_site;
    private int u_id;
    private String inv_state;
    private String inv_pass;

    public int getInv_id() {
        return inv_id;
    }

    public void setInv_id(int inv_id) {
        this.inv_id = inv_id;
    }

    public Date getInv_time() {
        return inv_time;
    }

    public void setInv_time(Date inv_time) {
        this.inv_time = inv_time;
    }

    public String getInv_site() {
        return inv_site;
    }

    public void setInv_site(String inv_site) {
        this.inv_site = inv_site;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getInv_state() {
        return inv_state;
    }

    public void setInv_state(String inv_state) {
        this.inv_state = inv_state;
    }

    public String getInv_pass() {
        return inv_pass;
    }

    public void setInv_pass(String inv_pass) {
        this.inv_pass = inv_pass;
    }

    @Override
    public String toString() {
        return "Invited{" +
                "inv_id=" + inv_id +
                ", inv_time=" + inv_time +
                ", inv_site='" + inv_site + '\'' +
                ", u_id=" + u_id +
                ", inv_state='" + inv_state + '\'' +
                ", inv_pass='" + inv_pass + '\'' +
                '}';
    }
}
