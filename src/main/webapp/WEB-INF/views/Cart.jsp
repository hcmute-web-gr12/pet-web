<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<title>Brand</title>
	<c:import url="../templates/Head.jsp" />
</head>

<body>
	<c:import url="../templates/Header.jsp" />
	<main class="my-8 mx-4 flex flex-col gap-8 bg-stone-50">
		<section class="relative w-full mx-auto max-w-screen-xl">
			<h1 class="font-bold text-2xl text-center mb-2">Giỏ hàng</h1>
			<c:choose>
				<c:when test="${props.cart == null || props.cart.items.size() == 0}">
				<p class="mt-8 font-black text-stone-300 text-7xl text-center">
					Trống trơn
					</P>
				</c:when>
				<c:otherwise>
					<c:import url="/WEB-INF/templates/cart/CartTable.jsp" />
				</c:otherwise>
			</c:choose>
		</section>
	</main>
	<c:import url="../templates/Footer.jsp" />
</body>

</html>
