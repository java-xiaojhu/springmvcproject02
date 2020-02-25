package com.accp.springmvc.pojo;
/**
 * 审查记录表(tb_check)
 * @author 小虎
 *
 */
public class TbCheck {
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
	//审查结果，外键，关联审查结果表
	private Integer checkResult;
	//审查意见
	private String checkComment;
	
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
	public TbCheck(Integer checkId, Integer bizId, Integer typeId, String checkTime, Integer checkMan,
			Integer checkResult, String checkComment) {
		super();
		this.checkId = checkId;
		this.bizId = bizId;
		this.typeId = typeId;
		this.checkTime = checkTime;
		this.checkMan = checkMan;
		this.checkResult = checkResult;
		this.checkComment = checkComment;
	}
	public TbCheck() {
		super();
	}
	@Override
	public String toString() {
		return "TbCheck [checkId=" + checkId + ", bizId=" + bizId + ", typeId=" + typeId + ", checkTime=" + checkTime
				+ ", checkMan=" + checkMan + ", checkResult=" + checkResult + ", checkComment=" + checkComment + "]";
	}
	
	
	
	
}
