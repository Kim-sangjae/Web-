<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
table{
border-spacing:5px;
text-align:center;
background-color:gray;
color:white;

}
tr{
background-color:black;
box-shadow:5px 5px 5px 5px;
}
</style>

<script type="text/javascript">
	function search(){
		var search = document.getElementById("search").value.trim();
		location.href="gogek_list.do?search="+search;
	}
</script>

</head>

<body>

<div align="center">
	지역:
	<input id="search" placeholder="검색어를 입력하세요">
	<input type="button" value="검색" onclick="search()">
</div>


<table border="1" align="center">
		<caption>:::고객목록:::</caption>
		<tr>
			<th>고객번호</th>
			<th>담당자</th>
			<th>이름</th>
			<th>주소</th>
			<th>주민번호</th>
		</tr>
		<c:forEach var="vo" items="${list}">
			<tr>
				<td>${vo.gobun}</td>
				<td>${vo.godam}</td>
				<td>${vo.goname}</td>
				<td>${vo.goaddr}</td>
				<td>${vo.gojumin}</td>
			</tr>
		</c:forEach>
	</table>
	


</body>
</html>