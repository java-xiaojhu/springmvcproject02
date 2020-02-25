package com.accp.springmvc.vo;

public class CheckVo {
	//审查记录编号
	private Integer checkId;
	//业务编号，关联请假表或报销主表
	private Integer bizId;
	//关联请假表或报销主表中type_id字段  1：请假表，2：报销表
	private Integer typeId;
	//审查时间
	private String checkTime;
	//审查人编号
	private Integer checkMan;
	//审批人名称
	private String employeeName;
	//审查结果，外键，关联审查结果表
	private Integer checkResult;
	//审批结果名称
	private String resultName;
	//审查意见
	private String checkComment;
	
	private Double totalCount;
	
	public Double getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Double totalCount) {
		this.totalCount = totalCount;
	}
	public String getResultName() {
		return resultName;
	}
	public void setResultName(String resultName) {
		this.resultName = resultName;
	}
	

	public Integer getCheckId() {
		return checkId;
	}
	public void setCheckId(Integer checkId) {
		this.checkId = checkId;
	}
	public Integer getBizId() {
		return bizId;
	}
	public void setBizId(Integer bizId) {
		this.bizId = bizId;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public String getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}
	public Integer getCheckMan() {
		return checkMan;
	}
	public void setCheckMan(Integer checkMan) {
		this.checkMan = checkMan;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Integer getCheckResult() {
		return checkResult;
	}
	public void setCheckResult(Integer checkResult) {
		this.checkResult = checkResult;
	}
	public String getCheckComment() {
		return checkComment;
	}
	public void setCheckComment(String checkComment) {
		this.checkComment = checkComment;
	}
	@Override
	public String toString() {
		return "CheckVo [checkId=" + checkId + ", bizId=" + bizId + ", typeId=" + typeId + ", checkTime=" + checkTime
				+ ", checkMan=" + checkMan + ", employeeName=" + employeeName + ", checkResult=" + checkResult
				+ ", resultName=" + resultName + ", checkComment=" + checkComment + "]";
	}
	
}
