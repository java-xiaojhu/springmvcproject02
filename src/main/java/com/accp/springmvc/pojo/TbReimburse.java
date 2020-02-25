package com.accp.springmvc.pojo;

import java.util.ArrayList;
import java.util.List;


/**
 * 报销主表(tb_reimburse)
 * @author 小虎
 *
 */
public class TbReimburse {
	//报销编号
	private Integer reimburseId;
	//2代表报销表
	private Integer typeId;
	//报销人
	private Integer createMan;
	//创建时间 
	private String createTime;
	//部门编号
	private Integer departmentId;
	//下个处理人
	private Integer nextDealMan;
	//报销事由
	private String event;
	//报销总金额
	private Double totalCount;
	//状态，外键，关联状态表
	private Integer statusId;
	
	private List<ReimburseDetail> reimburseDetails=new ArrayList<ReimburseDetail>(0);
	
	public List<ReimburseDetail> getReimburseDetails() {
		return reimburseDetails;
	}

	public void setReimburseDetails(List<ReimburseDetail> reimburseDetails) {
		this.reimburseDetails = reimburseDetails;
	}

	public TbReimburse() {
		super();
	}

	public TbReimburse(Integer reimburseId, Integer typeId, Integer createMan, String createTime, Integer departmentId,
			Integer nextDealMan, String event, Double totalCount, Integer statusId) {
		super();
		this.reimburseId = reimburseId;
		this.typeId = typeId;
		this.createMan = createMan;
		this.createTime = createTime;
		this.departmentId = departmentId;
		this.nextDealMan = nextDealMan;
		this.event = event;
		this.totalCount = totalCount;
		this.statusId = statusId;
	}

	public Integer getReimburseId() {
		return reimburseId;
	}

	public void setReimburseId(Integer reimburseId) {
		this.reimburseId = reimburseId;
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

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public Integer getNextDealMan() {
		return nextDealMan;
	}

	public void setNextDealMan(Integer nextDealMan) {
		this.nextDealMan = nextDealMan;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public Double getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Double totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	@Override
	public String toString() {
		return "TbReimburse [reimburseId=" + reimburseId + ", typeId=" + typeId + ", createMan=" + createMan
				+ ", createTime=" + createTime + ", departmentId=" + departmentId + ", nextDealMan=" + nextDealMan
				+ ", event=" + event + ", totalCount=" + totalCount + ", statusId=" + statusId + "]";
	}



	
	
	

}
