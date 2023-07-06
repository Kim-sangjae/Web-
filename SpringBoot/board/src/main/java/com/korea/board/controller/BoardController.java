package com.korea.board.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import com.korea.board.common.Common;
import com.korea.board.dao.BoardDAO;
import com.korea.board.util.Paging;
import com.korea.board.vo.BoardVO;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board/*")
public class BoardController {

	private final BoardDAO boardDAO;
	private final HttpServletRequest request;
	
	@GetMapping("board_list")
	public String list(Model model, @RequestParam(required = false) String page) {
		int nowPage = 1;
		
		if(page != null && !page.isEmpty()) {
			nowPage = Integer.parseInt(page);
		}
		
		//한 페이지에 표시될 게시물의 시작과 끝번호 계산
		//page가 1이면 1~10까지 계산
		//page가 2이면 11~20까지 계산
		int start = (nowPage -1) * Common.Board.BLOCKLIST+1;
		int end = start + Common.Board.BLOCKLIST - 1;
		
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		map.put("start", start);
		map.put("end", end);
		
		//페이지 번호에 따른 전체 게시글 조회
		List<BoardVO> list = boardDAO.selectList(map);
		
		//전체 게시물 수 조회
		int rowTotal = boardDAO.getRowTotal();
		
		//페이징 메뉴 생성하기
		String pageMenu = Paging.getPaging("board_list",
											nowPage,
											rowTotal, 
											Common.Board.BLOCKLIST,
											Common.Board.BLOCKPAGE);
		
		request.getSession().removeAttribute("show");
		
		model.addAttribute("list",list);
		
//		for(BoardVO vo : list) {
//			System.out.println("del_info: " + vo.getDelinfo());
//		}
		
		model.addAttribute("pageMenu",pageMenu);
		
		return "/board/board_list";
	}
	
	@GetMapping("view")
	public String view(Model model,int idx, @RequestParam(required = false) String page) {
		BoardVO vo = boardDAO.selectOne(idx);
		
		//조회수 증가
		String show = (String)request.getSession().getAttribute("show");
		
		if(show == null) {
			int res = boardDAO.update_readhit(idx);
			request.getSession().setAttribute("show", "0");
		}
		
		//상세보기 페이지로 전환하기 위해 바인딩 및 포워딩
		model.addAttribute("vo",vo);
		
		return "/board/board_view";
	}
	
	@GetMapping("insert_form")
	public String insert_form(Model model, @RequestParam(required = false) String page) {
		model.addAttribute("vo", new BoardVO());
		return "/board/insert_form";
	}
	
	@GetMapping("insert")
	public RedirectView insert(BoardVO vo, @RequestParam(required = false) String page) {
		String ip = request.getRemoteAddr();
		vo.setIp(ip);
		
		int res = boardDAO.insert(vo);
		
		if(res > 0) {
			return new RedirectView("/board/board_list?page="+page);
		}
			return null;
	}
	
	@PostMapping("del")
	@ResponseBody
	public void delete(int idx) {
		BoardVO vo = boardDAO.selectOne(idx);
		vo.setSubject("이미 삭제된 게시글입니다.");
		vo.setName("unknown");
		
		boardDAO.del_update(vo);
	}
	
}








