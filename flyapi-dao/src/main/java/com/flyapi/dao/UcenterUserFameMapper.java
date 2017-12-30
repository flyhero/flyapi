package com.flyapi.dao;

import com.flyapi.model.UcenterUserFame;
import com.flyapi.pojo.vo.TopVo;

import java.util.List;

public interface UcenterUserFameMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UcenterUserFame record);

    int insertSelective(UcenterUserFame record);

    UcenterUserFame selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UcenterUserFame record);

    int updateByPrimaryKey(UcenterUserFame record);

    int findCountByUserIdAndOpType(UcenterUserFame userFame);

    int updateFameValueByUserId(UcenterUserFame userFame);

    List<TopVo> findSumGroupByUserId();
}