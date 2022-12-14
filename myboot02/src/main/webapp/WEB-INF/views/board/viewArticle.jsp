<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>

<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	#tr_file_upload{
		display:none;
	}
	#tr_btn_modify {
		display:none;
	}
</style>
<meta charset="UTF-8">
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	function backToList(obj) {
		obj.action="${contextPath}/board/listArticles.do";
		obj.submit();
	}
	
	function fn_enable(obj) {
	      document.getElementById("i_title").disabled=false;
	      document.getElementById("i_content").disabled=false;
	      document.getElementById("i_imageFileName").disabled=false;
	      document.getElementById("tr_btn_modify").style.display="block";
	      //document.getElementById("tr_file_upload").style.display="block";
	      document.getElementById("tr_btn").style.display="none";
	 }
	function fn_modify_article(obj) {
		obj.action="${contextPath}/board/modArticle.do";
		obj.submit();
	}
	
	function fn_remove_article(url,articleNO) {
		var form = document.createElement("form");
		form.setAttribute("method","post");
		form.setAttribute("action",url);
		var articleNOInput = document.createElement("input");
		articleNOInput.setAttribute("type","hidden");
		articleNOInput.setAttribute("name","articleNO");
		articleNOInput.setAttribute("value",articleNO);
		
		form.appendChild(articleNOInput);
		document.body.appendChild(form);
		form.submit();
	}
	
	function fn_reply_form(url,parentNO) {
		var form = document.createElement("form");
		form.setAttribute("method","post");
		form.setAttribute("action",url);
		var parentNOInput = document.createElement("input");
		parentNOInput.setAttribute("type","hidden");
		parentNOInput.setAttribute("name","parentNO");
		parentNOInput.setAttribute("value",parentNO);
		
		form.appendChild(parentNOInput);
		document.body.appendChild(form);
		form.submit();
	}
	
	function readURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function (e) {
				$('#preview').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
</script>
<title>?????????</title>

</head>
<body>
	<form action="${contextPath}" name="frmArticle" method="post" enctype="multipart/form-data">
		<table border="0" align="center">
			<tr>
				<td width="150" align="center" bgcolor="lightblue">?????????</td>
				<td><input type="text" value="${article.articleNO}" disabled="disabled"/>
				 <input type="hidden" name="articleNO" value="${article.articleNO}" /></td>
			</tr>
			<tr>
				<td width="150" align="center" bgcolor="lightblue">????????? ?????????</td>
				<td><input type="text" value="${article.id}" name="writer" disabled="disabled"  /></td>
			</tr>
			<tr>
				<td width="150" align="center" bgcolor="lightblue">??????</td>
				<td><input type="text" value="${article.title}" name="title" id="i_title" disabled="disabled" ></td>
			</tr>
			<tr>
				<td width="150" align="center" bgcolor="lightblue">??????</td>
				<td><textarea rows="20" cols="60" name="content" id="i_content" disabled="disabled" >${article.content}</textarea></td>
			</tr>

			 <c:if test="${not empty article.imageFileName && article.imageFileName != 'null'}">
				<tr>
					<td width="150" align="center" bgcolor="lightblue" rowspan="2">?????????</td>
					<td>
						<input type="hidden" name="originalFileName" value="${article.imageFileName}" />
						<img src="${contextPath}/download.do?articleNO=${article.articleNO}&imageFileName=${article.imageFileName}" id="preview" /><br>
					</td>
				</tr>
				<tr>
					<td>
						<input type="file" name="imageFileName" id="i_imageFileName" disabled="disabled" onchange="readURL(this);" />
					</td>
				</tr>
			</c:if> 
			<c:choose>
				<c:when
					test="${not empty article.imageFileName && article.imageFileName!= 'null'} }">
					<tr>
						<td width="150" align="center" bgcolor="#FF9933" rowspan="2">
							?????????</td>
						<td><input type="hidden" name="originalFileName" value="${article.imageFileName}" /> 
							<img src="${contextPath}/download.do?articleNO=${article.articleNO}&imageFileName=${article.imageFileName}" id="preview" /> <br></td>
					</tr>
					<tr>
						<td><input type="file" name="imageFileName" id="i_imageFileName" disabled="disabled" onchange="readURL(this);" />
						</td>
					</tr>
				</c:when>
				<c:otherwise>
					<tr id="tr_file_upload">
						<td width="150" align="center" bgcolor="#FF9933" rowspan="2">
							?????????</td>
						<td><input type="hidden" name="originalFileName"
							value="${article.imageFileName}" /></td>
					</tr>
					<tr>
						<td></td>
						<td><img id="preview" /> <br> <input type="file"
							name="imageFileName" id="i_imageFileName" disabled="disabled" onchange="readURL(this);" /></td>
					</tr>
				</c:otherwise>
			</c:choose>
			<tr>
				<td></td>

			</tr>
			<tr>
				<td width="150" align="center" bgcolor="lightblue">????????????</td>
				<td><input type="text"
					value='<fmt:formatDate value="${article.writeDate}" />'
					disabled="disabled" /></td>
			</tr>
			<tr id="tr_btn_modify">
				<td colspan="2" align="center"><input type="button"
					value="??????????????????" onclick="fn_modify_article(frmArticle)" /> <input
					type="button" value="??????" onclick="backToList(frmArticle)" /></td>
			</tr>
			<tr id="tr_btn">
				<td colspan="2" align="center">
				<c:if test="${member.id == article.id}">
						<input type="button" value="????????????" onclick="fn_enable(this.form)" />
						<input type="button" value="????????????"
							onclick="fn_remove_article('${contextPath}/board/removeArticle.do', ${article.articleNO})" />
					</c:if> <input type="button" value="???????????? ????????????"
					onclick="backToList(this.form)" /> <input type="button" value="????????????" onclick="fn_reply_form('${contextPath}/board/replyForm.do', ${article.parentNO})" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>



























