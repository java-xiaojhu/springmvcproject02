package com.accp.springmvc.pojo;

public class Employee {
	//员工id
	private Integer employeeId;
	//员工姓名
	private String employeeName;
	//密码
	private String password;
	//部门id 外键
	private Integer departmentId;
	//职位编号
	private Integer positionId;
	//
	private Integer pId;
	//用户状态
	private String stuts;
	//图片路径
	private String imgph;
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
	public Employee() {
		super();
	}
	public Employee(Integer employeeId, String employeeName, String password, Integer departmentId, Integer positionId,
			Integer pId, String stuts, String imgph) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.password = password;
		this.departmentId = departmentId;
		this.positionId = positionId;
		this.pId = pId;
		this.stuts = stuts;
		this.imgph = imgph;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", password=" + password
				+ ", departmentId=" + departmentId + ", positionId=" + positionId + ", pId=" + pId + ", stuts=" + stuts
				+ ", imgph=" + imgph + "]";
	}
	
	

}
