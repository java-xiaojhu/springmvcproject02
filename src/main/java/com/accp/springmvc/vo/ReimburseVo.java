package com.accp.springmvc.vo;

import java.util.ArrayList;
import java.util.List;

import com.accp.springmvc.pojo.ReimburseDetail;

/**
 * 报销表工具类
 * 
 * @author 小虎
 *
 */
public class ReimburseVo {
	//报销编号
	private Integer reimburseId;
	//2代表报销表
	private Integer typeId;
	//报销人
	private Integer createMan;
	
	private String positionName;
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	//报销人名字
	private String employeeName;
	//创建时间 
	private String createTime;
	//部门编号
	private Integer departmentId;
	//部门名字
	private String departmentName;
	//下个处理人
	private Integer nextDealMan;
	//下个处理人名字
	private String nextEmployeeName;
	//报销事由
	private String event;
	//报销总金额
	private Double totalCount;
	//状态，外键，关联状态表
	private Integer statusId;
	//状态，外键，关联状态表
	private String  statusName;
	
	private List<ReimburseDetail> reimburseDetails=new ArrayList<ReimburseDetail>(0);
	
	private List<CheckVo> checksVos=new ArrayList<CheckVo>(0);
	
	
	public List<CheckVo> getChecksVos() {
		return checksVos;
	}
	public void setChecksVos(List<CheckVo> checksVos) {
		this.checksVos = checksVos;
	}
	public List<ReimburseDetail> getReimburseDetails() {
		return reimburseDetails;
	}
	public void setReimburseDetails(List<ReimburseDetail> reimburseDetails) {
		this.reimburseDetails = reimburseDetails;
	}
	public ReimburseVo() {
		super();
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
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
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
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Integer getNextDealMan() {
		return nextDealMan;
	}
	public void setNextDealMan(Integer nextDealMan) {
		this.nextDealMan = nextDealMan;
	}
	public String getNextEmployeeName() {
		return nextEmployeeName;
	}
	public void setNextEmployeeName(String nextEmployeeName) {
		this.nextEmployeeName = nextEmployeeName;
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
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	

}
