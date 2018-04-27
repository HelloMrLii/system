package com.iotek.biz;

import com.iotek.dao.RecruitMapper;
import com.iotek.model.Recruit;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/4/24.
 */
@Controller
public class RecruitServiceImpl implements RecruitService {
    @Resource
    private RecruitMapper recruitMapper;
    public boolean addRecruit(Recruit recruit) {
        return recruitMapper.addRecruit(recruit);
    }

    public List<Recruit> selectRecruit() {
        return recruitMapper.selectRecruit();
    }

    public boolean delectRecruit(Recruit recruit) {
        return recruitMapper.delectRecruit(recruit);
    }

    public Recruit selectResid(Recruit recruit) {
        return recruitMapper.selectResid(recruit);
    }

    public boolean updateRestate(Recruit recruit) {
        return recruitMapper.updateRestate(recruit);
    }
}
