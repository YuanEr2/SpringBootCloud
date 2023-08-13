package com.cloud.common.config;

import com.github.tobato.fastdfs.FdfsClientConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Import;
import org.springframework.jmx.support.RegistrationPolicy;

/**
 * @BelongsProject: demo02
 * @BelongsPackage: com.cloud.config
 * @Author: RuanChaoChao
 * @CreateTime: 2022-12-16  14:37
 */
@Configuration
// 解决 jmx 重复注册 bean 的问题
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
public class FastConfig {

}
