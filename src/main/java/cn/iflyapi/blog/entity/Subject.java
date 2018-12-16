package cn.iflyapi.blog.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author: flyhero
 * @date: 2018-12-16 4:38 PM
 */
@Data
@Entity
@Table(name = "cms_subject")
public class Subject {
    /**
     * 专题id
     */
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private Long subjectId;

    /**
     * 作者id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;

    /**
     * 封面图
     */
    private String cover;

    /**
     * 专题标题
     */
    private String subjectTitle;

    /**
     * 描述
     */
    private String subjectDes;

    /**
     * 权限0公开1私有
     */
    private Boolean isPrivate;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 0显示1删除
     */
    private Boolean isDelete;
}
