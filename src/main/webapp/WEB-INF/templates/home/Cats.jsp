<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section>
	<div class="mx-auto max-w-screen px-4 sm:px-6 lg:px-8 text-xs md:text-base">
		<div class="flex flex-col lg:flex-row gap-8 justify-center items-center h-fit">
			<div class="flex items-center">
				<div class="text-center lg:text-left prose prose:lg prose-a:no-underline">
					<h2 class="text-2xl font-bold text-brand">Giống mèo cảnh</h2>

					<p class="max-w-[45ch] text-sm text-gray-700">
						<span class="text-brand font-bold uppercase">Brand</span>
						có sẵn 13+ giống mèo cảnh đa dạng dành cho bạn.
					</p>

					<div class="w-fit mx-auto">
						<c:url var="href" value="/product?category=2" />
						<c:import url="/WEB-INF/templates/Link.jsp">
							<c:param name="slot" value="Đến cửa hàng" />
							<c:param name="href" value="${href}" />
						</c:import>
					</div>
				</div>
			</div>

			<ul class="w-full lg:w-2/3 grid grid-cols-3 lg:grid-cols-5 grid-flow-col gap-4">
				<c:forEach var="pet" varStatus="status" items="${props.cats}">
					<li>
						<a href="/product/${pet.id}" class="block">
							<img alt="${pet.name}" src="${pet.imagePublicId}"
								class="aspect-[7/9] w-full object-cover bg-stone-200 border" />

							<div class="mt-2">
								<h3 class="font-medium">${pet.name}</h3>
							</div>
						</a>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
</section>
