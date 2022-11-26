<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="hrefs" value="${fn:split(param.hrefs, ',')}" />
<nav aria-label="Main Nav">
	<ul class="flex flex-col space-y-1 w-full">
		<li>
			<a href="#" class="flex items-center rounded-lg bg-gray-100 px-4 py-2 text-gray-700">
				<span class="material-symbols-rounded">
					dashboard
				</span>
				<span class="ml-3 text-sm font-medium"> Tổng quan </span>
			</a>
		</li>
		<li>
			<a href="#"
				class="flex items-center rounded-lg px-4 py-2 text-gray-500 hover:bg-gray-100 hover:text-gray-700">
				<span class="material-symbols-rounded">
					pets
				</span>
				<span class="ml-3 text-sm font-medium"> Thú nuôi </span>
			</a>
		</li>
	</ul>
</nav>
