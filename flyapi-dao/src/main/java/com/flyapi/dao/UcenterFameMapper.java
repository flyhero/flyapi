package com.flyapi.dao;

import com.flyapi.model.UcenterFame;

public interface UcenterFameMapper {
    int deleteByPrimaryKey(Long fameId);

    int insert(UcenterFame record);

    int insertSelective(UcenterFame record);

    UcenterFame selectByPrimaryKey(Long fameId);

    int updateByPrimaryKeySelective(UcenterFame record);

    int updateByPrimaryKey(UcenterFame record);

    UcenterFame findByFameValue(int fameValue);
}