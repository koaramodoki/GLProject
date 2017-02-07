<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>
<%@ taglib prefix="c" uri="http://java.sun.con/"%>

<!DOCTYPE html>
<html>
<head>
	<title>res List</title>
	<style type="text/css">
		#textbox{
			width:380px;
			height:80px;
		}
		#res_content{
			width:480px;
		}
		#res_id{
			font-size: 9px;
			color: #333;
		}
	</style>
</head>
<body>

	<div>
		<form method='post' action='dbatestservlet'>
			<table>
				<tr><td>ID</td><td><input type="text" name="id"></td></tr>
				<tr><td>名前</td><td><input type="text" name="User"></td></tr>
				<tr><td colspan="2">投稿内容</td></tr>
				<tr><td>
					<input id="text" type='text' name='Content' valign="top">
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


		<table border="1">
			<c:forEach var="user" items="${users}">
				<tr>
					<td>${user.resUserName}</td><td id="resid">${user.resId}</td>
				</tr>
				<tr><td id="res_content">${Res.Content}</td></tr>
				<tr><td  align="right">${user.resCreateDate}</td></tr>
			</c:forEach>
		</table>

</body>
</html>