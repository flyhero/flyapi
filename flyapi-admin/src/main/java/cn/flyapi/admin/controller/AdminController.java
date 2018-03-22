package cn.flyapi.admin.controller;

import com.flyapi.core.base.BaseController;
import com.flyapi.core.constant.JSONResult;
import com.flyapi.core.util.AESUtil;
import com.flyapi.model.UcenterUser;
import com.flyapi.pojo.dto.AddNoticeDto;
import com.flyapi.service.api.HomepageApplyService;
import com.flyapi.service.api.SysNoticeService;
import com.flyapi.service.api.UserService;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    @Autowired
    private UserService userService;

    @GetMapping("go")
    public ModelAndView go(String html){
        mv.setViewName(html);
        return mv;
    }

    @PostMapping("login")
    @ResponseBody
    public JSONResult userLogin(UcenterUser user){

        if(userService.findUserByUsername(user.getUsername()) !=1){
            return JSONResult.error("用户名不存在",300,null);
        }
        user.setPassword(AESUtil.AESEncode(user.getPassword()));
        UcenterUser userLogin = userService.login(user);
        if(userLogin == null){
            return JSONResult.error("用户名或密码错误！",300,null);
        }

        userLogin.setPassword("");
        session.setAttribute("user",userLogin);

        return JSONResult.ok();
    }

    @GetMapping("/go/apply")
    public ModelAndView goApplyView(int status){
        mv.addObject("applyList",homepageApplyService.findListByStatus(status));
        mv.setViewName("apply");
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

    /**
     * 审核通过
     * @param applyId
     * @return
     */
    @PutMapping("apply/{applyId}/pass")
    @ResponseBody
    public JSONResult pass(@PathVariable Long applyId){
        return JSONResult.ok(homepageApplyService.pass(applyId));
    }

    /**
     * 审核不通过
     * @param applyId
     * @return
     */
    @PutMapping("apply/{applyId}/unpass")
    @ResponseBody
    public JSONResult unpass(@PathVariable Long applyId){
        return JSONResult.ok(homepageApplyService.unPass(applyId));
    }



    @PostMapping("admin/notice")
    @ResponseBody
    public JSONResult sendMsg(AddNoticeDto noticeDto){
        sysNoticeService.sendMsg(noticeDto);
        return JSONResult.ok();
    }
}
