<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<html>
<head><title>�f���e�X�g</title></head>
<body>
		
		<c:forEach var="user" items="${users}">
			${user.resId}<br>
			${user.resUserName}<hr><br>
		</c:forEach>
	</table>
	
</body>
</html>