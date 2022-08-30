<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<head>
<meta charset="UTF-8">
<title>develper test</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

</script>

</head>
<body>
	<form name="articleForm" method="post" action="${contextPath}/board/test9.do"
		<input value="회원 정보 조회">
	</form>
</body>
</html>