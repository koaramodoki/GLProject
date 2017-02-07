<%@ page pageEncoding = "Windows-31J" contentType="text/html;charset=Windows-31J" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head><title>結果</title></head>
<body>

    <c:forEach var="JJJ" items="${P}">
        ・${JJJ.resId}<br>
        ・${JJJ.resUserName}<br>
        ・${JJJ.resCreateDate}<br>
        ・${JJJ.resContent}<br>
        ・${JJJ.resDeleteFlag}<br>
        ・${JJJ.resStamp}<br>
    </c:forEach>

</body>
</html>
