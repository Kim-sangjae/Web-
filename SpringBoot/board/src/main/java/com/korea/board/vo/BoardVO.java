package com.korea.board.vo;

import lombok.Data;

@Data
public class BoardVO {
	private int idx; //글번호
	private int readhit; //조회수
	private int ref; //참조글 번호
	private int step; //순서
	private int depth; //댓글깊이
	private int delinfo; //삭제 여부 -1아니면 안삭제, -1이면 삭제
	
	private String name; //작성자
	private String subject;//제목
	private String content;//내용
	private String pwd;//비밀번호
	private String ip;//ip
	private String regdate;//작성날짜
}
