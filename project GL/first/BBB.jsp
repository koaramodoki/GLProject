<%@ page pageEncoding = "Windows-31J" contentType="text/html;charset=Windows-31J" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head><title>����</title></head>
<body>

    <c:forEach var="JJJ" items="${P}">
        �E${JJJ.resId}<br>
        �E${JJJ.resUserName}<br>
        �E${JJJ.resCreateDate}<br>
        �E${JJJ.resContent}<br>
        �E${JJJ.resDeleteFlag}<br>
        �E${JJJ.resStamp}<br>
    </c:forEach>

</body>
</html>
