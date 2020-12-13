package com.hr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
//扫描mybatis所有的业务mapper接口, 不用每个mapper接口上都添加@Mapper注解了
//@MapperScan(basePackages = "com.hr.mapper")
//通用MapperScan:  tk.mybatis.spring.annotation.MapperScan;
@MapperScan(basePackages = "com.hr.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
