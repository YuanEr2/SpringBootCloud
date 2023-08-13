package com.cloud.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 鉴权启动类
 * @BelongsProject: SpringBootCloud
 * @BelongsPackage: com.cloud.auth
 * @Author: RuanChaoChao
 * @CreateTime: 2023-08-13  11:47
 * @Description: //TODO 鉴权启动类
 * @Version: 1.0
 */
@SpringBootApplication
public class AuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class,args);
    }
}
