package com.accp.springmvc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.springmvc.pojo.Chat;
import com.accp.springmvc.vo.ChatVo;

/**
 * 信息模块
 * @author 小虎
 *
 */
public interface IMessageDao {
	/**
	 * 新增
	 * @param chat  实体
	 * @return
	 */
	Integer addMessage(@Param("chat")Chat chat);
	/**
	 * 聊天查询
	 * @param sUser 发送者
	 * @param tUser 接收者
	 * @return
	 */
	List<Chat> selectMessage(Integer sUser,Integer tUser);
	/**
	 * 修改信息状态
	 * @param sUser  发送者
	 * @param tUser  接收者
	 * @return
	 */
	Integer updateMessage(Integer sUser,Integer tUser);
	
	/**
	 * 接收者查询
	 */
	
	List<ChatVo> selectTUserMessage(@Param("userTock")Integer userTock );
}
