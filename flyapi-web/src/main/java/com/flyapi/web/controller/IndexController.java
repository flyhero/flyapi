package com.flyapi.web.controller;

import com.flyapi.core.base.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Author: qfwang
 * Date: 2017-12-26 下午8:33
 */
public class IndexController extends BaseController{

    @RequestMapping("/")
    public ModelAndView index(){
        mv.setViewName("index");
        return mv;
    }
}
