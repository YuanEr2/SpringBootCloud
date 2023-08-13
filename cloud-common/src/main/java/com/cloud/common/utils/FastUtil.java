package com.cloud.common.utils;

import org.springframework.stereotype.Component;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @BelongsProject: 0107day02
 * @BelongsPackage: com.cloud.config
 * @Author: RuanChaoChao
 * @CreateTime: 2023-02-01  08:52
 */
@Component
public class FastUtil {
    private static final Logger log = LoggerFactory.getLogger(FastUtil.class);

    @Resource
    private FastFileStorageClient storageClient ;

    /**
     * 上传文件
     */
    public String upload(MultipartFile multipartFile) throws Exception{
        String originalFilename = multipartFile.getOriginalFilename().
                substring(multipartFile.getOriginalFilename().
                        lastIndexOf(".") + 1);
        StorePath storePath = this.storageClient.uploadImageAndCrtThumbImage(
                multipartFile.getInputStream(),
                multipartFile.getSize(),originalFilename , null);
        return storePath.getFullPath() ;
    }
    /**
     * 删除文件
     */
    public String deleteFile(String fileUrl) {
        if (StringUtils.isEmpty(fileUrl)) {
            log.info("fileUrl == >>文件路径为空...");
            return "文件路径不能为空";
        }
        try {
            StorePath storePath = StorePath.parseFromUrl(fileUrl);
            storageClient.deleteFile(storePath.getGroup(), storePath.getPath());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return "删除成功";
    }

}
