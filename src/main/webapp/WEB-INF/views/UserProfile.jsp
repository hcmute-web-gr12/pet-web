<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<title>Profile</title>
	<c:import url="../templates/Head.jsp" />
</head>

<body>
	<c:import url="../templates/Header.jsp" />
	<main class="my-8 mx-4 flex flex-col gap-8">
		<section class="w-full max-w-5xl mx-auto flex gap-x-8 items-center">
			<img src="/assets/images/user-profile-photo.svg" alt="User profile photo."
				class="w-40 aspect-square object-cover rounded-lg bg-stone-400 border border-stone-600" />
			<div class="flex flex-col gap-y-4">
				<h1 class="text-2xl font-semibold">${requestScope.get("username")}</h1>
				<ul class="flex gap-x-4">
					<li>
						<span class="material-symbols-rounded align-middle">thumb_up</span>
						${Math.round(Math.random() * 100)} likes
					</li>
					<li>
						<span class="material-symbols-rounded align-middle">reviews</span>
						${Math.round(Math.random() * 100)} reviews
					</li>
				</ul>
			</div>
		</section>
	</main>
	<c:import url="../templates/Footer.jsp" />
</body>

</html>
