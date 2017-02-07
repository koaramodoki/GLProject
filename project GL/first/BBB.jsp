<%@ page pageEncoding = "Windows-31J" contentType="text/html;charset=Windows-31J" %>

<html>
<head><title>結果</title></head>
<body>

    <c:forEach var="ririri" items="${P}">
        ・${ririri.resId}<br>
        ・${ririri.resUserName}<br>
        ・${ririri.resCreateDate}<br>
        ・${ririri.resContent}<br>
        ・${ririri.resDeleteFlag}<br>
        ・${ririri.resStamp}<br>
    </c:forEach>

</body>
</html>
