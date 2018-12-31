package cn.iflyapi.blog.pojo.dto;

import lombok.Data;

/**
 * @author flyhero
 * @date 2018-12-31 2:19 PM
 */
@Data
public class UserBaseDto {
    private String nickName;

    private String avatar;

    private String phone;

    private String email;

    private Integer sex;

    private String sign;

    private String company;

    private String country;

    private String area;

    private String province;

    private String city;
}
