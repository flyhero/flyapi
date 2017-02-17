package com.flyhero.flyapi.utils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.lang3.StringUtils;

/**
 * @author administrator
 *
 * Http Client工具类
 * 发起http client 请求
 * 
 * 窗口 － 首选项 － Java － 代码样式 － 代码模板
 */
public final class SimpleHttpClient {
	
	private static final String TYPE_STRING = "string";
	
	private static final String TYPE_BYTEARRAY = "byte[]";
	
	private static final String TYPE_STREAM = "stream";
	
	private static SimpleHttpClient instance;
	
	private SimpleHttpClient(){}
	
	/**
	 * 使用默认的页面请求编码：utf-8
	 * @return
	 */
	public static SimpleHttpClient getInstance(){
		return getInstance("UTF-8");
	} 
	
	public static SimpleHttpClient getInstance(String urlCharset){
		if(instance == null){
			instance = new SimpleHttpClient();
		}
		//设置默认的url编码
		instance.setUrlCharset(urlCharset);
		return instance;
	}
	
	/**
	 * 请求编码，默认使用utf-8
	 */
	private String urlCharset = "UTF-8";
	
	/**
	 * @param urlCharset 要设置的 urlCharset。
	 */
	public void setUrlCharset(String urlCharset) {
		this.urlCharset = urlCharset;
	}
	/**
	 * 获取字符串型返回结果，通过发起http post请求
	 * @param targetUrl
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public String getResponseBodyAsString(String targetUrl,Map params)throws Exception{
		
		return (String)setPostRequest(targetUrl,params,TYPE_STRING,null);
	}
	
	/**
	 * 获取字符数组型返回结果，通过发起http post请求
	 * @param targetUrl
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public byte[] getResponseBodyAsByteArray(String targetUrl,Map params)throws Exception{
		
		return (byte[])setPostRequest(targetUrl,params,TYPE_BYTEARRAY,null);
	}
	
	/**
	 * 将response的返回流写到outputStream中，通过发起http post请求
	 * @param targetUrl					请求地址
	 * @param params					请求参数<paramName,paramValue>
	 * @param outputStream				输出流
	 * @throws Exception
	 */
	public void getResponseBodyAsStream(String targetUrl,Map params,OutputStream outputStream)throws Exception{
		if(outputStream == null){
			throw new IllegalArgumentException("调用HttpClientUtil.setPostRequest方法，targetUrl不能为空!");
		}
		
		//response 的返回结果写到输出流
		setPostRequest(targetUrl,params,TYPE_STREAM,outputStream);
	}
	
	/**
	 * 利用http client模拟发送http post请求
	 * @param targetUrl					请求地址
	 * @param params					请求参数<paramName,paramValue>
	 * @return	Object					返回的类型可能是：String 或者 byte[] 或者 outputStream			
	 * @throws Exception
	 */
	private Object setPostRequest(String targetUrl,Map params,String responseType,OutputStream outputStream)throws Exception{
		if(StringUtils.isBlank(targetUrl)){
			throw new IllegalArgumentException("调用HttpClientUtil.setPostRequest方法，targetUrl不能为空!");
		}
		
		Object responseResult = null;
		HttpClient client = null;
		PostMethod post = null;
		NameValuePair[] nameValuePairArr = null;
		SimpleHttpConnectionManager connectionManager = null;
		try{
			connectionManager =  new SimpleHttpConnectionManager(true);
			//连接超时,单位毫秒
			connectionManager.getParams().setConnectionTimeout(3000);
			//读取超时,单位毫秒
			connectionManager.getParams().setSoTimeout(60000);
			
			//设置获取内容编码
			connectionManager.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,urlCharset);
			client = new HttpClient(new HttpClientParams(),connectionManager);
			
			post = new PostMethod(targetUrl);
			//设置请求参数的编码
			post.getParams().setContentCharset(urlCharset);
			
			//服务端完成返回后，主动关闭链接
			post.setRequestHeader("Connection","close");
			if(params != null){
				nameValuePairArr = new NameValuePair[params.size()];
				
				Set key = params.keySet();
				Iterator keyIte = key.iterator();
				int index = 0;
				while(keyIte.hasNext()){
					Object paramName = keyIte.next();
					Object paramValue = params.get(paramName);
					if(paramName instanceof String && paramValue instanceof String){
						NameValuePair pair = new NameValuePair((String)paramName,(String)paramValue);
						nameValuePairArr[index] = pair;
						index++;
					}
				}
				
				post.addParameters(nameValuePairArr);
			}
			
			int sendStatus = client.executeMethod(post);
			
			if(sendStatus == HttpStatus.SC_OK){
				System.out.println("HttpClientUtil.setPostRequest()-responseType:"+responseType);
				
				if(StringUtils.equals(TYPE_STRING,responseType)){
					responseResult = post.getResponseBodyAsString();
				}else if(StringUtils.equals(TYPE_BYTEARRAY,responseType)){
					responseResult = post.getResponseBody();
				}else if(StringUtils.equals(TYPE_STREAM,responseType)){
					InputStream tempStream = post.getResponseBodyAsStream();
					byte[] temp = new byte[1024];
					int index = -1;
					while((index = tempStream.read(temp)) != -1){
						outputStream.write(temp);
					}
				}
			}else{
				System.err.println("***************************");
//				System.err.println("HttpClientUtil.setPostRequest()-请求url："+targetUrl+" 出错\n请求参数有："+JsonUtil.java2JsonStr(params)+"！！！");
				System.err.println("***************************");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//释放链接
			if(post != null){
				post.releaseConnection();
			}
			
			//关闭链接
			if(connectionManager != null){
				connectionManager.shutdown();
			}
		}
		
		return responseResult;
	}
	
	/**
	 * 测试方法
	 * @param args
	 */
	public static void main(String[] args)throws Exception{
		
		//String url = "http://192.168.33.33:7001/rworg/rworg/poPublic.do?method=portalSearch";
		String url = "http://localhost:9080/platform/baseService/um/dataSync.do";
		Map params = new HashMap();
		params.put("method","saveUser");
		params.put("userAccount","admin");
		params.put("keyWords","111");
		params.put("type","中午 我的是");
		
		SimpleHttpClient util = SimpleHttpClient.getInstance("GBK");
		
		String resultStr = util.getResponseBodyAsString(url,params);
		byte[] resultArr = util.getResponseBodyAsByteArray(url,params);
		
		File file = new File("D:\\result.txt");
		FileOutputStream out = new FileOutputStream(file);
		
		util.getResponseBodyAsStream(url,params,out);
		
		System.out.println("HttpClientUtil.main()-result:"+resultStr);
		if(resultArr != null){
			System.out.println("HttpClientUtil.main()-result:"+new String(resultArr));
		}
		
	}
	}