package com.korea.bbs;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.BoardDAO;
import util.Common;
import util.Paging;
import vo.BoardVO;

@Controller
public class BoardController {
	
	@Autowired
	HttpServletRequest request;
	
	BoardDAO board_dao;
	
	
	public BoardController(BoardDAO board_dao) {
		this.board_dao = board_dao;
	}
	
	@RequestMapping(value= {"/","board_list.do"})
	public String list(Model model, String page) {
		int nowPage = 1;
		
		if(page != null && !page.isEmpty()) {
			nowPage = Integer.parseInt(page);
		}
		
		// 한 페이지에 표시될 게시물의 시작과 끝번호를 계산
		int start = (nowPage -1) * Common.Board.BLOCKLIST + 1;
		int end = start + Common.Board.BLOCKLIST -1;
		
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		map.put("start", start);
		map.put("end", end);
		
		
		//페이지번호에 따른 전체 게시글 조회
		List<BoardVO> list = board_dao.selectList(map);
		
		// 전체 게시물 수 조회
		int rowTotal = board_dao.getRowTotal();
		
		
		// 페이지 메뉴 생성하기
		String pageMenu = Paging.getPaging("board_list.do",nowPage,rowTotal,Common.Board.BLOCKLIST,Common.Board.BLOCKPAGE);
				
		
		request.getSession().removeAttribute("show");
		model.addAttribute("list",list);
		model.addAttribute("pageMenu",pageMenu);
		
	
		return Common.VIEW_PATH + "board_list.jsp?page="+nowPage;
	}
	
	
	@RequestMapping("view.do")
	public String view(int idx, int page , Model model) {
		
		BoardVO vo = board_dao.selectOne(idx);
		
		// 한번클릭할때 마다 조회수가 1씩증가(새로고침을 했을때 조회수 증가는 막아야함)
		HttpSession session = request.getSession();
		String show = (String) session.getAttribute("show");
		
		if(show == null) {
			int res = board_dao.update_readhit(idx);
			session.setAttribute("show", "조회수증가");
		}
		
		model.addAttribute("vo",vo);
		
		return Common.VIEW_PATH + "board_view.jsp?page="+page;
	}
	
	
	
	@RequestMapping("insert_form.do")
	public String insert_form() {
		
		return Common.VIEW_PATH + "insert_form.jsp";
	}
	
	
	@RequestMapping("insert.do")
	public String insert(BoardVO vo) {
		String ip = request.getRemoteAddr();
		vo.setIp(ip);
		
		int res = board_dao.insert(vo);
		
		if(res > 0) {
			return "redirect:board_list.do";
		}
		
		return null;
	}
	
	
	@RequestMapping("del.do")
	@ResponseBody
	public String delete(int idx) {
		BoardVO baseVO = board_dao.selectOne(idx);
		
		baseVO.setName("unknown");
		baseVO.setSubject("삭제된 글입니다.");
		
		int res = board_dao.del_update(baseVO);
		
		
		if(res > 0) {
			return "[{'result' : 'yes'}]";
		}
		return "[{'result' : 'no'}]";
		
	}
	

}