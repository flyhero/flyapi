package com.flyapi.service.impl.file;

import com.alibaba.fastjson.JSON;
import com.flyapi.core.enums.PathEnum;
import com.flyapi.core.exception.UploadException;
import com.flyapi.dao.SettingStoreMapper;
import com.flyapi.model.SettingStore;
import com.flyapi.service.api.file.FileUploadService;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Author: qfwang
 * Date: 2018-03-04 上午11:26
 */
@Service
public class QiniuFileUploadServiceImpl implements FileUploadService{

    @Autowired
    private SettingStoreMapper settingStoreMapper;

    @Override
    public String upload(MultipartFile file,Long userId, PathEnum pathEnum) {

        String accessKey = "";
        String secretKey = "";
        String bucket = "";

        String domain = "";
        String imgUrl = "";

        SettingStore store = settingStoreMapper.selectByPrimaryKey(userId);
        if (store != null) {
            if (store.getVip() == 0) {
                throw new UploadException("请设置图片存储或赞助");
            } else {
                domain = store.getDomain();
                accessKey = store.getAk();
                secretKey = store.getSk();
                bucket = store.getBucket();
            }
        } else {
            throw new UploadException("未知错误，请联系管理员");
        }
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone0());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传

        System.out.println(file.getOriginalFilename());
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = userId + "/" + file.getOriginalFilename();
        try {
            byte[] uploadBytes = file.getBytes();
            ByteArrayInputStream byteInputStream = new ByteArrayInputStream(uploadBytes);
            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucket);
            try {
                Response response = uploadManager.put(byteInputStream, key, upToken, null, null);
                //解析上传成功的结果
                DefaultPutRet putRet = JSON.parseObject(response.bodyString(), DefaultPutRet.class);
                System.out.println(putRet.key);
                System.out.println(putRet.hash);
                imgUrl = domain + "/" + key;
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
        return imgUrl;
    }
}
