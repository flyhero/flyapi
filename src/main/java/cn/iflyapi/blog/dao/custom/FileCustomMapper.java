package cn.iflyapi.blog.dao.custom;

import org.apache.ibatis.annotations.Select;

/**
 * @author flyhero
 * @date 2018-12-31 10:25 AM
 */
public interface FileCustomMapper {

    @Select("select sum(file_size)\n" +
            "from ucenter_user_file\n" +
            "where user_id= #{userId} and is_delete=0")
    long sumFileSize(Long userId);

    @Select("update ucenter_user_file set is_try=0 where user_id = #{userId}")
    int endTry(Long userId);
}
