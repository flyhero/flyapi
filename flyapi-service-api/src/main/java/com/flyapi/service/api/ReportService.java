package com.flyapi.service.api;

import com.flyapi.core.base.BaseService;
import com.flyapi.model.CmsReply;
import com.flyapi.model.Report;

/**
 * author: flyhero
 * Date: 2018/1/25 上午12:27
 */
public interface ReportService extends BaseService<Report> {

    int countReportToday(String ip);
}
