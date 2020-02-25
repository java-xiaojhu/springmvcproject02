package com.accp.springmvc.servlet;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.springmvc.biz.EmployeeBiz;
import com.accp.springmvc.pojo.Employee;
import com.accp.springmvc.util.faceSend;
import com.accp.springmvc.vo.EmployeeVo;
import com.accp.springmvc.vo.ResultVo;
import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping("/c/EmployeeServlet")
public class EmployeeServlet {
	@Resource
	private EmployeeBiz employeeBiz;
	
	/**
	 * 登录
	 * @param session
	 * @param employee
	 * @param img
	 * @return
	 */
	@RequestMapping("login")
	@ResponseBody
	public Map<String, String> findEmployee(HttpSession session, Employee employee, String img) {
		EmployeeVo emp = employeeBiz.findEmployee(employee);
		System.out.println(img);
		System.out.println(emp);
		Map<String, String> message = new HashMap<String, String>();
		ResultVo result = null;
		try {
			result = JSON.parseObject(faceSend.faceverify(img), ResultVo.class);
			System.out.println(result);
			if(result.getResult()!=null) {
				System.out.println(result.getResult());
				if (result.getResult().getFace_liveness() > 0.5) {
					result = JSON.parseObject(faceSend.matchFace(img, new File("D:/myfile/images/" + emp.getImgph())),
							ResultVo.class);
					if(result!=null) {
						if (result.getResult().getScore() > 85) {
							message.put("code", "200");
							message.put("user",JSON.toJSONString(emp));
							message.put("msg", "验证成功!");
							System.out.println("是本人");
							session.setAttribute("emp", emp);
							session.setMaxInactiveInterval(120000);
						} else {
							message.put("code", "300");
							message.put("msg", "/springmvcproject02/speak/erorr.wav");
							System.out.println("不是本人");
						}
					}else {
						message.put("code", "400");
						message.put("msg", "/springmvcproject02/speak/noPeople.wav");
						throw new NullPointerException();	
					}
				} else {
					message.put("code", "400");
					message.put("msg", "/springmvcproject02/speak/noPeople.wav");
				}
			}else {
				message.put("code", "400");
				message.put("msg", "/springmvcproject02/speak/noPeople.wav");
				throw new NullPointerException();	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			System.out.println(result);
			return message;
		}
		
	}
	
	@RequestMapping("xiaohui")
	public String xiaohui(HttpSession session) {
		session.removeAttribute("emp");
		session.invalidate();// 会话销毁
		return "redirect:http://127.0.0.1:8080/springmvcproject02/login";
		
		
	}
	

}
