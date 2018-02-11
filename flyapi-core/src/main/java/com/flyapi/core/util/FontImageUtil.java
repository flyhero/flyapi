package com.flyapi.core.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

/**
 * author: flyhero
 * Date: 2017/5/17 0017 下午 2:23
 */
public class FontImageUtil {

    private static final String  ENGLISH_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final String FONT_IMAGE_BASE_PATH="";
    /**
     * 获取首字母或汉字来，用来进行绘制头像
     * @param nick
     * @return
     */
    public static String getCharString(String nick){

        if(nick==null){
            return  String.valueOf(ENGLISH_CHARS.charAt((int)(Math.random() * 26)));
        }

        char[] chars = nick.toCharArray();
        if(chars.length>0){
            char c=chars[0];
            if(Character.isLetter(c)){
                //是字母
                if(Character.isLowerCase(c)){
                    //是否是小写字母
                    c=Character.toUpperCase(c);
                    return String.valueOf(c);
                }else {
                    return String.valueOf(c);
                }
            }else{
                //不是字母返回
                return String.valueOf(c);
            }
        }
        return String.valueOf(ENGLISH_CHARS.charAt((int)(Math.random() * 26)));
    }
    /**
     * 根据文字和图片名称创建图片
     * 默认的字体　宋体加粗
     * @param str　文字
     * @param imgName　文件明
     * @throws Exception
     */
    public static void createImage(String str, String imgName) throws Exception{
        createImage(str,new Font("宋体", Font.BOLD,50),new File(FONT_IMAGE_BASE_PATH+imgName));
    }

    /**
     * 根据str,输出目录创建图片
     * 文字样式默认为　宋体加粗
     * @param str　文字
     * @param outFile　输出目录
     * @throws Exception
     */
    public static void createImage(String str, File outFile) throws Exception{
        createImage(str,new Font("宋体",Font.BOLD,50),outFile);
    }

    /**
     * 根据str,font的样式以及输出文件目录
     * @param str 文字
     * @param font　字体样式
     * @param outFile　输出的文件及其输出的位置
     * @throws Exception
     * createImage("中华人民共和国",new Font("宋体",Font.BOLD,18),new File("e:/a.png"));
     */
    public static void createImage(String str, Font font, File outFile) throws Exception{

//        ArrayList<int[]> rgbs = getRGB();
        int[] ranRGB = getRanRGB();
        boolean isQian=isQianRGB(ranRGB);
        int width=650;
        int height=910;

        //创建图片
        BufferedImage image=new BufferedImage(width,height, BufferedImage.TYPE_INT_BGR);
        Graphics2D g=image.createGraphics();
        g.setColor(new Color(ranRGB[0],ranRGB[1],ranRGB[2]));//　一个未知颜色
        g.fillRect(0, 0, width, height);//先用颜色填充背景
        //判断是浅颜色还是深颜色
        if(isQian){
            g.setColor(Color.black);//黑色
        }else{
            g.setColor(Color.white);//白色
        }
        //设置画笔字体
        g.setFont(font);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        //判断字体的绘制位置,居中显示
        FontMetrics fm=g.getFontMetrics(font);
        int textWidth=fm.stringWidth(str);
        int x=(width-textWidth)/2;
        int ascent=fm.getAscent();
        int descent=fm.getDescent();
        int y=(height-ascent-descent)/2+ascent;
        //画出字符串
        g.drawString(str,x,y);
        g.dispose();
        //输出png图片
        ImageIO.write(image, "png", outFile);
    }


    /**
     *  一个算法　－　判断是深颜色还是浅颜色的算法
     *
     *  $grayLevel = $R * 0.299 + $G * 0.587 + $B * 0.114;
     *    if ($grayLevel >= 192) {
     *      // add shadow
     *    }
     *
     * @deprecated  业务修改，不仅仅是需要深色悲剧，浅色字，效率底
     *
     * 修改为　：　获得随机颜色背景，深色绘制白色字体，浅色，绘制黑色字体
     * */
    private static ArrayList<int[]> getRGB(){
        //1.　随机生成　rgb
        //2.　判断深颜色还是浅颜色
        //3.　继续随机生成　rgb
        //4.　判读是深颜色还是浅颜色　：和第一次相反，返回两个rgb值
        //5.  颜色深的作为背景，颜色浅的作为文字；
        //6.　第一个存放浅颜色，第二个存放深颜色
        ArrayList<int[]> colorList=new ArrayList<int[]>();
        int[] rgb = getRanRGB();
        while (true){
            if(isQianRGB(rgb)){
                colorList.add(rgb);
                break;
            }else {
                rgb=getRanRGB();
            }
        }
        int[] rgbQ=getRanRGB();
        while (true){
            if(isQianRGB(rgbQ)){
                rgbQ=getRanRGB();
            }else {
                colorList.add(rgbQ);
                break;
            }
        }
        return colorList;
    }

    /**
     * 获得随机颜色
     * @return rgb颜色
     */
    private static int[] getRanRGB(){
        int [] colors=new int[3];
        for(int i=0;i<colors.length;i++){
            colors[i]=(int)(Math.random()*256);
        }
        return colors;
    }

    /**
     * 判断是不是浅颜色
     * @param colors
     * @return 是否是浅颜色
     */
    private static boolean isQianRGB(int[] colors){
        int grayLevel = (int) (colors[0] * 0.299 + colors[1] * 0.587 + colors[2] * 0.114);
        if(grayLevel>=192){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        try {
            createImage("测试用途hahahhahahahhahahhahhh你好",new File("/Users/qfwang/Desktop/t.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
