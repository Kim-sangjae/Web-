package com.korea.board.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.korea.board.vo.BoardVO;

@Mapper
public interface BoardMapper {

	//페이지별 게시물 조회
	public List<BoardVO> selectList(HashMap<String, Integer> map);
	
	//전체 게시물개수 조회
	public int getRowTotal();
	
	//게시글 한 건 조회
	public BoardVO selectOne(int idx);
	
	//조회수 변경하기
	public int update_readhit(int idx);
	
	//게시글 추가하기
	public int insert(BoardVO vo);
	
	//게시글 삭제하기
	public int del_update(BoardVO vo);
}
