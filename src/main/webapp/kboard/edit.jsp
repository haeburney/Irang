<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>수정하기</h3>

<form action = "${pageContext.request.contextPath }/kboard/edit.do" method = "post">

<input type="hidden" name="num" value="${vo.num }">

<table border="1">

<tr><th>제목</th><td><input type = "text" name = "writer" value = "${vo.title }">${vo.title } </td></tr>
<tr><th>작성자</th><td>${vo.writer }</td></tr>
<tr><th>작성일</th><td>${vo.w_date }</td></tr>
<tr><th>이벤트일</th><td><input type = "text" name = "e_date" value = "${vo.e_date }">${vo.e_date }</td></tr>
<tr><th>내용</th><td><input type = "text" name = "content" value = "${vo.content }">${vo.content }</td></tr>
</table>
<input type  = "submit"  value = "수정완료"> 
</form>
</body>
</html>