package com.accp.springmvc.servlet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.accp.springmvc.biz.LeaveBiz;
import com.accp.springmvc.pojo.Employee;
import com.accp.springmvc.pojo.TbLeave;
import com.accp.springmvc.pojo.TbStatus;
import com.accp.springmvc.vo.EmployeeVo;
import com.accp.springmvc.vo.LeaveVo;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/api/LeaveServlets")
public class LeaveServlet {
	@Resource
	private LeaveBiz leaveBiz;

	/**
	 * 新增请假
	 * 
	 * @param tbLeave
	 * @return
	 */
	@PostMapping("/tbLeave")
	public Map<String, String> addLeave(HttpSession session, @RequestBody TbLeave tbLeave) {
		Map<String, String> message = new HashMap<String, String>();
		EmployeeVo emp = (EmployeeVo) session.getAttribute("emp");
		System.out.println(emp);
		tbLeave.setDepartmentId(emp.getDepartmentId());
		tbLeave.setCreateMan(emp.getEmployeeId());
		tbLeave.setStatusId(2);
		Integer num = leaveBiz.addLeave(tbLeave, emp.getPositionId());
		if (num > 0) {
			message.put("code", "200");
			message.put("msg", "/springmvcproject02/ui/showLeave.html");
		} else {
			message.put("code", "400");
			message.put("msg", "服务器正忙");
		}
		return message;
	}

	@GetMapping("/findLeaves/{pageNum}/{pageSize}/{leaveId}/{starttime}/{endtime}/{createName}/{statusId}")
	public PageInfo<LeaveVo> findLeaves(HttpSession session,@PathVariable Integer pageNum,
			@PathVariable Integer pageSize, @PathVariable Integer leaveId, @PathVariable String starttime,
			@PathVariable String endtime, @PathVariable String createName,@PathVariable Integer statusId) {
		EmployeeVo emp = (EmployeeVo) session.getAttribute("emp");
		System.out.println(emp);
		if (leaveId == 0) {
			leaveId = null;
		}
		if (statusId == 0) {
			statusId = null;
		}
		if (createName.equals("null")) {
			createName = "";
		}
		if (starttime.equals("null")) {
			starttime = "";
		}
		if (endtime.equals("null")) {
			endtime = "";
		}
		return leaveBiz.findLeaves(pageNum, pageSize, leaveId, emp.getPositionId(), emp.getDepartmentId(),emp.getEmployeeId(), starttime, endtime, createName,statusId);

	}
	
	
	@GetMapping("/state")
	public List<TbStatus> findState() {
		return leaveBiz.findState();

	}

}
