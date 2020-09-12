package com.study.dao;

import com.study.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Harlan
 * @Date 2020/9/12
 */
@Repository
public interface IAccountDao {

    /**
     * 查询所有账户
     * @return 账户列表
     */
    @Select("select * from account")
    List<Account> findAll();

    /**
     * 保存账户
     * @param account 账户信息
     */
    @Insert("insert into account(name, money) values (#{name}, #{money})")
    void saveAccount(Account account);
}
