package com.flyapi.core.enums;

import com.flyapi.core.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: qfwang
 * Date: 2018-03-10 下午11:44
 */
public class ImagePath {

    private static List<String> imgList = new ArrayList<>();

    static {
        imgList.add("/flyapi/base/jinshi.png");
        imgList.add("/flyapi/base/wuya.png");
        imgList.add("/flyapi/base/duwa.png");
    }

    public static String randomPath(){
        int num = RandomUtil.randomInt(0,imgList.size());
        return imgList.get(num);
    }

    public List<String> getImgList() {
        return imgList;
    }

    public void setImgList(List<String> imgList) {
        this.imgList = imgList;
    }
}
