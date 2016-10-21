package com.flyhero.flyapi.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

/**
 * 使用HttpClient模拟HTTP访问
 * 
 * @see 
 *      ==========================================================================
 *      =====================================================
 * @see HttpClient代表了一个HTTP客户端,HttpClient接口中定义了大多数基本的HTTP请求执行行为
 * @see HttpEntity是发送或接收消息的载体,它可以通过HttpResponse.getEntity()获取到
 * @see HttpConnection代表了一个HTTP连接
 * @see 
 *      ==========================================================================
 *      =====================================================
 */
public class HttpClientUtil {
	public static void main(String[] args) throws Exception {

		JSONObject json = new JSONObject();
		json.put("mobile", "18365282216");
		json.put("password", "123456");
/*		{
			"mobile":"18365282216",
			"password":"123456"
		}*/
		// 参数可以任意加 ， 返回任意参数 json.put("xxx", "xxx");
		// System.out.println(json.toString());
//		JSONObject jsonget = HttpClientUtil.getUrl("POST",
//				"http://139.196.239.197:8080/jzll_s1/user/addPhoneRegisteredUser", json);
//		System.out.println(jsonget);
/*		JSONObject jsonpost = HttpClientUtil.getUrl("post",
				"http://html.yq1012.com", json);
		System.out.println(jsonpost);*/

	}

	public static JSONObject getUrl(String method, String requestUrl,
			String params,int jsonWay) {
		JSONObject json=JSON.parseObject(params);
		JSONObject jsonobject = new JSONObject();
		if ("POST".equals(method)) {
			if(jsonWay == 0){
				List<NameValuePair> formParams = new ArrayList<NameValuePair>();
				for (Map.Entry<String, Object> entry : json.entrySet()) {
					formParams.add(new BasicNameValuePair(entry.getKey(),
							(String) entry.getValue()));
				}
				jsonobject = sendPostRequest(requestUrl, formParams);	
			}else{
				jsonobject = sendPostRequest(requestUrl, params);
			}


		} else {
			if(jsonWay == 0){
				// 特殊字符进行转义
				requestUrl += "?";
				for (Map.Entry<String, Object> entry : json.entrySet()) {
					System.out.println(entry.getKey() + ":" + entry.getValue());
					String param = ((String) entry.getValue()).replace("\"", "%22")
							.replace("{", "%7b").replace("}", "%7d");
					requestUrl += entry.getKey() + "=" + param + "&";
				}
				int index=requestUrl.lastIndexOf("&");
				requestUrl=requestUrl.substring(0, index);
				System.out.println(requestUrl);
				jsonobject = sendGetRequest(requestUrl);
			}else{
				String s=params.replace(" ", "").replace("\"", "%22").replace("{", "%7b").replace("}", "%7d");
				requestUrl += "?jsonString="+s;
				System.out.println(requestUrl);
				jsonobject = sendGetRequest(requestUrl);
				
				
			}


		}
		return jsonobject;

	}

	/**
	 * 发送GET请求
	 * 
	 * @param requestUrl
	 *            请求的地址(含参数)
	 * @return 响应内容
	 */
	@SuppressWarnings("finally")
	public static JSONObject sendGetRequest(String requestUrl) {
		JSONObject json = new JSONObject();
		long responseLength = 0; // 响应长度
		String responseContent = null; // 响应内容
		HttpClient httpClient = new DefaultHttpClient(); // 创建默认的httpClient实例
		HttpGet httpGet = new HttpGet(requestUrl); // 创建HttpGet
		try {
			HttpResponse response = httpClient.execute(httpGet); // 执行GET请求
			HttpEntity entity = response.getEntity(); // 获取响应实体
			if (null != entity) {
				responseLength = entity.getContentLength();
				responseContent = EntityUtils.toString(entity, "UTF-8");
				EntityUtils.consume(entity); // Consume response content
			}
			json.put("address", httpGet.getURI().getSchemeSpecificPart());
			json.put("code", response.getStatusLine().getStatusCode());
			json.put("length", responseLength);
			json.put("content", responseContent);
		} catch (ClientProtocolException e) {
			// 该异常通常是协议错误导致
			// 比如构造HttpGet对象时传入的协议不对(将"http"写成"htp")或者服务器端返回的内容不符合HTTP协议要求等
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// 该异常通常是网络原因引起的,如HTTP服务器未启动等
			e.printStackTrace();
		} finally {
			httpClient.getConnectionManager().shutdown(); // 关闭连接，释放资源
			return json;
		}
	}

	/**
	 * 发送带有表单参数的POST请求
	 * 
	 * @param requestUrl
	 *            请求的地址(不含参数)
	 * @return 响应内容
	 */
	@SuppressWarnings("finally")
	public static JSONObject sendPostRequest(String requestUrl,
			List<NameValuePair> formParams) {
		JSONObject json = new JSONObject();
		long responseLength = 0; // 响应长度
		String responseContent = null; // 响应内容
		HttpClient httpClient = new DefaultHttpClient(); // 创建默认的httpClient实例
		HttpPost httpPost = new HttpPost(requestUrl); // 创建HttpPost

		try {
			httpPost.setEntity(new UrlEncodedFormEntity(formParams, "UTF-8"));
			HttpResponse response = httpClient.execute(httpPost); // 执行POST请求
			HttpEntity entity = response.getEntity(); // 获取响应实体
			if (null != entity) {
				responseLength = entity.getContentLength();
				responseContent = EntityUtils.toString(entity, "UTF-8");
				EntityUtils.consume(entity); // Consume response content
			}
			json.put("address", httpPost.getURI().getSchemeSpecificPart());
			json.put("code", response.getStatusLine().getStatusCode());
			json.put("length", responseLength);
			json.put("content", responseContent);
			/*
			 * System.out.println("请求地址: " + httpPost.getURI());
			 * System.out.println("响应状态: " + response.getStatusLine());
			 * System.out.println("响应长度: " + responseLength);
			 * System.out.println("响应内容: " + responseContent);
			 */
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			httpClient.getConnectionManager().shutdown(); // 关闭连接，释放资源
			return json;
		}
	}
	@SuppressWarnings({ "finally", "deprecation" })
	public static JSONObject sendPostRequest(String requestUrl,
			String params) {
		JSONObject json = new JSONObject();
		long responseLength = 0; // 响应长度
		String responseContent = null; // 响应内容
		HttpClient httpClient = new DefaultHttpClient(); // 创建默认的httpClient实例
		HttpPost httpPost = new HttpPost(requestUrl); // 创建HttpPost

		try {
//			String params="{\"mobile\":\"18365282216\",\"password\":\"123456\"}";
			StringEntity s=new StringEntity(params, "UTF-8");
			httpPost.setEntity(s);
			HttpResponse response = httpClient.execute(httpPost); // 执行POST请求
			HttpEntity entity = response.getEntity(); // 获取响应实体
			if (null != entity) {
				responseLength = entity.getContentLength();
				responseContent = EntityUtils.toString(entity, "UTF-8");
				EntityUtils.consume(entity); // Consume response content
			}
			json.put("address", httpPost.getURI().getSchemeSpecificPart());
			json.put("code", response.getStatusLine().getStatusCode());
			json.put("length", responseLength);
			json.put("content", responseContent);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			httpClient.getConnectionManager().shutdown(); // 关闭连接，释放资源
			return json;
		}
	}
	/**
	 * 将Json对象转换成Map
	 * 
	 * @param jsonObject
	 *            json对象
	 * @return Map对象
	 * @throws JSONException
	 */
	/*
	 * public static Map toMap(JSONObject jsonObject) throws JSONException {
	 * 
	 * Map result = new HashMap(); Iterator iterator = jsonObject.keys(); String
	 * key = null; String value = null;
	 * 
	 * while (iterator.hasNext()) {
	 * 
	 * key = (String) iterator.next(); value = jsonObject.getString(key);
	 * result.put(key, value);
	 * 
	 * } return result;
	 * 
	 * }
	 */

	/**
	 * 根据 json json 的key 查询对应的value
	 * 
	 * @param jsonObject
	 * @param key
	 * @return
	 * @throws JSONException
	 */
	public static Object toEqual(JSONObject jsonObject, String key)
			throws JSONException {

		Object o = jsonObject.get(key);
		return o;

	}

}