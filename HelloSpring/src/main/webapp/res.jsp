<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
id : ${id}<br>
pw : ${pw}<br><br>

id : <%=request.getAttribute("id") %><br>
pw : <%=request.getAttribute("pw") %><br>
</body>
</html>
