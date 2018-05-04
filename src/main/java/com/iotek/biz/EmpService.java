package com.iotek.biz;

import com.iotek.model.Emp;

import java.util.List;

/**
 * Created by Administrator on 2018/4/26.
 */
public interface EmpService {
    boolean addEmp(Emp emp);
    Emp selectUid(Emp emp);
    List<Emp> selectAll();
    List<Emp> selectdeptid(Emp emp);
    Emp login(Emp emp);
    Emp selectid(Emp emp);
    boolean updatedept(Emp emp);

}
