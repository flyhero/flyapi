package cn.iflyapi.blog.dao;

import cn.iflyapi.blog.entity.Social;
import cn.iflyapi.blog.entity.SocialExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SocialMapper {
    long countByExample(SocialExample example);

    int deleteByExample(SocialExample example);

    int deleteByPrimaryKey(Long socialId);

    int insert(Social record);

    int insertSelective(Social record);

    List<Social> selectByExample(SocialExample example);

    Social selectByPrimaryKey(Long socialId);

    int updateByExampleSelective(@Param("record") Social record, @Param("example") SocialExample example);

    int updateByExample(@Param("record") Social record, @Param("example") SocialExample example);

    int updateByPrimaryKeySelective(Social record);

    int updateByPrimaryKey(Social record);
}