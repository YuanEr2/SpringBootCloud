package com.cloud.auth.controller;

import com.cloud.auth.service.AuthService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

/**
 * 鉴权控制类
 *
 * @BelongsProject: SpringBootCloud
 * @BelongsPackage: com.cloud.auth.controller
 * @Author: RuanChaoChao
 * @CreateTime: 2023-08-13  11:49
 * @Description: //TODO 鉴权控制类
 * @Version: 1.0
 */
@RestController
@AllArgsConstructor
@Log4j2
public class AuthController {
    private final AuthService authService;
}
