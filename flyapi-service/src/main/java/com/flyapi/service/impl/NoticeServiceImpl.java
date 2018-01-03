package com.flyapi.service.impl;

import com.flyapi.core.base.BaseServiceImpl;
import com.flyapi.dao.SettingCarouselMapper;
import com.flyapi.dao.SysNoticeMapper;
import com.flyapi.model.SettingCarousel;
import com.flyapi.model.SysNotice;
import com.flyapi.service.api.NoticeService;
import com.flyapi.service.api.SettingCarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * author: flyhero
 * Date: 2018/01/03 0009 下午 1:58
 */
@Service
@Transactional
public class NoticeServiceImpl extends BaseServiceImpl<SysNotice,SysNoticeMapper> implements NoticeService {
}
