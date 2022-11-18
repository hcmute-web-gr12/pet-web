<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="bg" scope="page" value="${param.getOrDefault('bg', 'brand')}" />
<c:set var="text" scope="page" value="${param.getOrDefault('text', 'stone')}" />
<c:set var="rounded" scope="page" value="${param.getOrDefault('rounded', 'full')}" />
<a href="<c:url value="${param.href}" />"}
class="flex h-full items-center rounded-${rounded} bg-${bg} px-3 py-2
text-${text}-100
border border-${bg}-800
transition duration-100
focus:border-alternate focus:ring-alternate focus:outline-none focus:border-transparent
focus:ring">
	${param.slot}
</a>
