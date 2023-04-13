<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>글 작성 폼 </h3>
<form action="${pageContext.request.contextPath }/kboard/add.do" method="post" enctype="multipart/form-data">
<table border="1">
<tr><th>작성자</th><td><input type="text" name="writer" value="${sessionScope.loginId }" readonly></td></tr>
<tr><th>제목</th><td><input type="text" name="title"></td></tr>
<tr><th>내용</th><td><textarea name="content"></textarea></td></tr>
<tr><th>이벤트 날짜</th><td><input type="date" name="e_date"></td></tr>
<tr><th>등록</th><td><input type="submit" value="저장"></td></tr>
</table>
</form>
</body>
</html>3