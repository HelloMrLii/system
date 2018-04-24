package com.iotek.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/4/23.
 */
public class Users implements Serializable {
    private int U_ID;
    private String U_NAME;
    private String U_PASS;
    private int U_STATE;

    public Users() {
    }

    public int getU_STATE() {
        return U_STATE;
    }

    public void setU_STATE(int u_STATE) {
        U_STATE = u_STATE;
    }

    public int getU_ID() {
        return U_ID;
    }

    public void setU_ID(int u_ID) {
        U_ID = u_ID;
    }

    public String getU_NAME() {
        return U_NAME;
    }

    public void setU_NAME(String u_NAME) {
        U_NAME = u_NAME;
    }

    public String getU_PASS() {
        return U_PASS;
    }

    public void setU_PASS(String u_PASS) {
        U_PASS = u_PASS;
    }

    @Override
    public String toString() {
        return "Users{" +
                "U_ID=" + U_ID +
                ", U_NAME='" + U_NAME + '\'' +
                ", U_PASS='" + U_PASS + '\'' +
                ", U_STATE=" + U_STATE +
                '}';
    }
}
