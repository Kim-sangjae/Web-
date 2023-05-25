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
import org.springframework.web.context.annotation.RequestScope;

import dao.BoardDAO;
import dao.MemberDAO;
import util.Common;
import util.Paging;
import vo.BoardVO;
import vo.MemberVO;

@Controller
public class BoardController {
	
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpSession session;
	
	
	BoardDAO board_dao;
	MemberDAO member_dao;
	
	
	
	public BoardController(BoardDAO board_dao, MemberDAO member_dao) {
		this.board_dao = board_dao;
		this.member_dao = member_dao;
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
	public String insert_form(Model model) {
		
		MemberVO vo = (MemberVO)session.getAttribute("id");
		if(vo == null) {
			
			return Common.VIEW_PATH + "login_form.jsp";
		}
		
		model.addAttribute("vo",vo);
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
	
	
	
	
	// 댓글 달기 페이지로 이동
	@RequestMapping("reply_form.do")
	public String reply_form(int idx, int page) {
		return Common.VIEW_PATH + "reply_form.jsp?idx="+idx+"&page="+page;
	}
	
	
	
	
	//댓글달기
		@RequestMapping("reply.do")
		public String reply(BoardVO vo, int idx, int page) {
			String ip = request.getRemoteAddr();
			
			//ref, step, depth 잘 따져야 한다.
			
			//같은 ref를 가지고 있는 데이터들 중에서 지금 내가 추가하려고 하는
			//step값 이상인 애들을 +1을 미리 해놔야 하기 때문에 insert를 먼저하지 않는다
			
			//기준글의 idx를 이용해서 댓글을 달고싶은 게시글의 정보를 가져온다.
			BoardVO baseVO = board_dao.selectOne(idx);
			
			//기준글에 step이상 값을 갖는 데이터에 step = step + 1 처리
			int res = board_dao.update_step(baseVO);
			
			vo.setIp(ip);
			
			//댓글이 들어갈 위치 선정
			vo.setRef(baseVO.getRef());
			vo.setStep(baseVO.getStep()+1);
			vo.setDepth(baseVO.getDepth()+1);
			
			int n = board_dao.reply(vo);
			
			if(n > 0) {
				return "redirect:board_list.do?page="+page;
			}
			return null;
		}
		
		
		
		
		
		@RequestMapping("login.do")
		@ResponseBody
		public String login(String id , String pw) {
			
			MemberVO vo = member_dao.loginCheck(id);
			
			if(vo == null) {
				return "[{'result' : 'no_id'}]";
			}
			
			if(!vo.getPw().equals(pw)) {
				return "[{'result' : 'no_pw'}]";
			}
			
			
			session.setAttribute("id", vo);
			
			return "[{'result':'clear'}]";
		}
		
		
		
		
		@RequestMapping("login_form.do")
		public String login_form() {
			return Common.VIEW_PATH + "login_form.jsp";
		}
		
		
		
		@RequestMapping("logout.do")
		public String logout() {
			session.removeAttribute("id");
			
			//세션에 들어있는 모든 속성을 제거한다.
			//session.invalidate();
			
			return "redirect:board_list.do";
		}
		
		
		@RequestMapping("member_insert_form.do")
		public String member_insert_form() {
			return Common.VIEW_PATH + "member_insert.jsp";
		}
		
		
		
		
		// 중복체크 콜백
		// 중복이 안되면 yes, 중복이 되면 no 
		@RequestMapping("check_id.do")
		@ResponseBody
		public String check_id( String id ) {
			
			int res = member_dao.check_id(id);
			
			if(res > 0) {
				
				return "[{'res' : 'no'}]";
				
			}
			
			return "[{'res' : 'yes'}]";
			
		}
		
		
		
		@RequestMapping("member_insert.do")
		public String member_insert (MemberVO vo) {
			
			int res = member_dao.insert(vo);
			
			
			if(res > 0) {
				return "redirect:board_list.do";
			}
			
			return null;
			
		}
		
		
		
		
		

}