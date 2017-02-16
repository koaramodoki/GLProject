<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<title>掲示板テスト</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	</script>
<link rel="stylesheet" type="text/css" href="CSS/ResList.css">
</head>
<script type="text/javascript" src="javaScript/ThreadList.js"></script>
<body>
<header>
<div class="layer"></div>
	<button id="button" id="hd">
		<i class="fa fa-bars"></i>投稿
	</button>
	<form id="hd">
		<input type="button" value="更新" onclick="koshin()">
	</form>
</header>
<nav id="slide_menu">
	<br><br>
	<div>
		<form method='post' action='dbatestservlet'>
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
				</td></tr>
				<tr><td align="right" colspan="2"><input type="submit" value="送信 "></td></tr>
				<form>
			</table>
		</form>
	</div>
</nav>
<br><br><br>

		<c:forEach var="user" items="${users}">
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