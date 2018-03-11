package com.flyapi.service.api;

import com.flyapi.core.base.BaseService;
import com.flyapi.model.OpenSource;
import com.flyapi.model.UcenterSocial;

import java.util.List;

/**
 * author: flyhero
 * Date:  2018/3/11 上午12:08
 */
public interface SocialService extends BaseService<UcenterSocial> {

    void saveOrUpdate(List<UcenterSocial> socialList,Long userId);

    List<UcenterSocial> findAllSocial(Long userId);
}
