package com.iotek.biz;

import com.iotek.model.Users;

/**
 * Created by Administrator on 2018/4/23.
 */
public interface UserService {
    boolean addUser(Users users);
    Users selectUSers(Users users);
}
