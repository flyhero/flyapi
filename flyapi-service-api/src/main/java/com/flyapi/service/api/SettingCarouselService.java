package com.flyapi.service.api;

import com.flyapi.core.base.BaseService;
import com.flyapi.model.SettingCarousel;
import com.flyapi.model.SettingStore;

import java.util.List;

/**
 * author: flyhero
 * Date: 2017/11/18 0009 下午 1:57
 */
public interface SettingCarouselService extends BaseService<SettingCarousel> {
    List<SettingCarousel> findList();

}
