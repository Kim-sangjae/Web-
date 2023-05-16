<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
									<!-- webapp폴더까지의 경로 -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/visit.css">
	</head>
<body >
	<div id="main_box">
		<h1>방명록</h1>                   <!-- 스프링은 jsp -> jsp로 이동 불가 -->
		<input type="button" value="글쓰기" onclick="location.href='insert_form.do'"> 
	</div>


	<c:forEach var="vo" items="${list }">
		<div class="visit_box" >
		
			<div class="type_content">
				<pre>${vo.content }</pre>
			</div>
			<div class ="type_name">
				<b>작성자 :</b> ${vo.name } (${vo.ip })
			</div>
			<div class="type_regdate">
				<b>작성일 :</b> : ${vo.regdate }
			</div>
			
			<div>
				<form>
					<input type="hidden" name="idx" value="${vo.idx }">
					<b>비밀번호 </b> <input type="password" name="pwd">
					<input type="button" value="수정" onclick="modify(this.form)">
					<input type="button" value="삭제" onclick="del(this.form)">
				</form>
			</div>
			
		</div>
		<hr>
	</c:forEach>


</body>
</html>