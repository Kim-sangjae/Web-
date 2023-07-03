package com.korea.board.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String list(Model model, @RequestParam(/*name = "page",*/ required= false) String page) {
		int nowPage = 1;
		
		if(page != null && !page.isEmpty()) {
			nowPage = Integer.parseInt(page);
		}
		
		// 한 페이지에 표시 될 게시물의 시작과 끝번호 계산
		// page가 1이면 1~10 까지 계산
		// page가 2이면 11~20 까지 계산
		int start = (nowPage -1) * Common.Board.BLOCKLIST+1;
		int end = start + Common.Board.BLOCKLIST -1;
		
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		map.put("start", start);
		map.put("end", end);
		
		//페이지 번호에 따른 전체 게시글 조회
		List<BoardVO> list = boardDAO.selectList(map);
		
		// 전체 게시물 수 조회
		int rowTotal = boardDAO.getRowTotal();
		
		// 페이징 메뉴 생성
		String pageMenu = Paging.getPaging("board_list", nowPage, rowTotal, Common.Board.BLOCKLIST, Common.Board.BLOCKPAGE);
		
		request.getSession().removeAttribute("show");
		
		
		model.addAttribute("list",list);
		model.addAttribute("pageMenu",pageMenu);
		
		return "/board/board_list";
		
	}

}
