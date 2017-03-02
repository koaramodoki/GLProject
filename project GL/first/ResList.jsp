<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<title>レス一覧</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	</script>
<link rel="stylesheet" type="text/css" href="CSS/ResList.css">
</head>
<script type="text/javascript" src="javaScript/ThreadList.js"></script>
<body>
<div class="layer"></div>
<header>
	<form method='get' action='MainServlet' id=button>
		<input type="submit" value="TOPへ戻る">	
	</form>
	<button id="button" id="hd">
		<a class="fa fa-bars">投稿</a>
	</button>
</header>
<nav id="slide_menu">
	<br><br>
	<div>
		<form method='post' action='ResServlet'>
			<table>
				<tr><td>名前</td><td><input type="text" name="User" id="res_name"></td></tr>
				<tr><td colspan="2">投稿内容</td></tr>
				<tr><td colspan="2">
					<textarea id="textbox" type='text' name='Content'></textarea>
				</td></tr>
				<tr><td>
					<input type="checkbox" name="stamp" value="1">
					<input type="checkbox" name="stamp" value="2">
					<input type="checkbox" name="stamp" value="3">
					<input type="checkbox" name="stamp" value="4">
					<input type="checkbox" name="stamp" value="5">
					<input type="hidden" name="id" value="${thrId}">
				</td></tr>
				<tr><td align="right" colspan="2"><input type="submit" value="送信 "></td></tr>
				<form>
			</table>
		</form>
	</div>
</nav>
<br><br><br>

		<c:forEach var="user" items="${id}">
			<table id="res">
				<tr><td><xmp>${user.resId}:${user.resUserName}</xmp></td></tr>
				<tr><td id="res_content" colspan="2"><xmp>${user.resContent}</xmp></td></tr>
				<tr><td align="right" id="res_createdate" colspan="2">
					${user.resCreateDate}</td></tr>
			</table>
			<hr>
		</c:forEach>
</body>
</html>