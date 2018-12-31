package cn.iflyapi.blog.pojo.dto;

import lombok.Data;

/**
 * @author flyhero
 * @date 2018-12-31 10:53 AM
 */
@Data
public class ResetPwDto {

    private String oldPassword;
    private String newPassword;
}
