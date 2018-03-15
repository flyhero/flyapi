package com.flyapi.pojo.dto;

/**
 * Author: qfwang
 * Date: 2018-03-15 下午11:35
 */
public class CommentDto {
    private String content;
    private Long articleId;
    private Long authorId;
    private Long commentId;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }
}
