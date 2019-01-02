package cn.iflyapi.blog.dao.custom;

import cn.iflyapi.blog.entity.Article;
import cn.iflyapi.blog.entity.ArticleExample;
import cn.iflyapi.blog.entity.ArticleWithBLOBs;
import cn.iflyapi.blog.pojo.dto.RankArticleDto;
import cn.iflyapi.blog.pojo.po.ArticleStats;
import cn.iflyapi.blog.pojo.po.IdAndMonth;
import cn.iflyapi.blog.pojo.vo.MonthArticle;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleCustomMapper {

    int addNum(ArticleStats articleStats);

    List<MonthArticle> countArticlePerMonth(IdAndMonth idAndMonth);

    List<Article> rank(RankArticleDto rankArticleDto);
}