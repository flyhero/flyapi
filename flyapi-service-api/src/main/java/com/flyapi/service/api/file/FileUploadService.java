package com.flyapi.service.api.file;

import org.springframework.web.multipart.MultipartFile;

/**
 * Author: qfwang
 * Date: 2018-03-04 上午11:20
 */
public interface FileUploadService {
    String upload(MultipartFile file,Long userId);
}
