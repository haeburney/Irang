<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>

function a () {
	let type = f.serchType.value; 
	let span = document.getElementById("searchSpan");
	let html = ""; 
	
	if(type=="1"){ 
		html = "<input type = 'text' name = 'writer'>"; 
		
		f.action = "${pageContext.request.contextPath }/kboard/writerlist.do";
	
		
	} else if (type=="2") { 
		html = "<input type = 'text' name = 'title''>"; 
		
		f.action = "${pageContext.request.contextPath }/kboard/titlelist.do";
	} else {
		html = "<input type = 'date' name = 'e_date'>;"
		
		f.action = "${pageContext.request.contextPath }/kboard/datelist.do";
	}
	span.innerHTML = html;
	
	
	
}
</script>





</head>
<body>

<h3>공지사항</h3>

<form action = "${pageContext.request.contextPath }/kboard/writerlist.do" method = "post" name = "f"> 
<span> 
<select name = "serchType" onchange = "a()">
<option value = "1"> 작성자 </option>
<option value = "2"> 제목 </option>
<option value = "3"> 날짜 </option>
</select>
</span>
<span id = "searchSpan">
<input type = 'text' name = 'writer'>
</span>
<input type = "submit" value = "검색"> 
</form> 


<input type = "button"  onclick="location.href ='${pageContext.request.contextPath }/kboard/add.do'" value ="글작성"><br/>
<br/>


<table border="1">
<tr><th>번호</th><th>제목</th><th>작성자</th><th>작성일</th></tr>

<c:forEach var="vo" items="${wlist }">

<tr><td>${vo.board_num }</td>
<td><a href="${pageContext.request.contextPath }/kboard/detail.do?num=${vo.board_num }">${vo.title }</a></td>
<td>${vo.teacher_Id }</td>
<td>${vo.w_date }</td>
</tr>
</c:forEach>
</table>
</body>
</html>