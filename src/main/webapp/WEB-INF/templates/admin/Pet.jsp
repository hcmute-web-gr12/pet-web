<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<table class="w-full min-h-full text-left h-2 table-auto">
	<thead class="uppercase bg-stone-200">
		<tr>
			<th scope="col" class="px-4 py-3 rounded-l-xl">
				<div class="flex items-center">
					<input id="checkbox-all" type="checkbox"
						class="w-4 h-4 text-brand bg-stone-100 rounded border focus:ring-brand/60 focus:ring-2">
					<label for="checkbox-all" class="sr-only">checkbox</label>
				</div>
			</th>
			<th scope="col" class="px-4 py-3">
				Tên thú nuôi
			</th>
			<th scope="col" class="px-4 py-3">
				Giá tiền
			</th>
			<th scope="col" class="px-4 py-3">
				Số lượng
			</th>
			<th scope="col" class="px-4 py-3 rounded-r-xl">
				Hành động
			</th>
		</tr>
	</thead>
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
					<img class="w-10 h-10 object-cover rounded-full" src="${pet.imageUrl}"
						alt="${pet.name}">
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
						<button type="button" class="material-symbols-rounded text-primary">edit</button>
						<button type="button" class="material-symbols-rounded text-red-500">delete</button>
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
</table>
