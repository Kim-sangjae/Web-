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
	<script src="${pageContext.request.contextPath}/resources/js/httpRequest.js"></script>
	
	<script type="text/javascript">
		function del(f){
			var idx = f.idx.value;
			var pwd = f.pwd.value;
			var ori_pwd = f.ori_pwd.value;
			
			if(pwd == ''){
				alert('비밀번호를 입력하세요')
				return;
			}
			
			if(ori_pwd != pwd){
				alert('비밀번호가 일치하지 않습니다')
				return;
			}
			
			if(!confirm("삭제하시겠습니까?")){
				return;
			}
			
			var url = "delete.do";
			var param = "idx=" + idx + "&pwd=" + encodeURIComponent(pwd);
			
			
			sendRequest(url,param,resultFn,"POST");
				
		
		}
		
		
		function resultFn(){
			if(xhr.readyState == 4 && xhr.status == 200){
				var data = xhr.responseText;
				
				//var json = eval(data); 
				var json = (new Function('return' + data))();
				
				// eval() 문자열형태를 자바스크립트로 사용하게 하는 함수
				// eval은 인자로 받은 코드를 caller의 권한으로 수행하는 함수로
				// 악영향을 줄 수 있는 문자열을 eval()로 실행하게 되면 악의적인 코드를 수행하는 결과를 초래할 수 있다.
				// 또한 제 3자가 eval()로 호출된 위치의 스코프를 볼 수 있으며
				// Function으로는 실행할 수 없는 공격이 가능하다고 한다.
				
				if(json[0].res == 'no'){
					alert('삭제실패')
					return;
				}
				
				alert('삭제성공')
				location.href="visit_list.do";
			}
		}
		
		
		
		
		function modify(f){
			var ori_pwd = f.ori_pwd.value.trim(); // 원본비번
			var pwd = f.pwd.value.trim(); // 입력한 비번
			
			if(ori_pwd != pwd){
				alert("비밀번호 불일치")
				return;
			}
			
			f.action = "modify_form.do";
			f.method="post";
			f.submit();
			
		}
		
		
		
	
	</script>
	
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
					<input type="hidden" name="ori_pwd" value="${vo.pwd }">
					
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