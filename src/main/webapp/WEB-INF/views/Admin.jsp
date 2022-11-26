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
			transition-timing-function: ease-out;
			transition-duration: 300ms;
			opacity: var(--opacity);
			max-height: var(--max-height);
		}
	</style>
</head>

<body>
	<section class="flex flex-row">
		<header class="flex flex-col justify-between p-4 border-r bg-white min-h-screen">
			<div>
				<p class="mb-2 font-bold text-2xl w-fit text-brand rounded-lg">Brand</p>
				<c:import url="../templates/admin/Sidebar.jsp" />
			</div>
			<div class="sticky inset-x-0 bottom-0 border-t border-stone-100">
				<a href="#" class="flex shrink-0 items-center bg-white p-4 hover:bg-gray-50">
					<img alt="Profile picture"
						src="https://images.unsplash.com/photo-1600486913747-55e5470d6f40?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1770&q=80"
						class="h-10 w-10 rounded-full object-cover" />

					<div class="ml-1.5">
						<p class="text-xs">
							<strong class="block font-medium">Display Name</strong>
						</p>
					</div>
				</a>
			</div>
		</header>
		<main id="main-slot" class="p-4 w-full h-full">
			<c:import url="${props.url}" />
		</main>
	</section>
</body>

</html>
