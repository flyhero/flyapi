package cn.iflyapi.blog.pojo.dto;

import lombok.Data;

/**
 * @author flyhero
 * @date 2019-01-02 11:32 AM
 */
@Data
public class RankArticleDto {
    private int type;
    private int offset;
    private Long userId;
}
