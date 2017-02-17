package com.flyhero.flyapi.utils;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.alibaba.fastjson.serializer.ValueFilter;

import sun.misc.BASE64Encoder;

public class StringUtils {
	/**
	 * json过滤器
	 */
    public static ValueFilter filter = new ValueFilter() {
        @Override
        public Object process(Object obj, String s, Object v) {
            if (v == null)
                return "";
            return v;
        }
    };
	/**
	 * 将一个日期转换成String 
	 * 方法名：getDateString<BR>
	 * 创建人：gulj <BR>
	 * 时间：2014年8月11日-下午9:59:14 <BR>
	 * 
	 * @param date
	 * @param pattern
	 * @return String<BR>
	 * @exception <BR>
	 * @since 1.0.0
	 */
	public static String formatDateToString(Date date, String pattern) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat.format(date);
	}

	/**
	 * 将日期字符串转换成Date 方法名：getDateString<BR>
	 * 创建人：gulj <BR>
	 * 时间：2014年8月11日-下午10:04:06 <BR>
	 * 
	 * @param dateString
	 * @param pattern
	 * @return
	 * @throws ParseException
	 *             Date<BR>
	 * @exception <BR>
	 * @since 1.0.0
	 */
	public static Date parseStringToDate(String dateString, String pattern)
			throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat.parse(dateString);
	}

	/**
	 * 
	 * 将小数格式化成字符串，会进行四舍五入 如：3656.4554===结果:3656.46<BR>
	 * 方法名：formatDoubleToString<BR>
	 * 创建人：gulj <BR>
	 * 时间：2014年8月12日-下午9:12:01 <BR>
	 * 
	 * @param dou
	 * @return String<BR>
	 * @exception <BR>
	 * @since 1.0.0
	 */
	public static String formatDoubleToString(double dou,String format) {
		if(isEmpty(format))format = "#.##";
		DecimalFormat decimalFormat = new DecimalFormat(format);
		String string = decimalFormat.format(dou);// 四舍五入，逢五进一
		return string;
	}
	
	
	/**
	 * 判断字符串是否为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return null == str || str.length() == 0 || "".equals(str)
				|| str.matches("\\s*");
	}
	
	/**
	 * 非空判断
	 * (这里用一句话描述这个方法的作用)<BR>
	 * 方法名：isNotEmpty<BR>
	 * 创建人：gulj <BR>
	 * 时间：2014年8月12日-下午9:36:18 <BR>
	 * @param str
	 * @return boolean<BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}
	
	
	/**
	 * 百分比转换
	 * 方法名：getPercent<BR>
	 * 创建人：gulj <BR>
	 * 时间：2014年8月12日-下午9:50:46 <BR>
	 * @param num
	 * @param totalCount
	 * @param format
	 * @return String<BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	public static String getPercent(int num,double totalCount,String...objects){
		String format = "#.##";
		if(objects!=null && objects.length>0){
			format = objects[0];
		}
		return StringUtils.formatDoubleToString((num/totalCount)*100,format)+"%";
	}
	
	/**
	 * 百分比转换
	 * 方法名：getPercent<BR>
	 * 创建人：gulj <BR>
	 * 时间：2014年8月12日-下午9:50:46 <BR>
	 * @param num 当前的数字
	 * @param totalCount 总数
	 * @param format 
	 * @return String<BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	public static String getPercent(int num,float totalCount,String...objects){//动态参数
		String format = "#.##";
		if(objects!=null && objects.length>0){
			format = objects[0];
		}
		return StringUtils.formatDoubleToString((num/totalCount)*100,format)+"%";
	}
	
	
	
	/**
	 *冒泡排序方法,如果为true那就是降序，false那么久是升序 
	 * 方法名：sorts<BR>
	 * 创建人：gulj <BR>
	 * 时间：2014年8月12日-下午11:35:55 <BR>
	 * @param datas
	 * @param flag
	 * @return int[]<BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	public static int[] sorts(int[] datas,boolean flag){
		for (int i = 0; i < datas.length; i++) {//轮询次数
			for(int j=0; j < datas.length-1; j++){//交换次数
				if(flag){ 
					if(datas[j] < datas[j+1]){
						int temp = datas[j];
						datas[j] = datas[j+1];
						datas[j+1] = temp;
					}
				}else{
					if(datas[j] < datas[j+1]){
						int temp = datas[j];
						datas[j] = datas[j+1];
						datas[j+1] = temp;
					}
				}
			}
		}
		return datas;
	}
	
	/**
	 * 凯德加密
	 * 方法名：encryption<BR>
	 * 创建人：gulj <BR>
	 * 时间：2014年10月25日-下午9:48:19 <BR>
	 * @param str
	 * @param k
	 * @return String<BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	public static String encryption(String str,int k){
		String string = "";
		for (int i = 0; i < str.length(); i++) {
			char c= str.charAt(i);
			if(c>='a' && c<='z'){
				c += k%26;
				if(c<'a'){
					c+=26;
				}
				if(c>'z'){
					c-=26;
				}
			}else if(c>='A' && c<='Z'){
				c+=k%26;
				if(c<'A'){
					c+=26;
				}
				if(c>'Z'){
					c-=26;
				}
			}
			string+=c;
		}
		return string;
	}
	
	/**
	 * 凯德解密
	 * 方法名：dencryption<BR>
	 * 创建人：gulj <BR>
	 * 时间：2014年10月25日-下午9:48:35 <BR>
	 * @param str
	 * @param n
	 * @return String<BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	public static String dencryption(String str,int n){
		String string = "";
		int k = Integer.parseInt("-"+n);
		for (int i = 0; i < str.length(); i++) {
			char c= str.charAt(i);
			if(c>='a' && c<='z'){
				c += k%26;
				if(c<'a'){
					c+=26;
				}
				if(c>'z'){
					c-=26;
				}
			}else if(c>='A' && c<='Z'){
				c+=k%26;
				if(c<'A'){
					c+=26;
				}
				if(c>'Z'){
					c-=26;
				}
			}
			string+=c;
		}
		return string;
	}
	
	
	
	/**
	 * 文件后缀处理
	 * @param oldExt
	 * @return
	 */
	public static String ext(String oldExt){
		String result =oldExt;
		if(!oldExt.equals("") && oldExt!=null){
			if(oldExt.toLowerCase().equals("xlsx") || oldExt.toLowerCase().equals("xlsx"))result = "xls";
			if(oldExt.toLowerCase().equals("docx") || oldExt.toLowerCase().equals("doc"))result = "word";
		}
		return result;
	}
	
	public static boolean isImage(String ext){
		return ext.toLowerCase().matches("jpg|gif|bmp|png|jpeg");
	}
	
	public static boolean isDoc(String ext){
		return ext.toLowerCase().matches("doc|docx|xls|xlsx|pdf|txt|ppt|pptx|rar|zip|html|jsp|sql|htm|shtml|xml");
	}
	
	public static boolean isVideo(String ext){
		return ext.toLowerCase().matches("mp4|flv|mp3|rmbv|avi");
	}
	
	public static String base64Encode(byte[] b) {
		if (b == null) {
			return null;
		}
		return new BASE64Encoder().encode(b);
	}
	
	/**
	 * md5加密
	 * 方法名：md5Base64<BR>
	 * 创建人 gulj <BR>
	 * 时间：2014年11月28日-上午12:51:12 <BR>
	 * @param str
	 * @return String<BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	public static String md5Base64(String str) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			return base64Encode(md5.digest(str.getBytes()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static String saltPassword(String slatString,String password){
		return md5Base64(slatString+password);
	}
	
	public static void main(String[] args) {
//		long start = System.currentTimeMillis();
//		for (int i = 1; i <= 1000; i++) {
//			System.out.println("====="+i);
//		}
//		long end = System.currentTimeMillis();
//		System.out.println("一共耗费:"+(end-start)+"毫秒");
		
		System.out.println("323423dfsdf3".matches("\\d*"));
	}

}
