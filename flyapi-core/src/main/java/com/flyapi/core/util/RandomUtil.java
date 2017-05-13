package com.flyapi.core.util;


import java.util.Random;
import java.util.UUID;

/**
 * 随机数工具类
 * Title:RandomUtil
 * author: flyhero(http://flyhero.top)
 * date: 2017/5/12 0012 下午 4:17
 */
public class RandomUtil {

    private static final String baseInt = "0123456789";
    private static final String baseLowStr = "abcdefghijklmnopqrstuvwxyz";
    private static final String baseUpStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String baseIntLowStr = baseInt + baseLowStr;
    private static final String baseIntUpStr = baseInt + baseUpStr;
    private static final String baseIntStr = baseInt + baseUpStr + baseLowStr;
    private static final String baseStr = baseUpStr + baseLowStr;

    /**
     * 获取一个随机数
     * Title: randomInt
     * param: []
     * return: int
     * author: flyhero(http://flyhero.top)
     * date: 2017/5/12 0012 下午 4:01
     */
    public static int randomInt(){
        Random random=new Random();
        return random.nextInt();
    }

    /**
     * 获取一定范围内的一个随机数
     * Title: randomInt
     * params: [min, max]
     * return: int
     * author: flyhero(http://flyhero.top)
     * date: 2017/5/12 0012 下午 4:01
     */
    public static int randomInt(int min,int max){

        Random random=new Random();
        return random.nextInt(max-min)+min;
    }
    /**
     * 获取固定长度的数字型字符串
     * Title: randomNum
     * param: [length]
     * return: java.lang.String
     * author: flyhero(http://flyhero.top)
     * date: 2017/5/12 0012 下午 4:02
     */
    public static String randomNum(int length){
        return randomStr(baseInt,length);
    }
    /**
     * 获取固定长度的小写字符串
     * Title: randomLowStr
     * param: [length]
     * return: java.lang.String
     * author: flyhero(http://flyhero.top)
     * date: 2017/5/12 0012 下午 4:02
     */
    public static String randomLowStr(int length) {
        return randomStr(baseLowStr,length);
    }
    /**
     * 获取固定长度的大写字符串
     * Title: randomUpStr
     * param: [length]
     * return: java.lang.String
     * author: flyhero(http://flyhero.top)
     * date: 2017/5/12 0012 下午 4:02
     */
    public static String randomUpStr(int length) {
        return randomStr(baseUpStr,length);
    }
    /**
     * 获取固定长度的混合型[数字，大写，小写字母]字符串
     * Title: randomNumStr
     * param: [length]
     * return: java.lang.String
     * author: flyhero(http://flyhero.top)
     * date: 2017/5/12 0012 下午 4:02
     */
    public static String randomNumStr(int length) {
        return randomStr(baseIntStr,length);
    }
    /**
     * 获取固定长度的混合型[数字，小写字母]字符串
     * Title: randomNumLowStr
     * param: [length]
     * return: java.lang.String
     * date: 2017/5/12 0012 下午 4:02
     */
    public static String randomNumLowStr(int length) {
        return randomStr(baseIntLowStr,length);
    }
    /**
     * 获取固定长度的混合型[数字，小写字母]字符串
     * Title: randomNumUpStr
     * param: [length]
     * return: java.lang.String
     * date: 2017/5/12 0012 下午 4:02
     */
    public static String randomNumUpStr(int length) {
        return randomStr(baseIntUpStr,length);
    }
    /**
     * 随机UUID
     * Title: UUID
     * return: java.lang.String
     * date: 2017/5/12 0012 下午 5:59
     */
    public static String UUID(){

       return UUID.randomUUID().toString();
    }
    /**
     * 无符号UUID
     * Title: UUIDWithoutSymbol
     * return: java.lang.String
     * author: flyhero(http://flyhero.top)
     * date: 2017/5/12 0012 下午 5:59
     */
    public static String UUIDWithoutSymbol(){
        return UUID().replace("-","");
    }
    /**
     * 获取一串随机字符串
     * Title: randomStr
     * param: [typeStr, length] 字符串类型，长度
     * return: java.lang.String
     * author: flyhero(http://flyhero.top)
     * date: 2017/5/12 0012 下午 3:53
     */
    public static String randomStr(String typeStr,int length){

        Random random =new Random();
        StringBuffer sb=new StringBuffer();

        int typeLength=typeStr.length();
        for (int i=0;i<length;i++){
            int num=random.nextInt(typeLength);
            sb.append(typeStr.charAt(num));
        }
        return sb.toString();
    }

    public static void main(String[] strings){
/*        System.out.println("print:"+randomUpStr(4));
        System.out.println("print:"+randomNum(4));
        System.out.println("print:"+randomNumStr(4));*/
    }


}
