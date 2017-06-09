package com.flyapi.core.base;

/**
 * author: flyhero
 * Date: 2017/5/15 0015 下午 6:32
 */
public interface BaseService<Model> {

    int deleteByPrimaryKey(Long id);

    int insert(Model record);

    int insertSelective(Model record);

    Model selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Model record);

    int updateByPrimaryKey(Model record);
}
