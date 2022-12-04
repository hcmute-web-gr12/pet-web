<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="vi_VN"/>
<section class="max-w-screen-2xl mx-auto">
	<div class="flex items-center justify-between">
		<div class="flex border border divide-x divide-stone-100 rounded">
			<button
				class="inline-flex items-center justify-center border w-10 h-10 text-stone-600 transition hover:bg-stone-50 hover:text-stone-700">
				<svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5"
					stroke="currentColor" class="w-5 h-5">
					<path stroke-linecap="round" stroke-linejoin="round"
						d="M3.75 6A2.25 2.25 0 016 3.75h2.25A2.25 2.25 0 0110.5 6v2.25a2.25 2.25 0 01-2.25 2.25H6a2.25 2.25 0 01-2.25-2.25V6zM3.75 15.75A2.25 2.25 0 016 13.5h2.25a2.25 2.25 0 012.25 2.25V18a2.25 2.25 0 01-2.25 2.25H6A2.25 2.25 0 013.75 18v-2.25zM13.5 6a2.25 2.25 0 012.25-2.25H18A2.25 2.25 0 0120.25 6v2.25A2.25 2.25 0 0118 10.5h-2.25a2.25 2.25 0 01-2.25-2.25V6zM13.5 15.75a2.25 2.25 0 012.25-2.25H18a2.25 2.25 0 012.25 2.25V18A2.25 2.25 0 0118 20.25h-2.25A2.25 2.25 0 0113.5 18v-2.25z" />
				</svg>
			</button>

			<button
				class="inline-flex items-center justify-center border w-10 h-10 text-stone-600 transition hover:bg-stone-50 hover:text-stone-700">
				<svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5"
					stroke="currentColor" class="w-5 h-5">
					<path stroke-linecap="round" stroke-linejoin="round"
						d="M3.75 5.25h16.5m-16.5 4.5h16.5m-16.5 4.5h16.5m-16.5 4.5h16.5" />
				</svg>
			</button>
		</div>

		<div>
			<label for="SortBy" class="sr-only">SortBy</label>

			<select id="SortBy" class="h-10 text-sm border-stone-300 rounded focus:border-transparent focus:ring focus:ring-brand/60">
				<option selected value="new">Mới nhất</option>
				<option value="old">Cũ nhất</option>
				<option value="cheap">Rẻ nhất</option>
				<option value="expensive">Đắt nhất</option>
			</select>
		</div>
	</div>

	<ul class="grid gap-4 mt-4 sm:grid-cols-2 lg:grid-cols-4">
		<c:forEach var="pet" varStatus="status" items="${props.pets}">
			<li>
				<a href="#" class="block overflow-hidden group">
					<img src="${pet.imagePublicId}" alt="${pet.name}"
						class="h-[350px] w-full object-cover transition duration-200 group-hover:scale-105 sm:h-[450px]" />

					<div class="relative pt-3">
						<h3 class="text-stone-700 group-hover:underline group-hover:underline-offset-4">
							${pet.name}
						</h3>

						<p class="mt-2">
							<span class="sr-only"> Regular Price </span>

							<span class="tracking-wider text-stone-900"> <fmt:formatNumber value="${pet.price}" type="currency"/> </span>
</p>
						</p>
					</div>
				</a>
			</li>
		</c:forEach>
	</ul>
</section>
