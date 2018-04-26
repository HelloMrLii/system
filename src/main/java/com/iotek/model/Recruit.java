package com.iotek.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/4/24.
 */
public class Recruit implements Serializable {
    private int re_id;
    private int res_id;
    private String re_job;
    private String re_state;
    private String u_name;

    public int getRe_id() {
        return re_id;
    }

    public void setRe_id(int re_id) {
        this.re_id = re_id;
    }

    public int getRes_id() {
        return res_id;
    }

    public void setRes_id(int res_id) {
        this.res_id = res_id;
    }

    public String getRe_job() {
        return re_job;
    }

    public void setRe_job(String re_job) {
        this.re_job = re_job;
    }

    public String getRe_state() {
        return re_state;
    }

    public void setRe_state(String re_state) {
        this.re_state = re_state;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    @Override
    public String toString() {
        return "Recruit{" +
                "re_id=" + re_id +
                ", res_id=" + res_id +
                ", re_job='" + re_job + '\'' +
                ", re_state='" + re_state + '\'' +
                ", u_name='" + u_name + '\'' +
                '}';
    }
}
