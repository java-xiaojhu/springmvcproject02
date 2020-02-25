package com.accp.springmvc.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.accp.springmvc.dao.ICheckDao;
import com.accp.springmvc.dao.ILeaveDao;
import com.accp.springmvc.dao.IMessageDao;
import com.accp.springmvc.dao.IReimbursementDao;
import com.accp.springmvc.pojo.Chat;
import com.accp.springmvc.pojo.TbCheck;
import com.accp.springmvc.pojo.TbLeave;
import com.accp.springmvc.pojo.TbReimburse;
import com.accp.springmvc.vo.CheckVo;

@Service("CheckBiz")
public class CheckBiz {
	@Resource
	private ICheckDao iCheckDao;
	@Resource
	private ILeaveDao iLeaveDao;
	@Resource
	private IReimbursementDao iReimbursementDao;
	@Resource
	private IMessageDao iMessageDao;

	/**
	 * 
	 * @param tbCheck
	 * @return
	 */
	public Integer addTbCheck(TbCheck tbCheck) {
		Integer num = -1;
		Integer num1 = iCheckDao.addCheack(tbCheck);
		if (tbCheck.getCheckMan() == 1017) {
			TbLeave tbLeave = new TbLeave();
			tbLeave.setStatusId(7);
			tbLeave.setNextDealMan(10000);
			tbLeave.setLeaveId(tbCheck.getBizId());
			Integer num3 = iLeaveDao.updateLeaveById(tbLeave);
			if(num3>0) {				
				num = 1;
			}else {
				throw new RuntimeException("存档异常");
			}
		} else {
			if (num1 > 0) {
				Chat chat =new Chat();
				chat.setcUserSend(tbCheck.getCheckMan());
				TbLeave ckLeave=iLeaveDao.selectTbCheck(tbCheck.getBizId());
				chat.setcUserTake(ckLeave.getCreateMan());			
				if (tbCheck.getCheckResult() == 1) {
					TbLeave tbLeave = new TbLeave();
					tbLeave.setStatusId(4);
					tbLeave.setNextDealMan(1017);
					tbLeave.setLeaveId(tbCheck.getBizId());
					Integer num2 = iLeaveDao.updateLeaveById(tbLeave);
					chat.setcContent("审批通过,理由"+tbCheck.getCheckComment());	
					if (num2 > 0) {
						num = 1;
					} else {
						throw new RuntimeException("审批异常");
					}                                                                              
				} else if (tbCheck.getCheckResult() == 2) {
					TbLeave tbLeave = new TbLeave();
					tbLeave.setStatusId(4);
					tbLeave.setNextDealMan(10000);
					tbLeave.setLeaveId(tbCheck.getBizId());
					Integer num2 = iLeaveDao.updateLeaveById(tbLeave);
					chat.setcContent("审批拒绝你的请假申请，理由"+tbCheck.getCheckComment());
					if (num2 > 0) {
						num = 1;
					} else {
						throw new RuntimeException("审批异常");
					}
				}
				iMessageDao.addMessage(chat);
			} else {
				throw new RuntimeException("审批异常");
			}
		}
		return num;
	}
	/**
	 * 报销模块的审批
	 * 部门经理和普通员工的报销都需要上一级同意财务同意出纳给钱
	 * 普通员工 申请的报销金额大于10000需要总经理的同意
	 * @param tbCheck
	 * @return
	 */
	public Integer addTbCheckTbReimburse(CheckVo tbCheck) {
		Integer num = -1;
		Integer num1=iCheckDao.addCheack(tbCheck);
		if(num1>0) {
			TbReimburse  tbReimburse=new TbReimburse();
			if(tbCheck.getTotalCount()>10000) {
				tbReimburse.setNextDealMan(1000);
				tbReimburse.setStatusId(3);
			}else if(tbCheck.getCheckMan()==1004 || tbCheck.getCheckMan()==1000) {
				tbReimburse.setNextDealMan(1001);
				tbReimburse.setStatusId(3);
			}else if(tbCheck.getCheckMan()==1001) {
				tbReimburse.setNextDealMan(1002);
				tbReimburse.setStatusId(4);
			}else if(tbCheck.getCheckMan()==1002) {
				tbReimburse.setNextDealMan(10000);
				tbReimburse.setStatusId(5);
			}
			if(tbCheck.getCheckResult()==2) {
				tbReimburse.setStatusId(6);
				tbReimburse.setNextDealMan(10000);
			}	
			tbReimburse.setReimburseId(tbCheck.getBizId());
			Integer num2=iReimbursementDao.modifyReimbursement(tbReimburse);
			if(num2>0) {
				num=1;
			}else {
				throw new RuntimeException("修改报销表失败!");
			}
			
		}else {
			throw new RuntimeException("新增报销的是审批表失败!");
		}
		return num;
	}

}
