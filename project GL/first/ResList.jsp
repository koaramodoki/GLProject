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
			width:380px;
		}
	</style>
</head>
<body>
	<div>
		<form method='post' action=''>
			<table>
				<tr><td>投稿内容</td></tr>
				<tr><td>
					<input id="textbox" type='text' name='name' valign="top">
				</td></tr>
				<tr><td align="right"><input type="submit" value="送信 "></td></tr>
			</table>
		</form>
	</div>

<hr><br>

	<table border="0">
		<c:forEach var="Res" items="${_Res}">
			<tr>
				<td rowspan="3" valign="top">${Res.resId}</th>
				<td>${Res.resUserName}</td>
			</tr>
			<tr><td id="res_content">${Res.Content}</td></tr>
			<tr><td align="right">${Res.CreateDate}</td></tr>
			<tr><td></td></tr>
		</c:forEach>
	</table>

</body>
</html>