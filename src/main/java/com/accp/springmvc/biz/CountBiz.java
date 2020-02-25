package com.accp.springmvc.biz;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.accp.springmvc.dao.ICountDao;
import com.accp.springmvc.vo.CountVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("CountBiz")
public class CountBiz {
	@Resource
	private ICountDao iCountDao;

	public PageInfo<CountVo> selectMonthAll(Integer pageNum, Integer pageSize,Integer year, Integer startmonth,Integer endmonth) {
		PageHelper.startPage(pageNum, pageSize);
		PageInfo<CountVo> pageinfo = new PageInfo<CountVo>(iCountDao.selectMonthAll(year,startmonth,endmonth));
		return pageinfo;
	};

	public PageInfo<CountVo> selectMonthById(Integer pageNum, Integer pageSize, Integer month,Integer year) {
		PageHelper.startPage(pageNum, pageSize);
		PageInfo<CountVo> pageinfo = new PageInfo<CountVo>(iCountDao.selectMonthById(month,year));
		return pageinfo;
	};
	/**
	 * 查看所有的年报销
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageInfo<CountVo> selectYearAll(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		PageInfo<CountVo> pageinfo = new PageInfo<CountVo>(iCountDao.selectYearAll());
		return pageinfo;
	};
	/**
	 * 查看某一年的报销
	 * @param pageNum
	 * @param pageSize
	 * @param year
	 * @return
	 */
	public PageInfo<CountVo> selectYearById(Integer pageNum, Integer pageSize, Integer year) {
		PageHelper.startPage(pageNum, pageSize);
		PageInfo<CountVo> pageinfo = new PageInfo<CountVo>(iCountDao.selectYearById(year));
		return pageinfo;
	};
	
	public Integer addCount() {
		
		return 0;
	}

}
