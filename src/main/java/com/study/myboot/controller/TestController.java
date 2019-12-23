package com.study.myboot.controller;

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
public class TestController {
    @RequestMapping("test1")
    public String test(){
        String str = "hello world from myboot";
        str += " update by devtools2";
        return str;
    }
}
