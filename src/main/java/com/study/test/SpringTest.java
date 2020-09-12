package com.study.test;

import com.study.sevice.IAccountService;
import com.study.sevice.impl.AccountServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author Harlan
 * @Date 2020/9/12
 */
public class SpringTest {

    @Test
    public void run1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        IAccountService service = ac.getBean("accountService", AccountServiceImpl.class);
        service.findAll();
    }
}
