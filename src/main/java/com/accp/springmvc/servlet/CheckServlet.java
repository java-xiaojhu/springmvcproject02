package com.accp.springmvc.servlet;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accp.springmvc.biz.CheckBiz;
import com.accp.springmvc.pojo.TbCheck;
import com.accp.springmvc.vo.CheckVo;

@RestController
@RequestMapping("/c/CheckServlet")
public class CheckServlet {
	@Resource
	private CheckBiz checkBiz;
	/**
	 * 新增请假审批
	 * @param tbCheck
	 * @return
	 */
	@PostMapping("/tbCheck")
	public Map<String, String> addTbCheckLeave(@RequestBody TbCheck tbCheck){
		Map<String, String> message = new HashMap<String, String>();
		if(checkBiz.addTbCheck(tbCheck)>0) {
			message.put("code", "200");
			message.put("dizhi", "/springmvcproject02/ui/showLeave.html");
		}else {
			message.put("code", "300");
			message.put("dizhi", "/springmvcproject02/error/error.html");
		}
		return message;
	}
	/**
	 * 新增报销审批
	 * @param tbCheck
	 * @param totalCount
	 * @return
	 */
	@PostMapping("/tbCheckReimburse")
	public Map<String, String> addTbCheckTbReimburse(@RequestBody CheckVo tbCheck){
		Map<String, String> message = new HashMap<String, String>();
		if(checkBiz.addTbCheckTbReimburse(tbCheck)>0) {
			message.put("code", "200");
			message.put("dizhi", "/springmvcproject02/ui/Reimburse/showReimburse.html");
		}else {
			message.put("code", "300");
			message.put("dizhi", "/springmvcproject02/error/error.html");
		}
		return message;
	}
	
}
