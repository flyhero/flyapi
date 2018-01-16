package com.flyapi.service.impl;

import com.flyapi.core.base.BaseServiceImpl;
import com.flyapi.dao.CmsArticleMapper;
import com.flyapi.dao.CmsCommentMapper;
import com.flyapi.dao.CmsSubjectMapper;
import com.flyapi.dao.UcenterUserMapper;
import com.flyapi.model.CmsArticle;
import com.flyapi.model.CmsComment;
import com.flyapi.model.CmsSubject;
import com.flyapi.model.UcenterUser;
import com.flyapi.pojo.vo.ViewLevelVo;
import com.flyapi.service.api.ArticleService;
import com.flyapi.service.api.SubjectService;
import com.flyapi.pojo.vo.ArticleDetailVo;
import com.flyapi.pojo.vo.ArticleSimpleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * author: flyhero
 * Date: 2017/6/9 0009 下午 3:58
 */
@Service
@Transactional
public class ArticleServiceImpl extends BaseServiceImpl<CmsArticle,CmsArticleMapper> implements ArticleService {
    @Autowired
    private CmsArticleMapper cmsArticleMapper;
    @Autowired
    private UcenterUserMapper userMapper;

    /**
     * Title: findArticleDetail
     * params: [articleId]
     * return: com.flyapi.vo.ArticleDetailVo
     * author: flyhero(http://flyhero.top)
     * date: 2017/6/22 0022 下午 12:50
     */
    public ArticleDetailVo findArticleDetail(Long articleId) {

        CmsArticle article = cmsArticleMapper.selectByPrimaryKey(articleId);

        CmsArticle cmsArticle= new CmsArticle();
        cmsArticle.setArticleId(articleId);
        cmsArticle.setViewNum(1);
        cmsArticleMapper.updateCommentNumOrLikeNumOrViewNum(cmsArticle); //更新评论数、点赞数、浏览数

        UcenterUser user=userMapper.selectByPrimaryKey(article.getUserId());

        ArticleDetailVo detailVo =new ArticleDetailVo();
        detailVo.setArticle(article);
        detailVo.setUser(user);
        return detailVo;
    }
    /**
     * Title: findArticleSimple
     * params: []
     * return: java.util.List<com.flyapi.vo.ArticleSimpleVo>
     * author: flyhero(http://flyhero.top)
     * date: 2017/6/22 0022 下午 1:50
     */
    public List<ArticleSimpleVo> findArticleSimple() {
        return cmsArticleMapper.findArticleSimple();
    }
    /**
     * Title: findLastUpdateArticles
     * params: [int type]
     * return: java.util.List<com.flyapi.model.CmsArticle>
     * author: flyhero(http://flyhero.top)
     * date: 2017/6/22 0022 下午 5:37
     */
    public List<CmsArticle> findLastUpdateOrHotArticles(Integer type){
        return cmsArticleMapper.findLastUpdateOrHotArticles(type);
    }
    /**
     * Title: findArticleBySubjectId
     * params: [int type]
     * return: java.util.List<com.flyapi.model.CmsArticle>
     * author: flyhero(http://www.iflyapi.cn)
     * date: 2017/9/21 0022 下午 2:28
     */
    public List<CmsArticle> findArticleBySubjectId(Long subjectId) {
        return cmsArticleMapper.findArticleBySubjectId(subjectId);
    }

    public List<CmsArticle> findArticleByUserId(Long userId) {
        return cmsArticleMapper.findArticleByUserId(userId);
    }

    public List<ViewLevelVo> findViewLevel(Long userId) {
        return cmsArticleMapper.findViewLevel(userId);
    }

    public List<CmsArticle> findHotArticlesByUserId(Long userId) {
        return cmsArticleMapper.findHotArticlesByUserId(userId);
    }

    public List<CmsArticle> findLastUpdateArticlesByUserId(Long userId) {
        return cmsArticleMapper.findLastUpdateArticlesByUserId(userId);
    }
}
