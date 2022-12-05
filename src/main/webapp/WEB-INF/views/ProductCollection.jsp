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
	<main class="my-8 flex flex-col gap-8 bg-stone-50">
		<div class="max-w-screen-2xl px-4 md:px-8 mx-auto">
			<div class="flex justify-between items-end gap-4 mb-6">
				<h2 class="text-stone-800 text-2xl lg:text-3xl font-bold">Danh mục thú nuôi</h2>
			</div>

			<c:import url="/WEB-INF/templates/product/Collection.jsp" />
		</div>
	</main>
	<c:import url="../templates/Footer.jsp" />
</body>

</html>
