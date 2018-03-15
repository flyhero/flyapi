package com.flyapi.web.controller;

import com.flyapi.core.base.BaseController;
import com.flyapi.core.constant.JSONResult;
import com.flyapi.core.id.SnowflakeIdWorker;
import com.flyapi.core.util.IPUtil;
import com.flyapi.model.Report;
import com.flyapi.service.api.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * User: qfwang
 * Date: 2018/1/25 上午12:30
 */
@Controller
@RequestMapping("report")
public class ReportController extends BaseController{

    //今日举报上限
    private static final int REPORT_LIMIT_TODAY = 10;
    @Autowired
    private ReportService reportService;
    @Autowired
    private SnowflakeIdWorker snowflakeIdWorker;

    /**
     * 举报文章
     * @title: report
     * @author flyhero <http://www.iflyapi.cn>
     * @param report
     * @return com.flyapi.core.constant.JSONResult
     * @date 2018/1/28 下午7:44
     */
    @PostMapping("article")
    @ResponseBody
    public JSONResult report(Report report){

        //今天相同ip举报次数有限制

        String ip = IPUtil.getIP(request);
        int count = reportService.countReportToday(ip);
        if(count > REPORT_LIMIT_TODAY){
            return JSONResult.error();
        }
        report.setReportId(snowflakeIdWorker.nextId());
        report.setReporterIp(ip);
        report.setCreateTime(new Date());
        int num = reportService.insertSelective(report);
        if(num < 1){
            return JSONResult.error();
        }

        return JSONResult.ok();
    }
}
