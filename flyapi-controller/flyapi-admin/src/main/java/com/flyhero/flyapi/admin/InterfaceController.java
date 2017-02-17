package com.flyhero.flyapi.admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.TextMessage;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.flyhero.flyapi.entity.Interfaces;
import com.flyhero.flyapi.entity.OperateLog;
import com.flyhero.flyapi.entity.UserProject;
import com.flyhero.flyapi.pojo.HttpResponse;
import com.flyhero.flyapi.pojo.InterPojo;
import com.flyhero.flyapi.pojo.JSONResult;
import com.flyhero.flyapi.pojo.Message;
import com.flyhero.flyapi.pojo.TeamMemberPojo;
import com.flyhero.flyapi.service.InterfaceService;
import com.flyhero.flyapi.service.LogService;
import com.flyhero.flyapi.service.ProjectService;
import com.flyhero.flyapi.service.UserProjectService;
import com.flyhero.flyapi.utils.Constant;
import com.flyhero.flyapi.utils.HttpClientUtil;
import com.flyhero.flyapi.websocket.SystemWebSocketHandler;
import com.github.pagehelper.PageInfo;

/**
 * 接口控制器
 * @ClassName: InterfaceController 
 * @author flyhero(http://flyhero.top)
 * @date 2016年10月29日 下午4:21:46 
 *
 */
@Controller
@RequestMapping("interface")
public class InterfaceController extends BaseController {

	@Autowired
	private InterfaceService interfaceService;
	@Autowired
	private LogService LogService;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private UserProjectService userProjectService;
	@Resource
	private SystemWebSocketHandler handler;

	/**
	 * 新建接口
	 * @Title: addInterface 
	 * @author flyhero(http://flyhero.top)  
	 * @date 2016年11月29日 下午4:22:24 
	 * @param @param interfaces
	 * @param @param projectId
	 * @param @return   
	 * @return JSONResult    
	 * @throws
	 */
	@RequestMapping("addInterface.do")
	@ResponseBody
	public JSONResult addInterface(Interfaces interfaces, Integer projectId) {
		interfaces.setCreator(getCuUser().getUserId());
		int flag = interfaceService.insertSelective(interfaces);
		if (flag != 0) {
			try {
				interfaces.setContent("");
				OperateLog log = new OperateLog(getCuUser().getUserId(),
						getCuUser().getUserName(), projectId,
						Constant.TYPE_INSERT, Constant.CLASS_INTERFACE,
						Constant.NAME_INTERFACE, "新建：【"
								+ interfaces.getInterName() + "】接口",
						JSONObject.toJSONString(interfaces));
				LogService.addLog(log);
				UserProject up = new UserProject();
				up.setUserId(getCuUser().getUserId());
				up.setProjectId(projectId);
				List<TeamMemberPojo> list = userProjectService
						.findTeamMembers(up);
				Message msg = new Message(-1L, "系统广播", 0L, getCuUser()
						.getUserName()
						+ "新建："
						+ interfaces.getInterName()
						+ "接口", new Date());
				handler.sendMessageToTeam(list,
						new TextMessage(JSON.toJSONString(msg)));
			} catch (IOException e) {
				e.printStackTrace();
			}
			projectService.updateDoneCount(projectId);
			return new JSONResult(Constant.MSG_OK, Constant.CODE_200);
		}
		return new JSONResult(Constant.MSG_ERROR, Constant.CODE_200);

	}

	/**
	 * 根据条件获取接口
	 * 
	 * @Title: findInterface
	 * @author flyhero(http://flyhero.top)
	 * @date 2016年11月18日 下午4:46:20
	 * @param @param interPojo
	 * @param @return
	 * @return JSONResult 返回类型
	 * @throws
	 */
	@ResponseBody
	@RequestMapping("findInterface.do")
	public JSONResult findInterface(InterPojo interPojo) {
		PageInfo<InterPojo> list = interfaceService.findInterByWhere(interPojo);
		return new JSONResult(Constant.MSG_OK, Constant.CODE_200, list);
	}

	/**
	 * 下载项目文档
	 * @Title: downloadInter 
	 * @author flyhero(http://flyhero.top)  
	 * @date 2016年12月1日 下午2:09:01 
	 * @param @param projectId
	 * @param @throws IOException   
	 * @return void    
	 * @throws
	 */
	@ResponseBody
	@RequestMapping("downloadInter.do")
	public void downloadInter(Integer projectId) throws IOException {
		boolean flag=false;
		UserProject up=new UserProject();
		up.setProjectId(projectId);
		List<TeamMemberPojo> list=userProjectService.findTeamMembers(up);
		int id=getCuUser().getUserId();
		for(TeamMemberPojo pojo:list){
			if(pojo.getUserId()==id){
				flag=true;
				break;
			}
		}
		if(flag){
			request.setCharacterEncoding("UTF-8");
			File file = null;
			InputStream fin = null;
			ServletOutputStream out = null;
			try {
				file = interfaceService.findAllInter(projectId);
				fin = new FileInputStream(file);
				response.setCharacterEncoding("utf-8");
				response.setContentType("application/msword");
				response.setHeader("content-disposition", "attachment;filename="
						+ URLEncoder.encode("inter-"+(int)(Math.random()*10000)+".doc", "UTF-8"));
				out = response.getOutputStream();
				byte[] buffer = new byte[512]; // 缓冲区
				int bytesToRead = -1;
				// 通过循环将读入的Word文件的内容输出到浏览器中
				while ((bytesToRead = fin.read(buffer)) != -1) {
					out.write(buffer, 0, bytesToRead);
				}
			}catch (IOException e ) {
				e.printStackTrace();
			} finally {
				if (fin != null)
					fin.close();
				if (out != null)
					out.close();
				if (file != null)
					file.delete(); // 删除临时文件
			}
		}

	}

	/**
	 * 根据接口编号获取接口详情
	 * 
	 * @Title: findOneInter
	 * @author flyhero(http://flyhero.top)
	 * @date 2016年11月24日 下午2:32:28
	 * @param @param interfaceId
	 * @param @return
	 * @return JSONResult
	 * @throws
	 */
	@ResponseBody
	@RequestMapping("findOneInter.do")
	public JSONResult findOneInter(Integer interfaceId) {
		Interfaces interfaces = interfaceService
				.selectByPrimaryKey(interfaceId);
		if (interfaces != null) {
			return new JSONResult(Constant.MSG_OK, Constant.CODE_200,
					interfaces);
		}
		return new JSONResult(Constant.MSG_OK, Constant.CODE_404, interfaces);
	}

	@RequestMapping("testHttp.do")
	@ResponseBody
	public JSONObject testHttp(String method, StringBuffer url, String param,
			int jsonWay) {
		JSONObject jsonget = HttpClientUtil.getUrl(method, url, param, jsonWay);
		HttpResponse hr = JSON.parseObject(jsonget.toString(),
				HttpResponse.class);
/*		for (Map.Entry<String, Object> entry : jsonget.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}*/
		json.put("result", hr.getContent());
		json.put("msg", Constant.MSG_OK);
		return json;
	}

	// 发布系统广播（群发）
	@ResponseBody
	@RequestMapping("send")
	public void send() throws IOException {
		Message msg = new Message();
		msg.setDate(new Date());
		msg.setFrom(-1L);
		msg.setFromName("系统广播");
		msg.setTo(0L);
		msg.setText("这是我的第一个消息");
		handler.sendMessageToUser(2L, new TextMessage(JSON.toJSONString(msg)));
	}

}
