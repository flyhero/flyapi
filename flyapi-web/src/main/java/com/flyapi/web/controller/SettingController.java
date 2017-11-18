package com.flyapi.web.controller;

import com.flyapi.core.base.BaseController;
import com.flyapi.service.api.SettingCarouselService;
import com.flyapi.service.api.SettingStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
