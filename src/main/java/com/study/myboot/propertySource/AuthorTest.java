package com.study.myboot.propertySource;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @program: myboot
 * @description:
 * @author: ShiYulong
 * @create: 2019-12-23 15:39
 **/
@Data
@Component
@ConfigurationProperties(prefix = "author")
@PropertySource(value = {"classpath:authorSetting.properties"},
        ignoreResourceNotFound = false, encoding = "UTF-8", name = "authorSetting.properties")
public class AuthorTest {
    private String name;
    private int age;
}
