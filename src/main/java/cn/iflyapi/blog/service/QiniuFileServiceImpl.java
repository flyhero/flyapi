package cn.iflyapi.blog.service;

import cn.iflyapi.blog.dao.StoreMapper;
import cn.iflyapi.blog.dao.UserFileMapper;
import cn.iflyapi.blog.dao.custom.FileCustomMapper;
import cn.iflyapi.blog.entity.Store;
import cn.iflyapi.blog.entity.UserFile;
import cn.iflyapi.blog.enums.CodeMsgEnum;
import cn.iflyapi.blog.exception.FlyapiException;
import cn.iflyapi.blog.util.RandomUtils;
import cn.iflyapi.blog.util.SnowflakeIdWorker;
import com.alibaba.fastjson.JSON;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @author flyhero
 * @date 2018-12-22 6:02 PM
 */
@Service("qiniu")
public class QiniuFileServiceImpl implements IFileService {

    public static final int LIMIT_STORE = 100;
    @Autowired
    private StoreMapper storeMapper;

    @Autowired
    private SnowflakeIdWorker idWorker;

    @Autowired
    private UserFileMapper userFileMapper;

    @Autowired
    private FileCustomMapper fileCustomMapper;

    @Transactional
    @Override
    public String upload(MultipartFile file, Long userId) {

        String accessKey;
        String secretKey;
        String bucket;

        String domain;
        String imgUrl = "";

        Store store = storeMapper.selectByPrimaryKey(userId);
        if (store != null && !store.getIsDelete()) {
            if (store.getIsTry()) {
                long size = fileCustomMapper.sumFileSize(userId) / 1048576;
                if (size > LIMIT_STORE) {
                    fileCustomMapper.endTry(userId);
                    throw new FlyapiException(CodeMsgEnum.IMG_FILE_ALREADY_100M);
                }

            } else {
                if (store.getVip() == 0) {
                    throw new FlyapiException(CodeMsgEnum.IMG_BED_MUST_BE_SET);
                }
            }
            domain = store.getDomain();
            accessKey = store.getAk();
            secretKey = store.getSk();
            bucket = store.getBucket();

        } else {
            throw new FlyapiException(CodeMsgEnum.IMG_BED_MUST_BE_SET);
        }
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone0());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传

        String fileName = RandomUtils.randomLowStr(6) + file.getOriginalFilename();
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = userId + "/" + fileName;
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
        UserFile userFile = new UserFile();
        userFile.setFileId(idWorker.nextId());
        userFile.setFileName(fileName);
        userFile.setFileSize(file.getSize());
        userFileMapper.insertSelective(userFile);
        return imgUrl;
    }
}
