package com.flyapi.dao;

import com.flyapi.model.UcenterSocial;
import com.flyapi.model.UcenterSocialExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UcenterSocialMapper {
    long countByExample(UcenterSocialExample example);

    int deleteByExample(UcenterSocialExample example);

    int deleteByPrimaryKey(Long socialId);

    int insert(UcenterSocial record);

    int insertSelective(UcenterSocial record);

    List<UcenterSocial> selectByExample(UcenterSocialExample example);

    UcenterSocial selectByPrimaryKey(Long socialId);

    int updateByExampleSelective(@Param("record") UcenterSocial record, @Param("example") UcenterSocialExample example);

    int updateByExample(@Param("record") UcenterSocial record, @Param("example") UcenterSocialExample example);

    int updateByPrimaryKeySelective(UcenterSocial record);

    int updateByPrimaryKey(UcenterSocial record);
}