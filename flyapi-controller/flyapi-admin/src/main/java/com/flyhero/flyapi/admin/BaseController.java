package com.flyhero.flyapi.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.flyhero.flyapi.entity.User;

public class BaseController {
	protected HttpServletResponse response;
  	protected HttpServletRequest request;
  	protected HttpSession session;
  	protected ModelAndView mv;
  	protected JSONObject json = null;
	/**
	 * spring 中request、response是线程安全的，可以直接注入
	 * @ModelAttribute注解只有在被@Controller和@ControllerAdvice两个注解的类下使用
	 * ModelAttribute的作用 
	 * 1)放置在方法的形参上：表示引用Model中的数据
	 * 2)放置在方法上面：表示请求该类的每个Action前都会首先执行它，也可以将一些准备数据的操作放置在该方法里面。
	 * @param request
	 * @param response
	 */
  	@ModelAttribute  
  	public void setReqAndRes(HttpServletRequest request, HttpServletResponse response,HttpSession session){  
  	    this.response= response;  
  	    this.request = request;
  	    this.session = session;
  	    mv = new ModelAndView();
  	    json = new JSONObject();
  	}
  	/**
  	 * 获取当前用户
  	 * <p>Title: getCuUser</p>
  	 * <p>Description: </p>
  	 * @return
  	 */
  	 public User getCuUser(){
  		 return (User)session.getAttribute("user");
  	 }
  		/**
  		 * @return
  		 */
  		protected HashMap<String, String> getRequestHeaders()  {
  			HashMap<String, String> requestHeaders = new HashMap<String, String>();
  			@SuppressWarnings("unchecked")
  			Enumeration<String> headerNames = request.getHeaderNames();
  			while (headerNames.hasMoreElements()) {
  				String headerName = headerNames.nextElement();
  				String headerValue = request.getHeader(headerName);
  				requestHeaders.put(headerName, headerValue);
  			}
  			return requestHeaders;
  		}

  		/**
  		 * @return
  		 */
  		protected HashMap<String, String> getRequestParams() {
  			HashMap<String, String> requestParams = new HashMap<String, String>();
  			@SuppressWarnings("unchecked")
  			Enumeration<String> paramNames = request.getParameterNames();
  			while (paramNames.hasMoreElements()) {
  				String paramName = paramNames.nextElement();
  				String paramValue = request.getParameter(paramName);
  				requestParams.put(paramName, paramValue);
  			}
  			return requestParams;
  		}
  		
  		 protected void printMsg(String message){
  				response.setHeader("Content-Type" , "text/html");
  				response.setCharacterEncoding("utf-8");
  				try {
  					PrintWriter out = response.getWriter();
  					out.write(message);
  					out.flush();
  					out.close();
  				} catch (IOException e) {
  					e.printStackTrace();
  				}
  			}
  		 
//  		 protected void handleBindingValidation(BindingResult bindingResult) throws MyException{
//  		        if(bindingResult.hasErrors()){
//  		            List<ObjectError> list = bindingResult.getAllErrors();
//  		            StringBuilder msg= new StringBuilder();
//  		            for(ObjectError error:list){
//  		            	msg.append(error.getDefaultMessage()+";");
//  		            }
//  		            throw new MyException("0",msg.toString());
//  		        }
//  		    }
  		 
  		 protected Object getParam(String key, String def) {
  				String value = request.getParameter(key);
  				return value==null?def:value;
  		}
  	
}
