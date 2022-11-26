<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="bg" scope="page" value="${param.getOrDefault('bg', 'bg-brand')}" />
<c:set var="text" scope="page" value="${param.getOrDefault('text', 'text-stone-100')}" />
<c:set var="border" scope="page" value="${param.getOrDefault('border', 'border-brand-800')}" />
<c:set var="rounded" scope="page" value="${param.getOrDefault('rounded', 'rounded-lg')}" />
<c:set var="padding" scope="page" value="${param.getOrDefault('padding', 'px-4 py-2')}" />

<a
	id="${param.id}"
	href="<c:url value="${param.href}" />"
	class="flex h-full items-center ${padding}
		${rounded} ${bg} ${text}
		border ${border}
		transition duration-100
		focus:outline-none focus:border-transparent focus:ring focus:${param.getOrDefault('ring', 'ring-brand')}/60"
>
	${param.slot}
</a>
