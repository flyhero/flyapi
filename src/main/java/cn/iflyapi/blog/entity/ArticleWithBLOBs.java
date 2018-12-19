package cn.iflyapi.blog.entity;

public class ArticleWithBLOBs extends Article {
    private String mdContent;

    private String htmlContent;

    public String getMdContent() {
        return mdContent;
    }

    public void setMdContent(String mdContent) {
        this.mdContent = mdContent;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }
}