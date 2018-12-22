package cn.iflyapi.blog.controller;

import cn.iflyapi.blog.model.JSONResult;
import cn.iflyapi.blog.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author flyhero
 * @date 2018-12-22 6:48 PM
 */
@RestController
public class FileController extends BaseController {

    @Autowired
    @Qualifier("qiniu")
    private IFileService fileService;

    @PostMapping("files")
    public JSONResult upload(MultipartFile file) {
        return JSONResult.ok(fileService.upload(file, getUserId()));
    }
}
