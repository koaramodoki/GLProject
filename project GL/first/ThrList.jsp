<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<title>�X���b�h���X�g</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="CSS/ThreadList.css">
<script type="text/javascript" src="javaScript/ThreadList.js"></script>
</head>
<body>
<div class="layer"></div>
<header>
	<form id="hd">
		<input type="submit" value="�X�V">
		<input type="text" style="display: none">
	</form>
	<button id="button" id="hd">
		<a class="fa fa-bars">�X���b�h�쐬</a>
	</button>
</header>
<!-- �X���C�h���j���[����-->
<nav id="slide_menu">
	<br><br>
 	<div>
		<form method='post' action='MainServlet'>
			<table>
				<tr><td>���O:</td><td><input type="text" name="user" id="thr_user"></td></tr>
				<tr><td>�X���b�h��:</td><td><input type="text" name="name" id="thr_name"></td></tr>
				<tr><td align="right" colspan="2"><input type="submit" value="�쐬 "></td></tr>
			</table>
		</form>
	</div>
</nav>
 <br><br><br>


	<div id=thr_top>
		<div id="thr_id" align="center">ID</div>
		<div id="thr_name">�X���b�h��</div>
		<div id="thr_create_user">�쐬��</div>
		<div id="thr_create_date">�쐬��</div>
		<div id="thr_update">�X�V��</div>
		<div id="thr_count" align="center">���X��</div>
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
