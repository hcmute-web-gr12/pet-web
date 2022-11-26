<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="bg" scope="page" value="${param.getOrDefault('bg', 'bg-primary')}" />
<c:set var="text" scope="page" value="${param.getOrDefault('text', 'text-stone-100')}" />
<c:set var="border" scope="page" value="${param.getOrDefault('border', 'border-primary-600')}" />
<c:set var="rounded" scope="page" value="${param.getOrDefault('rounded', 'rounded')}" />
<c:set var="fontSize" scope="page" value="${param.getOrDefault('font-size', 'text-base')}" />

<button
	id="${param.id}"
	type="${param.type}"
	class="flex h-full items-center px-4 py-2 ${fontSize}
		${rounded} ${bg} ${text}
		border ${border}
		transition duration-100
		focus:outline-none focus:border-transparent focus:ring focus:${param.getOrDefault('ring', 'ring-primary')}/60"
>
	${param.slot}
</button>
