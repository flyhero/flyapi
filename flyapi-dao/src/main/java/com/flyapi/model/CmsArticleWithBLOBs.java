package com.flyapi.model;

import java.io.Serializable;

/**
 * @author 
 */
public class CmsArticleWithBLOBs extends CmsArticle implements Serializable {
    /**
     * md内容
     */
    private String mdContent;

    /**
     * html内容
     */
    private String htmlContent;

    private static final long serialVersionUID = 1L;

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