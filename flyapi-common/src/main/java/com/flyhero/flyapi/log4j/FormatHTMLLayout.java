package com.flyhero.flyapi.log4j;

import java.text.SimpleDateFormat;  
import java.util.Date;  
  
import org.apache.log4j.HTMLLayout;  
import org.apache.log4j.Layout;  
import org.apache.log4j.Level;  
import org.apache.log4j.helpers.Transform;  
import org.apache.log4j.spi.LocationInfo;  
import org.apache.log4j.spi.LoggingEvent;  

/**
 * 自定义html日志输出
 * @ClassName: FormatHTMLLayout 
 * @author flyhero(http://flyhero.top)
 * @date 2016年11月17日 上午11:38:40 
 *
 */
public class FormatHTMLLayout extends HTMLLayout {  
    public FormatHTMLLayout() {  
    }  
  
    protected final int BUF_SIZE = 256;  
    protected final int MAX_CAPACITY = 1024;  
    // 设置前缀  
    static String TRACE_PREFIX = "<br>    ";  
    private StringBuffer sbuf = new StringBuffer(BUF_SIZE);  
    String title = "hello";  
  
    public static final String TITLE_OPTION = "Title";  
  
    boolean locationInfo = true;  
  
    public String format(LoggingEvent event) {  
        // 如果缓冲区的容量大于最大的设置则新建一个空间  
        if (sbuf.capacity() > MAX_CAPACITY) {  
            sbuf = new StringBuffer(BUF_SIZE);  
        } else {  
            sbuf.setLength(0);  
        }  
        sbuf.append("<tr>" + Layout.LINE_SEP);  
        sbuf.append("<td>");  
        sbuf.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")  
                .format(new Date()));  
        sbuf.append("</td>" + Layout.LINE_SEP);  
  
        sbuf.append("<td title=673>");  
        if (event.getLevel().equals(Level.FATAL)) {  
            sbuf.append("<font color=\"#339933\">");  
            sbuf.append(Transform.escapeTags(String.valueOf(event.getLevel())));  
            sbuf.append("</font>");  
        } else if (event.getLevel().isGreaterOrEqual(Level.WARN)) {  
            sbuf.append("<font color=\"#993300\"><strong>");  
            sbuf.append(Transform.escapeTags(String.valueOf(event.getLevel())));  
            sbuf.append("</strong></font>");  
        } else {  
            sbuf.append("<font color=\"green\">");  
            sbuf.append(Transform.escapeTags(String.valueOf(event.getLevel())));  
            sbuf.append("</font>");  
        }  
        sbuf.append("</td>" + Layout.LINE_SEP);  
  
        if (locationInfo) {  
            LocationInfo locInfo = event.getLocationInformation();  
            sbuf.append("<td title=674>");  
            sbuf.append(Transform.escapeTags(locInfo.getFileName()));  
            sbuf.append(':');  
            sbuf.append(locInfo.getLineNumber());  
            sbuf.append("</td>" + Layout.LINE_SEP);  
        }  
      
        sbuf.append("<td title=675>");  
        sbuf.append(Transform.escapeTags(event.getRenderedMessage()));  
        sbuf.append("</td>" + Layout.LINE_SEP);  
        sbuf.append("</tr>" + Layout.LINE_SEP);  
  
        if (event.getNDC() != null) {  
            sbuf.append("<tr><td bgcolor=\"#EEEEEE\"> "  
                    + "style=\"font-size : xx-small;\" colspan=\"6\" "  
                    + "title=\"Nested Diagnostic Context\"> ");  
            sbuf.append("NDC:" + Transform.escapeTags(event.getNDC()));  
            sbuf.append("</td></tr>" + Layout.LINE_SEP);  
        }  
        String[] s = event.getThrowableStrRep();  
        if (s != null) {  
            sbuf  
                    .append("<tr><td bgcolor=\"#993300\" style=\"color:White;font-size : xx-small;\" colspan=\"4\" >");  
            appendThrowableAsHTML(s, sbuf);  
            sbuf.append("</td></tr>" + Layout.LINE_SEP);  
        }  
        return sbuf.toString();  
  
    }  
  
    private void appendThrowableAsHTML(String[] s, StringBuffer sbuf) {  
        if (s != null) {  
            int len = s.length;  
            if (len == 0)  
                return;  
            sbuf.append(Transform.escapeTags(s[0]));  
            sbuf.append(Layout.LINE_SEP);  
            for (int i = 1; i < len; i++) {  
                sbuf.append(TRACE_PREFIX);  
                sbuf.append(Transform.escapeTags(s[i]));  
                sbuf.append(Layout.LINE_SEP);  
            }  
        }  
    }  
  
    /* 
     * returns appropriate headers. 
     */  
  
    public String getHeader() {  
        StringBuffer sbuf = new StringBuffer();  
        sbuf  
                .append("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">"  
                        + Layout.LINE_SEP);  
        sbuf.append("<html>" + Layout.LINE_SEP);  
        sbuf.append("<head>" + Layout.LINE_SEP);  
  
        sbuf.append("<title>" + title + "</title>" + Layout.LINE_SEP);  
        sbuf.append("<style type=\"text/css\">" + Layout.LINE_SEP);  
        sbuf.append("<!--" + Layout.LINE_SEP);  
        sbuf  
                .append("body, table {font-family: '宋体',arial,sans-serif; font-size: 12px;}"  
                        + Layout.LINE_SEP);  
        sbuf  
                .append("th {background: #336699; color: #FFFFFF; text-align: left;}"  
                        + Layout.LINE_SEP);  
        sbuf.append("-->" + Layout.LINE_SEP);  
        sbuf.append("</style>" + Layout.LINE_SEP);  
        sbuf.append("</head>" + Layout.LINE_SEP);  
        sbuf  
                .append("<body bgcolor=\"#FFFFFF\" topmargin=\"6\" leftmargin=\"6\">"  
                        + Layout.LINE_SEP);  
  
        sbuf  
                .append("<table cellspacing=\"0\" cellpadding=\"4\" border=\"1\" bordercolor=\"#224466\" width=\"100%\">"  
                        + Layout.LINE_SEP);  
        sbuf.append("<tr>" + Layout.LINE_SEP);  
  
        sbuf.append("<th>执行时间</th>" + Layout.LINE_SEP);  
        sbuf.append("<th>级别</th>" + Layout.LINE_SEP);  
  
        if (locationInfo) {  
            sbuf.append("<th>所在行</th>" + Layout.LINE_SEP);  
        }  
  
        sbuf.append("<th>信息</th>" + Layout.LINE_SEP);  
        sbuf.append("</tr>" + Layout.LINE_SEP);  
        //sbuf.append("<br></br>" + Layout.LINE_SEP);  
        return sbuf.toString();  
    }  
  
}  