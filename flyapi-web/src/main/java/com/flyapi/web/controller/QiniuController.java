package com.flyapi.web.controller;

import com.alibaba.fastjson.JSON;
import com.flyapi.core.constant.JSONResult;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * 七牛云存储
 * author: flyhero
 * Date: 2017/6/21 0021 下午 6:47
 */
@Controller
@RequestMapping("qiniu")
public class QiniuController {

    /**
     * 上传图片到七牛
     * @title: uploadImage
     * @author flyhero <http://www.iflyapi.cn>
     * @params [file]
     * @return com.flyapi.core.constant.JSONResult
     * @date 2017/11/16 下午1:59
     */
    @PostMapping("upload")
    @ResponseBody
    public JSONResult uploadImage( @RequestParam(value = "editormd-image-file", required = false) MultipartFile file){
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone0());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传
        String accessKey = "vDuNp0Z4WtB2boJeLQ_mNXxcCdjnTaUeJ4yWOsWT";
        String secretKey = "AEbH11WApJIzQtLag7FouMKZNWS3oeJZX16TYUoD";
        String bucket = "flyapi";
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = null;
        try {
            byte[] uploadBytes = file.getBytes();
            ByteArrayInputStream byteInputStream=new ByteArrayInputStream(uploadBytes);
            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucket);
            try {
                Response response = uploadManager.put(byteInputStream,key,upToken,null, null);
                //解析上传成功的结果
                System.out.println("上传成功的结果:"+response.bodyString());
                DefaultPutRet putRet = JSON.parseObject(response.bodyString(), DefaultPutRet.class);
                System.out.println(putRet.key);
                System.out.println(putRet.hash);
            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    //ignore
                }
            }
        } catch (UnsupportedEncodingException ex) {
            //ignore
        } catch (IOException e) {
            e.printStackTrace();
        }
        return JSONResult.ok();
    }

    public static void main(String[] args) {

    }
}
