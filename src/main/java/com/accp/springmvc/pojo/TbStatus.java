package com.accp.springmvc.pojo;
/**
 * 状态名称
 * @author 小虎
 *
 */
public class TbStatus {
	//状态编号
	private Integer statusId;
	//状态名称
	private String statusName;
	
	public TbStatus() {
		super();
	}

	public TbStatus(Integer statusId, String statusName) {
		super();
		this.statusId = statusId;
		this.statusName = statusName;
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

	@Override
	public String toString() {
		return "TbStatus [statusId=" + statusId + ", statusName=" + statusName + "]";
	}
	
	
}
