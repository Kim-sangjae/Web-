<%@page import="vo.SawonVO"%>
<%@page import="java.util.ArrayList"%>
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
	//sawon_list.jsp?deptno=10
	//deptno 라는 이름의 파라미터값을 수신
	int no = Integer.parseInt(request.getParameter("deptno"));




    
    
    

InitialContext ic = new InitialContext();
Context ctx = (Context)ic.lookup("java:comp/env");
DataSource ds = (DataSource)ctx.lookup("jdbc/oracle_test");
Connection conn = ds.getConnection();
System.out.println("-----DB접속 성공-----");




String sql ="select * from sawon where deptno=" + no;

PreparedStatement pstmt = conn.prepareStatement(sql);

ResultSet rs = pstmt.executeQuery();

List<SawonVO> sawon_list = new ArrayList<>();


while(rs.next()){ // .next()다음줄이 있으면 true
	SawonVO sw = new SawonVO();

	sw.setSabun(rs.getInt("sabun"));
	sw.setSaname(rs.getString("saname"));
	sw.setDeptno(rs.getInt("deptno"));
	sw.setSapay(rs.getInt("sapay"));
	
	sawon_list.add(sw);
}

rs.close();
pstmt.close();
conn.close();



%>   
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
		<caption>사원테이블</caption>
		<tr>
			<th>사번</th>
			<th>이름</th>
			<th>부서번호</th>
			<th>급여</th>
		</tr>
		 
		<% for(int i = 0; i < sawon_list.size(); i++){
			SawonVO vo = sawon_list.get(i); %>
			<tr>	
				<td><%= vo.getSabun() %></td>
				<td><%= vo.getSaname() %></td>
				<td><%= vo.getDeptno() %></td>
				<td><%= vo.getSapay() %></td>
			</tr>
		<%} %>
	</table>



</body>
</html>