package com.flyapi.web.controller;

import com.alibaba.fastjson.JSON;
import com.flyapi.core.base.BaseController;
import com.flyapi.core.constant.JSONResult;
import com.flyapi.model.SettingStore;
import com.flyapi.model.UcenterUser;
import com.flyapi.service.api.SettingStoreService;
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
public class QiniuController extends BaseController {

    @Autowired
    private SettingStoreService settingStoreService;

    /**
     * 上传图片到七牛
     *
     * @return com.flyapi.core.constant.JSONResult
     * @title: uploadImage
     * @author flyhero <http://www.iflyapi.cn>
     * @params [file]
     * @date 2017/11/16 下午1:59
     */
    @PostMapping("upload")
    @ResponseBody
    public JSONResult uploadImage(@RequestParam(value = "editormd-image-file", required = false) MultipartFile file) {


        String accessKey = "";
        String secretKey = "";
        String bucket = "";
        Long userId = 1000000L;
        String domain = "";

        UcenterUser ucenterUser = (UcenterUser) session.getAttribute("user");
        //SettingStore store = settingStoreService.selectByPrimaryKey(ucenterUser.getUserId());
        SettingStore store = new SettingStore();
        store.setVip(1);
        if (store != null) {
            if(store.getVip() != 0){ //已赞助
                 accessKey = "vDuNp0Z4WtB2boJeLQ_mNXxcCdjnTaUeJ4yWOsWT";
                 secretKey = "AEbH11WApJIzQtLag7FouMKZNWS3oeJZX16TYUoD";
                 bucket = "flyhero";
                 userId = 1000000L;
                 domain = "";
            }else {
                if(!StringUtils.isEmpty(store.getAk()) && !StringUtils.isEmpty(store.getSk())
                        && !StringUtils.isEmpty(store.getDomain()) && !StringUtils.isEmpty(store.getBucket())){
                    domain = store.getDomain();
                    accessKey = store.getAk();
                    secretKey = store.getSk();
                    bucket = store.getBucket();
                    userId = ucenterUser.getUserId();
                }else {
                    return JSONResult.error("请设置图片存储或赞助",401,"");
                }
            }
        }else {
            return JSONResult.error("未知错误，请联系管理员",401,"");
        }
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone0());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传

        System.out.println(file.getOriginalFilename());
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = userId +"/"+ file.getOriginalFilename();
        try {
            byte[] uploadBytes = file.getBytes();
            ByteArrayInputStream byteInputStream = new ByteArrayInputStream(uploadBytes);
            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucket);
            try {
                Response response = uploadManager.put(byteInputStream, key, upToken, null, null);
                //解析上传成功的结果
                System.out.println("上传成功的结果:" + response.bodyString());
                DefaultPutRet putRet = JSON.parseObject(response.bodyString(), DefaultPutRet.class);
                System.out.println(putRet.key);
                System.out.println(putRet.hash);
                System.out.println("访问地址："+domain+"/"+key);
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
