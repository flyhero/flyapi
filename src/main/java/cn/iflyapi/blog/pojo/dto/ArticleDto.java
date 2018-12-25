package cn.iflyapi.blog.pojo.dto;

import lombok.Data;

/**
 * @author flyhero
 * @date 2018-12-25 3:58 PM
 */
@Data
public class ArticleDto {

    private Long subjectId;

    private String title;

    private String mdContent;

    private String htmlContent;

    private Integer status;
}
