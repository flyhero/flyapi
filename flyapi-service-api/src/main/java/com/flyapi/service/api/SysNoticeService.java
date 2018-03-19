package com.flyapi.service.api;

import com.flyapi.core.base.BaseService;
import com.flyapi.model.SysNotice;
import com.flyapi.pojo.dto.AddNoticeDto;

/**
 * Author: qfwang
 * Date: 2018-03-19 下午11:35
 */
public interface SysNoticeService extends BaseService<SysNotice>{

    /**
     * 发送消息
     * @title sendMsg
     * @param noticeDto
     * @return
     * @date 2018/3/19 下午11:48
     */
    boolean sendMsg(AddNoticeDto noticeDto);
}
