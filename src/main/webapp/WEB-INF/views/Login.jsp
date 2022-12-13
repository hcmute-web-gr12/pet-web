<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<title>Brand</title>
	<c:import url="../templates/Head.jsp" />
</head>

<body>
	<c:import url="../templates/Header.jsp" />
	<section class="p-4 md:py-20 lg:pr-20">
		<div class="flex justify-end overflow gap-4 lg:gap-20">
			<section
				class="hidden md:block w-full relative bg-[url(https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fanimalcarecentersmyrna.com%2Fwp-content%2Fuploads%2F2020%2F07%2FPet-hygiene-Animal-Care-Center.jpeg&f=1&nofb=1&ipt=7cc3697cd8583c429d3e483f84eb78c682fed62cddf6174c8dc0fd52a5ae35f0&ipo=images)] bg-cover bg-center bg-repeat">
				<div
					class="absolute inset-0 bg-stone-100 sm:bg-transparent sm:bg-gradient-to-r sm:from-stone-100/100 sm:to-stone-500/0">
				</div>

				<div class="relative py-8 px-4 lg:px-16 flex flex-col h-full justify-between">
					<div>
						<h1 class="text-3xl font-extrabold sm:text-5xl uppercase">
							Cho thú cưng
							<strong class="block font-extrabold text-brand uppercase">
								ĐI SPA
							</strong>
						</h1>

					</div>
					<div>
						<p class="sm:text-xl sm:leading-relaxed">
							Đúng vậy, bạn không nghe nhầm đâu!
						</p>
						<div class="w-fit">
							<c:import url="/WEB-INF/templates/Link.jsp">
								<c:param name="href" value="#" />
								<c:param name="slot" value="Tìm hiểu thêm" />
							</c:import>
						</div>
					</div>
				</div>
			</section>

			<div class="relative flex-auto min-w-96 flex-col justify-center lg:flex-none">
				<div class="flex flex-col gap-y-6">
					<div>
						<a href="<c:url value=" /" />" class="text-stone-500 text-medium font-bold uppercase">Brand</a>
						<h2 class="mt-6 text-3xl font-extrabold text-brand">Đăng nhập.</h2>
					</div>
					<form action="login" method="POST" class="flex flex-col gap-y-6">
						<div class="space-y-2">
							<label for="email" class="block text-sm font-medium text-stone-600"> Địa chỉ
								Email </label>
							<c:import url="/WEB-INF/templates/Input.jsp">
								<c:param name="id" value="email" />
								<c:param name="type" value="email" />
								<c:param name="autocomplete" value="email" />
								<c:param name="autofocus" value="${true}" />
								<c:param name="placeholder" value="Nhập Email..." />
								<c:param name="value" value="${param.email}" />
							</c:import>
							<c:if
								test='${requestScope.containsKey("error") != null && requestScope.get("error").email != null}'>
								<p class="text-red-600 font-medium">
									${requestScope.get("error").email}
								</p>
							</c:if>
						</div>

						<div class="space-y-2">
							<label for="password" class="block text-sm font-medium text-stone-600"> Mật
								khẩu </label>
							<c:import url="/WEB-INF/templates/Input.jsp">
								<c:param name="id" value="password" />
								<c:param name="type" value="password" />
								<c:param name="autocomplete" value="current-password" />
								<c:param name="required" value="${true}" />
								<c:param name="autofocus" value="${false}" />
								<c:param name="placeholder" value="Nhập mật khẩu..." />
							</c:import>
							<c:if
								test='${requestScope.containsKey("error") != null && requestScope.get("error").password != null}'>
								<p class="text-red-600 font-medium">
									${requestScope.get("error").password}
								</p>
							</c:if>
						</div>

						<div class="flex items-center justify-between">
							<div class="flex items-center">
								<c:choose>
									<c:when test="${requestScope.containsKey(\" rememberMe\")}">
										<input id="rememberMe" name="rememberMe" type="checkbox" checked
											placeholder="Remember me"
											class="w-4 h-4 text-brand-600 border-stone-200 rounded focus:ring-brand-500">
									</c:when>
									<c:otherwise>
										<input id="rememberMe" name="rememberMe" type="checkbox"
											placeholder="Remember me"
											class="w-4 h-4 text-brand-600 border-stone-200 rounded focus:ring-brand-500">
									</c:otherwise>
								</c:choose>
								<label for="rememberMe" class="block ml-2 text-sm text-stone-600"> Ghi nhớ đăng
									nhập </label>
							</div>

							<div class="text-sm">
								<a href="#" class="font-medium text-brand-500 hover:text-brand-300"> Quên mật
									khẩu? </a>
							</div>
						</div>
						<c:import url="/WEB-INF/templates/Button.jsp">
							<c:param name="type" value="submit" />
							<c:param name="slot" value="Đăng nhập" />
							<c:param name="bg" value="bg-brand" />
							<c:param name="ring" value="ring-brand" />
							<c:param name="border" value="border-brand-600" />
						</c:import>
						<p class="text-stone-600 text-bold text-sm text-right">
							Chưa có tài khoản?
							<a href="<c:url value=" /signup" />"
							class="font-medium text-alternate hover:text-alternate-300">đăng ký</a>
							ngay!
						</p>
					</form>
				</div>
			</div>
		</div>
	</section>

	<c:import url="../templates/Footer.jsp" />
</body>

</html>
