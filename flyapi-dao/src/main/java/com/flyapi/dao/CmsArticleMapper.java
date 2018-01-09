package com.flyapi.dao;

import com.flyapi.model.CmsArticle;
import com.flyapi.pojo.dto.SubjectDto;
import com.flyapi.pojo.vo.ArticleSimpleVo;
import com.flyapi.pojo.vo.ViewLevelVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CmsArticleMapper {
    int deleteByPrimaryKey(Long articleId);

    int insert(CmsArticle record);

    int insertSelective(CmsArticle record);

    CmsArticle selectByPrimaryKey(Long articleId);

    int updateByPrimaryKeySelective(CmsArticle record);

    int updateByPrimaryKey(CmsArticle record);

    int updateCommentNumOrLikeNumOrViewNum(CmsArticle record);

    List<ArticleSimpleVo> findArticleSimple();

    List<CmsArticle> findLastUpdateOrHotArticles(@Param("atype")Integer atype);

    List<CmsArticle> findArticleListByCount(SubjectDto subjectDto);


    List<CmsArticle> findArticleBySubjectId(Long subjectId);

    List<CmsArticle> findArticleByUserId(Long userId);

    List<ViewLevelVo> findViewLevel(Long userId);
}