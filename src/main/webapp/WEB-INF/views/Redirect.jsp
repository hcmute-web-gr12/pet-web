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
	<main class="h-screen box-border">
		<h1 class="mt-20 text-center text-4xl font-black text-brand">${requestScope.get("title")}</h1>
		<p class="mt-6 text-center text-xl text-stone-350">Bạn sẽ được chuyển hướng trong giây lát.</p>
	</main>
  <c:import url="../templates/Footer.jsp" />
</body>
</html>
