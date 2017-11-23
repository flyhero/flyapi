package com.flyapi.web.controller;

import com.flyapi.core.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * User: qfwang
 * Date: 2017/6/16
 * Time: 下午4:52
 */
@Controller
@RequestMapping("forward")
public class ForwardController extends BaseController{

    /**
     * 跳转到某处
     * Title: go
     * params: [html]
     * return: org.springframework.web.servlet.ModelAndView
     * author: flyhero(http://flyhero.top)
     * date: 2017/6/16 0016 下午 5:56
     */
    @RequestMapping("go")
    public ModelAndView go(String html){
        mv.setViewName(html);
        return mv;
    }
}
