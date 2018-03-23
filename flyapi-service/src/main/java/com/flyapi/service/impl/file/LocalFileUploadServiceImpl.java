package com.flyapi.service.impl.file;

import com.flyapi.core.constant.Constant;
import com.flyapi.core.enums.PathEnum;
import com.flyapi.service.api.file.FileUploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author: qfwang
 * Date: 2018-03-04 上午11:27
 */
@Service
public class LocalFileUploadServiceImpl implements FileUploadService{

    @Override
    public String upload(MultipartFile file,Long userId, PathEnum pathEnum) {

        String folderPath = "/flyapi"+File.separator+userId+File.separator+pathEnum.getPath()+File.separator;
        File folder = new File(folderPath);
        if(!folder.exists()){
            folder.mkdirs();
        }

        String str = (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date());
        String picture=file.getOriginalFilename();
        String[] s=picture.split("\\.");
        str=str+"."+s[1];

        String path=folderPath+str;
        File newFile=new File(path);
        try {
            //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
            file.transferTo(newFile);
        } catch (IOException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
        return Constant.FILE_BASE_PATH+path;
    }
}
