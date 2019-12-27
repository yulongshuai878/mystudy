package com.study.myboot.config.jersey;

import com.study.myboot.controller.JerseyController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 * @program: myboot
 * @description:Jersey配置类
 * @author: ShiYulong
 * @create: 2019-12-27 13:41
 **/
@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        //构造函数，在这里注册需要使用的内容，（过滤器，拦截器，API等）
//        packages("com.study.myboot.controller");
        register(JerseyController.class);
    }
}
