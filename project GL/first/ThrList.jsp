<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<title>スレッドリスト</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="CSS/ThreadList.css">
<script type="text/javascript" src="javaScript/ThreadList.js"></script>
</head>
<body>
<div class="layer"></div>
<header>
	<form id="hd">
		<input type="submit" value="更新">
		<input type="text" style="display: none">
	</form>
	<button id="button" id="hd">
		<a class="fa fa-bars">スレッド作成</a>
	</button>
</header>
<!-- スライドメニュー部分-->
<nav id="slide_menu">
	<br><br>
 	<div>
		<form method='post' action='MainServlet'>
			<table>
				<tr><td>名前:</td><td><input type="text" name="user" id="thr_user"></td></tr>
				<tr><td>スレッド名:</td><td><input type="text" name="name" id="thr_name"></td></tr>
				<tr><td align="right" colspan="2"><input type="submit" value="作成 "></td></tr>
			</table>
		</form>
	</div>
</nav>
 <br><br><br>


	<div id=thr_top>
		<div id="thr_id" align="center">ID</div>
		<div id="thr_name">スレッド名</div>
		<div id="thr_create_user">作成者</div>
		<div id="thr_create_date">作成日</div>
		<div id="thr_update">更新日</div>
		<div id="thr_count" align="center">レス数</div>
	</div>
		<hr>
	<c:forEach var="thr" items="${users}">
	<div id="thr"><a href="ResServlet?id=${thr.thrId}">
		<div id="thr_id" align="center">${thr.thrId}</div>
		<div id="thr_name">${thr.thrName}</div>
		<div id="thr_create_user">${thr.thrCreateUser}</div>
		<div id="thr_create_date">${thr.thrCreateDate}</div>
		<div id="thr_update">${thr.updateDate}</div>
		<div id="thr_count" align="center">${thr.resCount}</div>
	</a></div>
	<hr>
	</c:forEach>
</body>
</html>
