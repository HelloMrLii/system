package com.iotek.biz;

import com.iotek.dao.RewpunMapper;
import com.iotek.model.Rewpun;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/5/3.
 */
@Service
public class RewpunServiceImpl implements RewpunService {
    @Resource
    private RewpunMapper rewpunMapper;
    public boolean insertRewpun(Rewpun rewpun) {
        return rewpunMapper.insertRewpun(rewpun);
    }
}
