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
		
		
		
		function apiList(){
			var url = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json";
			var param = "key=f5eef3421c602c6cb7ea224104795888&targetDt=20230520";
			
			sendRequest(url,param,resultApi,"GET");
		}
		
		function resultApi(){
			if(xhr.readyState == 4 && xhr.status == 200){
				var data = xhr.responseText;
				var json = (new Function('return'+ data))();
				
				var res = json.boxOfficeResult.dailyBoxOfficeList[0].movieNm;
				
				// api 버튼 눌렀을 때 input 태그에 제목이 뜨게 하려면
				var api = document.getElementById("api");
				api.value = res;
			}
		}
		
	
	</script>
	
	
	<style>
.imagee{
  content: "";
  background-image: url(resources/비버2.png);
  position: absolute;
  width: 150px;
  height: 150px;
  top: 5%;
  right: 15%;
  background-size: cover;
  animation-name: updown;
  animation-duration: 1.2s;
  animation-iteration-count: infinite;
  transition: 1s;
  filter: drop-shadow(5px 5px 10px blue);
        }
        
.imagee:hover{
transform:rotate(90deg);
}


.imagee1{
  content: "";
  background: url('data:image/jpeg;base64,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') no-repeat center center fixed;
  position: absolute;
  width: 150px;
  height: 150px;
  top: 20%;
  right: 75%;
  background-size: cover;
  animation-name: updown;
  animation-duration: 1.2s;
  animation-iteration-count: infinite;
  transition: 1s;
  filter: drop-shadow(5px 5px 10px blue);
        }
        
        
.imagee1:hover{
transform:rotate(-90deg);
}        
.imagee2{
  content: "";
  background-image: url(resources/비버2.png);
  position: absolute;
  width: 150px;
  height: 150px;
  top: 70%;
  right: 30%;
  background-size: cover;
  animation-name: updown;
  animation-duration: 1.2s;
  animation-iteration-count: infinite;
  transition: 2s;
  filter: drop-shadow(5px 5px 10px blue);
        }
        
.imagee2:hover{
transform:rotateY(180deg);
transition:2s;
}         
 
 @keyframes updown{
      0%{

     }
     50%{
         transform: translateY(20px);
     }
     100%{

     }
  }       
	</style>
	</head>
<body >
	<div id="main_box">
		<h1>방명록</h1>                   <!-- 스프링은 jsp -> jsp로 이동 불가 -->
		
		<input type="button" value="API" onclick="apiList();">
		<input type="button" value="글쓰기" onclick="location.href='insert_form.do'"> 
	</div>

	<input id="api">
	<c:forEach var="vo" items="${list }">
		<div class="visit_box" >
		
			<div class="type_content">
				<pre>${vo.content }</pre>
				<img src="${pageContext.request.contextPath}/resources/upload/${vo.filename}"
				width="180" style="border-radius:15px; filter: drop-shadow(5px 5px 5px blue); ">
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
	
<div class="imagee"></div>
<div class="imagee1"></div>
<div class="imagee2"></div>

</body>
</html>