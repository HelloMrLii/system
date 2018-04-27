package com.iotek.biz;

import com.iotek.model.Recruit;

import java.util.List;

/**
 * Created by Administrator on 2018/4/24.
 */
public interface RecruitService {
    boolean addRecruit(Recruit recruit);
    List<Recruit> selectRecruit();
    boolean delectRecruit(Recruit recruit);
    Recruit selectResid(Recruit recruit);
    boolean updateRestate(Recruit recruit);
}
