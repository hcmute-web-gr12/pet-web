<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
  <a href="#" class="group h-80 block bg-stone-100 rounded-lg overflow-hidden relative mb-2 lg:mb-3">
    <img
      src="${param.src}"
      alt="${param.alt}"
      loading="lazy"
      class="w-full h-full aspect-square object-cover object-center group-hover:scale-110 transition duration-200" />
    <c:if test="${not empty param.sale}">
      <span class="bg-brand text-white text-sm tracking-wider uppercase rounded-br-lg absolute left-0 top-0 px-3 py-1.5">sale</span>
    </c:if>
  </a>

  <div>
    <a href="#" class="text-stone-500 hover:stone-800 lg:text-lg transition duration-100 mb-1">${param.text}</a>
    <div class="flex items-center justify-between gap-2">
      <c:choose>
        <c:when test="${not empty param.sale}">
          <span class="text-stone-800 lg:text-lg font-semibold">${param.sale}</span>
          <span class="text-brand line-through">${param.price}</span>
        </c:when>
        <c:otherwise>
          <span class="text-stone-800 lg:text-lg font-semibold">${param.price}</span>
        </c:otherwise>
      </c:choose>
    </div>
  </div>
</div>
