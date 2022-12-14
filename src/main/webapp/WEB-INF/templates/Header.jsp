<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="mx-4">
	<nav class="max-w-5xl rounded mx-auto flex items-center justify-between py-4 gap-x-2">
		<c:import url="/WEB-INF/templates/Link.jsp">
			<c:param name="slot" value="
				<h1 class='text-2xl font-semibold text-stone-100'>
					Brand
				</h1>
			" />
			<c:param name="href" value="/" />
		</c:import>
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
					<input id="search-basic" spellcheck="false" type="search" placeholder="Tìm thú cưng..." class="block pl-10 text-sm
						h-full w-full md:max-w-48 focus:w-full
						border-stone-200
						rounded-lg
						transition-all duration-100
						focus:border-transparent focus:ring focus:ring-brand/60
						disabled:cursor-not-allowed disabled:bg-stone-200 disabled:opacity-75">
				</li>
				<c:choose>
					<c:when test="${sessionScope.containsKey('user')}">
						<li>
							<c:import url="/WEB-INF/templates/Link.jsp">
								<c:param name="slot" value="<p class='material-symbols-rounded'>person</p>" />
								<c:param name="href" value="/user/profile" />
								<c:param name="padding" value="p-2" />
							</c:import>
						</li>
						<li>
							<c:import url="/WEB-INF/templates/Link.jsp">
								<c:param name="slot" value="<p class='material-symbols-rounded'>shopping_cart</p>" />
								<c:param name="href" value="/cart" />
								<c:param name="padding" value="p-2" />
							</c:import>
						</li>
						<li>
							<c:import url="/WEB-INF/templates/Link.jsp">
								<c:param name="slot" value="<p class='material-symbols-rounded'>logout</p>" />
								<c:param name="href" value="/logout" />
								<c:param name="padding" value="p-0" />
								<c:param name="text" value="text-brand" />
								<c:param name="bg" value="bg-transparent" />
								<c:param name="border" value="border-transparent" />
							</c:import>
						</li>
					</c:when>
					<c:otherwise>
						<li>
							<c:import url="/WEB-INF/templates/Link.jsp">
								<c:param name="slot" value="Đăng nhập" />
								<c:param name="href" value="/login" />
							</c:import>
						</li>
					</c:otherwise>
				</c:choose>
			</ul>
		</nav>
	</nav>
</header>
<hr />
