package com.flyapi.web.controller;

import com.alibaba.fastjson.JSON;
import com.flyapi.core.base.BaseController;
import com.flyapi.core.constant.JSONResult;
import com.flyapi.core.constant.TipsEnum;
import com.flyapi.core.id.SnowflakeIdWorker;
import com.flyapi.model.OpenSource;
import com.flyapi.model.UcenterSocial;
import com.flyapi.model.UcenterUser;
import com.flyapi.service.api.OpenSourceService;
import com.flyapi.service.api.SocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
    private SocialService socialService;
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

    /**
     * 删除开源项目
     * @title: removeOS
     * @param osId
     * @return com.flyapi.core.constant.JSONResult
     * @date 2018/3/7 上午12:27
     */
    @DeleteMapping("os/{osId}")
    @ResponseBody
    public JSONResult removeOS(@PathVariable Long osId) {

        UcenterUser user = (UcenterUser) currentUser();
        if(null == user){
            return JSONResult.error();
        }
        openSourceService.removeByOsId(osId,user.getUserId());
        return JSONResult.ok();
    }

    /**
     * 保存或更新社交
     * @title: saveOrUpdateSocial
     * @param socialList
     * @return com.flyapi.core.constant.JSONResult
     * @date 2018/3/11 下午12:34
     */
    @PostMapping("social")
    @ResponseBody
    public JSONResult saveOrUpdateSocial(@RequestBody String socialList) {

        UcenterUser user = (UcenterUser) currentUser();
        if (user == null) {
            return JSONResult.error(TipsEnum.NOT_LOGIN);
        }
        List<UcenterSocial> socials = null;
        try {
            socials = JSON.parseArray(socialList, UcenterSocial.class);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        socialService.saveOrUpdate(socials,user.getUserId());
        return JSONResult.ok();
    }
}
