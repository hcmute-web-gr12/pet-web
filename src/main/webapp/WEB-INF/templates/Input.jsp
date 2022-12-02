<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set
	var="defaultClass"
	value="block w-full h-auto px-5 py-3
	bg-stone-50 placeholder-stone-500
	transition duration-100 ease-in-out
	border border-stone-200 rounded-lg
	focus:border-transparent focus:ring focus:${param.getOrDefault('ring', 'ring-brand')}/60
	disabled:cursor-not-allowed disabled:bg-stone-200 disabled:opacity-75" />

<c:choose>
	<c:when test="${param.getOrDefault('disabled', false)}">
		<input
			disabled
			id="${param.id}"
			name="${param.getOrDefault('name', param.id)}"
			type="${param.getOrDefault('type', 'text')}"
			value="${param.value}"
			min="${param.min}"
			step="${param.step}"
			placeholder="${param.placeholder}"
			spellcheck="${param.getOrDefault('spellcheck', 'false')}"
			class="${defaultClass}">
	</c:when>
	<c:when test="${param.getOrDefault('autofocus', false)}">
		<input
			autofocus
			id="${param.id}"
			name="${param.getOrDefault('name', param.id)}"
			type="${param.getOrDefault('type', 'text')}"
			min="${param.min}"
			step="${param.step}"
			autocomplete="${param.getOrDefault('autocomplete', 'off')}"
			required="${param.getOrDefault('required', 'false')}"
			value="${param.value}"
			placeholder="${param.placeholder}"
			spellcheck="${param.getOrDefault('spellcheck', 'false')}"
			class="${defaultClass}">
	</c:when>
	<c:otherwise>
		<input
			id="${param.id}"
			name="${param.getOrDefault('name', param.id)}"
			type="${param.getOrDefault('type', 'text')}"
			min="${param.min}"
			step="${param.step}"
			autocomplete="${param.getOrDefault('autocomplete', 'off')}"
			required="${param.getOrDefault('required', 'false')}"
			value="${param.value}"
			placeholder="${param.placeholder}"
			spellcheck="${param.getOrDefault('spellcheck', 'false')}"
			class="${defaultClass}">
	</c:otherwise>
</c:choose>

