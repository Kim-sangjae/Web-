<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	제목:${title} <br>
	<!-- jsp는 프로젝트 외부의 경로까지 접근을 할 수 없다. -->
	<img src="upload/${filename}" width="200">

</body>
</html>