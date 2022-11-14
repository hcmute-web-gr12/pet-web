<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Brand</title>
  <c:import url="../templates/head.html" />
	<meta http-equiv="refresh" content="${requestScope.get('timeout')};URL=${requestScope.get('url')}"
</head>
<body>
  <c:import url="../templates/Header.jsp" />
	<main class="h-screen">
		<h1 class="mt-36 text-center text-9xl font-black text-stone-300">${requestScope.get("title")}</h1>
	</main>
  <c:import url="../templates/Footer.jsp" />
</body>
</html>
