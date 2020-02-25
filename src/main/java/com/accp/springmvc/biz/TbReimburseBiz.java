package com.accp.springmvc.biz;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.accp.springmvc.dao.IEmployeeDao;
import com.accp.springmvc.dao.ILeaveDao;
import com.accp.springmvc.dao.IReimbursementDao;
import com.accp.springmvc.pojo.ReimburseDetail;
import com.accp.springmvc.pojo.TbCheck;
import com.accp.springmvc.pojo.TbCount;
import com.accp.springmvc.pojo.TbReimburse;
import com.accp.springmvc.vo.EmployeeVo;
import com.accp.springmvc.vo.LeaveVo;
import com.accp.springmvc.vo.ReimburseVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("TbReimburseBiz")
public class TbReimburseBiz {
	@Resource
	private IReimbursementDao iReimbursementDao;
	@Resource
	private ILeaveDao iLeaveDao;
	@Resource
	private IEmployeeDao iEmployeeDao;

	/**
	 * 报销模块--提交功能 以及 保存功能
	 * 
	 * @param tbReimburse
	 * @param reimburseDetails
	 * @param tbCheck
	 * @return
	 */
	public Integer addReimbursement(TbReimburse tbReimburse, Integer positionId, Integer departmentId) {
		Integer num = -1;
		if (tbReimburse.getStatusId() == 2) {
			Integer nextDealMan = null;
			if (positionId == 2) {
				nextDealMan = iLeaveDao.selectNextMan(positionId, departmentId);
			} else {
				nextDealMan = iLeaveDao.selectNextMan(null, 0);
			}
			tbReimburse.setNextDealMan(nextDealMan);
		}
		Integer num1 = iReimbursementDao.addReimbursement(tbReimburse);
		TbCount tbCount =new TbCount();
		EmployeeVo emp=iEmployeeDao.selectOneEmployee(tbReimburse.getCreateMan());
		tbCount.setMoney(tbReimburse.getTotalCount());
		tbCount.setEmployeeId(emp.getEmployeeId());
		tbCount.setEmployeeName(emp.getEmployeeName());
		tbCount.setDepartmentName(emp.getDepartmentName());
		tbCount.setDepartmentId(emp.getDepartmentId());
		Calendar calendar = Calendar.getInstance();
		tbCount.setYear(calendar.get(Calendar.YEAR));
		tbCount.setMonth((calendar.get(Calendar.MONTH)+1));
		Integer num3=iReimbursementDao.addCount(tbCount);
		if (num1 > 0) {
			Integer reimburseId = iReimbursementDao.selectMaxReimbursemen();
			Integer num2 = iReimbursementDao.addReimburseDetail(tbReimburse.getReimburseDetails(), reimburseId);
			if (num2 > 0) {
				num = 1;
			} else {
				throw new RuntimeException("新增报销详细表失败");
			}
		} else {
			throw new RuntimeException("新增报销主表失败");
		}
		return num;
	};

	/**
	 * 查询报销
	 */
	public PageInfo<ReimburseVo> findTbReimburse(Integer pageNum, Integer pageSize, Integer leaveId, Integer positionId,
			Integer departmentId, Integer createMan, String starttime, String endtime, String createName,
			Integer statusId) {
		PageHelper.startPage(pageNum, pageSize);
		PageInfo<ReimburseVo> leaves = new PageInfo<ReimburseVo>(iReimbursementDao.selectReimbursement(leaveId, positionId,
				departmentId, starttime, endtime, createName, createMan, statusId));
		return leaves;

	}

	/**
	 * 修改报销 --修改页面的保存 和提交
	 */

	public Integer modifyReimburse(TbReimburse tbReimburse, Integer positionId, Integer departmentId) {
		Integer num = -1;
		if (tbReimburse.getStatusId() == 2) {
			Integer nextDealMan = null;
			if (positionId == 2) {
				nextDealMan = iLeaveDao.selectNextMan(positionId, departmentId);
			} else {
				nextDealMan = iLeaveDao.selectNextMan(null, 0);
			}
			tbReimburse.setNextDealMan(nextDealMan);
		}
		Integer num3 = iReimbursementDao.modifyReimbursement(tbReimburse);
		if (num3 > 0) {
			Integer num1 = iReimbursementDao.removeReimburseDetail(tbReimburse.getReimburseId());
			if (num1 > 0) {
				Integer num2 = iReimbursementDao.addReimburseDetail(tbReimburse.getReimburseDetails(),
						tbReimburse.getReimburseId());
				if (num2 > 0) {
					num = 1;
				} else {
					throw new RuntimeException("新增报销详细表失败");
				}
			} else {
				throw new RuntimeException("删除报销详表失败");
			}
		} else {
			throw new RuntimeException("修改报销表失败");
		}
 		return num;
	}

	/**
	 * 删除报销记录
	 */

	public Integer removeReimburse(Integer reimburseId) {
		Integer num = -1;
		Integer num1 = iReimbursementDao.removeReimburse(reimburseId);
		if (num1 > 0) {
			num = 1;
		}
		return num;
	}

	/**
	 * 修改报销表 提交事件
	 */
	public Integer modifyReimburseByreimburseId(TbReimburse tbReimburse, Integer positionId, Integer departmentId) {
		Integer num = -1;
		Integer nextDealMan = null;
		if (positionId == 2) {
			nextDealMan = iLeaveDao.selectNextMan(positionId, departmentId);
		} else {
			nextDealMan = iLeaveDao.selectNextMan(null, 0);
		}
		tbReimburse.setNextDealMan(nextDealMan);
		Integer num1 = iReimbursementDao.modifyReimbursement(tbReimburse);
		TbCount tbCount =new TbCount();
		EmployeeVo emp=iEmployeeDao.selectOneEmployee(tbReimburse.getCreateMan());
		tbCount.setMoney(tbReimburse.getTotalCount());
		tbCount.setEmployeeId(emp.getEmployeeId());
		tbCount.setEmployeeName(emp.getEmployeeName());
		tbCount.setDepartmentName(emp.getDepartmentName());
		tbCount.setDepartmentId(emp.getDepartmentId());
		Calendar calendar = Calendar.getInstance();
		tbCount.setYear(calendar.get(Calendar.YEAR));
		tbCount.setMonth((calendar.get(Calendar.MONTH)+1));
		Integer num3=iReimbursementDao.addCount(tbCount);
		if (num1 > 0) {
			num = 1;
		}
		return num;
	}

}
