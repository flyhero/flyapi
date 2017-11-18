package com.flyapi.service.impl;

import com.flyapi.core.base.BaseServiceImpl;
import com.flyapi.dao.SettingCarouselMapper;
import com.flyapi.model.SettingCarousel;
import com.flyapi.service.api.SettingCarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * author: flyhero
 * Date: 2017/11/18 0009 下午 1:58
 */
@Service
@Transactional
public class SettingCarouselServiceImpl extends BaseServiceImpl<SettingCarousel,SettingCarouselMapper> implements SettingCarouselService {
    @Autowired
    private SettingCarouselMapper settingCarouselMapper;

    public List<SettingCarousel> findList() {
        return settingCarouselMapper.findList();
    }
}
