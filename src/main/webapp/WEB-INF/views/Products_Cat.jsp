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
  <main class="flex flex-col gap-8 bg-stone-50">
    <div></div>
      <div class="max-w-screen-2xl px-4 md:px-8 mx-auto">
        <div class="flex justify-between items-end gap-4 mb-6">
          <h2 class="text-gray-800 text-2xl lg:text-3xl font-bold">Cửa hàng mèo cưng</h2>
        </div>

        <div class="grid sm:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 gap-x-4 md:gap-x-6 gap-y-8">
          <c:forEach var="i" begin="1" end="10">
            <c:choose>
              <c:when test="${Math.random() > 0.5}">
                <c:import url="/WEB-INF/templates/product/Card.jsp">
                  <c:param name="text" value="Cat ${i}"/>
                  <c:param name="price" value="${Math.floor(Math.random() * 100 + 50)}$"/>
                  <c:param name="sale" value="${Math.floor(Math.random() * 70 + 20)}$"/>
                  <c:param name="src" value="https://images.unsplash.com/photo-1598935888738-cd2622bcd437?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80"/>
                  <c:param name="alt" value="Cat ${i}"/>
                </c:import>
              </c:when>
              <c:otherwise>
                <c:import url="/WEB-INF/templates/product/Card.jsp">
                  <c:param name="text" value="Cat ${i}"/>
                  <c:param name="price" value="${Math.floor(Math.random() * 100 + 50)}$"/>
                  <c:param name="src" value="https://images.unsplash.com/photo-1630126798948-1abb357a1ec5?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80"/>
                  <c:param name="alt" value="Cat ${i}"/>
                </c:import>
              </c:otherwise>
            </c:choose>
          </c:forEach>
        </div>
      </div>
    <div></div>
  </main>
  <c:import url="../templates/Footer.jsp" />
</body>
</html>
