<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<title>掲示板テスト</title>
	<style type="text/css">
		#textbox{
			width:380px;
			height:80px;
		}
		#res_content{
			width:480px;
			font-size: 16px;
		}
		#res_id{
			font-size: 9px;
			color: #333;
		}
		#res{
			width: 50%;
		}
		#res_createdate{
			font-size: 7px;
			color: #333;
		}
	</style>
</head>
<body>

	<div>
		<form method='post' action='dbatestservlet'>
			<table>
				<tr><td>ID</td><td><input type="text" name="Id"></td></tr>
				<tr><td>名前</td><td><input type="text" name="User"></td></tr>
				<tr><td colspan="2">投稿内容</td></tr>
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
				<tr><td align="right"><input type="submit" value="送信 "></td></tr>
			</table>
		</form>
	</div>


			<c:forEach var="user" items="${users}">
				<div id="res">
					<p>${user.resUserName}</p><p id="resid">${user.resId}</p><br>
					<p id="res_content">${user.resContent}</p><br>
					<p  align="right" id="res_createdate">${user.resCreateDate}</p><br>
					<hr>
				</div>
				</c:forEach>
		</table>

</body>
</html>