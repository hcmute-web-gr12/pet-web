<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="bg" value="${param.getOrDefault('bg', 'bg-primary')}" />
<c:set var="text" value="${param.getOrDefault('text', 'text-stone-100')}" />
<c:set var="border" value="${param.getOrDefault('border', 'border-primary-600')}" />
<c:set var="rounded" value="${param.getOrDefault('rounded', 'rounded')}" />
<c:set var="fontSize" value="${param.getOrDefault('font-size', 'text-base')}" />
<c:set var="ring" value="${param.getOrDefault('ring', 'ring-primary')}" />
<c:set var="padding" value="${param.getOrDefault('padding', 'px-4 py-2')}" />
<c:set var="__class" value="${param.className} ${padding} ${fontSize} ${rounded} ${bg} ${text} ${border} ${param.slot} w-auto text-center flex h-full justify-center items-center border transition focus:outline-none focus:border-transparent focus:ring focus:${ring}/60 disabled:bg-stone-500 disabled:border-stone-600" />

<c:choose>
	<c:when test="${param.disabled}">
		<button disabled id="${param.id}" type="${param.type}" class="${__class}">
			${param.slot}
		</button>
	</c:when>
	<c:otherwise>
		<button id="${param.id}" type="${param.type}" class="${__class}">
			${param.slot}
		</button>
	</c:otherwise>
</c:choose>
