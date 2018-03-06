package com.flyapi.service.api;

import com.flyapi.core.base.BaseService;
import com.flyapi.model.UcenterFame;

/**
 * author: flyhero
 * Date: 2017/6/9 0009 下午 3:57
 */
public interface FameService extends BaseService<UcenterFame> {

    UcenterFame findByFameValue(int fameValue);
}
