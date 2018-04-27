package com.iotek.biz;

import com.iotek.dao.UsersMapper;
import com.iotek.model.Users;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/4/23.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UsersMapper usersMapper;

    /**
     * 注册游客
     * @param users
     * @return
     */
    public boolean addUser(Users users) {
        return usersMapper.addUser(users);
    }

    /**
     * 游客登录
     * @param users
     * @return
     */
    public Users selectUSers(Users users) {
        return usersMapper.selectUSers(users);
    }

    public Users selectID(Users users) {
        return usersMapper.selectID(users);
    }
}
