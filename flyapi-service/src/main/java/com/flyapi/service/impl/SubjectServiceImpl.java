package com.flyapi.service.impl;

import com.flyapi.core.base.BaseServiceImpl;
import com.flyapi.dao.CmsArticleMapper;
import com.flyapi.dao.CmsRssMapper;
import com.flyapi.dao.CmsSubjectMapper;
import com.flyapi.dao.UcenterUserMapper;
import com.flyapi.model.CmsArticle;
import com.flyapi.model.CmsRss;
import com.flyapi.model.CmsSubject;
import com.flyapi.model.UcenterUser;
import com.flyapi.pojo.dto.SubjectDto;
import com.flyapi.pojo.vo.SubjectVo;
import com.flyapi.service.api.SubjectService;
import com.flyapi.service.api.UserService;
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
public class SubjectServiceImpl extends BaseServiceImpl<CmsSubject,CmsSubjectMapper> implements SubjectService {

    @Autowired
    private CmsSubjectMapper cmsSubjectMapper;
    @Autowired
    private CmsArticleMapper cmsArticleMapper;
    @Autowired
    private UcenterUserMapper ucenterUserMapper;
    @Autowired
    private CmsRssMapper rssMapper;

    public List<SubjectVo> findSubjectList(SubjectDto subjectDto,Long userId) {
        List<CmsArticle> list=cmsArticleMapper.findArticleListByCount(subjectDto);
        List<SubjectVo> voList = new ArrayList<SubjectVo>();
        for(CmsArticle article:list){
            SubjectVo subjectVo =new SubjectVo();
            subjectVo.setViewNum(article.getViewNum());
            subjectVo.setLikeNum(article.getLikeNum());
            subjectVo.setCommentNum(article.getCommentNum());

            CmsSubject subject = cmsSubjectMapper.selectByPrimaryKey(article.getSubjectId());
            subjectVo.setCmsSubject(subject);

            UcenterUser user= ucenterUserMapper.selectByPrimaryKey(article.getUserId());
            user.setPassword("");
            user.setPhone("");
            subjectVo.setUcenterUser(user);


            CmsRss cmsRss =new CmsRss();
            cmsRss.setSubjectId(subject.getSubjectId());
            List<CmsRss> cmsRssList = rssMapper.findByUserIdAndSubjectId(cmsRss);
            subjectVo.setRssNum(cmsRssList.size());

            if(userId == null || userId == 0){
                subjectVo.setRss(false);
            }else {
                cmsRss.setUserId(userId);
                List<CmsRss> cmsRsses = rssMapper.findByUserIdAndSubjectId(cmsRss);
                if(cmsRsses != null && cmsRsses.size() >0){
                    subjectVo.setRss(true);
                }
            }

            voList.add(subjectVo);
        }
        return voList;
    }

    public List<CmsSubject> findUserSubject(Long userId) {
        List<CmsSubject> list = cmsSubjectMapper.findUserSubject(userId);
        return list;
    }
}
