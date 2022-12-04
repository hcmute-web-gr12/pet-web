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
				<ol class="flex justify-center gap-1 text-xs font-medium">
					<li>
						<a href="#"
							class="page-previous inline-flex h-8 w-8 items-center justify-center rounded border">
							<span class="sr-only">Previous</span>
							<span class="material-symbols-rounded">chevron_left</span>
						</a>
					</li>
					<c:forEach var="page" items="${props.pages}">
						<c:choose>
							<c:when test="${page.equals('...')}">
								<li class="block h-8 w-8 rounded border text-center leading-8">
									...
								</li>
							</c:when>
							<c:when test="${page.equals(props.page.toString())}">
								<li
									class="block h-8 w-8 rounded border-brand-700 bg-brand text-center leading-8 text-white">
									${page}
								</li>
							</c:when>
							<c:otherwise>
								<li>
									<a href="?page=${page}"
										class="page-link block h-8 w-8 rounded border text-center leading-8">
										${page}
									</a>
								</li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<li>
						<a href="#" class="page-next inline-flex h-8 w-8 items-center justify-center rounded border">
							<span class="sr-only">Next</span>
							<span class="material-symbols-rounded">chevron_right</span>
						</a>
					</li>
				</ol>
			</nav>
		</div>
	</div>
	<div class="flex flex-1 justify-end gap-x-2 sm:hidden">
		<nav class="isolate inline-flex -space-x-px rounded-lg" aria-label="Pagination">
			<ol class="flex justify-center gap-1 text-xs font-medium">
				<li>
					<a href="#" class="page-previous inline-flex h-8 w-8 items-center justify-center rounded border">
						<span class="sr-only">Previous</span>
						<span class="material-symbols-rounded">chevron_left</span>
					</a>
				</li>
				<li class="block h-8 w-8 rounded border-brand-700 bg-brand text-center leading-8 text-white">
					${props.page}
				</li>
				<li>
					<a href="#" class="page-next inline-flex h-8 w-8 items-center justify-center rounded border">
						<span class="sr-only">Next</span>
						<span class="material-symbols-rounded">chevron_right</span>
					</a>
				</li>
			</ol>
		</nav>
	</div>
</div>
