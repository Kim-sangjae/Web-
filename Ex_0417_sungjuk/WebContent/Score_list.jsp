<%@page import="java.util.List"%>
<%@page import="dao.ScoreDAO"%>
<%@page import="vo.ScoreVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

ScoreDAO dao = ScoreDAO.getInstance();
List<ScoreVO> list = dao.selectList();


%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<script>
	function del(no){
		
		if(confirm("정말삭제하시겠습니까?") == false ){ // 예 아니요 창 true false
			return;
		}
		location.href='sung_del.jsp?no='+no;
	}
	
	function modify(no,name,kor,eng,mat){
		location.href="sung_update.jsp?no="+no+"&name="+name+"&kor="+kor+"&eng="+eng+"&mat="+mat;
	}
	
	
</script>

</head>
<body>
<table border="1">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>국어성적</th>
			<th>영어성적</th>
			<th>수학성적</th>
			<th>총점</th>
			<th>평균</th>
			<th>순위</th>
			<th>비고</th>
		</tr>
		<%for(int i = 0; i<list.size(); i++){
			
			ScoreVO vo = list.get(i);
			
			%>

			<tr>
				<td><%= vo.getNo() %></td>
				<td><%= vo.getName() %></td>
				<td><%= vo.getKor() %></td>
				<td><%= vo.getEng() %></td>
				<td><%= vo.getMat() %></td>
				<td><%= vo.getTotal() %></td>
				<td><%= vo.getAvgr() %></td>
				<td><%= vo.getRank() %></td>
				<td><input type="button" value="삭제" onclick="del('<%= vo.getNo()%>')">
				<input type="button" value="수정" onclick="modify('<%=vo.getNo()%>',
				'<%=vo.getName() %>',
				'<%=vo.getKor()%>',
				'<%=vo.getEng()%>',
				'<%=vo.getMat()%>')"></td>
				
			</tr>
			
			
		<%}%>
		
		
			<tr>
				<td colspan="9" align="center">
					<input type="button" value="학생정보추가하기" onclick="location.href='sung_register.jsp'">
				</td>
			</tr>
		
		
	</table>




</body>
</html>