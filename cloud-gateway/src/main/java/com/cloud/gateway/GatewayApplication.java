package com.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 网关启动类
 * @BelongsProject: SpringBootCloud
 * @BelongsPackage: com.cloud.gateway
 * @Author: RuanChaoChao
 * @CreateTime: 2023-08-13  11:57
 * @Description: //TODO 网关启动类
 * @Version: 1.0
 */
@SpringBootApplication
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class,args);
    }
}
