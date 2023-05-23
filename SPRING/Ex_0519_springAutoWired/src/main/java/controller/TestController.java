package controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.DeptDAO;
import vo.DeptVO;

@Controller
public class TestController {
	
	@Autowired
	DeptDAO dept_dao;
	
	
	public TestController() {
		System.out.println("---------testcontroller 기본생성자------");
	}
	
	
	@RequestMapping(value= {"dept_list.do"})
	public String deptlist(Model model) {
		List<DeptVO> list = dept_dao.selectlist();
		
		model.addAttribute("list",list);
		
		return "/WEB-INF/views/dept_list.jsp";
	}

	
	
	@RequestMapping("/")
	public String loginForm() {
		return "/WEB-INF/views/login_form.jsp";
	}
	
	
	@PostMapping("login")
	public String login(@ModelAttribute("id") String id , String pwd) {
		if(id.equals("admin")) {
			
			return "/WEB-INF/views/admin.jsp";
		} else {
			
			return "/WEB-INF/views/main.jsp";
		}
	}
	
	
	
	
}
