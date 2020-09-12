package com.study.sevice;

import com.study.domain.Account;

import java.util.List;

/**
 * @Author Harlan
 * @Date 2020/9/12
 */
public interface IAccountService {

    /**
     * 查询所有账户
     * @return 账户列表
     */
    List<Account> findAll();

    /**
     * 保存账户
     * @param account 账户信息
     */
    void saveAccount(Account account);
}
