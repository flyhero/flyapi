package com.flyapi.service.impl.file;

import com.flyapi.core.constant.Constant;
import com.flyapi.core.enums.PathEnum;
import com.flyapi.core.util.ImageUtil;
import com.flyapi.service.api.file.FileUploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Author: qfwang
 * Date: 2018-03-04 上午11:27
 */
@Service
public class LocalFileUploadServiceImpl implements FileUploadService{

    private static final Logger logger = LoggerFactory.getLogger(LocalFileUploadServiceImpl.class);
    @Override
    public String upload(MultipartFile file,Long userId, PathEnum pathEnum) {
        String folderPath = File.separator+userId+pathEnum.getPath()+File.separator;
        File folder = new File("/flyapi"+folderPath);
        if(!folder.exists()){
            boolean f = folder.mkdirs();
            changeFolderPermission(folder);
            logger.debug("创建文件夹：{},{}",folder,f);
        }

        String str = (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date());
        String picture=file.getOriginalFilename();
        String[] s=picture.split("\\.");
        str=str+"."+s[1];

        String path=folderPath+str;
        File newFile=new File(path);
        try {
            if(!newFile.exists()){
                newFile.createNewFile();
            }


            //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
            file.transferTo(newFile);
            changeFolderPermission(newFile);
        } catch (IOException e) {
            logger.error(e.toString());
        }
        return Constant.FILE_BASE_PATH+folderPath+str;
    }

    public final static void changeFolderPermission(File dirFile) {
        Set<PosixFilePermission> perms = new HashSet<PosixFilePermission>();
        perms.add(PosixFilePermission.OWNER_READ);
        perms.add(PosixFilePermission.OWNER_WRITE);
        perms.add(PosixFilePermission.OWNER_EXECUTE);
        //add group permissions
        perms.add(PosixFilePermission.GROUP_READ);
        perms.add(PosixFilePermission.GROUP_WRITE);
        perms.add(PosixFilePermission.GROUP_EXECUTE);
        //add others permissions
        perms.add(PosixFilePermission.OTHERS_READ);
        perms.add(PosixFilePermission.OTHERS_WRITE);
        perms.add(PosixFilePermission.OTHERS_EXECUTE);
        try {
            Path path = Paths.get(dirFile.getAbsolutePath());
            Files.setPosixFilePermissions(path, perms);
        } catch (IOException e) {
            logger.error("Change folder " + dirFile.getAbsolutePath() + " permission failed.");
        }
    }
}
