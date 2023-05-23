package util;

public class Common {
	//
	
	public static final String VIEW_PATH = "/WEB-INF/views/board/";
	
	
	// 일반 게시판용
	public static class Board{
		
		// 한페이지에 보여줄 게시물 수
		public final static int BLOCKLIST = 10;
		// 페이지 메뉴개수
		public final static int BLOCKPAGE = 3;
	}
	
	public static class Notice{
		
		public final static int BLOCKLIST = 20;
		
		public final static int BLOCKPAGE = 5;
		
	}
}
