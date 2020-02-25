package com.accp.springmvc.biz;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.accp.springmvc.dao.IEmployeeDao;
import com.accp.springmvc.pojo.Employee;
import com.accp.springmvc.vo.EmployeeVo;

@Service("EmployeeBiz")
public class EmployeeBiz {
	/**
	 * 员工Dao
	 */
	@Resource
	private IEmployeeDao iEmployeeDao;
	/**
	 * 登录根据密码用户id查询
	 * @param employee
	 * @return
	 */
	public EmployeeVo findEmployee(Employee employee) {
		return iEmployeeDao.selectEmployee(employee);
	}
}
