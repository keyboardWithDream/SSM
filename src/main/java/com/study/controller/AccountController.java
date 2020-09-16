package com.study.controller;

import com.study.domain.Account;
import com.study.sevice.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author Harlan
 * @Date 2020/9/12
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        System.out.println("表现层: findAll");
        List<Account> accounts = accountService.findAll();
        model.addAttribute("accounts", accounts);
        return "success";
    }

    @RequestMapping("/saveAccount")
    public String saveAccount(Account account){
        System.out.println(account);
        accountService.saveAccount(account);
        return "forward:/account/findAll";
    }

    @RequestMapping("/guess")
    public  @ResponseBody() String guess(Integer num){
        return accountService.guess(num);
    }
}
