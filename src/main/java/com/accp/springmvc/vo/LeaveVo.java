package com.accp.springmvc.vo;

import java.util.List;

import com.accp.springmvc.pojo.TbCheck;
/**
 * 请假表的工具类
 * @author 小虎
 *
 */
public class LeaveVo {

	// 请假编号
	private Integer leaveId;
	// 1表示为请假表
	private Integer typeId;
	// 请假人编号
	private Integer createMan;
	//请假人姓名
	private String createName;
	// 请假人职位编号
	private Integer positionId;
	public Integer getPositionId() {
		return positionId;
	}

	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}

	// 请假人部门编号
	private Integer departmentId;
	//请假人部门名称
	private String departmentName;
	// 创建时间
	private String createTime;
	// 请假开始时间
	private String startTime;
	// 请假结束时间
	private String endTime;
	// 下个处理人，外键
	private Integer nextDealMan;
	//请假人姓名
	private String  nextDealName;
	// 请假事由
	private String event;
	// 请假总天数
	private Integer totalCount;
	// 状态
	private Integer statusId;
	//状态名称
	private String statusName;
	//审查时间
	private String checkTime;
	
	private String resultName;
	
	
	public String getResultName() {
		return resultName;
	}

	public void setResultName(String resultName) {
		this.resultName = resultName;
	}

	public String getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}

	//单个请假表的多条审批记录
	private List<TbCheck> tbChecks;

	public LeaveVo() {
		super();
	}

	public LeaveVo(Integer leaveId, Integer typeId, Integer createMan, String createName, Integer departmentId,
			String departmentName, String createTime, String startTime, String endTime, Integer nextDealMan,
			String nextDealName, String event, Integer totalCount, Integer statusId, String statusName,
			List<TbCheck> tbChecks) {
		super();
		this.leaveId = leaveId;
		this.typeId = typeId;
		this.createMan = createMan;
		this.createName = createName;
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.createTime = createTime;
		this.startTime = startTime;
		this.endTime = endTime;
		this.nextDealMan = nextDealMan;
		this.nextDealName = nextDealName;
		this.event = event;
		this.totalCount = totalCount;
		this.statusId = statusId;
		this.statusName = statusName;
		this.tbChecks = tbChecks;
	}

	public Integer getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(Integer leaveId) {
		this.leaveId = leaveId;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public Integer getCreateMan() {
		return createMan;
	}

	public void setCreateMan(Integer createMan) {
		this.createMan = createMan;
	}

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Integer getNextDealMan() {
		return nextDealMan;
	}

	public void setNextDealMan(Integer nextDealMan) {
		this.nextDealMan = nextDealMan;
	}

	public String getNextDealName() {
		return nextDealName;
	}

	public void setNextDealName(String nextDealName) {
		this.nextDealName = nextDealName;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public List<TbCheck> getTbChecks() {
		return tbChecks;
	}

	public void setTbChecks(List<TbCheck> tbChecks) {
		this.tbChecks = tbChecks;
	}

	@Override
	public String toString() {
		return "LeaveVo [leaveId=" + leaveId + ", typeId=" + typeId + ", createMan=" + createMan + ", createName="
				+ createName + ", departmentId=" + departmentId + ", departmentName=" + departmentName + ", createTime="
				+ createTime + ", startTime=" + startTime + ", endTime=" + endTime + ", nextDealMan=" + nextDealMan
				+ ", nextDealName=" + nextDealName + ", event=" + event + ", totalCount=" + totalCount + ", statusId="
				+ statusId + ", statusName=" + statusName + ", checkTime=" + checkTime + ", tbChecks=" + tbChecks + "]";
	}

	
	
	

}
