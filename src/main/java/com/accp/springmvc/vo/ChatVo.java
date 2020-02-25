package com.accp.springmvc.vo;

public class ChatVo {
	private Integer number;
	private Integer cUserSend;
	private String userName;
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Integer getcUserSend() {
		return cUserSend;
	}
	public void setcUserSend(Integer cUserSend) {
		this.cUserSend = cUserSend;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "ChatVo [number=" + number + ", cUserSend=" + cUserSend + ", userName=" + userName + "]";
	}
	public ChatVo(Integer number, Integer cUserSend, String userName) {
		super();
		this.number = number;
		this.cUserSend = cUserSend;
		this.userName = userName;
	}
	public ChatVo() {
		super();
	}
	
	
}
