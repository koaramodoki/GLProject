<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<html>
<head><title>�f���e�X�g</title></head>
<body>
<form method='post' action='dbatestservlet'>
		id<input type="text" name='Id'><br>
		���O<input type="text" name='User'><br>
		�{��<input type="text" name='Content'><br>
	<input type='submit' value='���M'><br><hr>
	</form>
		
		<c:forEach var="user" items="${users}">
			${user.resUserName}:${user.resCreateDate}:${user.resId}<br>
			<h2>${user.resContent}</h2><hr><br>
		</c:forEach>
	</table>
	
</body>
</html>