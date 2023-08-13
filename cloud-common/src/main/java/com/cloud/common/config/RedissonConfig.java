package com.cloud.common.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * RedissonConfig-布式锁配置
 * @Description: TODO RedissonConfig-布式锁配置
 * @Auther: RuanChaoChao
 * @Date: 2023/5/26 23:34
 */

@Configuration
public class RedissonConfig {

    @Bean(destroyMethod="shutdown") // 服务停止后调用 shutdown 方法。
    public RedissonClient redisson() throws IOException {
        System.out.println("配置类初始加载......");
        // 1.创建配置
        Config config = new Config();
        // 集群模式
        // config.useClusterServers().addNodeAddress("127.0.0.1:6379", "127.0.0.1:6378");
        // 2.根据 Config 创建出 RedissonClient 实例。
        config.useSingleServer().setAddress("redis://yunjisuan:6379");
        return Redisson.create(config);
    }

}
