package com.flyapi.dao;

import com.flyapi.model.SettingCarousel;

import java.util.List;

public interface SettingCarouselMapper {

    List<SettingCarousel> findList();

    int deleteByPrimaryKey(Integer id);

    int insert(SettingCarousel record);

    int insertSelective(SettingCarousel record);

    SettingCarousel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SettingCarousel record);

    int updateByPrimaryKey(SettingCarousel record);
}