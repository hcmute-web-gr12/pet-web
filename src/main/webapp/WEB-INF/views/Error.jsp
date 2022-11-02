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
    <div class="grid h-screen place-content-center bg-white">
      <div class="text-center">
        <strong class="text-9xl font-black text-stone-200">Uh-oh!</strong>

        <h1 class="text-2xl font-bold tracking-tight text-stone-900 sm:text-4xl">
          Có lỗi đã xảy ra.
        </h1>

        <a
                href="<c:url value="/" />"
                class="mt-6 inline-block rounded bg-brand px-5 py-3 text-sm font-medium text-white hover:bg-brand-600 focus:outline-none focus:ring focus:ring-brand"
        >
          Quay lại
        </a>
      </div>
    </div>
    <div></div>
  </main>
  <c:import url="../templates/Footer.jsp" />
</body>
</html>
