package com.study.myboot.controller;

import com.study.myboot.propertySource.AuthorBean;
import com.study.myboot.propertySource.AuthorTest;
import com.study.myboot.beans.UserBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: myboot
 * @description:
 * @author: ShiYulong
 * @create: 2019-12-23 11:40
 **/
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {
    @Autowired
    private AuthorBean authorBean;
    @Autowired
    private AuthorTest authorTest;
    @RequestMapping("test1")
    public String test(){
        String str = "hello world from myboot";
        str += " update by devtools2";
        UserBean userBean = new UserBean();
        userBean.setName("YLsTone");
        userBean.setAge(30);
        String logger = userBean.toString();
        log.info("doing get by {}",logger);
        return str;
    }
    @RequestMapping("test2")
    public String test2(){
        log.debug("author is {}",authorBean.getName());
        return authorBean.toString();
    }
    @RequestMapping("test3")
    public String test3(){
        return authorTest.toString();
    }
    @RequestMapping("test4")
    public UserBean get(){
        UserBean userBean = new UserBean();
        userBean.setName("ylstone");
        userBean.setAge(30);
        return userBean;
    }
}
