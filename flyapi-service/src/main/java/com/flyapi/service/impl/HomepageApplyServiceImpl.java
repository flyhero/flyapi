package com.flyapi.service.impl;

import com.flyapi.core.base.BaseServiceImpl;
import com.flyapi.core.enums.ApplyStatus;
import com.flyapi.dao.CmsApplyMapper;
import com.flyapi.dao.CmsArticleMapper;
import com.flyapi.dao.UcenterUserMapper;
import com.flyapi.model.CmsApply;
import com.flyapi.model.CmsApplyExample;
import com.flyapi.model.CmsArticle;
import com.flyapi.model.UcenterUser;
import com.flyapi.pojo.vo.ArticleCollectVo;
import com.flyapi.pojo.vo.HomePageVo;
import com.flyapi.service.api.HomepageApplyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * author: flyhero
 * Date: 2017/6/9 0009 下午 3:58
 */
@Service
@Transactional
public class HomepageApplyServiceImpl extends BaseServiceImpl<CmsApply, CmsApplyMapper> implements HomepageApplyService {
    @Autowired
    private CmsApplyMapper cmsApplyMapper;
    @Autowired
    private CmsArticleMapper articleMapper;
    @Autowired
    private UcenterUserMapper ucenterUserMapper;

    @Override
    public CmsApply findByArticleId(Long articleId) {
        CmsApplyExample example = new CmsApplyExample();
        example.createCriteria().andArticleIdEqualTo(articleId).andIsDeleteEqualTo((byte) 0);
        return cmsApplyMapper.selectByExample(example).get(0);
    }

    @Override
    public PageInfo<HomePageVo> findListByExample(int pageSize, int pageNum, int status) {
        PageInfo<HomePageVo> pageInfo = null;
        PageHelper.startPage(pageNum, pageSize);
        pageInfo = new PageInfo<HomePageVo>(findListByStatus(status));
        return pageInfo;
    }

    public List<HomePageVo> findListByStatus(int status){
        List<HomePageVo> homePageVoList = new ArrayList<>();
        CmsApplyExample example = new CmsApplyExample();
        if (status != ApplyStatus.UNKNOW.getValue()) {
            example.createCriteria().andApplyStatusEqualTo((byte) status).andIsDeleteEqualTo((byte) 0);
        }
        example.createCriteria().andIsDeleteEqualTo((byte) 0);
        example.setOrderByClause("create_time DESC");
        example.setLimit(100);
        List<CmsApply> applyList = cmsApplyMapper.selectByExample(example);
        applyList.forEach(cmsApply -> {
            HomePageVo homePageVo = new HomePageVo();
            homePageVo.setApplyStatus(cmsApply.getApplyStatus());
            homePageVo.setArticleId(cmsApply.getArticleId());
            homePageVo.setCreateTime(cmsApply.getCreateTime());
            CmsArticle article = articleMapper.selectByPrimaryKey(cmsApply.getArticleId());
            homePageVo.setTitle(article.getTitle());
            UcenterUser user = ucenterUserMapper.selectByPrimaryKey(article.getUserId());
            homePageVo.setNickName(user.getNickName());
            homePageVoList.add(homePageVo);
        });
        return homePageVoList;
    }

    @Override
    public boolean pass(Long applyId) {
        return update(applyId,ApplyStatus.PASS.getValue());
    }

    @Override
    public boolean unPass(Long applyId) {
        return update(applyId,ApplyStatus.UNPASS.getValue());
    }

    @Override
    public boolean update(Long applyId, int status) {
        CmsApply apply = new CmsApply();
        apply.setApplyStatus((byte) status);

        CmsApplyExample example = new CmsApplyExample();
        example.createCriteria().andIdEqualTo(applyId);

        int num = cmsApplyMapper.updateByExampleSelective(apply, example);
        return num > 0;
    }
}
