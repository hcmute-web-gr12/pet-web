<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="vi_VN" />
<table class="w-full text-left table-auto overflow-hidden overflow-x-auto">
	<thead class="text-sm font-bold">
		<tr class="border-b">
			<th class="whitespace-nowrap px-4 py-4">Sản phẩm</th>
			<th class="whitespace-nowrap px-4 py-4">Đơn giá</th>
			<th class="whitespace-nowrap px-4 py-4">Thành tiền</th>
		</tr>
	</thead>
	<tbody class="divide-y">
		<c:set var="total" value="${0}" />
		<c:forEach var="item" varStatus="status" items="${props.cart.items}">
			<tr>
				<td class="px-4 py-2 align-top">
					<div class="flex gap-x-4">
						<img src="${item.pet.imagePublicId}"
							class="block rounded border-stone-400 max-w-[11em] w-full aspect-square" />
						<div class="flex flex-col gap-y-4">
							<h2 class="font-medium text-xl">
								${item.pet.name}
							</h2>
							<div class="flex gap-x-2">
								<div
									class="align-middle text-stone-700 text-sm px-1 bg-stone-200 rounded-lg border-stone-400 w-fit">
									${item.quantity} con
								</div>
								<c:import url="/WEB-INF/templates/Button.jsp">
									<c:param name="slot" value="<span class='material-symbols-rounded'>remove</span>" />
									<c:param name="bg" value="bg-brand" />
									<c:param name="border" value="border-brand" />
									<c:param name="ring" value="ring-brand" />
									<c:param name="padding" value="p-0" />
									<c:param name="rounded" value="rounded-lg" />
									<c:param name="className" value="text-sm w-fit h-fit" />
								</c:import>
							</div>
						</div>
					</div>
				</td>
				<td class="whitespace-nowrap w-0 px-4 py-2 align-top">
					<fmt:formatNumber value="${item.pet.price}" type="currency" />
				</td>
				<td class="whitespace-nowrap w-0 px-4 py-2 align-top">
					<c:set var="total" value="${total + item.pet.price * item.quantity}" />
					<fmt:formatNumber value="${item.pet.price * item.quantity}" type="currency" />
				</td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot class="text-right">
		<tr class="border-t">
			<td class="px-4 py-2" colspan="3">
				Thành tiền: <span class="ml-2 font-medium">
					<fmt:formatNumber value="${total}" type="currency" />
				</span>
			</td>
		</tr>
		<tr>
			<td class="px-4 py-2" colspan="3">
				<div class="flex justify-end">
					<c:import url="/WEB-INF/templates/Button.jsp">
						<c:param name="slot" value="Thanh toán <span class='material-symbols-rounded'>payment</span>" />
						<c:param name="bg" value="bg-brand" />
						<c:param name="border" value="border-brand" />
						<c:param name="ring" value="ring-brand" />
						<c:param name="rounded" value="rounded-lg" />
					</c:import>
				</div>
			</td>
		</tr>
	</tfoot>
</table>
