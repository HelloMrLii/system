package com.iotek.dao;

import com.iotek.model.Admin;

/**
 * Created by Administrator on 2018/4/24.
 */
public interface AdminMapper {
    Admin login(Admin admin);
    boolean insertAdmin(Admin admin);
}
