package cn.iflyapi.blog.service;

import cn.iflyapi.blog.dao.SubjectDao;
import cn.iflyapi.blog.entity.Subject;
import cn.iflyapi.blog.util.FastValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author: qfwang
 * @date: 2018-12-16 4:41 PM
 */
@Service
public class SubjectService {

    @Autowired
    private SubjectDao subjectDao;

    public List<Subject> listSubject(Long userId) {
        return subjectDao.findSubjectsByUserIdAndIsDelete(userId, false);
    }

    public Subject save(Subject subject) {
        FastValidator.doit().notEmpty(subject.getUserId(), "userId")
                .notEmpty(subject.getSubjectTitle(), "subjectTitle")
                .onMax(subject.getSubjectTitle(), 20, "subjectTitle");
        subject.setSubjectDes(Objects.isNull(subject.getSubjectDes()) ? subject.getSubjectTitle() : subject.getSubjectDes());
        subject.setCreateTime(new Date());
        return subjectDao.save(subject);
    }

    public boolean remove(Long subjectId) {
        return subjectDao.remove(subjectId);
    }
}
