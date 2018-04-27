package com.iotek.dao;

import com.iotek.model.Users;

/**
 * Created by Administrator on 2018/4/23.
 */
public interface UsersMapper {
    boolean addUser(Users users);
    Users selectUSers(Users users);
    Users selectID(Users users);
}
