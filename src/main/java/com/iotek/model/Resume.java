package com.iotek.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/4/23.
 */
public class Resume implements Serializable{
    private int res_id;
    private String res_title;//标题
    private String res_name;//（姓名）
    private String res_sex;//(性别)
    private String res_old;//（年龄）
    private String res_education;//（学历
    private String res_suffer;//工作经验）
    private String res_phone;//（电话）
    private String res_idnumber;//(身份证号码)
    private int u_id;
    private String res_state;//状态
    private String res_read_state;//是否阅读

    public Resume() {
    }

    public int getRes_id() {
        return res_id;
    }

    public void setRes_id(int res_id) {
        this.res_id = res_id;
    }

    public String getRes_title() {
        return res_title;
    }

    public void setRes_title(String res_title) {
        this.res_title = res_title;
    }

    public String getRes_name() {
        return res_name;
    }

    public void setRes_name(String res_name) {
        this.res_name = res_name;
    }

    public String getRes_sex() {
        return res_sex;
    }

    public void setRes_sex(String res_sex) {
        this.res_sex = res_sex;
    }

    public String getRes_old() {
        return res_old;
    }

    public void setRes_old(String res_old) {
        this.res_old = res_old;
    }

    public String getRes_education() {
        return res_education;
    }

    public void setRes_education(String res_education) {
        this.res_education = res_education;
    }

    public String getRes_suffer() {
        return res_suffer;
    }

    public void setRes_suffer(String res_suffer) {
        this.res_suffer = res_suffer;
    }

    public String getRes_phone() {
        return res_phone;
    }

    public void setRes_phone(String res_phone) {
        this.res_phone = res_phone;
    }

    public String getRes_idnumber() {
        return res_idnumber;
    }

    public void setRes_idnumber(String res_idnumber) {
        this.res_idnumber = res_idnumber;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getRes_state() {
        return res_state;
    }

    public void setRes_state(String res_state) {
        this.res_state = res_state;
    }

    public String getRes_read_state() {
        return res_read_state;
    }

    public void setRes_read_state(String res_read_state) {
        this.res_read_state = res_read_state;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "res_id=" + res_id +
                ", res_title='" + res_title + '\'' +
                ", res_name='" + res_name + '\'' +
                ", res_sex='" + res_sex + '\'' +
                ", res_old='" + res_old + '\'' +
                ", res_education='" + res_education + '\'' +
                ", res_suffer='" + res_suffer + '\'' +
                ", res_phone='" + res_phone + '\'' +
                ", res_idnumber='" + res_idnumber + '\'' +
                ", u_id=" + u_id +
                ", res_state='" + res_state + '\'' +
                ", res_read_state='" + res_read_state + '\'' +
                '}';
    }
}
