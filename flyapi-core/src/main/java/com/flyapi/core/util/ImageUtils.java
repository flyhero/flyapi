package com.flyapi.core.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
/**
 * Author: qfwang
 * Date: 2018-02-01 下午11:09
 */
public class ImageUtils {

    /**
     *
     * 功能描述: <br>
     * 〈调整图像到固定大小〉
     *
     * @param srcImageFile  源图像文件地址
     * @param descImageFile 缩放后的图像地址
     * @param width         缩放后的宽度
     * @param height        缩放后的高度
     * @param isPadding     是否补白
     *
     */
    public final static void changeSize(String srcImageFile, String descImageFile, int width, int height, boolean isPadding) {
        try {
            // 缩放比例
            double ratio = 0.0;
            File file = new File(srcImageFile);
            BufferedImage bufferedImage = ImageIO.read(file);
            Image image = bufferedImage.getScaledInstance(width, height, bufferedImage.SCALE_SMOOTH);
            // 计算缩放比例
            if (bufferedImage.getHeight() > bufferedImage.getWidth()) {
                ratio = (new Integer(height)).doubleValue() / bufferedImage.getHeight();
            } else {
                ratio = (new Integer(width)).doubleValue() / bufferedImage.getWidth();
            }
            AffineTransformOp op = new AffineTransformOp(AffineTransform.getScaleInstance(ratio, ratio), null);
            image = op.filter(bufferedImage, null);

            // 是否需要补白
            if (isPadding) {
                BufferedImage tempBufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
                Graphics2D graphics2d = tempBufferedImage.createGraphics();
                graphics2d.setColor(Color.white);
                graphics2d.fillRect(0, 0, width, height);
                if (width == image.getWidth(null)) {
                    graphics2d.drawImage(image, 0, (height - image.getHeight(null)) / 2, image.getWidth(null), image.getHeight(null), Color.white, null);
                } else {
                    graphics2d.drawImage(image, (width - image.getWidth(null)) / 2, 0, image.getWidth(null), image.getHeight(null), Color.white, null);
                }
                graphics2d.dispose();
                image = tempBufferedImage;
            }
            ImageIO.write((BufferedImage) image, "png", new File(descImageFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * 功能描述: <br>
     * 〈利用画布生成新的图片〉
     *
     * @param backImage 背景图文件地址
     * @param srcImage  前景图文件地址
     * @param descImage 生成图文件地址
     * @return
     *
     */
    public static void mergeImage(String backImage, String srcImage, String descImage) {
        try {
            int offset = 0;
            BufferedImage backBufferedImage = ImageIO.read(new File(backImage));
            BufferedImage srcBufferedImage = ImageIO.read(new File(srcImage));
            // 输出图片宽度
            int width = backBufferedImage.getWidth() + offset;
            // 输出图片高度
            int height = backBufferedImage.getWidth() + offset;
            BufferedImage descBufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
            Graphics2D graphics2d = (Graphics2D) descBufferedImage.getGraphics();
            graphics2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            // 往画布上添加图片,并设置边距
            graphics2d.drawImage(backBufferedImage, null, 0, 0);
            graphics2d.drawImage(srcBufferedImage, null, 175, 175);
            graphics2d.dispose();
            // 输出新图片
            ImageIO.write(descBufferedImage, "png", new File(descImage));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        // 重新调整b.png尺寸 生成d.png
        changeSize("d:\\b.png", "d:\\d.png", 640, 640, false);
        // 合并a.png+d.png->c.png
        mergeImage("d:\\a.png", "d:\\d.png", "d:\\c.png");
    }
}
