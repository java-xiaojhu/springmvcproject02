package com.accp.springmvc.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.accp.springmvc.dao.ILeaveDao;
import com.accp.springmvc.dao.IMessageDao;
import com.accp.springmvc.pojo.Chat;
import com.accp.springmvc.pojo.TbCheck;
import com.accp.springmvc.pojo.TbLeave;
import com.accp.springmvc.pojo.TbStatus;
import com.accp.springmvc.vo.LeaveVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 请假业务层
 * 
 * @author 小虎
 *
 */
@Service
public class LeaveBiz {
	@Resource
	private ILeaveDao iLeaveDao;
	@Resource
	private IMessageDao iMessageDao;

	/**
	 * 添加请假
	 * 
	 * @param tbLeave 请假参数
	 * @return
	 */
	public Integer addLeave(TbLeave tbLeave, Integer positionId) {
		Integer num = 0;
		if (positionId == 2) {
			tbLeave.setNextDealMan(iLeaveDao.selectNextMan(positionId, tbLeave.getDepartmentId()));
		} else {
			tbLeave.setNextDealMan(iLeaveDao.selectNextMan(null, 0));
		}
		Integer num1 = iLeaveDao.addLeave(tbLeave);
		if (num1 > 0) {
			Chat chat =new Chat();
			chat.setcUserSend(tbLeave.getCreateMan());
			chat.setcUserTake(tbLeave.getNextDealMan());
			chat.setcContent("请假申请");
			iMessageDao.addMessage(chat);
			num = 1;
		} else {
			throw new RuntimeException("新增请假异常");
		}
		return num;
	}

	/**
	 * 查询请假
	 */

	public PageInfo<LeaveVo> findLeaves(Integer pageNum, Integer pageSize, Integer leaveId, Integer positionId,
			Integer departmentId,Integer createMan, String starttime,String endtime,String createName,Integer statusId) {
		PageHelper.startPage(pageNum, pageSize);
		PageInfo<LeaveVo> leaves = new PageInfo<LeaveVo>(iLeaveDao.selectLeaveByid(leaveId,positionId, departmentId,  starttime, endtime, createName,createMan,statusId));
		return leaves;

	}
	
	/**
	 * 查询状态
	 */
	public List<TbStatus> findState() {
		return iLeaveDao.selectStude();

	}
}
