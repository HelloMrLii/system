package com.iotek.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/4/23.
 */
public class Users implements Serializable {
    private int u_id;
    private String u_name;
    private String u_pass;
    private int u_state;

    public Users() {
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getU_pass() {
        return u_pass;
    }

    public void setU_pass(String u_pass) {
        this.u_pass = u_pass;
    }

    public int getU_state() {
        return u_state;
    }

    public void setU_state(int u_state) {
        this.u_state = u_state;
    }

    @Override
    public String toString() {
        return "Users{" +
                "u_id=" + u_id +
                ", u_name='" + u_name + '\'' +
                ", u_pass='" + u_pass + '\'' +
                ", u_state=" + u_state +
                '}';
    }
}
