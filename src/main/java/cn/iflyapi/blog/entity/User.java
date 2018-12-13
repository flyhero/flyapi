package cn.iflyapi.blog.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author: qfwang
 * @date: 2018-12-13 9:38 AM
 */
@Data
@Entity
@Table(name = "ucenter_user")
public class User {

    /**
     * 用户id
     */
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 头像地址
     */
    private String avatar;

    /**
     * 手机
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 0未知1男2女
     */
    private Byte sex;

    /**
     * 个性签名
     */
    private String sign;

    /**
     * 公司
     */
    private String company;

    /**
     * 国家
     */
    private String country;

    /**
     * 地区
     */
    private String area;

    /**
     * 省份
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 注册来源
     */
    private String platform;

    /**
     * 声望值
     */
    private Integer fameValue;

    private String supportWord;

    private String supportQrcode;

    /**
     * 注册时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 0正常1注销
     */
    private Byte isDelete;
}
