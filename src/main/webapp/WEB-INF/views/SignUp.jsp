<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Brand - Sign Up</title>
    <c:import url="../templates/head.html" />
</head>
<body>
    <c:import url="../templates/Header.jsp" />
    <section class="p-4 lg:py-20 xl:pr-60 lg:pr-42 md:pr-20">
        <div class="flex justify-end overflow gap-20">
            <section
                    class="hidden md:block w-full relative bg-[url(https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fanimalcarecentersmyrna.com%2Fwp-content%2Fuploads%2F2020%2F07%2FPet-hygiene-Animal-Care-Center.jpeg&f=1&nofb=1&ipt=7cc3697cd8583c429d3e483f84eb78c682fed62cddf6174c8dc0fd52a5ae35f0&ipo=images)] bg-cover bg-center bg-repeat"
            >
                <div
                        class="absolute inset-0 bg-stone-100 sm:bg-transparent sm:bg-gradient-to-r sm:from-stone-100/100 sm:to-stone-500/0"
                ></div>

                <div
                    class="relative p-4 lg:p-16 lg:flex lg:flex-col lg:h-full lg:justify-between"
                >
                    <div>
                        <h1 class="text-3xl font-extrabold sm:text-5xl uppercase">
                            Cho thú cưng
                            <strong class="block font-extrabold text-alternate-700 uppercase">
                                ĐI SPA
                            </strong>
                        </h1>

                    </div>
                    <div>
                        <p class="sm:text-xl sm:leading-relaxed">
                            Đúng vậy, bạn không nghe nhầm đâu!
                        </p>
                        <a
                                href="#"
                                class="block w-fit rounded bg-alternate px-4 py-3 font-medium text-stone-100 shadow hover:bg-alternate-900 active:bg-alternate"
                        >
                            Tìm hiểu thêm
                        </a>
                    </div>
                </div>
            </section>

            <div class="relative flex-auto min-w-96 flex-col justify-center lg:flex-none">
                <div class="">
                    <div>
                        <a href="<c:url value="/"/>" class="text-stone-500 text-medium font-bold uppercase">Brand</a>
                        <h2 class="mt-6 text-3xl font-extrabold text-alternate">Đăng ký.</h2>
                    </div>
                    <p class="mt-8">
                        <div class="mt-6">
                            <form action="#" method="POST" class="space-y-6">
                                <div>
                                    <label for="username" class="block text-sm font-medium text-stone-600"> Tên tài khoản </label>
                                    <div class="mt-1">
                                        <input id="username" name="username" type="email" required=""
                                               autofocus
                                               placeholder="Nhập tên tài khoản..."
                                               class="block w-full px-5 py-3 text-base placeholder-stone-400 transition
                                               duration-200 ease-in-out transform border border-stone-200 rounded-lg
                                               disabled:cursor-not-allowed disabled:bg-stone-200 disabled:opacity-75
                                               text-stone-600 bg-stone-50 focus:border-stone-600 focus:ring-stone-600">
                                    </div>
                                </div>

                                <div>
                                    <label for="email" class="block text-sm font-medium text-stone-600"> Địa chỉ Email </label>
                                    <div class="mt-1">
                                        <input id="email" name="email" type="email" autocomplete="email" required=""
                                               placeholder="Nhập Email..."
                                               class="block w-full px-5 py-3 text-base placeholder-stone-400 transition
                                               duration-200 ease-in-out transform border border-stone-200 rounded-lg
                                               disabled:cursor-not-allowed disabled:bg-stone-200 disabled:opacity-75
                                               text-stone-600 bg-stone-50 focus:border-stone-600 focus:ring-stone-600">
                                    </div>
                                </div>

                                <div class="space-y-1">
                                    <label for="password" class="block text-sm font-medium text-stone-600">
                                        Mật khẩu </label>
                                    <div class="mt-1">
                                        <input id="password" name="password" type="password" autocomplete="current-password"
                                               required placeholder="Nhập mật khẩu..."
                                               class="block w-full px-5 py-3 text-base placeholder-stone-400 transition
                                               duration-200 ease-in-out transform border border-stone-200 rounded-lg
                                               disabled:cursor-not-allowed disabled:bg-stone-200 disabled:opacity-75
                                               text-stone-600 bg-stone-50 focus:border-stone-600 focus:ring-stone-600">
                                    </div>
                                </div>

                                <div class="space-y-1">
                                    <label for="password-confirm" class="block text-sm font-medium text-stone-600">
                                        Xác nhận mật khẩu </label>
                                    <div class="mt-1">
                                        <input id="password-confirm" name="password-confirm" type="password" autocomplete="current-password"
                                               required placeholder="Xác nhận mật khẩu..."
                                               class="block w-full px-5 py-3 text-base placeholder-stone-400 transition
                                               duration-200 ease-in-out transform border border-stone-200 rounded-lg
                                               disabled:cursor-not-allowed disabled:bg-stone-200 disabled:opacity-75
                                               text-stone-600 bg-stone-50 focus:border-stone-600 focus:ring-stone-600">
                                    </div>
                                </div>
                                <div>
                                    <button type="submit"
                                            class="flex items-center justify-center w-full px-10 py-4 text-base font-medium text-center text-stone-100 transition duration-200 ease-in-out transform bg-alternate rounded-xl hover:bg-alternate-400 focus:outline-none focus:ring-2 focus:ring-alternate-400">
                                        Đăng ký
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
                                <button type="submit"
                                        class="w-full items-center block px-10 py-3.5 text-base font-medium text-center transition duration-200 ease-in-out transform border border-alternate rounded-xl focus:outline-none focus:ring-1 focus:ring-alternate">
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
                                        <span class="ml-4">Đăng ký với Google</span>
                                    </div>
                                </button>
                                <p class="mt-2 text-stone-600 text-bold text-sm text-right">
                                    Đã có tài khoản?
                                    <a href="<c:url value="/login" />" class="font-medium text-brand-500 hover:text-brand-300">đăng nhập</a>
                                    ngay!
                                </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <c:import url="../templates/Footer.jsp" />
</body>
</html>
