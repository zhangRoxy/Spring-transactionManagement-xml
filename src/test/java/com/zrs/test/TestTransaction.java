package com.zrs.test;

import com.zrs.bean.Account;
import com.zrs.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestTransaction {

    @Resource
    AccountService accountService;

    @Test
    public void testAdd(){
        Account a1=new Account("老何",10000.0);
        Account a2=new Account("老刘",10000.0);
        List<Account> list=new ArrayList<Account>();
        list.add(a1);
        list.add(a2);
        boolean b = accountService.saveBatch(list);
        System.out.println(b);
    }

    @Test
    public void testTransferMoney(){
        int count = accountService.transferMoney("老何", "老刘", 100);
        System.out.println(count);
    }


}
