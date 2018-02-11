package com.flyapi.core.util;


import java.awt.*;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
/**
 * Author: qfwang
 * Date: 2018-02-01 下午11:02
 */
public class ChartGraphics {
    private BufferedImage image;
    private int imageWidth = 300;  //图片的宽度
    private int imageHeight = 500; //图片的高度
    //生成图片文件
    @SuppressWarnings("restriction")
    public void createImage(String fileLocation) {
        BufferedOutputStream bos = null;
        if(image != null){
            try {
                FileOutputStream fos = new FileOutputStream(fileLocation);
                bos = new BufferedOutputStream(fos);

                JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(bos);
                encoder.encode(image);
                bos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                if(bos!=null){//关闭输出流
                    try {
                        bos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void graphicsGeneration(String name, String id, String classname, String imgurl) {
        int H_title = 30;     //头部高度
        int H_mainPic = 200;  //轮播广告高度
        int H_tip = 60;  //上网提示框高度
        int H_btn = 25;  //按钮栏的高度
        int tip_2_top = (H_title+H_mainPic);
        int btns_2_top = tip_2_top+H_tip+20;
        int btn1_2_top = btns_2_top+10;
        int btn2_2_top = btn1_2_top+H_btn;
        int shops_2_top = btn2_2_top+H_btn+20;
        int W_btn = 280;  //按钮栏的宽度

        image = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
        //设置图片的背景色
        Graphics2D main = image.createGraphics();
        main.setColor(Color.white);
        main.fillRect(0, 0, imageWidth, imageHeight);

        //***********************页面头部
        Graphics title = image.createGraphics();
        //设置区域颜色
        title.setColor(new Color(45, 176, 255));
        //填充区域并确定区域大小位置
        title.fillRect(0, 0, imageWidth, H_title);
        //设置字体颜色，先设置颜色，再填充内容
        title.setColor(Color.white);
        //设置字体
        Font titleFont = new Font("宋体", Font.BOLD, 14);
        title.setFont(titleFont);
        title.drawString("my head", 100, (H_title)/2+5);

        //***********************插入中间广告图
        Graphics mainPic = image.getGraphics();
        BufferedImage bimg = null;
        try {
            bimg = javax.imageio.ImageIO.read(new java.io.File(imgurl));
        } catch (Exception e) {}

        if(bimg!=null){
            mainPic.drawImage(bimg, 0, H_title, imageWidth, H_mainPic, null);
            mainPic.dispose();
        }
        //***********************设置下面的提示框

        Graphics2D tip = image.createGraphics();
        //设置区域颜色
/*        tip.setColor(new Color(255, 120, 89));
        //填充区域并确定区域大小位置
        tip.fillRect(0, tip_2_top, imageWidth, H_tip);
        //设置字体颜色，先设置颜色，再填充内容
        tip.setColor(Color.white);*/
        //设置字体
/*
        Font tipFont = new Font("宋体", Font.PLAIN, 14);
        tip.setFont(tipFont);
        tip.drawString("登录成功，本次认证时间1小时", 60, tip_2_top+(H_tip)/2-10);
        tip.drawString("正在返回商家主页", 100, tip_2_top+(H_tip)/2+10);
*/

                       /* --------对要显示的文字进行处理-------------- */
        AttributedString ats = new AttributedString(name);
        Font font = new Font("宋体", Font.BOLD, 14);
        tip.setFont(font);
                         /* 消除java.awt.Font字体的锯齿 */
        tip.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
                          /* 消除java.awt.Font字体的锯齿 */
        // font = g.getFont().deriveFont(30.0f);
        ats.addAttribute(TextAttribute.FONT, font, 0, name.length());
        AttributedCharacterIterator iter = ats.getIterator();

        //***********************设置下面的按钮块
        //设置字体颜色，先设置颜色，再填充内容
        tip.setColor(Color.black);
        tip.drawString("您可以选择的操作：", 20, 80);
        tip.drawString("下面的小图标："+iter, 20, shops_2_top);
        //***********************按钮
/*        Font btnFont = new Font("宋体", Font.BOLD, 14);
        Graphics2D btn1 = image.createGraphics();
        btn1.setColor(new Color(41,192 , 50));//#29C65A
        btn1.fillRect(10, btn1_2_top, W_btn, H_btn);
        btn1.setColor(Color.BLACK);
        btn1.drawRect(10, btn1_2_top, W_btn, H_btn);
        //btn1 文本
        btn1.setColor(Color.white);
        btn1.setFont(btnFont);
        btn1.drawString("单击我啊", 120, btn1_2_top+(H_btn/2)+5);*/

/*
        Graphics2D btn2 = image.createGraphics();
        btn2.setColor(new Color(141,120 , 22));//#29C65A
        btn2.fillRect(10, btn2_2_top, W_btn, H_btn);
        btn2.setColor(Color.BLACK);
        btn2.drawRect(10, btn2_2_top, W_btn, H_btn);
        //btn2文本
        btn2.setColor(Color.white);
        btn2.setFont(btnFont);
        btn2.drawString("单击我啊", 120, btn2_2_top+(H_btn/2)+5);
*/

        createImage("/Users/qfwang/Desktop/hehe.jpg");

    }

    public static void main(String[] args) {
        ChartGraphics cg = new ChartGraphics();
        try {
            cg.graphicsGeneration("这是不一样的", "1", "12", "/Users/qfwang/Desktop/1.jpg");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
