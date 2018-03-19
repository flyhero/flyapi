package com.flyapi.dao;

import com.flyapi.model.CmsApply;
import com.flyapi.model.CmsApplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmsApplyMapper {
    long countByExample(CmsApplyExample example);

    int deleteByExample(CmsApplyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CmsApply record);

    int insertSelective(CmsApply record);

    List<CmsApply> selectByExample(CmsApplyExample example);

    CmsApply selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CmsApply record, @Param("example") CmsApplyExample example);

    int updateByExample(@Param("record") CmsApply record, @Param("example") CmsApplyExample example);

    int updateByPrimaryKeySelective(CmsApply record);

    int updateByPrimaryKey(CmsApply record);
}