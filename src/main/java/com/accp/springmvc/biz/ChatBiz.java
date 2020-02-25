package com.accp.springmvc.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.accp.springmvc.dao.ICheckDao;
import com.accp.springmvc.dao.IMessageDao;
import com.accp.springmvc.pojo.Chat;
import com.accp.springmvc.vo.ChatVo;
@Service("ChatBiz")
public class ChatBiz {
	@Resource
	private IMessageDao iMessageDao;

	/**
	 * 查詢
	 * @param userSend
	 * @param userTock
	 * @return
	 */
	public List<Chat> queryByUserSendAndUserTock(Integer userSend,Integer userTock){
		return iMessageDao.selectMessage(userSend, userTock);
	}
	
	/**
	 * 接收者查询
	 * @param userSend
	 * @param userTock
	 * @return
	 */
	public List<ChatVo> queryByUserTock(Integer userTock){		
		return iMessageDao.selectTUserMessage(userTock);
	}
	
	/**
	 * 改变转态
	 * @param userTock
	 * @return
	 */
	public  int modifyChatStatus(Integer userTock,Integer userSend) {		
		return iMessageDao.updateMessage(userSend, userTock);
	}

}
