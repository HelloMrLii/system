package com.iotek.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/4/23.
 */
public class Resume implements Serializable{
    private int RES_ID;
    private String RES_TITLE;//标题
    private String RES_NAME;//（姓名）
    private String RES_SEX;//(性别)
    private String RES_OLD;//（年龄）
    private String RES_EDUCATION;//（学历
    private String RES_SUFFER;//工作经验）
    private String RES_PHONE;//（电话）
    private String RES_IDNUMBER;//(身份证号码)
    private int U_ID;
    private String RES_STATE;//状态
    private String RES_READ_STATE;//是否阅读

    public Resume() {
    }

    public String getRES_READ_STATE() {
        return RES_READ_STATE;
    }

    public void setRES_READ_STATE(String RES_READ_STATE) {
        this.RES_READ_STATE = RES_READ_STATE;
    }

    public int getRES_ID() {
        return RES_ID;
    }

    public void setRES_ID(int RES_ID) {
        this.RES_ID = RES_ID;
    }

    public Resume(int RES_ID) {
        this.RES_ID = RES_ID;
    }

    public String getRES_TITLE() {
        return RES_TITLE;
    }

    public void setRES_TITLE(String RES_TITLE) {
        this.RES_TITLE = RES_TITLE;
    }

    public String getRES_NAME() {
        return RES_NAME;
    }

    public void setRES_NAME(String RES_NAME) {
        this.RES_NAME = RES_NAME;
    }

    public String getRES_SEX() {
        return RES_SEX;
    }

    public void setRES_SEX(String RES_SEX) {
        this.RES_SEX = RES_SEX;
    }

    public String getRES_OLD() {
        return RES_OLD;
    }

    public void setRES_OLD(String RES_OLD) {
        this.RES_OLD = RES_OLD;
    }

    public String getRES_EDUCATION() {
        return RES_EDUCATION;
    }

    public void setRES_EDUCATION(String RES_EDUCATION) {
        this.RES_EDUCATION = RES_EDUCATION;
    }

    public String getRES_SUFFER() {
        return RES_SUFFER;
    }

    public void setRES_SUFFER(String RES_SUFFER) {
        this.RES_SUFFER = RES_SUFFER;
    }

    public String getRES_PHONE() {
        return RES_PHONE;
    }

    public void setRES_PHONE(String RES_PHONE) {
        this.RES_PHONE = RES_PHONE;
    }

    public String getRES_IDNUMBER() {
        return RES_IDNUMBER;
    }

    public void setRES_IDNUMBER(String RES_IDNUMBER) {
        this.RES_IDNUMBER = RES_IDNUMBER;
    }

    public int getU_ID() {
        return U_ID;
    }

    public void setU_ID(int u_ID) {
        U_ID = u_ID;
    }

    public String getRES_STATE() {
        return RES_STATE;
    }

    public void setRES_STATE(String RES_STATE) {
        this.RES_STATE = RES_STATE;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "RES_ID=" + RES_ID +
                ", RES_TITLE='" + RES_TITLE + '\'' +
                ", RES_NAME='" + RES_NAME + '\'' +
                ", RES_SEX='" + RES_SEX + '\'' +
                ", RES_OLD='" + RES_OLD + '\'' +
                ", RES_EDUCATION='" + RES_EDUCATION + '\'' +
                ", RES_SUFFER='" + RES_SUFFER + '\'' +
                ", RES_PHONE='" + RES_PHONE + '\'' +
                ", RES_IDNUMBER='" + RES_IDNUMBER + '\'' +
                ", U_ID=" + U_ID +
                ", RES_STATE='" + RES_STATE + '\'' +
                ", RES_READ_STATE='" + RES_READ_STATE + '\'' +
                '}';
    }
}
