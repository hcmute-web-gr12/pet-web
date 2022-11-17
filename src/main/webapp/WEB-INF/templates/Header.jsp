<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
	<nav class="max-w-5xl rounded mx-auto flex items-center justify-between p-4 gap-x-2">
		<a href="<c:url value="/" />"
		class="p-2 bg-brand border border-brand-800 rounded-md
		transition-background-color duration-100
		hover:bg-brand-600 focus:outline-alternate focus:ring-alternate">
		<h1 class="text-2xl font-semibold text-stone-100">
			Brand
		</h1>
		</a>
		<nav>
			<ul class="list-none flex items-stretch gap-x-2 text-sm font-medium ">
				<li class="relative text-right">
					<svg class="pointer-events-none absolute inset-y-0 left-0 h-full w-7 stroke-stone-400 ml-2"
						viewBox="0 0 256 256" aria-hidden="true">
						<circle cx="116" cy="116" r="84" fill="none" stroke-linecap="round" stroke-linejoin="round"
							stroke-width="16"></circle>
						<line x1="175.4" y1="175.4" x2="224" y2="224" fill="none" stroke-linecap="round"
							stroke-linejoin="round" stroke-width="16"></line>
					</svg>
					<label for="search-basic" class="sr-only">Tìm thú cưng...</label>
					<input id="search-basic" type="search" placeholder="Tìm thú cưng..." class="block pl-10 text-sm
						w-full md:max-w-48 focus:w-full
						rounded-full
						border border-1 border-stone-300
						transition-all duration-300
						hover:border-stone-400
						focus:border-alternate focus:ring-alternate
						disabled:cursor-not-allowed disabled:bg-stone-200 disabled:opacity-75">
				</li>
				<c:choose>
					<c:when test="${!sessionScope.containsKey('user')}">
						<li>
							<a href="<c:url value="/profile" />"
							class="material-symbols-rounded h-10 w-10 rounded-full
							text-2xl text-center text-stone-700
							transition duration-100
							border border-1 border-stone-300
							hover:border-stone-500
							focus:border-alternate focus:ring-alternate focus:outline-none focus:border-transparent
							focus:ring">
								<p class="mt-0.5">
									person
								</p>
							</a>
						</li>
					</c:when>
					<c:otherwise>
						<li>
							<a href="<c:url value="/login" />"
							class="flex h-full items-center rounded-full bg-brand px-2 text-stone-100
							border border-brand-800
							transition duration-100
							focus:border-alternate focus:ring-alternate focus:outline-none focus:border-transparent
							focus:ring">
								Đăng nhập
							</a>
						</li>
					</c:otherwise>
				</c:choose>
			</ul>
		</nav>
	</nav>
</header>
<hr />
