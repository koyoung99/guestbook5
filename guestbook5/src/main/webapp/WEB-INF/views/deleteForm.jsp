<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.javaex.vo.GuestVo"%>
<%
List<GuestVo> guestList = (List<GuestVo>) request.getAttribute("guestList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/guestbook3/gtc?">
		<table>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="password"></td>
				
				<td><button type="submit">삭제</button></td>
				
				<input type="hidden" name="action" value="gdelete">
				<input type="hidden" name="no" value="<%=request.getAttribute("no") %>">
				
			</tr>
		</table>
		
	</form>

	<br>
	<br>
	<a href="/guestbook3/gtc?action=aform">메인으로 돌아가기</a>
</body>
</html>