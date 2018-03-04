package com.flyapi.dao;

import com.flyapi.model.CmsPk;
import com.flyapi.model.SettingStore;

public interface SettingStoreMapper {
    int deleteByPrimaryKey(Long id);

    int insertSelective(SettingStore record);

    SettingStore selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(SettingStore record);

    int updateByUserId(SettingStore store);
}