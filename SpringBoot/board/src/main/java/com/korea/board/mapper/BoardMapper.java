package com.korea.board.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.korea.board.vo.BoardVO;

@Mapper
public interface BoardMapper {
	
	//페이지별 전체게시물 조회
	public List<BoardVO> selectList(HashMap<String, Integer> map);
	
	//전체 게시물개수 조회
	public int getRowTotal();
	
	
	
}
