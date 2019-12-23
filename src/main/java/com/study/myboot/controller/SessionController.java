package com.study.myboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: myboot
 * @description:
 * @author: ShiYulong
 * @create: 2019-12-23 21:09
 **/
@RestController
@RequestMapping("/session")
public class SessionController {
    @RequestMapping("put")
    public Map<String,Object> put(HttpServletRequest request){
        request.getSession().setAttribute("username", "admin");
        Map<String, Object> map = new HashMap<>();
        map.put("sessionId", request.getSession().getId());
        return map;
    }
    @RequestMapping(value = "get")
    public String get(HttpServletRequest request) {
        String userName = (String) request.getSession().getAttribute("username");
        return userName;
    }
}
