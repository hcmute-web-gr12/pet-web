<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<table class="w-full rounded-lg text-left h-2">
	<thead class="uppercase bg-stone-100 rounded">
		<tr>
			<th scope="col" class="p-4">
				<div class="flex items-center">
					<input id="checkbox-all" type="checkbox"
						class="w-4 h-4 text-brand bg-stone-100 rounded border focus:ring-brand/60 focus:ring-2">
					<label for="checkbox-all" class="sr-only">checkbox</label>
				</div>
			</th>
			<th scope="col" class="py-3 px-6">
				Name
			</th>
			<th scope="col" class="py-3 px-6">
				Position
			</th>
			<th scope="col" class="py-3 px-6">
				Status
			</th>
			<th scope="col" class="py-3 px-6">
				Action
			</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="pet" varStatus="status" items="${fn:split('1,2,3,4,5,6,7,8,9,10,11,12,13', ',')}">
			<tr class="border-b">
				<td class="p-4 w-4">
					<div class="flex items-center">
						<input id="checkbox-${status.getIndex()}" type="checkbox"
							class="w-4 h-4 text-brand bg-stone-100 rounded border focus:ring-brand/60">
						<label for="checkbox-${status.getIndex()}" class="sr-only">checkbox</label>
					</div>
				</td>
				<td scope="row" class="flex items-center py-4 px-6 whitespace-nowrap gap-x-2">
					<img class="w-10 h-10 object-cover rounded-full" src="https://via.placeholder.com/70"
						alt="Jese image">
					<div class="text-base font-medium">Pet ${status.getIndex()}</div>
				</td>
				<td class="py-4 px-6">
					Pet
				</td>
				<td class="py-4 px-6">
					<div class="flex items-center">
						<div class="h-2.5 w-2.5 rounded-full bg-green-400 mr-2"></div> Online
					</div>
				</td>
				<td class="py-4 px-6">
					<a href="#" class="font-medium text-blue-600 dark:text-blue-500 hover:underline">Edit user</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="4">
				Foot
			</td>
		</tr>
	</tfoot>
</table>
