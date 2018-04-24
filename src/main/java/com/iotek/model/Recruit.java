package com.iotek.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/4/24.
 */
public class Recruit implements Serializable {
    private int RE_ID;
    private int RES_ID;
    private String RE_JOB;
    private String RE_STATE;
    private String U_NAME;

    public String getU_NAME() {
        return U_NAME;
    }

    public void setU_NAME(String u_NAME) {
        U_NAME = u_NAME;
    }

    public int getRE_ID() {
        return RE_ID;
    }

    public void setRE_ID(int RE_ID) {
        this.RE_ID = RE_ID;
    }

    public int getRES_ID() {
        return RES_ID;
    }

    public void setRES_ID(int RES_ID) {
        this.RES_ID = RES_ID;
    }

    public String getRE_JOB() {
        return RE_JOB;
    }

    public void setRE_JOB(String RE_JOB) {
        this.RE_JOB = RE_JOB;
    }

    public String getRE_STATE() {
        return RE_STATE;
    }

    public void setRE_STATE(String RE_STATE) {
        this.RE_STATE = RE_STATE;
    }

    @Override
    public String toString() {
        return "Recruit{" +
                "RE_ID=" + RE_ID +
                ", RES_ID=" + RES_ID +
                ", RE_JOB='" + RE_JOB + '\'' +
                ", RE_STATE='" + RE_STATE + '\'' +
                ", U_NAME='" + U_NAME + '\'' +
                '}';
    }
}
