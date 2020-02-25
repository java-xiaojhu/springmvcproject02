package com.accp.springmvc.pojo;
/**
 * 统计表(tb_count)
 * @author 小虎
 *
 */
public class TbCount {
	//统计编号
	private Integer countId;
	//金额
	private Double money;
	//年份
	private Integer year;
	//月份
	private Integer month;
	//部门编号
	private Integer departmentId;
	//员工编号
	private Integer employeeId;
	//部门名称
	private String departmentName;
	//员工名称
	private String employeeName;
	
	public TbCount(Integer countId, Double money, Integer year, Integer month, Integer departmentId, Integer employeeId,
			String departmentName, String employeeName) {
		super();
		this.countId = countId;
		this.money = money;
		this.year = year;
		this.month = month;
		this.departmentId = departmentId;
		this.employeeId = employeeId;
		this.departmentName = departmentName;
		this.employeeName = employeeName;
	}

	public TbCount() {
		super();
	}

	public Integer getCountId() {
		return countId;
	}

	public void setCountId(Integer countId) {
		this.countId = countId;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	@Override
	public String toString() {
		return "TbCount [countId=" + countId + ", money=" + money + ", year=" + year + ", month=" + month
				+ ", departmentId=" + departmentId + ", employeeId=" + employeeId + ", departmentName=" + departmentName
				+ ", employeeName=" + employeeName + "]";
	}
	
	
	
	
	
	
}
