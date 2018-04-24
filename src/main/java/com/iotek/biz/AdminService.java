package com.iotek.biz;

import com.iotek.model.Admin;

/**
 * Created by Administrator on 2018/4/24.
 */
public interface AdminService {
    Admin login(Admin admin);
    boolean insertAdmin(Admin admin);
}
