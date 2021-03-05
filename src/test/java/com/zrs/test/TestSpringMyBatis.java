package com.zrs.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zrs.bean.Emp;
import com.zrs.service.EmpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestSpringMyBatis {

    @Resource
    EmpService empService;

    @Test
    public void test1(){
        List<Emp> emps = empService.getEmps();
        for (Emp emp : emps) {
            System.out.println(emp);
        }
    }

    @Test
    public void testAdd(){
        Emp e=new Emp();
        e.setName("测试");
        e.setEmail("35353344@qq.com");
        int count = empService.addEmp(e);
        System.out.println(count);
    }

    @Test
    public void testDeleteById(){
        boolean b = empService.removeById(2);
        System.out.println(b);
    }

    @Test
    public void testFindById(){
        Emp emp = empService.getById(3);
        System.out.println(emp);
    }

    @Test
    public void testPage(){
        //分页条件
        Page<Emp> page = new Page<Emp>(2,3);
        //封装条件
        QueryWrapper<Emp> wrapper=new QueryWrapper<Emp>();
        //分页
        IPage<Emp> p = empService.page(page, wrapper);
        System.out.println("===============获取分页相关的一些信息======================");
        System.out.println("总条数:" +p.getTotal());
        System.out.println("当前页码: "+  p.getCurrent());
        System.out.println("总页码:" + p.getPages());
        System.out.println("每页显示的条数:" + p.getSize());
        List<Emp> records = p.getRecords();
        for (Emp record : records) {
            System.out.println(record);
        }
    }

}
