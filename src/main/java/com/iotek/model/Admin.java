package com.iotek.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/4/24.
 */
public class Admin implements Serializable {
    private int AD_ID;
    private String AD_NAME;
    private String AD_PASS;
    private int AD_STATE;

    public Admin() {
    }

    public Admin(int AD_ID, String AD_NAME, String AD_PASS, int AD_STATE) {
        this.AD_ID = AD_ID;
        this.AD_NAME = AD_NAME;
        this.AD_PASS = AD_PASS;
        this.AD_STATE = AD_STATE;
    }

    public int getAD_ID() {
        return AD_ID;
    }

    public void setAD_ID(int AD_ID) {
        this.AD_ID = AD_ID;
    }

    public String getAD_NAME() {
        return AD_NAME;
    }

    public void setAD_NAME(String AD_NAME) {
        this.AD_NAME = AD_NAME;
    }

    public String getAD_PASS() {
        return AD_PASS;
    }

    public void setAD_PASS(String AD_PASS) {
        this.AD_PASS = AD_PASS;
    }

    public int getAD_STATE() {
        return AD_STATE;
    }

    public void setAD_STATE(int AD_STATE) {
        this.AD_STATE = AD_STATE;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "AD_ID=" + AD_ID +
                ", AD_NAME='" + AD_NAME + '\'' +
                ", AD_PASS='" + AD_PASS + '\'' +
                ", AD_STATE=" + AD_STATE +
                '}';
    }
}
