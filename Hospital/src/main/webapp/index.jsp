<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*, com.database.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<jsp:include page="links.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="components/navbar.jsp"></jsp:include>
	<jsp:include page="components/carousel.jsp"></jsp:include>
	<jsp:include page="components/features.jsp"></jsp:include>
	<jsp:include page="components/teams.jsp"></jsp:include>
	<jsp:include page="components/footer.jsp"></jsp:include>
</body>
</html>