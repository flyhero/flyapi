package com.flyapi.web.controller;

import com.flyapi.core.base.BaseController;
import com.flyapi.service.api.OpenSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Author: qfwang
 * Date: 2018-03-02 下午1:33
 */
@Controller
public class OpenSourceSocialController extends BaseController{
    @Autowired
    private OpenSourceService openSourceService;


    @GetMapping("user/os")
    public ModelAndView osso(){
        mv.setViewName("user/os-social");
        return mv;
    }
}
