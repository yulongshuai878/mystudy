package com.study.myboot.beans;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @program: myboot
 * @description:
 * @author: ShiYulong
 * @create: 2019-12-23 15:17
 **/
@Data
@Component
@PropertySource(value = {"classpath:authorSetting.properties"},
        ignoreResourceNotFound = false, encoding = "UTF-8", name = "authorSetting.properties")
public class AuthorBean {
    @Value("${author.name}")
    private String name;
    @Value("${author.age}")
    private int age;
}
