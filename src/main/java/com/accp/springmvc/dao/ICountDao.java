package com.accp.springmvc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.springmvc.pojo.TbCount;
import com.accp.springmvc.vo.CountVo;

public interface ICountDao {
	
	 List<CountVo> selectMonthAll(@Param("year") Integer year,@Param("startmonth") Integer startmonth,@Param("endmonth") Integer endmonth);
	 /**
	  * 查看月的详情得
	  * @param month
	  * @param year
	  * @return
	  */
	 List<CountVo> selectMonthById(@Param("month") Integer month,@Param("year") Integer year);
	 
	 List<CountVo> selectYearAll();
	 
	 List<CountVo> selectYearById(@Param("year") Integer year);
	 
	
	 
	 
	 

}
