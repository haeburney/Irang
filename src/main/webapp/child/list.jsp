<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="${pageContext.request.contextPath }/child/listall.do">전체아동보기</a>
<table border="1">
<c:forEach var="vo" items="${list }">
<tr><th>아이이름</th><td>${vo.name }</td></tr>
<tr><th>보호자 이름</th><td>${vo.p_name }</td></tr>
<tr><th>전화번호</th><td>${vo.phone }</td></tr>
<tr><th>반</th><td>${vo.class_num }</td></tr>
<tr><th>생년월일</th><td>${vo.birthday }</td></tr>
<tr><th>아이사진</th><td><img src="/child/${vo.path }"></td></tr>
</c:forEach>
</table>
</body>
</html>