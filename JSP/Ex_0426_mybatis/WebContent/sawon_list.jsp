<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	
	function find(){
		//선택된 select태그의 value값을 가져온다
		var deptno = document.getElementById("deptno").value;
		
		// form 태그를 사용하고 있지 않기 때문에 location.href를 통해서 보낸다.
		location.href="sawon_list.do?deptno="+deptno;
		
	}
	
	//window.onload : jsp가 완전히 호출되고 난 다음에 호출되는 콜백메서드
	window.onload = function(){
		var deptno = document.getElementById("deptno");
		
		var dept_array = [0,10,20,30,40];
		
		for(var i = 0 ; i < dept_array.length; i++){
			if('${param.deptno}' == dept_array[i]){
				// 다음과 같이 특정 option을 강제 선택할 수 있다.
				deptno[i].selected = true;
				break;
			}
		};
		
	}
	
</script>


</head>
<body>

<div align="center">
부서 :
<!-- 검색해서 현재 셀렉트된 선택값을 전달하기 위한 id 설정 -->
	<select id="deptno">
		<option value="0">:::부서를 선택하세요:::</option>
		<option value="10">총무부</option>
		<option value="20">영업부</option>
		<option value="30">전산실</option>
		<option value="40">관리부</option>
		<option value="50">경리부</option>
	</select>
	<input type="button" value="검색" onclick="find()">
</div>



<table border="1" align="center">
		<caption>:::사원목록:::</caption>
		<tr>
			<th>사원번호</th>
			<th>사원이름</th>
			<th>직책</th>
			<th>급여</th>
			<th>입사일</th>
		</tr>
		<c:forEach var="vo" items="${list}">
			<tr>
				<td>${vo.sabun}</td>
				<td>${vo.saname}</td>
				<td>${vo.sajob}</td>
				<td>${vo.sapay}</td>
				<c:set var="sahire" value="${vo.sahire}"/>
				<td>${fn:split(sahire,' ')[0]}</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>