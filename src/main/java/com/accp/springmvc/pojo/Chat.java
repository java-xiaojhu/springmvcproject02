package com.accp.springmvc.pojo;

import java.util.Date;

public class Chat {
	private Integer cid;
	private Integer cUserSend;
	private Integer cUserTake;
	private Date cTime;
	private String cContent;
	private Integer cStatus;
	private  Integer cISpIC;
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Integer getcUserSend() {
		return cUserSend;
	}
	public void setcUserSend(Integer cUserSend) {
		this.cUserSend = cUserSend;
	}
	public Integer getcUserTake() {
		return cUserTake;
	}
	public void setcUserTake(Integer cUserTake) {
		this.cUserTake = cUserTake;
	}
	public Date getcTime() {
		return cTime;
	}
	public void setcTime(Date cTime) {
		this.cTime = cTime;
	}
	public String getcContent() {
		return cContent;
	}
	public void setcContent(String cContent) {
		this.cContent = cContent;
	}
	public Integer getcStatus() {
		return cStatus;
	}
	public void setcStatus(Integer cStatus) {
		this.cStatus = cStatus;
	}
	public Integer getcISpIC() {
		return cISpIC;
	}
	public void setcISpIC(Integer cISpIC) {
		this.cISpIC = cISpIC;
	}
	public Chat() {
		super();
	}
	@Override
	public String toString() {
		return "Chat [cid=" + cid + ", cUserSend=" + cUserSend + ", cUserTake=" + cUserTake + ", cTime=" + cTime
				+ ", cContent=" + cContent + ", cStatus=" + cStatus + ", cISpIC=" + cISpIC + "]";
	}
	public Chat(Integer cid, Integer cUserSend, Integer cUserTake, Date cTime, String cContent, Integer cStatus,
			Integer cISpIC) {
		super();
		this.cid = cid;
		this.cUserSend = cUserSend;
		this.cUserTake = cUserTake;
		this.cTime = cTime;
		this.cContent = cContent;
		this.cStatus = cStatus;
		this.cISpIC = cISpIC;
	}
	
	
}
