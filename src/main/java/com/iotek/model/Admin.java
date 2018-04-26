package com.iotek.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/4/24.
 */
public class Admin implements Serializable {
    private int ad_id;
    private String ad_name;
    private String ad_pass;
    private int ad_state;

    public Admin() {
    }

    public int getAd_id() {
        return ad_id;
    }

    public void setAd_id(int ad_id) {
        this.ad_id = ad_id;
    }

    public String getAd_name() {
        return ad_name;
    }

    public void setAd_name(String ad_name) {
        this.ad_name = ad_name;
    }

    public String getAd_pass() {
        return ad_pass;
    }

    public void setAd_pass(String ad_pass) {
        this.ad_pass = ad_pass;
    }

    public int getAd_state() {
        return ad_state;
    }

    public void setAd_state(int ad_state) {
        this.ad_state = ad_state;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "ad_id=" + ad_id +
                ", ad_name='" + ad_name + '\'' +
                ", ad_pass='" + ad_pass + '\'' +
                ", ad_state=" + ad_state +
                '}';
    }
}
