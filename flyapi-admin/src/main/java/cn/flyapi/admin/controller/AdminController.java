package cn.flyapi.admin.controller;

import com.flyapi.core.base.BaseController;
import com.flyapi.core.constant.JSONResult;
import com.flyapi.pojo.dto.AddNoticeDto;
import com.flyapi.service.api.HomepageApplyService;
import com.flyapi.service.api.SysNoticeService;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @Autowired
    private SysNoticeService sysNoticeService;

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
    @GetMapping("admin/applys")
    @ResponseBody
    public JSONResult findApply(int pageSize, int pageNum, int status){
        return JSONResult.ok(homepageApplyService.findListByExample(pageSize,pageNum,status));
    }

    @PostMapping("admin/notice")
    @ResponseBody
    public JSONResult sendMsg(AddNoticeDto noticeDto){
        sysNoticeService.sendMsg(noticeDto);
        return JSONResult.ok();
    }
}
