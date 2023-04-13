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
<a href="${pageContext.request.contextPath }/child/join.do">반별로 검색</a>
<a href="${pageContext.request.contextPath }/child/join.do">아이등록</a>
<a href="${pageContext.request.contextPath }/child/edit.do">아이수정</a>
<a href="${pageContext.request.contextPath }/child/out.do">아이삭제</a>
<table border="1">
<c:forEach var="vo2" items="${list }">
<tr><th>아이이름</th><td><a href="${pageContext.request.contextPath }/child/edit.do?id=${vo2.child_id}">${vo2.name }</a></td></tr>
<tr><th>보호자 이름</th><td>${vo2.p_name }</td></tr>
<tr><th>전화번호</th><td>${vo2.phone }</td></tr>
<tr><th>반</th><td>${vo2.class_num }</td></tr>
<tr><th>생년월일</th><td>${vo2.birthday }</td></tr>
</c:forEach>
</table>
</body>
</html>