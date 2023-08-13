package com.cloud.system.controller;

import com.cloud.system.service.SystemService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统控制类
 *
 * @BelongsProject: SpringBootCloud
 * @BelongsPackage: com.cloud.system.controller
 * @Author: RuanChaoChao
 * @CreateTime: 2023-08-13  12:08
 * @Description: //TODO 系统控制类
 * @Version: 1.0
 */
@RestController
@AllArgsConstructor
@Log4j2
public class SystemController {
    private final SystemService systemService;
}
