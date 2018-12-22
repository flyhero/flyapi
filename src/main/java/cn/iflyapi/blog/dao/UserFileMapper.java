package cn.iflyapi.blog.dao;

import cn.iflyapi.blog.entity.UserFile;
import cn.iflyapi.blog.entity.UserFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserFileMapper {
    long countByExample(UserFileExample example);

    int deleteByExample(UserFileExample example);

    int deleteByPrimaryKey(Long fileId);

    int insert(UserFile record);

    int insertSelective(UserFile record);

    List<UserFile> selectByExample(UserFileExample example);

    UserFile selectByPrimaryKey(Long fileId);

    int updateByExampleSelective(@Param("record") UserFile record, @Param("example") UserFileExample example);

    int updateByExample(@Param("record") UserFile record, @Param("example") UserFileExample example);

    int updateByPrimaryKeySelective(UserFile record);

    int updateByPrimaryKey(UserFile record);
}