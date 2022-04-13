package com.lilei.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lilei.entity.Dept;
import com.lilei.mapper.DeptMapper;
import com.lilei.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("deptService")
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public Dept get(Integer deptNo) {
        QueryWrapper<Dept> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("dept_no",deptNo);
        return deptMapper.selectOne(queryWrapper);
    }

    @Override
    public List<Dept> selectAll() {
        QueryWrapper<Dept> queryWrapper = new QueryWrapper<>();
        return deptMapper.selectList(queryWrapper);
    }
}
