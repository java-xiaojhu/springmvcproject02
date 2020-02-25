package com.accp.springmvc.vo;

public class CountVo {

	private Integer year;
	
	private Integer month;
	
	private Double total;
	
	private String departmentName;
	private String employeeName;

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
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

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public CountVo() {
		super();
	}

	public CountVo(Integer year, Integer month, Double total, String departmentName) {
		super();
		this.year = year;
		this.month = month;
		this.total = total;
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "CountVo [year=" + year + ", month=" + month + ", total=" + total + ", departmentName=" + departmentName
				+ "]";
	}

}
