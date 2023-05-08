<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/httpRequest.js"></script>
<script type="text/javascript">

	function reply(){
		location.href="reply_form.jsp?idx=${vo.idx}&page=${param.page}";
	}
	
	function del(){
		if(!confirm("삭제하시겠습니까?")){
			return;
		}
		
		var pwd = "${vo.pwd}"; // 원본 비밀번호
		var c_pwd = document.getElementById("c_pwd").value;
		
		if(pwd != c_pwd){
			alert("비밀번호 불일치");
			return;
		}
		
		if(c_pwd == ''){
			alert("비밀번호를 입력하세요");
			return;
		}
		
		var url = "del.do";
		var param = "idx=${vo.idx}";
		
		sendRequest(url,param,delCheck,"post");
	}
	
	
	
	function delCheck(){
		if(xhr.readyState == 4 && xhr.status == 200){
			
			var data = xhr.responseText;
			var json = eval(data);
			
			if(json[0].param == 'yes'){
				alert('삭제성공');
				location.href="board_list.do?page=${param.page}";
			} else{
				alert('삭제실패');
			}
		}
	}
</script>
</head>
<body>
	<table border="1">
		<caption>:::게시글 상세보기:::</caption>
		<tr>
			<th>제목</th>
			<td>${vo.subject}</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${vo.name}</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${vo.regdate}</td>
		</tr>
		<tr>
			<th>ip</th>
			<td>${vo.ip}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td width="500px" height="200px"><pre>${vo.content}</pre></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" id="c_pwd"></td>
		</tr>
		<tr>
			<td colspan="2">
				<!-- 목록으로 돌아가기 -->
				<img src="img/btn_list.gif" onclick="location.href='board_list.do?page=${param.page}'">
				<!-- 답글달기 -->
				<c:if test="${vo.depth lt 1}">
				<img src="img/btn_reply.gif" onclick="reply();">
				</c:if>
				<!-- 글삭제 -->
				<img src="img/btn_delete.gif" onclick="del();">
			</td>
		</tr>
	</table>

</body>
</html>