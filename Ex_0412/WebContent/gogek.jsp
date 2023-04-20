<%@page import="vo.GogekVO"%>
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
InitialContext ic = new InitialContext();


Context ctx = (Context)ic.lookup("java:comp/env");


DataSource ds = (DataSource)ctx.lookup("jdbc/oracle_test");


Connection conn = ds.getConnection();

System.out.println("-----DB접속 성공-----");




String sql = "select * from gogek";

PreparedStatement pstmt = conn.prepareStatement(sql);

ResultSet rs = pstmt.executeQuery();

List<GogekVO> gogek_list = new ArrayList<>();


while(rs.next()){ // .next()다음줄이 있으면 true
	GogekVO gv = new GogekVO();

	gv.setGobun(rs.getInt("gobun"));
	gv.setGoname(rs.getString("goname"));
	gv.setGoaddr(rs.getString("goaddr"));
	gv.setGojumin(rs.getString("gojumin"));
	
	gogek_list.add(gv);
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
<style>
caption{
font-size:20px;
font-weight:bold;
color:green;
}
caption:hover{
transform: rotate( 720deg );
transition:1s;
color:red;
font-size:30px;
}
table{

background-color:yellow;
color:white;
font-size:25px;
border-spacing: 5px;

}

tr{
	padding:20spx;
	background-color:black;
	
}
tr:hover{
background-color:gray;
cursor:pointer;
transition:0.4s;
border: dashed 5px red;


}

td{
	padding:10px;
	border-radius:15px;
}



</style>
</head>
<body>

	<table border="1">
		<caption>예린린 바보</caption>
		<caption>어휴!! -익명의 누군가-</caption>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>주소</th>
			<th>주민번호</th>
		</tr>
		 
		<% for(int i = 0; i < gogek_list.size(); i++){
			GogekVO vo = gogek_list.get(i); %>
			<tr>	
				<td><%= vo.getGobun() %></td>
				<td><%= vo.getGoname() %></td>
				<td><%= vo.getGoaddr() %></td>
				<td><%= vo.getGojumin() %></td>
			</tr>
		<%} %>
	</table>

</body>
</html>