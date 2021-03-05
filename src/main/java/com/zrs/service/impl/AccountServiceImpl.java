package com.zrs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zrs.bean.Account;
import com.zrs.mapper.AccountMapper;
import com.zrs.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

    @Resource
    AccountMapper accountMapper;

    /**
     * 转账方法---这个业务方法需要在事务中运行！！！！
     * @param fromName
     * @param toName
     * @param money
     * @return
     */
    public int transferMoney(String fromName, String toName, double money) {

        //第一账户的钱减少啦！
        Account account1 = accountMapper.selectOne(new QueryWrapper<Account>().eq("username", fromName));
        account1.setMoney(account1.getMoney()-money);
        int count1 = accountMapper.updateById(account1);

        //模拟异常
        //int i=10000/0;

        //第二账户的钱增加啦！
        Account account2 = accountMapper.selectOne(new QueryWrapper<Account>().eq("username", toName));
        account2.setMoney(account2.getMoney()+money);
        int count2 = accountMapper.updateById(account2);

        return count1+count2;
    }
}
