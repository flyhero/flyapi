package com.flyhero.flyapi.web;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.flyhero.flyapi.entity.Resume;
import com.flyhero.flyapi.pojo.JSONResult;
import com.flyhero.flyapi.service.impl.ResumeServiceImpl;

/**
 * 简历控制器
 * @ClassName: ResumeController 
 * @author flyhero(http://flyhero.top)
 * @date 2017年3月1日 上午11:44:01 
 *
 */
@Controller
@RequestMapping("resume")
public class ResumeController extends BaseController{
	
	Logger logger=Logger.getLogger(ResumeController.class);
	@Autowired
	private ResumeServiceImpl resumeService;
	/**
	 * 前往简历页
	 * @Title: goResumeHtml   
	 * @author flyhero(http://flyhero.top)
	 * @date 2017年3月2日 下午3:28:23 
	 * @param: @param resumeId
	 * @param: @return      
	 * @return: ModelAndView      
	 */
	@RequestMapping(value="/publish/{resumeId}",method=RequestMethod.GET)
	public ModelAndView goResumeHtml(@PathVariable("resumeId") Integer resumeId){
		mv.addObject("resumeId", resumeId);
		mv.setViewName("publish_resume");
		return mv;
	}
	
	/**
	 * 获取某个简历信息
	 * @Title: findOneResume   
	 * @author flyhero(http://flyhero.top)
	 * @date 2017年3月2日 下午3:28:27 
	 * @param: @param resumeId
	 * @param: @return      
	 * @return: JSONResult      
	 */
	@ResponseBody
	@RequestMapping("/publish/info")
	public JSONResult findOneResume(Integer resumeId){
		Resume resume=null;
		try {
			resume=resumeService.findOneResume(resumeId);
		} catch (Exception e) {
			logger.error("获取某个简历出错：",e);
			return JSONResult.error(resume);
		}
		
		return JSONResult.ok(resume);
	}
	
	/**
	 * 获取某人发布的简历
	 * @Title: findResumeByUserId   
	 * @author flyhero(http://flyhero.top)
	 * @date 2017年3月2日 上午11:34:18 
	 * @param: @param userId
	 * @param: @return      
	 * @return: JSONResult      
	 */
	@ResponseBody
	@RequestMapping(value="/findResumeByUserId/{userId}",method=RequestMethod.GET)
	public JSONResult findResumeByUserId(@PathVariable Integer userId){
		Resume resume=null;
		try {
			resume=resumeService.findResumeByUserId(userId);
		} catch (Exception e) {
			logger.error("获取已发布简历出错：",e);
			return JSONResult.error(resume);
		}
		
		return JSONResult.ok(resume);
	}
	
	/**
	 * 保存简历
	 * @Title: saveUserResume 
	 * @author flyhero(http://flyhero.top)  
	 * @date 2017年3月2日 上午10:21:49 
	 * @param @param resume
	 * @param @return   
	 * @return JSONResult    
	 */
	@ResponseBody
	@RequestMapping(value="saveUserResume.do",method=RequestMethod.POST)
	public JSONResult saveUserResume(Resume resume){
		resume.setCreateTime(new Date());
		try {
			resumeService.saveUserResume(resume);
		} catch (Exception e) {
			logger.error("保存简历出错",e);
			return JSONResult.error();
		}
		return JSONResult.ok();
		
	}

}
