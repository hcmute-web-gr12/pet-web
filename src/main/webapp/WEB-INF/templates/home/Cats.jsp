<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section>
  <div class="mx-auto max-w-screen px-4 sm:px-6 lg:px-8 text-xs md:text-base">
    <div
            class="flex flex-col lg:flex-row gap-8 justify-center items-center h-fit"
    >
      <div class="flex items-center">
        <div class="text-center lg:text-left prose prose:lg prose-a:no-underline">
          <h2 class="text-2xl font-bold text-brand">Giống mèo cảnh</h2>

          <p class="max-w-[45ch] text-sm text-gray-700">
            <span class="text-brand font-bold uppercase">Brand</span>
            có sẵn 13+ giống mèo cảnh đa dạng dành cho bạn.
          </p>

          <a
                  href="<c:url value="/products?type=cat" />"
                  class="inline-block rounded bg-brand px-6 py-3 text-sm text-stone-100"
          >
            Đến cửa hàng mèo
          </a>
        </div>
      </div>

      <div class="w-full lg:w-2/3 grid grid-cols-5 grid-flow-col gap-4">
        <a href="#" class="block aspect-square">
          <img
                  alt="Abyssinian"
                  src="https://images.unsplash.com/photo-1598935888738-cd2622bcd437?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80"
                  class="aspect-square w-full rounded object-cover object-top"
          />

          <div class="mt-2">
            <h3 class="font-medium">Abyssinian</h3>
          </div>
        </a>

        <a href="#" class="block">
          <img
                  alt="Ragdoll"
                  src="https://images.unsplash.com/photo-1586289883499-f11d28aaf52f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1887&q=80"
                  class="aspect-square w-full rounded object-cover bg-stone-200 border border-w-1 border-stone-300"
          />

          <div class="mt-2">
            <h3 class="font-medium">Ragdoll</h3>
          </div>
        </a>

        <a href="#" class="block">
          <img
                  alt="Persian"
                  src="https://images.unsplash.com/photo-1630126798948-1abb357a1ec5?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80"
                  class="aspect-square w-full rounded object-cover bg-stone-200 border border-w-1 border-stone-300"
          />

          <div class="mt-2">
            <h3 class="font-medium">Persian</h3>
          </div>
        </a>

        <a href="#" class="block">
          <img
                  alt="Norwegian Forest"
                  src="data:image/gif;base64,R0lGODlhAQABAAD/ACwAAAAAAQABAAACADs%3D"
                  class="aspect-square w-full rounded object-cover bg-stone-200 border border-w-1 border-stone-300"
          />

          <div class="mt-2">
            <h3 class="font-medium">Norwegian Forest</h3>
          </div>
        </a>

        <a href="#" class="block">
          <img
                  alt="American Bobtail"
                  src="data:image/gif;base64,R0lGODlhAQABAAD/ACwAAAAAAQABAAACADs%3D"
                  class="aspect-square w-full rounded object-cover bg-stone-200 border border-w-1 border-stone-300"
          />

          <div class="mt-2">
            <h3 class="font-medium">American Bobtail</h3>
          </div>
        </a>
      </div>
    </div>
  </div>
</section>
