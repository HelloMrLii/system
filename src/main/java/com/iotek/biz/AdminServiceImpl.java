package com.iotek.biz;

import com.iotek.dao.AdminMapper;
import com.iotek.model.Admin;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/4/24.
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminMapper adminMapper;

    public Admin login(Admin admin) {
        return adminMapper.login(admin);
    }

    public boolean insertAdmin(Admin admin) {
        return adminMapper.insertAdmin(admin);
    }
}
