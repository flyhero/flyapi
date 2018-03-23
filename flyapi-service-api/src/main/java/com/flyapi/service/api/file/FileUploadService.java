package com.flyapi.service.api.file;

import com.flyapi.core.enums.PathEnum;
import org.springframework.web.multipart.MultipartFile;

/**
 * Author: qfwang
 * Date: 2018-03-04 上午11:20
 */
public interface FileUploadService {
    /**
     * 文件上传
     * @param file 文件
     * @param userId 用户id
     * @param pathEnum 文件分类
     * @return
     */
    String upload(MultipartFile file, Long userId, PathEnum pathEnum);
}
