package cn.iflyapi.blog.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author flyhero
 * @date 2018-12-22 5:59 PM
 */
public interface IFileService {

    String upload(MultipartFile file, Long userId);
}
