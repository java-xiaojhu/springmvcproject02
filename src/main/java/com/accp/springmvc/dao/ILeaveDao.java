package com.accp.springmvc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.springmvc.pojo.TbCheck;
import com.accp.springmvc.pojo.TbLeave;
import com.accp.springmvc.pojo.TbStatus;
import com.accp.springmvc.vo.LeaveVo;

/**
 * 请假模块
 * 
 * @author 小虎
 *
 */
public interface ILeaveDao {

	/**
	 * 新增请假
	 */
	Integer addLeave(@Param("tbLeave") TbLeave tbLeave);

	/**
	 * 修改请假表
	 * 
	 * @param tbLeave
	 * @return
	 */
	Integer updateLeaveById(@Param("tbLeave") TbLeave tbLeave);

	/**
	 * 查看请假
	 * 
	 * @param leaveId 请假的id 没有则查看所有 有查看单个
	 * @return
	 */
	List<LeaveVo> selectLeaveByid(@Param("leaveId") Integer leaveId, @Param("positionId") Integer positionId,
			@Param("departmentId") Integer departmentId, @Param("starttime") String starttime,
			@Param("endtime") String endtime,@Param("createName")  String createName,@Param("createMan") Integer createMan,@Param("statusId")Integer statusId);

	/**
	 * 查询出下一个处理人
	 */
	Integer selectNextMan(@Param("positionId") Integer positionId, @Param("departmentId") Integer departmentId);
	/**
	 * 查询请假根据 请假编号
	 * @param leaveId
	 * @return
	 */
	TbLeave selectTbCheck(@Param("leaveId") Integer leaveId);
	List<TbStatus> selectStude();

}
