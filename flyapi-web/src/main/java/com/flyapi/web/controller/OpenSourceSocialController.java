package com.flyapi.web.controller;

import com.flyapi.core.base.BaseController;
import com.flyapi.core.constant.JSONResult;
import com.flyapi.core.constant.TipsEnum;
import com.flyapi.core.id.SnowflakeIdWorker;
import com.flyapi.model.OpenSource;
import com.flyapi.model.UcenterUser;
import com.flyapi.service.api.OpenSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Author: qfwang
 * Date: 2018-03-02 下午1:33
 */
@Controller
public class OpenSourceSocialController extends BaseController {
    @Autowired
    private OpenSourceService openSourceService;

    @Autowired
    private SnowflakeIdWorker snowflakeIdWorker;

    @GetMapping("user/os")
    public ModelAndView osso() {
        UcenterUser user = (UcenterUser) currentUser();
        List<OpenSource> openSourceList = openSourceService.findAll(user.getUserId());
        mv.setViewName("user/os-social");
        mv.addObject("openSourceList",openSourceList);
        return mv;
    }

    @PostMapping("os")
    @ResponseBody
    public JSONResult saveOrUpdateOS(OpenSource openSource) {
        UcenterUser user = (UcenterUser) currentUser();
        if (user == null) {
            return JSONResult.error(TipsEnum.NOT_LOGIN);
        }
        if (openSource.getOsId() == null) {
            openSource.setUserId(user.getUserId());
            openSource.setOsId(snowflakeIdWorker.nextId());
            openSourceService.insertSelective(openSource);
        } else {
            openSourceService.updateByPrimaryKeySelective(openSource);
        }
        return JSONResult.ok();
    }
}
