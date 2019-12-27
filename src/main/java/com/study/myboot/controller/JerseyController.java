package com.study.myboot.controller;

import com.study.myboot.beans.UserBean;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @program: myboot
 * @description:测试jersey控制器
 * @author: ShiYulong
 * @create: 2019-12-27 13:43
 **/
@Component
@Path("/jersey")
public class JerseyController {
    @Path("/get")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public UserBean get(){
        UserBean userBean = new UserBean();
        userBean.setName("ylstone");
        userBean.setAge(30);
        return userBean;
    }
}
