<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<html>
<head><title>�f���e�X�g</title></head>
<body>

	<div>
		<form method='post' action='dbatestservlet'>
			<table>
				<tr><td>���O</td><td><input type="text" name="User"></td></tr>
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
				<tr><td align="right"><input type="submit" value="���M "></td></tr>
			</table>
		</form>

</body>
</html>