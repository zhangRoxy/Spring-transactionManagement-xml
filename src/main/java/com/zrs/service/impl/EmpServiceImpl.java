package com.zrs.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zrs.bean.Emp;
import com.zrs.mapper.EmpMapper;
import com.zrs.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements EmpService {

    @Resource
    EmpMapper empMapper;

    public List<Emp> getEmps() {
        return empMapper.getEmps();
    }

    public int addEmp(Emp emp) {
        return empMapper.addEmp(emp);
    }


}
