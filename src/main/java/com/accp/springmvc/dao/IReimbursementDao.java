package com.accp.springmvc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.springmvc.pojo.ReimburseDetail;
import com.accp.springmvc.pojo.TbCheck;
import com.accp.springmvc.pojo.TbCount;
import com.accp.springmvc.pojo.TbReimburse;
import com.accp.springmvc.vo.LeaveVo;
import com.accp.springmvc.vo.ReimburseVo;

/**
 * 报销模块
 * @author 小虎
 *
 */
public interface IReimbursementDao {
	/**
	*新增报销表
	*/
	Integer addReimbursement(@Param("tbReimburse")TbReimburse tbReimburse);
	/**
	 * 新增报销详情表
	 */
	Integer addReimburseDetail(@Param("ReimburseDetails")List<ReimburseDetail> reimburseDetails,@Param("reimburseId")Integer reimburseId);
	
	/**
	 * 查询报销 
	 * @param leaveId 请假的id 没有则查看所有 有查看单个
	 * @return
	 */
	List<ReimburseVo> selectReimbursement(@Param("reimburseId") Integer reimburseId, @Param("positionId") Integer positionId,
			@Param("departmentId") Integer departmentId, @Param("starttime") String starttime,
			@Param("endtime") String endtime,@Param("createName")  String createName,@Param("createMan") Integer createMan,@Param("statusId")Integer statusId);

	/**
	 * 查询报销表的id
	 */
	Integer selectMaxReimbursemen();
	
	/**
	 * 删除报销详细表
	 */
	Integer removeReimburseDetail(@Param("mainId")Integer mainId);
	/**
	 * 修改报销表
	 */
	Integer modifyReimbursement(@Param("tbReimburse")TbReimburse tbReimburse);
	/**
	 * 修改审批表
	 */
	Integer modifyTbCheck(@Param("tbCheck")TbCheck tbCheck);
	
	/**
	 * 删除报销表以及报销详细表
	 */
	Integer removeReimburse(@Param("reimburseId")Integer reimburseId);
	
	/**
	 * 新增统计
	 */
	 Integer addCount(@Param("tbCount") TbCount tbCount);
	
	
}
