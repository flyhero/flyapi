package com.flyapi.web.controller;

import com.flyapi.core.base.BaseController;
import com.flyapi.core.constant.JSONResult;
import com.flyapi.model.SettingCarousel;
import com.flyapi.service.api.SettingCarouselService;
import com.flyapi.service.api.SettingStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Author: qfwang
 * Date: 2017-11-18 上午11:52
 */
@Controller
@RequestMapping("setting")
public class SettingController extends BaseController{

    @Autowired
    private SettingCarouselService settingCarouselService;
    @Autowired
    private SettingStoreService settingStoreService;

    /**
     *
     * @title: findCarouselList
     * @author flyhero <http://www.iflyapi.cn>
     * @params []
     * @return com.flyapi.core.constant.JSONResult
     * @date 2017/11/18 下午12:01
     */
    @RequestMapping("carousel")
    @ResponseBody
    public JSONResult findCarouselList(){
        List<SettingCarousel> list = null;
        try {
            list = settingCarouselService.findList();
        } catch (Exception e) {
            return JSONResult.error(e);
        }
        return JSONResult.ok(list);
    }
}
