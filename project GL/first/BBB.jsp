<%@ page pageEncoding = "Windows-31J" contentType="text/html;charset=Windows-31J" %>

<html>
<head><title>����</title></head>
<body>

    <c:forEach var="ririri" items="${P}">
        �E${ririri.resId}<br>
        �E${ririri.resUserName}<br>
        �E${ririri.resCreateDate}<br>
        �E${ririri.resContent}<br>
        �E${ririri.resDeleteFlag}<br>
        �E${ririri.resStamp}<br>
    </c:forEach>

</body>
</html>
