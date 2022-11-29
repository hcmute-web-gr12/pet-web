<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
	<script src="/scripts/admin/pet.js" defer></script>
</head>
<div class="flex justify-between gap-x-2">
	<input id="search-pet-input" name="search-pet-input" type="search" value="${param.get('search-pet-input')}"
		placeholder="Tìm thú nuôi" spellcheck="false" class="block w-48 px-4 py-2
		bg-stone-50 placeholder-stone-500
		transition duration-100 ease-in-out
		border border-stone-200 rounded-lg
		focus:border-transparent focus:ring focus:ring-brand/60">
	<ul class="flex justify-end gap-x-2">
		<li>
			<c:import url="/WEB-INF/templates/Button.jsp">
				<c:param name="id" value="pet-add" />
				<c:param name="type" value="button" />
				<c:param name="slot" value="<span class='material-symbols-rounded'>add</span>" />
				<c:param name="padding" value="p-2" />
				<c:param name="rounded" value="rounded-lg" />
			</c:import>
		</li>
		<li>
			<c:import url="/WEB-INF/templates/Button.jsp">
				<c:param name="id" value="delete-pet-button" />
				<c:param name="type" value="button" />
				<c:param name="slot" value="<span class='material-symbols-rounded'>delete</span>" />
				<c:param name="padding" value="p-2" />
				<c:param name="rounded" value="rounded-lg" />
				<c:param name="bg" value="bg-red-500" />
				<c:param name="border" value="border-red-600" />
				<c:param name="ring" value="ring-red-500" />
			</c:import>
		</li>
	</ul>
</div>
<table id="pet-table" class="mt-2 w-full min-h-full text-left h-2 table-auto">
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
	<c:import url="/WEB-INF/templates/admin/pet/TableSlot.jsp">
	</c:import>
</table>

<dialog id="pet-dialog" loading modal-mode="mega" class="bg-stone-50 rounded-lg shadow-lg border">
	<div class="relative flex-auto min-w-96 flex-col justify-center lg:flex-none">
		<header>
			<h2 class="mt-6 text-3xl font-extrabold text-brand">Thêm thú cưng.</h2>
		</header>
		<form id="pet-form" action="/api/admin/pet" method="dialog" class="flex flex-col gap-y-6 mt-6">
			<div class="flex flex-col gap-y-6
				sm:flex-row sm:gap-x-4 sm:items-center sm:justify-stretch">
				<div class="space-y-2">
					<c:import url="/WEB-INF/templates/Label.jsp">
						<c:param name="slot" value="Tên thú cưng" />
						<c:param name="of" value="name" />
					</c:import>
					<c:import url="/WEB-INF/templates/Input.jsp">
						<c:param name="id" value="name" />
						<c:param name="type" value="text" />
						<c:param name="required" value="${true}" />
						<c:param name="placeholder" value="Nhập tên thú cưng..." />
					</c:import>
				</div>

				<div class="space-y-2">
					<c:import url="/WEB-INF/templates/Label.jsp">
						<c:param name="slot" value="Giá tiền" />
						<c:param name="of" value="price" />
					</c:import>
					<c:import url="/WEB-INF/templates/Input.jsp">
						<c:param name="id" value="price" />
						<c:param name="type" value="number" />
						<c:param name="min" value="0" />
						<c:param name="step" value="1000" />
						<c:param name="required" value="${true}" />
						<c:param name="placeholder" value="Nhập giá tiền..." />
					</c:import>
				</div>

				<div class="space-y-2">
					<c:import url="/WEB-INF/templates/Label.jsp">
						<c:param name="slot" value="Số lượng" />
						<c:param name="of" value="stock" />
					</c:import>
					<c:import url="/WEB-INF/templates/Input.jsp">
						<c:param name="id" value="stock" />
						<c:param name="min" value="0" />
						<c:param name="type" value="number" />
						<c:param name="required" value="${true}" />
						<c:param name="placeholder" value="Nhập số lượng..." />
					</c:import>
				</div>

			</div>

			<div class="flex flex-col gap-y-2">
				<c:import url="/WEB-INF/templates/Label.jsp">
					<c:param name="slot"
						value="Hình ảnh <span class='text-xs font-bold text-stone-400'># .png, .jpg, ...</span>" />
					<c:param name="of" value="imageFile" />
				</c:import>
				<input type="file" id="imageFile" name="imageFile" accept="image/*"
					class="text-stone-700 focus:ring-brand/60" />
			</div>

			<div class="space-y-2">
				<c:import url="/WEB-INF/templates/Label.jsp">
					<c:param name="slot"
						value="Mô tả <span class='text-xs font-bold text-stone-400'># Markdown</span>" />
					<c:param name="of" value="description" />
				</c:import>
				<textarea id="description" name="description" placeholder="Nhập mô tả..." rows="10" cols="80"
					spellcheck="false" class="block w-full h-full px-5 py-3
						bg-stone-50 placeholder-stone-500
						transition duration-100 ease-in-out
						border border-stone-200 rounded-lg
						focus:border-transparent focus:ring focus:ring-brand/60"></textarea>
			</div>
			<div class="flex justify-between gap-x-4">
				<p id='pet-form-error' class="text-red-600 font-medium"></p>
				<div class="flex gap-x-4">
					<c:import url="/WEB-INF/templates/Button.jsp">
						<c:param name="id" value="pet-form-back" />
						<c:param name="type" value="button" />
						<c:param name="slot" value="Trở về" />
						<c:param name="bg" value="bg-stone-500" />
						<c:param name="border" value="border-stone-600" />
						<c:param name="ring" value="ring-stone-500" />
					</c:import>
					<c:import url="/WEB-INF/templates/Button.jsp">
						<c:param name="id" value="pet-add-submit" />
						<c:param name="type" value="submit" />
						<c:param name="slot" value="Thêm" />
					</c:import>
				</div>
			</div>
		</form>
	</div>
</dialog>
