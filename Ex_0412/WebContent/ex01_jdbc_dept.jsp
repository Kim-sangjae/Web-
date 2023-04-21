<%@page import="java.util.ArrayList"%>
<%@page import="vo.DeptVO"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// 톰캣이  JNDI를 검색하기 위해 필요한 클래스(JNDI기법 : Java Naming Directory interface)
	InitialContext ic = new InitialContext();

	// javax -> 라이브러리에서 왔다고 생각하면 된다.
	
	
	// Resource 위치를 검색 -> 프로그램을 구성할만한 모든 참조파일을 리소스라고 한다.
	Context ctx = (Context)ic.lookup("java:comp/env");
	// lookup -> 조회 , jsp에서 db에 대한 리소스가 저장되어 있는 위치 검색
	// java:comp/env -> 자바에 내장되어있는 리소스 자원을 검색하는 상수(고정)
	
	
	// 검색된 Resource를 통해 필요한 JNDI의 Resource를 검색
	// context.xml 파일의 Resource영역에 참조되어있는 name 속성값
	DataSource ds = (DataSource)ctx.lookup("jdbc/oracle_test");
	
	
	// 위해서 준비해놓은 경로로 로그인시도
	Connection conn = ds.getConnection();
	
	System.out.println("-----DB접속 성공-----");
	
	
	
	
	String sql = "select * from dept";
	
	// 문자열을 쿼리로 바꿔준다
	PreparedStatement pstmt = conn.prepareStatement(sql);
	
	// 실행된 sql쿼리문 결과를  vo객체에 담아준다
	ResultSet rs = pstmt.executeQuery();
	
	// 부서목록 저장할 ArrayList만들기
	List<DeptVO> dept_list = new ArrayList<>();
	
	while(rs.next()){ // .next()다음줄이 있으면 true
		DeptVO vo = new DeptVO();
	
		vo.setDeptno(rs.getInt("deptno"));
		vo.setDname(rs.getString("dname"));
		vo.setLoc(rs.getString("loc"));
		
		dept_list.add(vo);
	}
	
	// 연결후 사용한 DB는 종료코드로 마무리
	// DB접속과 관련된 모든 객체는 생성된 역순으로 닫아줘야한다.
	
	rs.close();
	pstmt.close();
	conn.close();
	




%>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	function send(data){
		var f = document.f;
		var deptno = f.deptno;
		deptno.value = data;
		
		f.action = "sawon_list.jsp";
		f.method = "GET";
		f.submit();
	}

</script>


</head>
<body>

	<form name="f">
	
	<table border="1">
		<caption>부서목록</caption>
		<tr>
			<th>부서번호</th>
			<th>부서명</th>
			<th>부서위치</th>
		</tr>
		
		<% for(int i = 0; i < dept_list.size(); i++){
			DeptVO vo = dept_list.get(i); %>
			<tr>	
				<td><%= vo.getDeptno() %></td>
				<td>
				<a href="javascript:send(<%= vo.getDeptno()%>)"><%= vo.getDname() %></a>
				</td>
				<td><%= vo.getLoc() %></td>
			</tr>
		<%} %>
	</table>
	<input type="hidden" name="deptno">
	</form>
</body>
</html>