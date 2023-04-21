<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/photo.css">
<script src="js/httpRequest.js"></script>
</head>
<body>
	<div id="main_box">
		<h1>:::Photo Gallery:::</h1>
		<div>
			<input type="button" value="사진등록" onclick="location.href='insert_form.jsp'">
		</div>
		
		<!-- for(PhotoVo vo : list) {
			System.out.println(vo.getTitle());
			System.out.println(vo.getFilename());
			
		} -->
		<div id="photo_box">
			<c:forEach var="vo" items="${list}">
				<div class="photo_type">
					<img src="">
					<div class="title">제목</div>
					<div>
						<input type="button" value="삭제">
					</div>
				</div>
				</c:forEach>
		</div>
	</div>
</body>
</html>