package com.iotek.biz;

import com.iotek.dao.EmpMapper;
import com.iotek.model.Emp;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/4/26.
 */
@Service
public class EmpServiceImpl implements EmpService {
    @Resource
    private EmpMapper empMapper;
    public boolean addEmp(Emp emp) {
        return empMapper.addEmp(emp);
    }

    public Emp selectUid(Emp emp) {
        return empMapper.selectUid(emp);
    }

    public List<Emp> selectAll() {
        return empMapper.selectAll();
    }

    public List<Emp> selectdeptid(Emp emp) {

        return empMapper.selectdeptid(emp);
    }

    public Emp login(Emp emp) {
        return empMapper.login(emp);
    }

    public Emp selectid(Emp emp) {
        return empMapper.selectid(emp);
    }

    public boolean updatedept(Emp emp) {
        return empMapper.updatedept(emp);
    }
}
