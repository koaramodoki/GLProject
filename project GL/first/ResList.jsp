<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<title>${thrName}</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	</script>
<link rel="stylesheet" type="text/css" href="CSS/ResList.css">
</head>
<script type="text/javascript" src="javaScript/ThreadList.js"></script>
<body>
<div class="layer"></div>
<header>
	<form method='get' action='MainServlet' id="hd">
		<input type="submit" value="TOP‚Ö–ß‚é">
	</form>
	<button id="button" id="hd">
		<a class="fa fa-bars">“Še</a>
	</button>
	<button id="hd_2">
		<a href="Test.html">ƒwƒ‹ƒv</a>
	</button>
</header>
<nav id="slide_menu">
	<br><br>
	<div>
		<form method='post' action='ResServlet'>
			<table>
				<tr><td>–¼‘O</td><td><input type="text" name="User" id="res_name"></td></tr>
				<tr><td colspan="2">“Še“à—e</td></tr>
				<tr><td colspan="2">
					<textarea id="textbox" type='text' name='Content'></textarea>
				</td></tr>
<!--				<tr><td>
					<input type="checkbox" name="stamp" value="1">
					<input type="checkbox" name="stamp" value="2">
					<input type="checkbox" name="stamp" value="3">
					<input type="checkbox" name="stamp" value="4">
					<input type="checkbox" name="stamp" value="5">
					<input type="hidden" name="id" value="${thrId}">
					<input type="hidden" name="thrName" value="${thrName}"
				</td></tr>-->
				<tr><td align="right" colspan="2"><input type="submit" value="‘—M "></td></tr>
				<form>
			</table>
		</form>
	</div>
</nav>
<br><br><br>


			<h1>${thrId}:${thrName}</h1>
		<hr>

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
