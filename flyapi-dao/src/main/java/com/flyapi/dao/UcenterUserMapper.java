package com.flyapi.dao;

import com.flyapi.model.UcenterUser;
import com.flyapi.model.UcenterUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UcenterUserMapper {
    long countByExample(UcenterUserExample example);

    int deleteByExample(UcenterUserExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(UcenterUser record);

    int insertSelective(UcenterUser record);

    List<UcenterUser> selectByExample(UcenterUserExample example);

    UcenterUser selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") UcenterUser record, @Param("example") UcenterUserExample example);

    int updateByExample(@Param("record") UcenterUser record, @Param("example") UcenterUserExample example);

    int updateByPrimaryKeySelective(UcenterUser record);

    int updateByPrimaryKey(UcenterUser record);

    UcenterUser findUserByUsernameAndPassword(UcenterUser record);

    int findUserByUsername(String username);
}