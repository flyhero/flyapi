package cn.iflyapi.blog.service;

import cn.iflyapi.blog.dao.UserLogMapper;
import cn.iflyapi.blog.entity.UserLog;
import cn.iflyapi.blog.entity.UserLogExample;
import cn.iflyapi.blog.enums.OperationEnum;
import cn.iflyapi.blog.model.OpLogArticle;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author flyhero
 * @date 2018-12-25 5:44 PM
 */
@Service
public class OperationService {

    @Autowired
    private UserLogMapper userLogMapper;

    public Page<UserLog> listUserLog(Long userId, Date start, Date end, OperationEnum operationEnum, Integer pageNum, Integer pageSize) {
        UserLogExample userLogExample = new UserLogExample();
        UserLogExample.Criteria criteria = userLogExample.createCriteria();
        if (Objects.nonNull(userId)) {
            criteria.andUserIdEqualTo(userId);
        }
        if (Objects.nonNull(start) && Objects.nonNull(end)) {
            criteria.andCreateTimeBetween(start, end);
        }
        if (Objects.nonNull(operationEnum)) {
            criteria.andOpTypeEqualTo(operationEnum.getCode());
        }
        userLogExample.setOrderByClause("create_time desc");
        userLogExample.createCriteria().andUserIdEqualTo(userId);
        return PageHelper.startPage(pageNum, pageSize)
                .doSelectPage(() -> userLogMapper.selectByExample(userLogExample));
    }

    /**
     * 用户最近常读的文章tags
     *
     * @param userId
     * @return
     */
    public String tagsArticleReadOpLog(Long userId) {
        Page<UserLog> page = listUserLog(userId, null, null, OperationEnum.ARTICLE_READ, 1, 10);
        if (Objects.isNull(page) || page.size() == 0) {
            return null;
        }
        List<String> tags = new ArrayList<>();
        page.getResult().forEach(userLog -> {
            OpLogArticle opLogArticle = JSONObject.parseObject(userLog.getContent(), OpLogArticle.class);
            tags.add(opLogArticle.getTags());
        });
        return String.join(",", tags);
    }

}
