<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Brand</title>
    <c:import url="../templates/Head.jsp"/>
</head>
<body>
<c:import url="../templates/Header.jsp"/>
<section class="p-4 md:py-20 lg:pr-20">
    <div class="flex justify-end overflow gap-4 lg:gap-20">
        <section
                class="hidden md:block w-full relative bg-[url(https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fanimalcarecentersmyrna.com%2Fwp-content%2Fuploads%2F2020%2F07%2FPet-hygiene-Animal-Care-Center.jpeg&f=1&nofb=1&ipt=7cc3697cd8583c429d3e483f84eb78c682fed62cddf6174c8dc0fd52a5ae35f0&ipo=images)] bg-cover bg-center bg-repeat"
        >
            <div
                    class="absolute inset-0 bg-stone-100 sm:bg-transparent sm:bg-gradient-to-r sm:from-stone-100/100 sm:to-stone-500/0"
            ></div>

            <div
                    class="relative py-8 px-4 lg:px-16 flex flex-col h-full justify-between"
            >
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
            <div class="">
                <div>
                    <a href="<c:url value="/"/>" class="text-stone-500 text-medium font-bold uppercase">Brand</a>
                    <h2 class="mt-6 text-3xl font-extrabold text-brand">Đăng nhập.</h2>
                </div>
                <div class="mt-8">
                    <div class="mt-6">
                        <form action="login" method="POST" class="space-y-6">
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
                                <c:if test='${requestScope.containsKey("error") != null && requestScope.get("error").email != null}'>
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
                                <c:if test='${requestScope.containsKey("error") != null && requestScope.get("error").password != null}'>
                                    <p class="text-red-600 font-medium">
                                            ${requestScope.get("error").password}
                                    </p>
                                </c:if>
                            </div>

                            <div class="flex items-center justify-between">
                                <div class="flex items-center">
                                    <c:choose>
                                        <c:when test="${requestScope.containsKey(\"rememberMe\")}">
                                            <input id="rememberMe" name="rememberMe" type="checkbox"
                                                   checked
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

                            <div>
                                <button type="submit"
                                        class="flex items-center justify-center w-full px-10 py-4 text-base font-medium text-center text-stone-100 transition duration-200 ease-in-out transform bg-brand-700 rounded-xl hover:bg-brand focus:outline-none focus:ring-2 focus:ring-brand">
                                    Đăng nhập
                                </button>
                            </div>
                        </form>
                        <div class="relative my-4">
                            <div class="absolute inset-0 flex items-center">
                                <div class="w-full border-t border-stone-300"></div>
                            </div>
                            <div class="relative flex justify-center text-sm">
                                <span class="px-2 bg-stone-100 text-stone-600"> Hoặc </span>
                            </div>
                        </div>
                        <div>
                            <button type="submit"
                                    class="w-full items-center block px-10 py-3.5 text-base font-medium text-center transition duration-200 ease-in-out transform border border-brand rounded-xl focus:outline-none focus:ring-1 focus:ring-brand">
                                <div class="flex items-center justify-center">
                                    <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"
                                         class="w-6 h-6" viewBox="0 0 48 48">
                                        <defs>
                                            <path id="a"
                                                  d="M44.5 20H24v8.5h11.8C34.7 33.9 30.1 37 24 37c-7.2 0-13-5.8-13-13s5.8-13 13-13c3.1 0 5.9 1.1 8.1 2.9l6.4-6.4C34.6 4.1 29.6 2 24 2 11.8 2 2 11.8 2 24s9.8 22 22 22c11 0 21-8 21-22 0-1.3-.2-2.7-.5-4z"></path>
                                        </defs>
                                        <clipPath id="b">
                                            <use xlink:href="#a" overflow="visible"></use>
                                        </clipPath>
                                        <path clip-path="url(#b)" fill="#FBBC05" d="M0 37V11l17 13z"></path>
                                        <path clip-path="url(#b)" fill="#EA4335"
                                              d="M0 11l17 13 7-6.1L48 14V0H0z"></path>
                                        <path clip-path="url(#b)" fill="#34A853"
                                              d="M0 37l30-23 7.9 1L48 0v48H0z"></path>
                                        <path clip-path="url(#b)" fill="#4285F4" d="M48 48L17 24l-4-3 35-10z"></path>
                                    </svg>
                                    <span class="ml-4"> Đăng nhập bằng Google</span>
                                </div>
                            </button>
                            <p class="mt-2 text-stone-600 text-bold text-sm text-right">
                                Chưa có tài khoản?
                                <a href="<c:url value="/signup" />"
                                   class="font-medium text-alternate hover:text-alternate-300">đăng ký</a>
                                ngay!
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<c:import url="../templates/Footer.jsp"/>
</body>
</html>
