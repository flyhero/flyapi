package cn.iflyapi.blog.pojo.dto;

import lombok.Data;

/**
 * @author flyhero
 * @date 2018-12-21 2:04 PM
 */
@Data
public class LoginDto {
    String username;
    String password;
    Integer platform;
}
