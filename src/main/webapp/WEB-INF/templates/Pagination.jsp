<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="flex items-center justify-between gap-x-2">
	<div class="sm:flex sm:flex-1 sm:items-center sm:justify-between">
		<div>
			<p class="text-sm text-stone-700">
				Hiển thị từ	
				<span class="font-medium">${(props.page - 1) * props.pageSize + 1}</span>
				đến
				<span class="font-medium">${props.page * props.pageSize}</span>
				trong
				<span class="font-medium">${props.total}</span>
				thú nuôi.
			</p>
		</div>
		<div class="hidden sm:block">
			<nav class="isolate inline-flex -space-x-px rounded-lg" aria-label="Pagination">
				<a href="#"
					class="relative inline-flex items-center rounded-l-lg border bg-white px-2 py-2 text-sm font-medium text-stone-500 hover:bg-stone-50 focus:z-20">
					<span class="sr-only">Previous</span>
					<!-- Heroicon name: mini/chevron-left -->
					<span class="material-symbols-rounded">chevron_left</span>
				</a>
				<a href="#" aria-current="page"
					class="relative z-10 inline-flex items-center border border-brand bg-brand/30 px-4 py-2 text-sm font-medium text-brand focus:z-20">1</a>
				<a href="#"
					class="relative inline-flex items-center border bg-white px-4 py-2 text-sm font-medium text-stone-500 hover:bg-stone-50 focus:z-20">2</a>
				<a href="#"
					class="relative hidden items-center border bg-white px-4 py-2 text-sm font-medium text-stone-500 hover:bg-stone-50 focus:z-20 md:inline-flex">3</a>
				<span
					class="relative inline-flex items-center border bg-white px-4 py-2 text-sm font-medium text-stone-700">...</span>
				<a href="#"
					class="relative hidden items-center border bg-white px-4 py-2 text-sm font-medium text-stone-500 hover:bg-stone-50 focus:z-20 md:inline-flex">8</a>
				<a href="#"
					class="relative inline-flex items-center border bg-white px-4 py-2 text-sm font-medium text-stone-500 hover:bg-stone-50 focus:z-20">9</a>
				<a href="#"
					class="relative inline-flex items-center border bg-white px-4 py-2 text-sm font-medium text-stone-500 hover:bg-stone-50 focus:z-20">10</a>
				<a href="#"
					class="relative inline-flex items-center rounded-r-lg border bg-white px-2 py-2 text-sm font-medium text-stone-500 hover:bg-stone-50 focus:z-20">
					<span class="sr-only">Next</span>
					<span class="material-symbols-rounded">chevron_right</span>
				</a>
			</nav>
		</div>
	</div>
	<div class="flex flex-1 justify-end gap-x-2 sm:hidden">
		<c:import url="/WEB-INF/templates/Link.jsp">
			<c:param name="slot" value="<span class='material-symbols-rounded'>chevron_left</span>" />
			<c:param name="bg" value="bg-white" />
			<c:param name="text" value="text-stone-700" />
			<c:param name="border" value="border" />
		</c:import>
		<c:import url="/WEB-INF/templates/Link.jsp">
			<c:param name="slot" value="<span class='material-symbols-rounded'>chevron_right</span>" />
			<c:param name="bg" value="bg-white" />
			<c:param name="text" value="text-stone-700" />
			<c:param name="border" value="border" />
		</c:import>
	</div>
</div>
