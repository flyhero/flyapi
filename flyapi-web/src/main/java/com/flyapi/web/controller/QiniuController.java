package com.flyapi.web.controller;

import com.alibaba.fastjson.JSON;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.flyapi.core.base.BaseController;
import com.flyapi.core.constant.JSONResult;
import com.flyapi.core.enums.PathEnum;
import com.flyapi.core.exception.UploadException;
import com.flyapi.model.SettingStore;
import com.flyapi.model.UcenterUser;
import com.flyapi.service.api.SettingStoreService;
import com.flyapi.service.impl.file.LocalFileUploadServiceImpl;
import com.flyapi.service.impl.file.QiniuFileUploadServiceImpl;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;

/**
 * 七牛云存储
 * author: flyhero
 * Date: 2017/6/21 0021 下午 6:47
 */
@RestController
public class QiniuController extends BaseController {

    @Autowired
    private SettingStoreService settingStoreService;

    @Autowired
    private QiniuFileUploadServiceImpl qiniuFileUploadService;
    @Autowired
    private LocalFileUploadServiceImpl localFileUploadService;
    /**
     * 上传图片到七牛
     *
     * @return com.flyapi.core.constant.JSONResult
     * @title: uploadImage
     * @author flyhero <http://www.iflyapi.cn>
     * @params [file]
     * @date 2017/11/16 下午1:59
     */
    @PostMapping("qiniu/upload")
    public JSONResult uploadImage(@RequestParam(value = "editormd-image-file", required = false) MultipartFile file) {
        UcenterUser user = (UcenterUser) currentUser();
        if (user == null) {
            return JSONResult.error();
        }
        String imgUrl = null;
        try {
            imgUrl = qiniuFileUploadService.upload(file, user.getUserId(),PathEnum.ARTICLE);
        } catch (Exception e) {

            return JSONResult.error("上传失败", 401, "");
        }
        return JSONResult.ok(imgUrl);
    }

    @PostMapping("qiniu/common/upload")
    public JSONResult commonUpload(@RequestParam(value = "file", required = true) MultipartFile file) {
        UcenterUser user = (UcenterUser) currentUser();
        if (user == null) {
            return JSONResult.error();
        }
        String imgUrl = null;
        try {
            imgUrl = qiniuFileUploadService.upload(file, user.getUserId(), PathEnum.ARTICLE);
        } catch (Exception e) {
            return JSONResult.error("上传失败", 401, "");
        }
        return JSONResult.ok(imgUrl);
    }
    /**
     * 上传到本地服务器
     * @title: localUpload
     * @param file
     * @return com.flyapi.core.constant.JSONResult
     * @date 2018/3/4 上午11:58
     */
    @PostMapping("local/upload")
    public JSONResult localUpload(@RequestParam(value = "file", required = true) CommonsMultipartFile file,int type) {

        UcenterUser user = (UcenterUser) currentUser();
        if (user == null) {
            return JSONResult.error();
        }
        String imgUrl = null;
        try {
            if(type != 0 && type == PathEnum.HEADER.getType()){
                imgUrl = localFileUploadService.upload(file, user.getUserId(),PathEnum.HEADER);
            }
            if(type != 0 && type == PathEnum.COVER.getType()){
                imgUrl = localFileUploadService.upload(file, user.getUserId(),PathEnum.COVER);
            }

        } catch (Exception e) {
            return JSONResult.error("上传失败", 401, "");
        }
        return JSONResult.ok(imgUrl);
    }

    public static void main(String[] args) {

    }
}
