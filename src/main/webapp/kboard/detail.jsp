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

<h3>자료 내용</h3>

<a href="${pageContext.request.contextPath }/kboard/list.do">공지사항 메인</a><br/>

<table border="1">

<tr><th>글번호</th><td>${vo.num }</td></tr>
<tr><th>제목</th><td>${vo.title }</td></tr>
<tr><th>작성자</th><td>${vo.writer }</td></tr>
<tr><th>작성일</th><td>${vo.w_date }</td></tr>
<tr><th>이벤트일</th><td>${vo.e_date }</td></tr>
<tr><th>내용</th><td>${vo.content }</td></tr>
</table>


<c:if test="${sessionScope.loginId == vo.wrtier }">
<a href="${pageContext.request.contextPath }/kboard/edit.do?num=${vo.num}">수정</a>
<a href="${pageContext.request.contextPath }/kboard/del.do?num=${vo.num}">삭제</a>

</c:if>

</body>
</html>