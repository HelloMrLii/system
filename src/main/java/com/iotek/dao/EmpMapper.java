package com.iotek.dao;

import com.iotek.model.Emp;

/**
 * Created by Administrator on 2018/4/26.
 */
public interface EmpMapper {
    boolean addEmp(Emp emp);
    Emp selectUid(Emp emp);
}
