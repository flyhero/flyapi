package cn.iflyapi.blog.dao.custom;

import cn.iflyapi.blog.pojo.po.UserFame;
import cn.iflyapi.blog.pojo.vo.RankFameVo;

import java.util.List;

public interface UserCustomMapper {

    int countUserFameVal(UserFame userFame);

    int viewHomePage(Long userId);

    List<RankFameVo> rankDay();

    List<RankFameVo> rankWeek();
}