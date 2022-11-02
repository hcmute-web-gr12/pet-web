<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Brand</title>
  <c:import url="../templates/head.html" />
</head>
<body>
  <c:import url="../templates/Header.jsp" />
  <main class="flex flex-col gap-8">
    <c:import url="../templates/home/Hero.jsp" />
    <c:import url="../templates/home/Dogs.jsp" />
    <div></div>
    <c:import url="../templates/home/Cats.jsp" />
    <div></div>
  </main>
  <c:import url="../templates/Footer.jsp" />
</body>
</html>
