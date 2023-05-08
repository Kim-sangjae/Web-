<%@page import="vo.MemberVo"%>
<%@page import="java.util.List"%>
<%@page import="dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%


MemberDAO dao = MemberDAO.getInstance();
List<MemberVo> list = dao.selectList();




%>
    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body{
background-img:url("img6.jpg");
}
</style>

<script type="text/javascript">

function del(no){
		
		if(confirm("정말삭제하시겠습니까?") == false ){ // 예 아니요 창 true false
			return;
		}
		location.href='Member_del.jsp?no='+ no;
	}
	

function modify(no,name,id,pw,email){
	location.href="Member_update.jsp?no="+no+"&name="+name+"&id="+id+"&pw="+pw+"&email="+email;
}
	
</script>

</head>
<body>

<table border="1">
		<tr>
			<th>회원번호</th>
			<th>이름</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이메일</th>
			<th>비고</th>
		</tr>
		<%for(int i = 0; i<list.size(); i++){
			
			MemberVo vo = list.get(i);
			
			%>

			<tr>
				<td><%= vo.getIdx()%></td>
				<td><%= vo.getName()%></td>
				<td><%= vo.getId() %></td>
				<td><%= vo.getPw() %></td>
				<td><%= vo.getEmail() %></td>
				<td><input type="button" value="삭제" onclick="del(<%=vo.getIdx()%>)">
				<input type="button" value="수정" onclick="modify('<%=vo.getIdx()%>',
				'<%=vo.getName() %>',
				'<%=vo.getId()%>',
				'<%=vo.getPw()%>',
				'<%=vo.getEmail()%>')"></td>
			</tr>
			
		<%}%>	
		
	</table>
	
		<div>
		<input type="button" value="추가" onclick="location.href='Member_insert.jsp'">
		</div>

</body>
</html>