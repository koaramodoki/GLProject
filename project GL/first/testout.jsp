<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<title>�f���e�X�g</title>
	<style type="text/css">
		body{
			font-size: 11px;
		}
		#textbox{
			width:380px;
			height:80px;
		}
		#res_content{
			width:480px;
			font-size: 16px;
		}
		#res{
			width: 50%;
		}
		#res_createdate{
			font-size: 11px;
			color: #333;
		}
		#res_name{
			width:254px;
		}
	</style>
</head>
<body>

	<div>
		<form method='post' action='dbatestservlet'>
			<table>
				<tr><td>���O</td><td><input type="text" name="User" id="res_name"></td></tr>
				<tr><td colspan="2">���e���e</td></tr>
				<tr><td colspan="2">
					<input id="textbox" type='text' name='Content' valign="top">
				</td></tr>
				<tr><td>
					<input type="checkbox" name="stamp" value="1">
					<input type="checkbox" name="stamp" value="2">
					<input type="checkbox" name="stamp" value="3">
					<input type="checkbox" name="stamp" value="4">
					<input type="checkbox" name="stamp" value="5">
				</td></tr>
				<tr><td align="right" colspan="2"><input type="submit" value="���M "></td></tr>
				<form>
			</table>
		</form>
		<form method='post' action='dbatestservlet'>
		<div id="disp" style="visibility:hidden"><input type='text' name='Content'></div>
			<input type="submit" value="�X�V ">
		</form>
	</div>


		<c:forEach var="user" items="${users}">
			<table id="res">
				<tr><td>${user.resId}:<xmp>${user.resUserName}</xmp></td></tr>
				<tr><td id="res_content" colspan="2"><xmp>${user.resContent}</xmp></td></tr>
				<tr><td align="right" id="res_createdate" colspan="2">
					${user.resCreateDate}</td></tr>
			</table>
			<hr>
		</c:forEach>

</body>
</html>