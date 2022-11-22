<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<input id="${param.id}"
	name="${param.id}"
	type="${param.getOrDefault('type', 'text')}"
	autocomplete="${param.getOrDefault('autocomplete', 'off')}"
	required="${param.getOrDefault('required', 'false')}"
	value="${param.value}"
	autofocus="${param.getOrDefault('autofocus', 'false')}"
	placeholder="${param.placeholder}"
	spellcheck="${param.getOrDefault('spellcheck', 'false')}"
	class="block w-full h-full px-5 py-3
		bg-stone-50 placeholder-stone-500
		transition duration-100 ease-in-out
		border border-stone-200 rounded-lg
		focus:border-transparent focus:ring focus:${param.getOrDefault('ring', 'ring-brand')}/60
		disabled:cursor-not-allowed disabled:bg-stone-200 disabled:opacity-75">
