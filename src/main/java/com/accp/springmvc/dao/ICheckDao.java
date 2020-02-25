package com.accp.springmvc.dao;

import org.apache.ibatis.annotations.Param;

import com.accp.springmvc.pojo.TbCheck;
import com.accp.springmvc.vo.CheckVo;

public interface ICheckDao {
	
	/**
	 * 新增审批表
	 */
	public Integer addCheack(@Param("tbCheck") CheckVo tbCheck );
	public Integer addCheack(@Param("tbCheck") TbCheck tbCheck );
}
