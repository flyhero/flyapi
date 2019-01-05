package cn.iflyapi.blog.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author flyhero
 * @date 2019-01-05 11:48 AM
 */
@ApiModel(value="CommentDto对象")
@Data
public class CommentDto {

    @ApiModelProperty(value="文章id",required=true)
    private Long targetId;

    @ApiModelProperty(value="作者id",required=true)
    private Long authorId;

    @ApiModelProperty(value="评论者id",required=true)
    private Long userId;

    @ApiModelProperty(value="评论者昵称",required=true)
    private String nickName;

    @ApiModelProperty(value="评论内容",required=true)
    private String content;

    @ApiModelProperty(value="评论类型 1.文章",required=true)
    private Integer type;
}
