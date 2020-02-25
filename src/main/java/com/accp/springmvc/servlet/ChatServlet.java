package com.accp.springmvc.servlet;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accp.springmvc.biz.ChatBiz;
import com.accp.springmvc.vo.ChatVo;
@RestController
@RequestMapping("/api/ChatServlet")
public class ChatServlet {
	
	@Resource
	private ChatBiz chatBiz;
	@GetMapping("/receive/{Tuser}")
	public List<ChatVo> findTUser(@PathVariable Integer Tuser){		
		return chatBiz.queryByUserTock(Tuser);
	}
	
	

}
