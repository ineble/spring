<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*, java.io.*"
    isELIgnored="false"
%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<% request.setCharacterEncoding("utf-8"); %>
<script>
	function fn_articleForm(isLogOn,articleForm,loginForm) {
		if(isLogOn != '' && isLogOn != 'false'){
			location.href=articleForm;
		}else{
			alert("로그인 후 글쓰기가 가능합니다.")
			location.href=loginForm+'?action=/board/articleForm.do';
		}
		
	}
</script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 출력창</title>
<style type="text/css">
	.cls1{
	font-size: 40px;
	text-align: center;
	}
	
	.cls2{
	text-align: center;
	}
</style>

</head>
<body>
	</form>
	<table align="center" width="100%" border="1">
		<tr align="center" bgcolor="lightgreen" >
			<td width="7%">아이디</td>
			<td width="7%">비밀번호</td>
			<td width="7%">이름</td>
			<td width="7%">이메일</td>
			<td width="7%">가입일</td>
		</tr>
	
	<c:choose>
	<c:when test="${TestList == null}">
		<tr align="center" >
			<td colspan="7" width="7%">
			<b>등록된 회원이 없습니다.</b>
			</td>
		</tr>
	</c:when>
	<c:when test="${!empty TestList}">
		<c:forEach var="test" items="${TestList }">
		<tr align="center" >
			<td width="7%">${test.id }</td>
			<td width="7%">${test.pwd }</td>
			<td width="7%">${test.name }</td>
			<td width="7%">${test.email }</td>
			<td width="7%">${test.joinDate }</td>
		</tr>
		</c:forEach>
	</c:when>
	</c:choose>
	</table>	

</body>
</html>