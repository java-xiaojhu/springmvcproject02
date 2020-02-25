package com.accp.springmvc.servlet;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accp.springmvc.biz.TbReimburseBiz;
import com.accp.springmvc.pojo.TbReimburse;
import com.accp.springmvc.vo.EmployeeVo;
import com.accp.springmvc.vo.LeaveVo;
import com.accp.springmvc.vo.ReimburseVo;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/api/TbReimburseServlet")
public class TbReimburseServlet {
	@Resource
	private TbReimburseBiz tbReimburseBiz;
	
	/*
	 * @RequestMapping("addReimbursement")
	 * 
	 * @ResponseBody public Map<String, String> addReimbursement(TbReimburse
	 * tbReimburse,TbCheck tbCheck) { Map<String, String> message = new
	 * HashMap<String, String>(); System.out.println("主表"+tbReimburse);
	 * System.out.println(tbReimburse.getReimburseDetails().size());
	 * tbReimburse.getReimburseDetails().forEach(temp->{ System.out.println(temp);
	 * }); System.out.println("审批"+tbCheck); System.out.println(res); int
	 * num=tbReimburseBiz.addReimbursement(tbReimburse, reimburseDetails, tbCheck);
	 * if(num==1) { message.put("code", "200"); message.put("msg", "提交成功!"); }else
	 * if(num==2){ message.put("code", "200"); message.put("msg", "保存成功!"); }else{
	 * message.put("code", "300"); message.put("msg", "新增失败!"); } for (MultipartFile
	 * imgFile : imgFiles){ String fileName = imgFile.getOriginalFilename();
	 * fileName = UUID.randomUUID().toString().replace("-", "") +
	 * fileName.substring(fileName.lastIndexOf(".")); try { //
	 * imgFile.transferTo(new File("D:\\myfile\\images\\" + fileName)); } catch
	 * (Exception e) { // TODO Auto-generated catch block e.printStackTrace(); }//
	 * 保存 } return message; }
	 */
	/*
	 * @RequestMapping("addReimbursement") public String
	 * addReimbursement(HttpSession session,TbReimburse tbReimburse,Double[]
	 * subTotal,String[] shixiang,TbCheck tbCheck,MultipartFile[] imgFile) throws
	 * Exception { EmployeeVo emp=(EmployeeVo)session.getAttribute("emp");
	 * tbReimburse.setCreateMan(emp.getEmployeeId());
	 * tbReimburse.setDepartmentId(emp.getDepartmentId()); String path=null;
	 * List<ReimburseDetail> reimburseDetails =new ArrayList<ReimburseDetail>(); for
	 * (int i = 0; i < subTotal.length; i++) { String fileName =
	 * imgFile[i].getOriginalFilename(); path =
	 * UUID.randomUUID().toString().replace("-", "") +
	 * fileName.substring(fileName.lastIndexOf(".")); imgFile[i].transferTo(new
	 * File("D:\\myfile\\images\\" + path)); reimburseDetails.add(new
	 * ReimburseDetail( subTotal[i],shixiang[i],fileName,path)); }
	 * if(tbReimburse.getStatusId()==2) { tbCheck=new TbCheck(); Integer positionId=
	 * emp.getPositionId(); if(positionId==2 ||positionId==4 ) {
	 * tbCheck.setCheckMan(1004); }else if(positionId==1 || positionId==3
	 * ||positionId==5) { tbCheck.setCheckMan(1000); } tbCheck.setTypeId(2); }else {
	 * tbCheck=null; } System.out.println(tbReimburse);
	 * tbReimburseBiz.addReimbursement(tbReimburse, reimburseDetails, tbCheck);
	 * return
	 * "redirect:/c/TbReimburseServlet/showReimbursement?pageNum=1&pageSize=8"; }
	 */	
	
	/*
	 * @RequestMapping("showReimbursement") public String addReimbursement(Model
	 * model,HttpSession session,Integer pageNum,Integer pageSize,Integer
	 * statusId,String start,String end) throws Exception { List<Integer>
	 * positionIds =new ArrayList<Integer>(); EmployeeVo
	 * emp=(EmployeeVo)session.getAttribute("emp"); Integer createMan=null;
	 * if(emp.getPositionId()==2) { createMan=emp.getEmployeeId(); }else
	 * if(emp.getPositionId()==1) { positionIds.add(1); positionIds.add(2); }else {
	 * positionIds=null; } model.addAttribute("reimbursement",
	 * tbReimburseBiz.findTbReimburse(pageNum, pageSize, positionIds, statusId,
	 * start, end,createMan)); return "showReimburse"; }
	 */
	/**
	 * 新增报销
	 * @param tbReimburse
	 * @param session
	 * @return
	 */
	@PostMapping("TbReimburse")
	public Map<String, String> addReimbursement(@RequestBody TbReimburse tbReimburse,HttpSession session){
		Map<String, String> message = new HashMap<String, String>();
		EmployeeVo emp = (EmployeeVo) session.getAttribute("emp");
		Integer num=tbReimburseBiz.addReimbursement(tbReimburse,emp.getPositionId(),emp.getDepartmentId());
		if(num>0) {
			message.put("code", "200");
			message.put("dizhi", "/springmvcproject02/ui/Reimburse/showReimburse.html");
		}else {
			message.put("code", "300");
			message.put("dizhi", "/springmvcproject02/error/error.html");
		}
		return message;
	}
	/**
	 * 查询报销
	 * @param session
	 * @param pageNum
	 * @param pageSize
	 * @param leaveId
	 * @param starttime
	 * @param endtime
	 * @param createName
	 * @param statusId
	 * @return
	 */
	@GetMapping("/TbReimburses/{pageNum}/{pageSize}/{leaveId}/{starttime}/{endtime}/{createName}/{statusId}")
	public PageInfo<ReimburseVo> findLeaves(HttpSession session, @PathVariable Integer pageNum,
			@PathVariable Integer pageSize, @PathVariable Integer leaveId, @PathVariable String starttime,
			@PathVariable String endtime, @PathVariable String createName,@PathVariable Integer statusId) {
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
		EmployeeVo emp = (EmployeeVo) session.getAttribute("emp");
		System.out.println("职位编号"+ emp.getPositionId()+"\t"+emp.getDepartmentId()+"\t"+
				emp.getEmployeeId()+"\t"+starttime+"\t"+endtime+"\t"+createName+"\t"+statusId);
		return tbReimburseBiz.findTbReimburse(pageNum, pageSize, leaveId, emp.getPositionId(), emp.getDepartmentId(),
				emp.getEmployeeId(), starttime, endtime, createName,statusId);
	}
	
	@PutMapping("TbReimburse")
	public Map<String, String> modifyTbReburse(@RequestBody TbReimburse tbReimburse,HttpSession session){
		Map<String, String> message = new HashMap<String, String>();
		EmployeeVo emp = (EmployeeVo) session.getAttribute("emp");
		Integer num =null;
		System.out.println(tbReimburse);
		System.out.println("报销详细表--------------");
		tbReimburse.getReimburseDetails().forEach(temp->{System.out.println(temp);});
		if(tbReimburse.getReimburseDetails().size()<=0) {
			System.out.println("进入了报销列表的提交按钮事件");
			//直接提交
			 num=tbReimburseBiz.modifyReimburseByreimburseId(tbReimburse,emp.getPositionId(),emp.getDepartmentId());
		}else {
			System.out.println("进入了报销列表的进入修改页面的保存以及提交");
			//进入修改页面的保存以及提交
			 num=tbReimburseBiz.modifyReimburse(tbReimburse,emp.getPositionId(),emp.getDepartmentId());
		}
		if(num>0) {
			message.put("code", "200");
			message.put("dizhi", "/springmvcproject02/ui/Reimburse/showReimburse.html");
		}else {
			message.put("code", "300");
			message.put("dizhi", "/springmvcproject02/error/error.html");
		}
		return message;
	};
	/**
	 * 删除报销表
	 */
	@DeleteMapping("/TbReimburse/{reimburseId}")
	public Map<String, String> modifyTbReburse(@PathVariable Integer reimburseId){
		Map<String, String> message = new HashMap<String, String>();
		Integer num=tbReimburseBiz.removeReimburse(reimburseId);
		if(num>0) {
			message.put("code", "200");
			message.put("dizhi", "/springmvcproject02/ui/Reimburse/showReimburse.html");
		}else {
			message.put("code", "300");
			message.put("dizhi", "/springmvcproject02/error/error.html");
		}
		return message;
	};
}
