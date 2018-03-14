package cn.flyapi.admin.controller;

import com.flyapi.core.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Author: qfwang
 * Date: 2018-03-14 下午11:23
 */
@Controller
public class AdminController extends BaseController{

    @GetMapping("go")
    public ModelAndView go(String html){
        mv.setViewName(html);
        return mv;
    }
}
