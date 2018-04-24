package com.iotek.dao;

import com.iotek.model.Recruit;

import java.util.List;

/**
 * Created by Administrator on 2018/4/24.
 */
public interface RecruitMapper {
    boolean addRecruit(Recruit recruit);
    List<Recruit> selectRecruit();
}
