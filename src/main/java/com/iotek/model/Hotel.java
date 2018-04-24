package com.iotek.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2018/4/23.
 */
public class Hotel implements Serializable{
    private int HOT_ID;
    private String HOT_TITLE;
    private String HOT_MONEY;
    private Date HOT_REL_TIME;
    private String HOT_POST;
    private String HOT_REQUIRE;

    public Hotel() {
    }

    public int getHOT_ID() {
        return HOT_ID;
    }

    public void setHOT_ID(int HOT_ID) {
        this.HOT_ID = HOT_ID;
    }

    public String getHOT_TITLE() {
        return HOT_TITLE;
    }

    public void setHOT_TITLE(String HOT_TITLE) {
        this.HOT_TITLE = HOT_TITLE;
    }

    public String getHOT_MONEY() {
        return HOT_MONEY;
    }

    public void setHOT_MONEY(String HOT_MONEY) {
        this.HOT_MONEY = HOT_MONEY;
    }

    public Date getHOT_REL_TIME() {
        return HOT_REL_TIME;
    }

    public void setHOT_REL_TIME(Date HOT_REL_TIME) {
        this.HOT_REL_TIME = HOT_REL_TIME;
    }

    public String getHOT_POST() {
        return HOT_POST;
    }

    public void setHOT_POST(String HOT_POST) {
        this.HOT_POST = HOT_POST;
    }

    public String getHOT_REQUIRE() {
        return HOT_REQUIRE;
    }

    public void setHOT_REQUIRE(String HOT_REQUIRE) {
        this.HOT_REQUIRE = HOT_REQUIRE;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "HOT_ID=" + HOT_ID +
                ", HOT_TITLE='" + HOT_TITLE + '\'' +
                ", HOT_MONEY='" + HOT_MONEY + '\'' +
                ", HOT_REL_TIME=" + HOT_REL_TIME +
                ", HOT_POST='" + HOT_POST + '\'' +
                ", HOT_REQUIRE='" + HOT_REQUIRE + '\'' +
                '}';
    }
}
