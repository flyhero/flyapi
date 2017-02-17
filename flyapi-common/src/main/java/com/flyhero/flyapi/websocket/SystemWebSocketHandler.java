package com.flyhero.flyapi.websocket;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.flyhero.flyapi.pojo.Message;
import com.flyhero.flyapi.pojo.TeamMemberPojo;
import com.flyhero.flyapi.entity.User;
/**
 * Socket处理器
 * @ClassName: SystemWebSocketHandler 
 * @author flyhero(http://flyhero.top)
 * @date 2016年11月16日 下午1:32:22 
 *
 */
@Component
public class SystemWebSocketHandler implements WebSocketHandler {
	public static final Map<Long, WebSocketSession> userSocketSessionMap;

	static {
		userSocketSessionMap = new HashMap<Long, WebSocketSession>();
	}

	/**
	 * 建立连接后
	 */
	public void afterConnectionEstablished(WebSocketSession session)
			throws Exception {
		Long uid = (Long) session.getAttributes().get("uid");
		if (userSocketSessionMap.get(uid) == null) {
			userSocketSessionMap.put(uid, session);
		}
	}

	/**
	 * 消息处理，在客户端通过Websocket API发送的消息会经过这里，然后进行相应的处理
	 */
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
			if(message.getPayloadLength()==0)return;
			Message msg=JSONObject.parseObject(message.getPayload().toString(),Message.class);
			msg.setDate(new Date());
			if (msg.getTo() == -1){ //发送给指定某些人
				
			}else if (msg.getTo() == 0){ //发送给所有人
				broadcast(new TextMessage(JSON.toJSONString(msg)));
			}else { //发送给指定某个人
				sendMessageToUser(msg.getTo(), new TextMessage(JSON.toJSONString(msg)));
			}
			
			
	}

	/**
	 * 消息传输错误处理
	 */
	public void handleTransportError(WebSocketSession session,
			Throwable exception) throws Exception {
		if (session.isOpen()) {
			session.close();
		}
		Iterator<Entry<Long, WebSocketSession>> it = userSocketSessionMap
				.entrySet().iterator();
		// 移除Socket会话
		while (it.hasNext()) {
			Entry<Long, WebSocketSession> entry = it.next();
			if (entry.getValue().getId().equals(session.getId())) {
				userSocketSessionMap.remove(entry.getKey());
				System.out.println("Socket会话已经移除:用户ID" + entry.getKey());
				break;
			}
		}
	}

	/**
	 * 关闭连接后
	 */
	public void afterConnectionClosed(WebSocketSession session,
			CloseStatus closeStatus) throws Exception {
		System.out.println("Websocket:" + session.getId() + "已经关闭");
		Iterator<Entry<Long, WebSocketSession>> it = userSocketSessionMap
				.entrySet().iterator();
		// 移除Socket会话
		while (it.hasNext()) {
			Entry<Long, WebSocketSession> entry = it.next();
			if (entry.getValue().getId().equals(session.getId())) {
				userSocketSessionMap.remove(entry.getKey());
				System.out.println("Socket会话已经移除:用户ID" + entry.getKey());
				break;
			}
		}
	}

	public boolean supportsPartialMessages() {
		return false;
	}

	/**
	 * 给所有在线用户发送消息
	 * 
	 * @param message
	 * @throws IOException
	 */
	public void broadcast(final TextMessage message) throws IOException {
		Iterator<Entry<Long, WebSocketSession>> it = userSocketSessionMap
				.entrySet().iterator();

		// 多线程群发
		while (it.hasNext()) {

			final Entry<Long, WebSocketSession> entry = it.next();

			if (entry.getValue().isOpen()) {
				// entry.getValue().sendMessage(message);
				new Thread(new Runnable() {

					public void run() {
						try {
							if (entry.getValue().isOpen()) {
								entry.getValue().sendMessage(message);
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
					}

				}).start();
			}

		}
	}
	/**
	 * 发送消息给团队成员
	 * @Title: sendMessageToTeam  
	 * @author flyhero(http://flyhero.top)
	 * @date 2016年11月16日 下午2:12:34 
	 * @param @param list
	 * @param @param message
	 * @param @throws IOException    
	 * @return void    返回类型 
	 * @throws
	 */
	public void sendMessageToTeam(List<TeamMemberPojo> list,final TextMessage message) throws IOException {
		for(TeamMemberPojo t:list){
			WebSocketSession session = userSocketSessionMap.get(Long.valueOf(t.getUserId()));
			if (session != null && session.isOpen()) {
				session.sendMessage(message);
			}
		}

	}
	/**
	 * 给某个用户发送消息
	 * 
	 * @param userName
	 * @param message
	 * @throws IOException
	 */
	public void sendMessageToUser(Long uid, TextMessage message)
			throws IOException {
		WebSocketSession session = userSocketSessionMap.get(uid);
		if (session != null && session.isOpen()) {
			session.sendMessage(message);
		}
	}

}
