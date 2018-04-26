package com.iotek.biz;

import com.iotek.dao.DeptMapper;
import com.iotek.model.Dept;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/4/25.
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Resource
    private DeptMapper deptMapper;
    public boolean insertDept(Dept dept) {
        return deptMapper.insertDept(dept);
    }

    public Dept selectDept(Dept dept) {
        return deptMapper.selectDept(dept);
    }

    public List<Dept> selectAll() {
        return deptMapper.selectAll();
    }
}
