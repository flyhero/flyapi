package cn.iflyapi.blog.util;

import org.apache.ibatis.reflection.ArrayUtil;
import org.springframework.util.StringUtils;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.regex.Pattern;

import static cn.iflyapi.blog.util.StrUtils.EMPTY_JSON;

/**
 * HTML工具类
 *
 * @author xiaoleilu
 */
public class HtmlUtil {
    public static final String NBSP = StrUtils.HTML_NBSP;
    public static final String AMP = StrUtils.HTML_AMP;
    public static final String QUOTE = StrUtils.HTML_QUOTE;
    public static final String APOS = StrUtils.HTML_APOS;
    public static final String LT = StrUtils.HTML_LT;
    public static final String GT = StrUtils.HTML_GT;

    public static final String RE_HTML_MARK = "(<[^<]*?>)|(<[\\s]*?/[^<]*?>)|(<[^<]*?/[\\s]*?>)";
    public static final String RE_SCRIPT = "<[\\s]*?script[^>]*?>.*?<[\\s]*?\\/[\\s]*?script[\\s]*?>";

    private static final char[][] TEXT = new char[64][];

    static {
        for (int i = 0; i < 64; i++) {
            TEXT[i] = new char[]{(char) i};
        }

        // special HTML characters
        TEXT['\''] = "&#039;".toCharArray(); // 单引号 ('&apos;' doesn't work - it is not by the w3 specs)
        TEXT['"'] = QUOTE.toCharArray(); // 单引号
        TEXT['&'] = AMP.toCharArray(); // &符
        TEXT['<'] = LT.toCharArray(); // 小于号
        TEXT['>'] = GT.toCharArray(); // 大于号
    }

    /**
     * 转义文本中的HTML字符为安全的字符，以下字符被转义：
     * <ul>
     * <li>'  替换为 &amp;#039; (&amp;apos; doesn't work in HTML4)</li>
     * <li>"  替换为 &amp;quot;</li>
     * <li>&amp; 替换为 &amp;amp;</li>
     * <li>&lt; 替换为 &amp;lt;</li>
     * <li>&gt; 替换为 &amp;gt;</li>
     * </ul>
     *
     * @param text 被转义的文本
     * @return 转义后的文本
     */
    public static String escape(String text) {
        return encode(text, TEXT);
    }

    /**
     * 还原被转义的HTML特殊字符
     *
     * @param htmlStr 包含转义符的HTML内容
     * @return 转换后的字符串
     */
    public static String unescape(String htmlStr) {
        if (StringUtils.isEmpty(htmlStr)) {
            return htmlStr;
        }
        return htmlStr.replace(StrUtils.HTML_APOS, "'")//
                .replace("&#039;", "'")//
                .replace("&#39;", "'")//
                .replace(StrUtils.HTML_LT, "<")//
                .replace(StrUtils.HTML_GT, ">")//
                .replace(StrUtils.HTML_QUOTE, "\"")//
                .replace(StrUtils.HTML_AMP, "&")//
                .replace(StrUtils.HTML_NBSP, " "//
                );
    }

// ---------------------------------------------------------------- encode text

    /**
     * 清除所有HTML标签
     *
     * @param content 文本
     * @return 清除标签后的文本
     */
    public static String cleanHtmlTag(String content) {
        return content.replaceAll(RE_HTML_MARK, "");
    }

    /**
     * 清除指定HTML标签和被标签包围的内容<br>
     * 不区分大小写
     *
     * @param content  文本
     * @param tagNames 要清除的标签
     * @return 去除标签后的文本
     */
    public static String removeHtmlTag(String content, String... tagNames) {
        return removeHtmlTag(content, true, tagNames);
    }

    /**
     * 清除指定HTML标签，不包括内容<br>
     * 不区分大小写
     *
     * @param content  文本
     * @param tagNames 要清除的标签
     * @return 去除标签后的文本
     */
    public static String unwrapHtmlTag(String content, String... tagNames) {
        return removeHtmlTag(content, false, tagNames);
    }

    /**
     * 清除指定HTML标签<br>
     * 不区分大小写
     *
     * @param content        文本
     * @param withTagContent 是否去掉被包含在标签中的内容
     * @param tagNames       要清除的标签
     * @return 去除标签后的文本
     */
    public static String removeHtmlTag(String content, boolean withTagContent, String... tagNames) {
        String regex = null;
        for (String tagName : tagNames) {
            if (StringUtils.isEmpty(tagName)) {
                continue;
            }
            tagName = tagName.trim();
            // (?i)表示其后面的表达式忽略大小写
            if (withTagContent) {
                // 标签及其包含内容
                regex = format("(?i)<{}\\s*?[^>]*?/?>(.*?</{}>)?", tagName, tagName);
            } else {
                // 标签不包含内容
                regex = format("(?i)<{}\\s*?[^>]*?>|</{}>", tagName, tagName);
            }

            content = delAll(regex, content); // 非自闭标签小写
        }
        return content;
    }

    /**
     * 删除匹配的全部内容
     *
     * @param regex 正则
     * @param content 被匹配的内容
     * @return 删除后剩余的内容
     */
    public static String delAll(String regex, CharSequence content) {
        if (StringUtils.isEmpty(regex) || StringUtils.isEmpty(content)) {
            return str(content,Charset.forName("UTF-8"));
        }

         Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
        return delAll(pattern, content);
    }

    /**
     * 删除匹配的全部内容
     *
     * @param pattern 正则
     * @param content 被匹配的内容
     * @return 删除后剩余的内容
     */
    public static String delAll(Pattern pattern, CharSequence content) {
        if (null == pattern || StringUtils.isEmpty(content)) {
            return str(content,Charset.forName("UTF-8"));
        }

        return pattern.matcher(content).replaceAll(StrUtils.EMPTY);
    }

    /**
     * 去除HTML标签中的属性
     *
     * @param content 文本
     * @param attrs   属性名（不区分大小写）
     * @return 处理后的文本
     */
    public static String removeHtmlAttr(String content, String... attrs) {
        String regex = null;
        for (String attr : attrs) {
            regex = format("(?i)\\s*{}=([\"']).*?\\1", attr);
            content = content.replaceAll(regex, StrUtils.EMPTY);
        }
        return content;
    }

    /**
     * 去除指定标签的所有属性
     *
     * @param content  内容
     * @param tagNames 指定标签
     * @return 处理后的文本
     */
    public static String removeAllHtmlAttr(String content, String... tagNames) {
        String regex = null;
        for (String tagName : tagNames) {
            regex = format("(?i)<{}[^>]*?>", tagName);
            content = content.replaceAll(regex, format("<{}>", tagName));
        }
        return content;
    }

    /**
     * Encoder
     *
     * @param text  被编码的文本
     * @param array 特殊字符集合
     * @return 编码后的字符
     */
    private static String encode(String text, char[][] array) {
        int len;
        if ((text == null) || ((len = text.length()) == 0)) {
            return StrUtils.EMPTY;
        }
        StringBuilder buffer = new StringBuilder(len + (len >> 2));
        char c;
        for (int i = 0; i < len; i++) {
            c = text.charAt(i);
            if (c < 64) {
                buffer.append(array[c]);
            } else {
                buffer.append(c);
            }
        }
        return buffer.toString();
    }

    /**
     * 过滤HTML文本，防止XSS攻击
     *
     * @param htmlContent HTML内容
     * @return 过滤后的内容
     */
    public static String filter(String htmlContent) {
        return new HTMLFilter().filter(htmlContent);
    }


    /**
     * 格式化文本, {} 表示占位符<br>
     * 此方法只是简单将占位符 {} 按照顺序替换为参数<br>
     * 如果想输出 {} 使用 \\转义 { 即可，如果想输出 {} 之前的 \ 使用双转义符 \\\\ 即可<br>
     * 例：<br>
     * 通常使用：format("this is {} for {}", "a", "b") =》 this is a for b<br>
     * 转义{}： format("this is \\{} for {}", "a", "b") =》 this is \{} for a<br>
     * 转义\： format("this is \\\\{} for {}", "a", "b") =》 this is \a for b<br>
     *
     * @param template 文本模板，被替换的部分用 {} 表示
     * @param params   参数值
     * @return 格式化后的文本
     */
    public static String format(CharSequence template, Object... params) {
        if (null == template) {
            return null;
        }
        if (params == null || params.length == 0 || StringUtils.isEmpty(template)) {
            return template.toString();
        }
        return format(template.toString(), params);
    }


    /**
     * 格式化字符串<br>
     * 此方法只是简单将占位符 {} 按照顺序替换为参数<br>
     * 如果想输出 {} 使用 \\转义 { 即可，如果想输出 {} 之前的 \ 使用双转义符 \\\\ 即可<br>
     * 例：<br>
     * 通常使用：format("this is {} for {}", "a", "b") =》 this is a for b<br>
     * 转义{}： 	format("this is \\{} for {}", "a", "b") =》 this is \{} for a<br>
     * 转义\：		format("this is \\\\{} for {}", "a", "b") =》 this is \a for b<br>
     *
     * @param strPattern 字符串模板
     * @param argArray   参数列表
     * @return 结果
     */
    public static String format(final String strPattern, final Object... argArray) {
        if (StringUtils.isEmpty(strPattern) || argArray == null || argArray.length == 0) {
            return strPattern;
        }
        final int strPatternLength = strPattern.length();

        //初始化定义好的长度以获得更好的性能
        StringBuilder sbuf = new StringBuilder(strPatternLength + 50);

        int handledPosition = 0;//记录已经处理到的位置
        int delimIndex;//占位符所在位置
        for (int argIndex = 0; argIndex < argArray.length; argIndex++) {
            delimIndex = strPattern.indexOf(EMPTY_JSON, handledPosition);
            if (delimIndex == -1) {//剩余部分无占位符
                if (handledPosition == 0) { //不带占位符的模板直接返回
                    return strPattern;
                } else { //字符串模板剩余部分不再包含占位符，加入剩余部分后返回结果
                    sbuf.append(strPattern, handledPosition, strPatternLength);
                    return sbuf.toString();
                }
            } else {
                if (delimIndex > 0 && strPattern.charAt(delimIndex - 1) == StrUtils.C_BACKSLASH) {//转义符
                    if (delimIndex > 1 && strPattern.charAt(delimIndex - 2) == StrUtils.C_BACKSLASH) {//双转义符
                        //转义符之前还有一个转义符，占位符依旧有效
                        sbuf.append(strPattern, handledPosition, delimIndex - 1);
                        sbuf.append(str((argArray[argIndex]), Charset.forName("UTF-8")));
                        handledPosition = delimIndex + 2;
                    } else {
                        //占位符被转义
                        argIndex--;
                        sbuf.append(strPattern, handledPosition, delimIndex - 1);
                        sbuf.append(StrUtils.C_DELIM_START);
                        handledPosition = delimIndex + 1;
                    }
                } else {//正常占位符
                    sbuf.append(strPattern, handledPosition, delimIndex);
                    sbuf.append(str((argArray[argIndex]), Charset.forName("UTF-8")));
                    handledPosition = delimIndex + 2;
                }
            }
        }
        // append the characters following the last {} pair.
        //加入最后一个占位符后所有的字符
        sbuf.append(strPattern, handledPosition, strPattern.length());

        return sbuf.toString();
    }

    /**
     * 将对象转为字符串<br>
     * 1、Byte数组和ByteBuffer会被转换为对应字符串的数组 2、对象数组会调用Arrays.toString方法
     *
     * @param obj     对象
     * @param charset 字符集
     * @return 字符串
     */
    public static String str(Object obj, Charset charset) {
        if (null == obj) {
            return null;
        }

        if (obj instanceof String) {
            return (String) obj;
        } else if (obj instanceof byte[]) {
            return str((byte[]) obj, charset);
        } else if (obj instanceof Byte[]) {
            return str((Byte[]) obj, charset);
        } else if (obj instanceof ByteBuffer) {
            return str((ByteBuffer) obj, charset);
        } else if (obj.getClass().isArray()) {
            return ArrayUtil.toString(obj);
        }

        return obj.toString();
    }

}