<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form method="post" action="/user/profile">
	<ul class="flex flex-col gap-y-4 list-none">
		<li class="flex flex-col gap-y-1 w-full max-w-sm">
			<c:import url="/WEB-INF/templates/Label.jsp">
				<c:param name="of" value="username" />
				<c:param name="slot" value="Username" />
			</c:import>
			<c:import url="/WEB-INF/templates/Input.jsp">
				<c:param name="id" value="username" />
				<c:param name="value" value="${props.user.getName()}" />
			</c:import>
		</li>

		<li class="flex flex-col gap-y-1 w-full max-w-sm">
			<c:import url="/WEB-INF/templates/Label.jsp">
				<c:param name="of" value="email" />
				<c:param name="slot" value="Email" />
			</c:import>
			<c:import url="/WEB-INF/templates/Input.jsp">
				<c:param name="id" value="email" />
				<c:param name="value" value="${props.user.getEmail()}" />
				<c:param name="disabled" value="${true}" />
			</c:import>
		</li>

		<li class="w-fit max-w-xs">
			<c:import url="/WEB-INF/templates/Button.jsp">
				<c:param name="type" value="submit" />
				<c:param name="id" value="update-profile" />
				<c:param name="slot" value="Update profile" />
			</c:import>
		</li>
	</ul>
</form>
