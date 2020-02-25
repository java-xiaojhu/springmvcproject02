package com.accp.springmvc.dao;

import org.apache.ibatis.annotations.Param;

import com.accp.springmvc.pojo.Employee;
import com.accp.springmvc.vo.EmployeeVo;

/**
 * 员工类
 * @author 小虎
 *
 */
public interface IEmployeeDao {
	/**
	 * 登录根据密码用户id查询
	 * @param employee
	 * @return
	 */
	EmployeeVo selectEmployee(@Param("employee")Employee employee);
	
	
	/**
	 * 查询单个
	 */
	EmployeeVo selectOneEmployee(@Param("employeeId")Integer employeeId);

}
