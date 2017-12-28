package com.flyapi.web.controller;

import com.flyapi.core.base.BaseController;
import com.flyapi.core.constant.JSONResult;
import com.flyapi.model.SettingCarousel;
import com.flyapi.service.api.SettingCarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Author: qfwang
 * Date: 2017-12-26 下午8:33
 */
@Controller
public class IndexController extends BaseController{

    @Autowired
    private SettingCarouselService settingCarouselService;

    @RequestMapping("index.html")
    public ModelAndView index(){

        List<SettingCarousel> list = null;
        try {
            list = settingCarouselService.findList();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        mv.setViewName("index");
        mv.addObject("carouselList",list);
        return mv;
    }
}
