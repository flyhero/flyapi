package com.flyapi.service.impl;

import com.flyapi.core.base.BaseServiceImpl;
import com.flyapi.dao.CmsReplyMapper;
import com.flyapi.dao.ReportMapper;
import com.flyapi.model.CmsReply;
import com.flyapi.model.Report;
import com.flyapi.service.api.ReplyService;
import com.flyapi.service.api.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * author: flyhero
 * Date: 2018/1/25 上午12:29
 */
@Service
@Transactional
public class ReportServiceImpl extends BaseServiceImpl<Report,ReportMapper> implements ReportService {
    @Autowired
    private ReportMapper reportMapper;

    @Override
    public int countReportToday(String ip) {
        return reportMapper.findCountByIP(ip);
    }
}
