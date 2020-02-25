package com.accp.springmvc.pojo;
/**
 * 职位表(position)
 * @author 小虎
 *
 */
public class Position {
	//职位编号
	private Integer positionId;
	//职位名称
	private String  positionName;
	
	public Position() {
		super();
	}

	public Position(Integer positionId, String positionName) {
		super();
		this.positionId = positionId;
		this.positionName = positionName;
	}

	public Integer getPositionId() {
		return positionId;
	}

	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	@Override
	public String toString() {
		return "Position [positionId=" + positionId + ", positionName=" + positionName + "]";
	}
	
	
	

}
