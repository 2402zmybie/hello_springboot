package com.hr.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
/**
 * ConfigurationProperties 从配置文件中读取配置型
 * prefix表示配置项的前缀
 * 配置项中的变量名必须要与前缀之后的配置项名称保持松散绑定
 */
@ConfigurationProperties(prefix = "jdbc")
public class JdbcProperties {

    private String driver;
    private String url;
    private String username;
    private String password;
}
