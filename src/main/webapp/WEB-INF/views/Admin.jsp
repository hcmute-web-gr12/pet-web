<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<title>Brand</title>
	<c:import url="../templates/Head.jsp" />
	<style>
		#main-slot {
			transition-property: max-height, opacity;
			transition-timing-function: ease-in-out;
			transition-duration: 300ms;
			opacity: var(--opacity);
			max-height: var(--max-height);
		}
	</style>
</head>

<body>
	<section class="flex flex-row">
		<header class="flex flex-col p-4 border-r bg-white min-h-screen">
			<p class="mb-2 font-bold text-2xl w-fit text-brand rounded-lg">Brand</p>
			<c:import url="../templates/admin/Sidebar.jsp" />
		</header>
		<main id="main-slot" class="p-4 w-full h-full">
			<c:import url="${props.url}" />
		</main>
	</section>
</body>

</html>
