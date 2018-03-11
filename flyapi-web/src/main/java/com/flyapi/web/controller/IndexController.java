package com.flyapi.web.controller;

import com.flyapi.core.base.BaseController;
import com.flyapi.core.constant.JSONResult;
import com.flyapi.core.enums.ImagePath;
import com.flyapi.core.util.ImageUtil;
import com.flyapi.model.CmsArticle;
import com.flyapi.model.CmsSubject;
import com.flyapi.model.SettingCarousel;
import com.flyapi.model.UcenterUser;
import com.flyapi.pojo.vo.TopVo;
import com.flyapi.service.api.ArticleService;
import com.flyapi.service.api.SettingCarouselService;
import com.flyapi.service.api.SubjectService;
import com.flyapi.service.api.UserFameService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: qfwang
 * Date: 2017-12-26 下午8:33
 */
@Controller
public class IndexController extends BaseController{

    private Logger logger = LogManager.getLogger(ArticleController.class);

    @Autowired
    private SettingCarouselService settingCarouselService;

    @Autowired
    private ArticleService articleService;
    @Autowired
    private UserFameService userFameService;


    @RequestMapping("index.html")
    public ModelAndView index(){

        List<SettingCarousel> carouselList = null;
        try {
            carouselList = settingCarouselService.findList();
        } catch (Exception e) {
            System.out.println(e.toString());
        }


        List<CmsArticle> updateList =null;
        List<CmsArticle> hotList =null;
        List<TopVo> topList =null;

        try{
            UcenterUser user = (UcenterUser)currentUser();
            updateList=articleService.findLastUpdateOrHotArticles(1);
            hotList=articleService.findLastUpdateOrHotArticles(2);
            topList=userFameService.findSumGroupByUserId();

        }catch (Exception e){
            logger.error(e.toString());
        }
        mv.setViewName("index");
        mv.addObject("carouselList",carouselList);
        mv.addObject("updateList",updateList);
        mv.addObject("hotList",hotList);
        mv.addObject("topList",topList);
        return mv;
    }

    @GetMapping("terms-of-service.html")
    public ModelAndView termsOfService(){
        mv.setViewName("terms-of-service");
        return mv;
    }
    /**
     * 自动生成图片
     * @title: createImg
     * @param subjectTitle
     * @return com.flyapi.core.constant.JSONResult
     * @date 2018/3/10 下午11:40
     */
    @GetMapping("image")
    public JSONResult createImg(String subjectTitle){
        UcenterUser user = (UcenterUser)currentUser();
        String pathName = "";
        ImageUtil.createImage(subjectTitle,user.getNickName(),new File(ImagePath.randomPath()),new File(pathName));
        return JSONResult.ok();
    }
}
