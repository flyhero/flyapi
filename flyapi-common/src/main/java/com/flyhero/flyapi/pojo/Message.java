package com.flyhero.flyapi.pojo;

import java.util.Date;

public class Message {

	//发送者
	public Long from;
	//发送者名称
	public String fromName;
	//接收者
	public Long to;
	/**
	 * 1.
	 */
	public Integer type;
	//发送的文本
	public String text;
	//发送日期
	public Date date;

	
	public Message() {
		super();
	}

	public Message(Long from, String fromName, Long to, Integer type,
			String text, Date date) {
		super();
		this.from = from;
		this.fromName = fromName;
		this.to = to;
		this.type = type;
		this.text = text;
		this.date = date;
	}


	public Long getFrom() {
		return from;
	}


	public void setFrom(Long from) {
		this.from = from;
	}


	public String getFromName() {
		return fromName;
	}


	public void setFromName(String fromName) {
		this.fromName = fromName;
	}


	public Long getTo() {
		return to;
	}


	public void setTo(Long to) {
		this.to = to;
	}


	public Integer getType() {
		return type;
	}


	public void setType(Integer type) {
		this.type = type;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}

}
