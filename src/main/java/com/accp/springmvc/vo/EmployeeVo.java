package com.accp.springmvc.vo;
/**
 * 员工工具类
 * @author 小虎
 *
 */
public class EmployeeVo {
	//员工id
	private Integer employeeId;
	//员工姓名
	private String employeeName;
	//密码
	private String password;
	//部门id 外键
	private Integer departmentId;
	//
	private String departmentName;
	//职位编号
	private Integer positionId;
	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public Integer getPositionId() {
		return positionId;
	}

	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}

	private String positionName;
	//
	private Integer pId;
	//用户状态
	private String stuts;
	//图片路径
	private String imgph;
	
	public EmployeeVo() {
		super();
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public String getStuts() {
		return stuts;
	}

	public void setStuts(String stuts) {
		this.stuts = stuts;
	}

	public String getImgph() {
		return imgph;
	}

	public void setImgph(String imgph) {
		this.imgph = imgph;
	}

	@Override
	public String toString() {
		return "EmployeeVo [employeeId=" + employeeId + ", employeeName=" + employeeName + ", password=" + password
				+ ", departmentId=" + departmentId + ", departmentName=" + departmentName + ", positionId=" + positionId
				+ ", positionName=" + positionName + ", pId=" + pId + ", stuts=" + stuts + ", imgph=" + imgph + "]";
	}

	
	
}
