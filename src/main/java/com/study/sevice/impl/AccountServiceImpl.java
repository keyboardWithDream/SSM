package com.study.sevice.impl;

import com.study.dao.IAccountDao;
import com.study.domain.Account;
import com.study.sevice.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * @Author Harlan
 * @Date 2020/9/12
 */
@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    private Integer res = new Random().nextInt(10);

    @Override
    public List<Account> findAll() {
        System.out.println("业务层: findAll");
        return accountDao.findAll();
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("业务层: saveAccount");
        accountDao.saveAccount(account);
    }

    @Override
    public String guess(Integer num) {
        System.out.println(res);
        if (num > res){
            return "bigger";
        }else if (num < res){
            return "smaller";
        }else {
            res = new Random().nextInt(10);
            return "right";
        }
    }
}
