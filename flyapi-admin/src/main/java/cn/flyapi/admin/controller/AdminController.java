package cn.flyapi.admin.controller;

import com.flyapi.core.base.BaseController;
import com.flyapi.core.constant.JSONResult;
import com.flyapi.service.api.HomepageApplyService;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Author: qfwang
 * Date: 2018-03-14 下午11:23
 */
@Controller
public class AdminController extends BaseController{

    @Autowired
    private HomepageApplyService homepageApplyService;
    @GetMapping("go")
    public ModelAndView go(String html){
        mv.setViewName(html);
        return mv;
    }
    /**
     * 获取最近100条的首页申请
     * @title: findApply
     * @author flyhero <http://www.iflyapi.cn>
     * @param pageSize
     * @param pageNum
     * @param status
     * @return com.flyapi.core.constant.JSONResult
     * @date 2018/3/19 下午11:29
     */
    @GetMapping("applys")
    @ResponseBody
    public JSONResult findApply(int pageSize, int pageNum, int status){
        return JSONResult.ok(homepageApplyService.findListByExample(pageSize,pageNum,status));
    }
}
