package com.korea.param;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.MyPath;
import vo.PersonVO;

@Controller
public class ParamController {
	@RequestMapping(value={"/","/insert.do"})//맨처음 화면일때 mapping이 2개일수 있다.
	public String insert_form() {
		return MyPath.PATH+"insert_form.jsp";
	}
	
	//name ="홍길동"&age =30&tel =010-1111-1111
	@RequestMapping("insert1.do")
	public String insert1(Model model,String name,int age, String tel) {
		//스프링에서는 넘어온 파라미터의 이름과 메서드의 파라미터의 이름이 같으면 
		//자동으로 값을 받아온다. 정수는 자동으로 정수로 들어온다.
		
		PersonVO vo = new PersonVO();
		vo.setName(name);
		vo.setAge(age);
		vo.setTel(tel);
		
		model.addAttribute("vo",vo);
		return MyPath.PATH+"insert_result.jsp";
	}
	
	@RequestMapping("insert2.do")
	//name ="홍길동"&age =30&tel =010-1111-1111
	public String insert2(Model model,PersonVO vo) {
		//파라미터로 넘어온 name,tel,age를 vo객체에 자동으로 setting을 해준다.
		//현재 PersonVO에 변수가 세 개 있는데 파라미터를 두개 (ex. name,age)만 던지게 되면
		//tel은 자동으로 null값이 들어간다.
		//PersonVO의 변수보다 많은 개수의 파라미터를 던지게되면 문제가 생긴다.
		
		model.addAttribute("vo",vo);
		return MyPath.PATH+"insert_result.jsp";
	}
}

