<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="vi_VN"/>
<!DOCTYPE html>
<html>

<head>
	<title>Brand</title>
	<c:import url="../templates/Head.jsp" />
	<script>
	 const description = `${fn:replace(fn:replace(props.pet.description, "`", "&grave;"), "<", "&lt;")}`;
	</script>
	<script defer src="/scripts/product.js"></script>
</head>

<body>
	<c:import url="../templates/Header.jsp" />
	<main class="my-8 mx-4 flex flex-col gap-8 bg-stone-50">
		<section class="relative mx-auto max-w-screen-xl">
			<div class="lg:hidden">
				<h1 class="text-2xl font-bold lg:text-3xl">${props.pet.name}</h1>
				<p class="mt-1 text-sm text-gray-500">ID: ${props.pet.id.toString()}</p>
			</div>

			<div class="grid gap-8 lg:grid-cols-4 lg:items-start">
				<div class="lg:col-span-3">
					<div class="relative mt-4">
						<img alt="${props.pet.name}" src="${props.pet.imagePublicId}"
							class="border h-72 w-full rounded-xl object-cover lg:h-[540px]" />

						<div
							class="absolute bottom-4 left-1/2 inline-flex -translate-x-1/2 items-center rounded-full bg-black/75 px-3 py-1.5 text-white">
							<svg class="h-4 w-4" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24"
								stroke="currentColor">
								<path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
									d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0zM10 7v3m0 0v3m0-3h3m-3 0H7" />
							</svg>

							<span class="ml-1.5 text-xs"> Hover to zoom </span>
						</div>
					</div>

					<ul class="mt-1 flex gap-1">
						<li>
						<img alt="${props.pet.name}" src="${props.pet.imagePublicId}"
								class="border h-16 w-16 rounded-md object-cover" />
						</li>

						<li>
						<img alt="${props.pet.name}" src="${props.pet.imagePublicId}"
								class="border h-16 w-16 rounded-md object-cover" />
						</li>

						<li>
						<img alt="${props.pet.name}" src="${props.pet.imagePublicId}"
								class="border h-16 w-16 rounded-md object-cover" />
						</li>

						<li>
						<img alt="${props.pet.name}" src="${props.pet.imagePublicId}"
								class="border h-16 w-16 rounded-md object-cover" />
						</li>
					</ul>
				</div>

				<div class="flex flex-col gap-y-4 lg:sticky lg:top-0 lg:pt-2">
					<div class="hidden lg:block">
						<h1 class="text-2xl font-bold lg:text-3xl">${props.pet.name}</h1>
						<p class="mt-1 text-sm text-gray-500">ID: ${props.pet.id.toString()}</p>
					</div>
					<form class="flex flex-col gap-y-4">
						<fieldset>
							<legend class="text-lg font-bold">Color</legend>

							<div class="mt-2 flex gap-1">
								<label for="color_green" class="cursor-pointer">
									<input type="radio" id="color_green" name="color" class="peer sr-only" checked />

									<span
										class="block h-6 w-6 rounded-full border border-gray-200 bg-green-700 ring-1 ring-transparent ring-offset-1 peer-checked:ring-gray-300"></span>
								</label>

								<label for="color_blue" class="cursor-pointer">
									<input type="radio" id="color_blue" name="color" class="peer sr-only" />

									<span
										class="block h-6 w-6 rounded-full border border-gray-200 bg-blue-700 ring-1 ring-transparent ring-offset-1 peer-checked:ring-gray-300"></span>
								</label>

								<label for="color_pink" class="cursor-pointer">
									<input type="radio" id="color_pink" name="color" class="peer sr-only" />

									<span
										class="block h-6 w-6 rounded-full border border-gray-200 bg-pink-700 ring-1 ring-transparent ring-offset-1 peer-checked:ring-gray-300"></span>
								</label>

								<label for="color_red" class="cursor-pointer">
									<input type="radio" id="color_red" name="color" class="peer sr-only" />

									<span
										class="block h-6 w-6 rounded-full border border-gray-200 bg-red-700 ring-1 ring-transparent ring-offset-1 peer-checked:ring-gray-300"></span>
								</label>

								<label for="color_indigo" class="cursor-pointer">
									<input type="radio" id="color_indigo" name="color" class="peer sr-only" />

									<span
										class="block h-6 w-6 rounded-full border border-gray-200 bg-indigo-700 ring-1 ring-transparent ring-offset-1 peer-checked:ring-gray-300"></span>
								</label>
							</div>
						</fieldset>

						<fieldset>
							<legend class="text-lg font-bold">Category</legend>

							<div class="mt-2 flex gap-1">
								<label for="material_cotton" class="cursor-pointer">
									<input type="radio" id="material_cotton" name="material" class="peer sr-only"
										checked />

									<span
										class="block rounded-full border border-gray-200 px-3 py-1 text-xs peer-checked:bg-gray-100">
										Cotton
									</span>
								</label>

								<label for="material_wool" class="cursor-pointer">
									<input type="radio" id="material_wool" name="material" class="peer sr-only"
										checked />

									<span
										class="block rounded-full border border-gray-200 px-3 py-1 text-xs peer-checked:bg-gray-100">
										Wool
									</span>
								</label>
							</div>
						</fieldset>

						<div>
							<p class="text-xl font-bold"><fmt:formatNumber value="${props.pet.price}" type="currency"/></p>
						</div>

						<c:import url="/WEB-INF/templates/Button.jsp">
							<c:param name="slot" value="Thêm vào giỏ hàng" />
							<c:param name="type" value="submit" />
							<c:param name="bg" value="bg-brand" />
							<c:param name="border" value="border-brand-700" />
							<c:param name="ring" value="ring-brand" />
						</c:import>
					</form>
				</div>

				<div class="lg:col-span-3">
					<div id="description"
						class="prose prose-stone dark:prose-invert max-w-none [&>iframe]:mt-6 [&>iframe]:aspect-video [&>iframe]:w-full [&>iframe]:rounded-xl">
					</div>
				</div>
			</div>
		</section>
	</main>
	<c:import url="../templates/Footer.jsp" />
</body>

</html>
