package cn.iflyapi.blog.controller;

import cn.iflyapi.blog.model.JSONResult;
import cn.iflyapi.blog.service.IFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author flyhero
 * @date 2018-12-22 6:48 PM
 */
@Api(value = "FileController", tags = "文件接口")
@RestController
public class FileController extends BaseController {

    @Autowired
    @Qualifier("qiniu")
    private IFileService fileService;

    @ApiOperation("文件上传")
    @PostMapping("files")
    public JSONResult upload(MultipartFile file) {
        return JSONResult.ok(fileService.upload(file, getUserId()));
    }
}
