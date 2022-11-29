<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<tbody>
	<c:forEach var="pet" varStatus="status" items="${props.pets}">
		<tr class="border-b">
			<td scope="col" class="px-4 py-3">
				<div class="flex items-center">
					<input id="checkbox-${status.getIndex()}" type="checkbox"
						class="w-4 h-4 text-brand bg-stone-100 rounded border focus:ring-brand/60">
					<label for="checkbox-${status.getIndex()}" class="sr-only">checkbox</label>
				</div>
			</td>
			<td scope="row" class="px-4 py-3 flex items-center whitespace-nowrap gap-x-2">
				<img class="w-10 h-10 object-cover rounded-full" src="${pet.imagePublicId}" alt="${pet.name}">
				<div class="text-base font-medium">${pet.name}</div>
			</td>
			<td scope="col" class="px-4 py-3">
				${pet.price} VND
			</td>
			<td scope="col" class="px-4 py-3">
				${pet.stock}
			</td>
			<td scope="col" class="px-4 py-3">
				<div class="flex items-center space-x-2">
					<c:import url="/WEB-INF/templates/Button.jsp">
						<c:param name="id" value="add-pet-button" />
						<c:param name="type" value="button" />
						<c:param name="slot" value="<span class='material-symbols-rounded'>edit</span>" />
						<c:param name="text" value="text-stone-700" />
						<c:param name="padding" value="p-2" />
						<c:param name="rounded" value="rounded-lg" />
						<c:param name="bg" value="bg-yellow-500" />
						<c:param name="border" value="border-yellow-600" />
						<c:param name="ring" value="ring-yellow-500" />
					</c:import>
					<c:import url="/WEB-INF/templates/Button.jsp">
						<c:param name="id" value="add-pet-button" />
						<c:param name="type" value="button" />
						<c:param name="slot" value="<span class='material-symbols-rounded'>delete</span>" />
						<c:param name="padding" value="p-2" />
						<c:param name="rounded" value="rounded-lg" />
						<c:param name="bg" value="bg-red-500" />
						<c:param name="border" value="border-red-600" />
						<c:param name="ring" value="ring-red-500" />
					</c:import>
				</div>
			</td>
		</tr>
	</c:forEach>
</tbody>
<tfoot>
	<tr>
		<td colspan="5" class="px-4 py-3">
			<c:import url="/WEB-INF/templates/Pagination.jsp" />
		</td>
	</tr>
</tfoot>
