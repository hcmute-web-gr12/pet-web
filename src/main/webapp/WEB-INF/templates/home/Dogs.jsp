<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section>
  <div class="mx-auto max-w-screen px-4 sm:px-6 lg:px-8 text-xs md:text-base">
    <div
            class="flex flex-col lg:flex-row gap-8 justify-center items-center h-fit"
    >
      <div class="flex items-center">
        <div class="text-center lg:text-left prose prose:lg prose-a:no-underline">
          <h2 class="text-2xl font-bold text-brand">Giống chó cảnh</h2>

          <p class="max-w-[45ch] text-sm text-gray-700">
            <span class="text-brand font-bold uppercase">Brand</span>
            có sẵn 20+ giống chó cảnh đa dạng dành cho bạn.
          </p>

          <a
                  href="<c:url value="/products?type=dog" />"
                  class="inline-block rounded bg-brand px-6 py-3 text-sm text-stone-100"
          >
            Đến cửa hàng
          </a>
        </div>
      </div>

      <div class="w-full lg:w-2/3 grid grid-cols-5 grid-flow-col gap-4">
        <a href="#" class="block aspect-square">
          <img
                  alt="Alaska"
                  src="https://i0.wp.com/petsidi.com/wp-content/uploads/2018/06/alaskan-husky-dogs.jpg?w=680"
                  class="aspect-square w-full rounded object-cover bg-stone-200 border border-w-1 border-stone-300"
          />

          <div class="mt-2">
            <h3 class="font-medium">Alaska</h3>
          </div>
        </a>

        <a href="#" class="block">
          <img
                  alt="Corgi"
                  src="https://images.unsplash.com/photo-1589965716319-4a041b58fa8a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1074&q=80"
                  class="aspect-square w-full rounded object-cover bg-stone-200 border border-w-1 border-stone-300""
          />

          <div class="mt-2">
            <h3 class="font-medium">Corgi</h3>
          </div>
        </a>

        <a href="#" class="block">
          <img
                  alt="Pug"
                  src="https://images.unsplash.com/photo-1512723185835-0700e5069a9a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1887&q=80"
                  class="aspect-square w-full rounded object-cover bg-stone-200 border border-w-1 border-stone-300""
          />

          <div class="mt-2">
            <h3 class="font-medium">Pug</h3>
          </div>
        </a>

        <a href="#" class="block">
          <img
                  alt="Pug"
                  src="data:image/gif;base64,R0lGODlhAQABAAD/ACwAAAAAAQABAAACADs%3D"
                  class="aspect-square w-full rounded object-cover bg-stone-200 border border-w-1 border-stone-300""
          />

          <div class="mt-2">
            <h3 class="font-medium">Pug</h3>
          </div>
        </a>

        <a href="#" class="block">
          <img
                  alt="Pug"
                  src="data:image/gif;base64,R0lGODlhAQABAAD/ACwAAAAAAQABAAACADs%3D"
                  class="aspect-square w-full rounded object-cover bg-stone-200 border border-w-1 border-stone-300""
          />

          <div class="mt-2">
            <h3 class="font-medium">Pug</h3>
          </div>
        </a>
      </div>
    </div>
  </div>
</section>
