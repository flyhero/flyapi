package cn.iflyapi.blog.service;

import cn.iflyapi.blog.dao.SocialMapper;
import cn.iflyapi.blog.entity.Social;
import cn.iflyapi.blog.entity.SocialExample;
import cn.iflyapi.blog.util.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author flyhero
 * @date 2018-12-31 7:21 PM
 */
@Service
public class SocialService {

    @Autowired
    private SocialMapper socialMapper;

    @Autowired
    private SnowflakeIdWorker idWorker;

    public List<Social> listSocial(Long userId){
        SocialExample socialExample = new SocialExample();
        socialExample.createCriteria().andUserIdEqualTo(userId).andIsDeleteEqualTo(false);
        return socialMapper.selectByExample(socialExample);
    }

    public void update(List<Social> socials){
        for (Social social : socials){
            update(social);
        }

    }

    public void update(Social social){
        if (Objects.nonNull(social.getSocialId())) {
            socialMapper.updateByPrimaryKeySelective(social);
        }else {
            social.setSocialId(idWorker.nextId());
            socialMapper.insertSelective(social);
        }
    }

    public void remove(Long socialId){
        Social social = new Social();
        social.setSocialId(socialId);
        social.setIsDelete(true);
        socialMapper.updateByPrimaryKeySelective(social);
    }
}
