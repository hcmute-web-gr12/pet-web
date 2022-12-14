<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="vi_VN" />
<!DOCTYPE html>
<html>

<head>
	<title>Brand</title>
	<c:import url="../templates/Head.jsp" />
	<script>
		const props = {
			id: '${props.pet.id.toString()}',
			description: `${fn: replace(fn: replace(props.pet.description, "`", "&grave;"), "<", "&lt;")}`,
			stock: ${props.pet.stock},
		 };
	</script>
	<script defer src="/scripts/product.js"></script>
</head>

<body>
	<c:import url="../templates/Header.jsp" />
	<main class="my-8 mx-4 flex flex-col gap-8 bg-stone-50">
		<section class="relative mx-auto max-w-screen-xl">
			<div class="lg:hidden mb-2">
				<h1 class="text-2xl text-brand font-bold lg:text-3xl">${props.pet.name}</h1>
				<p class="mt-1 text-sm text-gray-500">ID: ${props.pet.id.toString()}</p>
			</div>

			<div class="grid gap-8 lg:grid-cols-4 lg:items-start">
				<div class="lg:col-span-3">
					<img alt="${props.pet.name}" src="${props.pet.imagePublicId}"
						class="border h-72 bg-stone-100 w-full rounded-xl object-contain lg:h-[540px]" />
				</div>

				<div class="flex flex-col gap-y-4 lg:sticky lg:top-0 lg:pt-2">
					<div class="hidden lg:block">
						<h1 class="text-2xl text-brand font-bold lg:text-3xl">${props.pet.name}</h1>
						<p class="mt-1 text-sm text-gray-500">ID: ${props.pet.id.toString()}</p>
					</div>
					<form id="cart-form" class="flex flex-col gap-y-4">
						<div>
							<p class="text-xl font-bold">
								<fmt:formatNumber value="${props.pet.price}" type="currency" />
							</p>
						</div>

						<c:choose>
							<c:when test="${props.pet.stock == 0}">
								<div
									class="w-fit inline-flex items-center rounded-full bg-red-600 border border-red-700 px-2.5 py-1 gap-x-1">
									<span class="material-symbols-rounded text-stone-200"> sentiment_dissatisfied
									</span>
									<p class="whitespace-nowrap text-sm font-medium text-stone-200">H???t h??ng</p>
								</div>
								<c:import url="/WEB-INF/templates/Button.jsp">
									<c:param name="id" value="add-to-cart" />
									<c:param name="slot" value="Th??m v??o gi??? h??ng" />
									<c:param name="type" value="submit" />
									<c:param name="bg" value="bg-brand w-fit lg:w-full" />
									<c:param name="border" value="border-brand-700" />
									<c:param name="ring" value="ring-brand" />
									<c:param name="disabled" value="${true}" />
								</c:import>
							</c:when>
							<c:otherwise>
								<c:import url="/WEB-INF/templates/Button.jsp">
									<c:param name="id" value="add-to-cart" />
									<c:param name="slot" value="Th??m v??o gi??? h??ng" />
									<c:param name="type" value="submit" />
									<c:param name="bg" value="bg-brand" />
									<c:param name="border" value="border-brand-700" />
									<c:param name="ring" value="ring-brand" />
								</c:import>
							</c:otherwise>
						</c:choose>
						<p id="form-result" class="text-sm font-medium text-red-600 opacity-0 transition-opacity">
						</p>
					</form>
				</div>

				<c:choose>
					<c:when test="${props.pet.description == null || props.pet.description.length() == 0}">
						<div
							class="w-fit h-fit inline-flex items-center rounded-full bg-stone-500 border border-stone-600 px-2.5 py-1 gap-x-1">
							<span class="material-symbols-rounded text-stone-300"> sentiment_dissatisfied </span>
							<p class="whitespace-nowrap text-sm font-medium text-stone-300 m-0">Ch??a c?? m?? t???</p>
						</div>
					</c:when>
					<c:otherwise>
						<article class="lg:col-span-3">
							<h2 class="text-brand mb-1 text-2xl font-bold">M?? t??? th?? c??ng</h2>
							<section id="description" class="prose prose-stone max-w-none border rounded-xl p-4">
							</section>
						</article>
					</c:otherwise>
				</c:choose>
			</div>
		</section>
	</main>
	<c:import url="../templates/Footer.jsp" />
</body>

</html>
