package com.korea.board.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.korea.board.mapper.BoardMapper;
import com.korea.board.vo.BoardVO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BoardDAO {

	private final BoardMapper boardMapper;
	
	public List<BoardVO> selectList(HashMap<String,Integer> map){
		return boardMapper.selectList(map);
	}
	
	public int getRowTotal() {
		return boardMapper.getRowTotal();
	}	
	
	public BoardVO selectOne(int idx) {
		return boardMapper.selectOne(idx);
	}
	
	public int update_readhit(int idx) {
		return boardMapper.update_readhit(idx);
	}
	
	public int insert(BoardVO vo) {
		return boardMapper.insert(vo);
	}
	
	public int del_update(BoardVO vo) {
		return boardMapper.del_update(vo);
	}
	
}
