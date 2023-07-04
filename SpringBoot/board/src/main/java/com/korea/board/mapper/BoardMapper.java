package com.korea.board.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.korea.board.common.Common.Board;
import com.korea.board.vo.BoardVO;

@Mapper
public interface BoardMapper {
	
	//페이지별 전체게시물 조회
	public List<BoardVO> selectList(HashMap<String, Integer> map);
	
	//전체 게시물개수 조회
	public int getRowTotal();
	
	
	//idx 값을 가진 게시물 한건 조회
	public BoardVO selectOne(int idx);
	
	//조회 수 증가
	public int update_readhit(int idx);
	
	//게시판 등록
	public int insert(BoardVO vo);
	
	
}
