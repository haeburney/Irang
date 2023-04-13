<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function idcheck(){
	//비동기 요청 객체 생성
	const xhttp = new XMLHttpRequest();
	
	//비동기 요청 응답이 왔을때 자동 실행될 핸들러 등록
	xhttp.onload = function(){
		let val = xhttp.responseText;
		alert(val);
		let html = '<h4 style="color:'
		let obj = JSON.parse(val);
		if(obj.flag){
			html += 'blue">사용가능한 아이디</h4>';
		}
		else{
			html += 'red">사용 불가능한 아이디</h4>';
		}
		let res = document.getElementById("res");
		res.innerHTML = html;//responseText: 서버로부터 받은 응답값
	}
	
	//요청 전송방식, 서버페이지 url 설정. get방식인 경우 url뒤에 파람 붙임
	let param = "?id="+ f.id.value;
	xhttp.open("GET", "${pageContext.request.contextPath}/child/idcheck.do"+param);
	xhttp.send();
}
</script>
</head>
<body>
<h3>회원가입</h3>
	<form action="${pageContext.request.contextPath }/child/join.do" method="post" name="f">
		<table border="1">
			<tr><th>ID</th>
			<td>
				<input type="text" name="id">
				<input type="button" value="id중복체크" onclick="idcheck()">
				<span id="res"></span>
				</td></tr>
			<tr><th>PWD</th><td><input type="password" name="pwd"></td></tr>
			<tr><th>NAME</th><td><input type="text" name="name"></td></tr>
			<tr><th>P_NAME</th><td><input type="text" name="p_name"></td></tr>
			<tr><th>BIRTHDAY</th><td><input type="date" name="birthday"></td></tr>
			<tr><th>PHONE</th><td><input type="text" name="phone"></td></tr>
			<tr><th>CLASS_NUM</th><td><input type="number" name="classNum"></td></tr>
			<tr><th>photo</th><td><input type="file" name="path"></td></tr>
			<tr><th>가입</th><td><input type="submit" value="가입"></td></tr>
		</table>
	</form>
</body>
</html>