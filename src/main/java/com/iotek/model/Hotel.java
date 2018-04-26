package com.iotek.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2018/4/23.
 */
public class Hotel implements Serializable{
    private int hot_id;
    private String hot_title;
    private int hot_money;
    private Date hot_rel_time;
    private String hot_post;
    private String hot_require;
    private String hot_site;
    private String hot_welfare;
    private String hot_intro;
    private String hot_work_time;

    public Hotel() {
    }

    public int getHot_id() {
        return hot_id;
    }

    public void setHot_id(int hot_id) {
        this.hot_id = hot_id;
    }

    public String getHot_title() {
        return hot_title;
    }

    public void setHot_title(String hot_title) {
        this.hot_title = hot_title;
    }

    public int getHot_money() {
        return hot_money;
    }

    public void setHot_money(int hot_money) {
        this.hot_money = hot_money;
    }

    public Date getHot_rel_time() {
        return hot_rel_time;
    }

    public void setHot_rel_time(Date hot_rel_time) {
        this.hot_rel_time = hot_rel_time;
    }

    public String getHot_post() {
        return hot_post;
    }

    public void setHot_post(String hot_post) {
        this.hot_post = hot_post;
    }

    public String getHot_require() {
        return hot_require;
    }

    public void setHot_require(String hot_require) {
        this.hot_require = hot_require;
    }

    public String getHot_site() {
        return hot_site;
    }

    public void setHot_site(String hot_site) {
        this.hot_site = hot_site;
    }

    public String getHot_welfare() {
        return hot_welfare;
    }

    public void setHot_welfare(String hot_welfare) {
        this.hot_welfare = hot_welfare;
    }

    public String getHot_intro() {
        return hot_intro;
    }

    public void setHot_intro(String hot_intro) {
        this.hot_intro = hot_intro;
    }

    public String getHot_work_time() {
        return hot_work_time;
    }

    public void setHot_work_time(String hot_work_time) {
        this.hot_work_time = hot_work_time;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hot_id=" + hot_id +
                ", hot_title='" + hot_title + '\'' +
                ", hot_money='" + hot_money + '\'' +
                ", hot_rel_time=" + hot_rel_time +
                ", hot_post='" + hot_post + '\'' +
                ", hot_require='" + hot_require + '\'' +
                ", hot_site='" + hot_site + '\'' +
                ", hot_welfare='" + hot_welfare + '\'' +
                ", hot_intro='" + hot_intro + '\'' +
                ", hot_work_time='" + hot_work_time + '\'' +
                '}';
    }
}
