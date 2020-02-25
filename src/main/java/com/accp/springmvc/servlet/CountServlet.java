package com.accp.springmvc.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.filechooser.FileSystemView;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.accp.springmvc.biz.CountBiz;
import com.accp.springmvc.util.CreateExecl;
import com.accp.springmvc.vo.CountVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/api/CountServlet")
public class CountServlet {
	@Resource
	private CountBiz countBiz;

	@GetMapping("/months/{pageNum}/{pageSize}/{year}/{startmonth}/{endmonth}")
	public PageInfo<CountVo> selectMonthAll(@PathVariable Integer pageNum, @PathVariable Integer pageSize,@PathVariable Integer year, @PathVariable Integer startmonth, @PathVariable Integer endmonth) {
		if (year == 0) {
			year = null;
		}
		if (startmonth == 0) {
			startmonth = null;
		}
		if (endmonth == 0) {
			endmonth = null;
		}		
		return countBiz.selectMonthAll(pageNum, pageSize,year,startmonth,endmonth);
	};

	@GetMapping("/months/{pageNum}/{pageSize}/{month}/{year}")
	public PageInfo<CountVo> selectMonthById(@PathVariable Integer pageNum, @PathVariable Integer pageSize,
			@PathVariable Integer month, @PathVariable Integer year) {
		return countBiz.selectMonthById(pageNum, pageSize, month, year);
	};

	@GetMapping("/years/{pageNum}/{pageSize}")
	public PageInfo<CountVo> selectYearsAll(@PathVariable Integer pageNum, @PathVariable Integer pageSize) {
		return countBiz.selectYearAll(pageNum, pageSize);
	};

	@GetMapping("/years/{pageNum}/{pageSize}/{month}/{year}")
	public PageInfo<CountVo> selecYearsById(@PathVariable Integer pageNum, @PathVariable Integer pageSize,
			@PathVariable Integer year) {
		return countBiz.selectYearById(pageNum, pageSize, year);
	};
	@PostMapping("/execl")
	public Map<String, String>  execl(@RequestBody CreateExecl createExecl) {
		Map<String, String> message = new HashMap<String, String>();
		if(createExecl.createExecl()) {
			message.put("code", "200");
			message.put("msg", "导出成功");
		}else{
			message.put("code", "200");
			message.put("msg", "导出失败");
		};
		return message ;
	};

}
