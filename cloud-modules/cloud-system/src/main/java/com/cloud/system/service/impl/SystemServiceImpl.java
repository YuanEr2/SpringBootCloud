package com.cloud.system.service.impl;

import com.cloud.system.mapper.SystemMapper;
import com.cloud.system.service.SystemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: SpringBootCloud
 * @BelongsPackage: com.cloud.system.service.impl
 * @Author: RuanChaoChao
 * @CreateTime: 2023-08-13  12:09
 * @Description: //TODO
 * @Version: 1.0
 */
@Service
@AllArgsConstructor
public class SystemServiceImpl implements SystemService {
    private final SystemMapper systemMapper;
}
