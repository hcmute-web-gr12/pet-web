<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul class="flex flex-wrap gap-x-2 text-sm font-medium text-center text-stone-600">
	<c:forTokens var="tab" delims="," varStatus="status" items="${param.tabs}">
		<li>
			<c:choose>
				<c:when test="${status.getIndex() == param.active}">
					<c:import url="/WEB-INF/templates/Link.jsp">
						<c:param name="id" value="active" />
						<c:param name="slot" value="${tab}" />
						<c:param name="href" value="#" />
					</c:import>
				</c:when>
				<c:otherwise>
					<c:import url="/WEB-INF/templates/Link.jsp">
						<c:param name="id" value="tab-${status.getIndex()}" />
						<c:param name="slot" value="${tab}" />
						<c:param name="href" value="#" />
						<c:param name="text" value="text-stone-600" />
						<c:param name="bg" value="bg-transparent" />
						<c:param name="border" value="border-stone-300" />
					</c:import>
				</c:otherwise>
			</c:choose>
		</li>
	</c:forTokens>
</ul>
