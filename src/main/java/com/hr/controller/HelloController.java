package com.hr.controller;


import com.hr.pojo.User;
import com.hr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;

@RestController
public class HelloController {

//    //读取激活的yml配置文件属性
//    @Value("${hr.url}")
//    private String hrUrl;
//    @Value("${baidu.url}")
//    private String baiduUrl;
//
//    @Autowired
//    private DataSource dataSource;

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public User queryById(@PathVariable("id") Long id) {
        User user = userService.queryById(id);
        return user;
    }


    @RequestMapping("/hello")
    public String hello() {
//        System.out.println(dataSource);
//        System.out.println(hrUrl);
//        System.out.println(baiduUrl);
        return "hello springboot";
    }
}
