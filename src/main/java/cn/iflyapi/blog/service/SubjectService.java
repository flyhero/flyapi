package cn.iflyapi.blog.service;

import cn.iflyapi.blog.dao.SubjectMapper;
import cn.iflyapi.blog.entity.Subject;
import cn.iflyapi.blog.entity.SubjectExample;
import cn.iflyapi.blog.util.FastValidator;
import cn.iflyapi.blog.util.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author: flyhero
 * @date: 2018-12-16 4:41 PM
 */
@Service
public class SubjectService {

    @Autowired
    private SubjectMapper subjectMapper;

    @Autowired
    private SnowflakeIdWorker idWorker;

    public List<Subject> listSubjects(Long userId, Long currentUserId) {
        SubjectExample subjectExample = new SubjectExample();
        if (userId.equals(currentUserId)) {
            subjectExample.createCriteria().andUserIdEqualTo(userId).andIsDeleteEqualTo(false);
            return subjectMapper.selectByExample(subjectExample);
        }
        subjectExample.createCriteria().andIsDeleteEqualTo(false).andIsPrivateEqualTo(false).andUserIdEqualTo(userId);
        return subjectMapper.selectByExample(subjectExample);
    }


    public Subject save(Subject subject) {
        FastValidator.doit().notEmpty(subject.getUserId(), "userId")
                .notEmpty(subject.getSubjectTitle(), "subjectTitle")
                .onMax(subject.getSubjectTitle(), 20, "subjectTitle");

        subject.setSubjectId(idWorker.nextId());
        subject.setSubjectDes(Objects.isNull(subject.getSubjectDes()) ? subject.getSubjectTitle() : subject.getSubjectDes());
        subject.setCreateTime(new Date());
        subjectMapper.insertSelective(subject);
        return subjectMapper.selectByPrimaryKey(subject.getSubjectId());
    }

    public boolean update(Subject subject) {
        FastValidator.doit().notEmpty(subject.getUserId(), "userId")
                .notEmpty(subject.getSubjectTitle(), "subjectTitle")
                .onMax(subject.getSubjectTitle(), 20, "subjectTitle");

        return subjectMapper.updateByPrimaryKeySelective(subject) > 0;
    }

    public boolean remove(Long subjectId) {
        Subject subject = new Subject();
        subject.setSubjectId(subjectId);
        int num = subjectMapper.updateByPrimaryKeySelective(subject);
        if (num > 0) {
            return true;
        }
        return false;
    }
}
