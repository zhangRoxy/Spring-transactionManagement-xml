package com.zrs.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zrs.bean.Emp;

import java.util.List;


public interface EmpService extends IService<Emp> {

   List<Emp> getEmps();

    int addEmp(Emp emp);
}
