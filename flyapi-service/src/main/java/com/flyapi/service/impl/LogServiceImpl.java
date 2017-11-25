package com.flyapi.service.impl;

import com.flyapi.core.base.BaseServiceImpl;
import com.flyapi.dao.UcenterLogMapper;
import com.flyapi.model.UcenterLog;
import com.flyapi.service.api.LogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Author: qfwang
 * Date: 2017-11-25 下午1:18
 */
@Service
@Transactional
public class LogServiceImpl extends BaseServiceImpl<UcenterLog,UcenterLogMapper> implements LogService{
}
