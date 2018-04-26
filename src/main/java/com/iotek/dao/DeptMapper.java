package com.iotek.dao;

import com.iotek.model.Dept;

import java.util.List;

/**
 * Created by Administrator on 2018/4/25.
 */
public interface DeptMapper {
    boolean insertDept(Dept dept);
    Dept selectDept(Dept dept);
    List<Dept> selectAll();
}
