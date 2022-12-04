<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="flex items-center justify-between gap-x-2">
	<div class="sm:flex sm:flex-1 sm:items-center sm:justify-between">
		<div>
			<p class="text-sm text-stone-700">
				Hiển thị từ
				<span class="font-medium">${(props.page - 1) * props.pageSize + 1}</span>
				đến
				<span class="font-medium">${(props.page - 1) * props.pageSize +
					fn:length(props.pets)}</span>
				trong
				<span class="font-medium">${props.total}</span>
				thú nuôi.
			</p>
		</div>
		<div class="hidden sm:block">
			<nav class="isolate inline-flex -space-x-px rounded-lg" aria-label="Pagination">
				<a href="#" id="page-previous"
					class="relative inline-flex items-center rounded-l-lg border bg-white px-2 py-2 text-sm font-medium text-stone-500 hover:bg-stone-50 focus:z-20">
					<span class="sr-only">Previous</span>
					<span class="material-symbols-rounded">chevron_left</span>
				</a>
				<c:forEach var="page" items="${props.pages}">
					<c:choose>
						<c:when test="${page.equals('...')}">
							<span
								class="relative inline-flex items-center border bg-white px-4 py-2 text-sm font-medium text-stone-700">...</span>
						</c:when>
						<c:when test="${page.equals(props.page.toString())}">
							<a href="?page=${page}" aria-current="page"
								class="page-link relative z-10 inline-flex items-center border border-brand bg-brand/30 px-4 py-2 text-sm font-medium text-brand focus:z-20">${page}</a>
						</c:when>
						<c:otherwise>
							<a href="?page=${page}"
								class="page-link relative hidden items-center border bg-white px-4 py-2 text-sm font-medium text-stone-500 hover:bg-stone-50 focus:z-20 md:inline-flex">${page}</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<a href="#" id="page-next"
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
