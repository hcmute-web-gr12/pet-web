<%@ page %>
<header>
    <div class="mx-auto flex max-w-7xl items-center justify-between p-4">
        <div class="flex items-center gap-2 bg-brand hover:bg-grand-600 rounded">
            <button class="flex appearance-none p-1 text-gray-500 md:hidden">
                <svg class="h-6 w-6" fill="currentcolor" viewBox="0 0 256 256">
                    <line x1="40" y1="128" x2="216" y2="128" fill="none" stroke="currentcolor" stroke-linecap="round"
                          stroke-linejoin="round" stroke-width="24"></line>
                    <line x1="40" y1="64" x2="216" y2="64" fill="none" stroke="currentcolor" stroke-linecap="round"
                          stroke-linejoin="round" stroke-width="24"></line>
                    <line x1="40" y1="192" x2="216" y2="192" fill="none" stroke="currentcolor" stroke-linecap="round"
                          stroke-linejoin="round" stroke-width="24"></line>
                </svg>
            </button>
            <a class="p-2" href="#">
                <h1 class="text-3xl font-semibold text-stone-100">
                    Brand
                </h1>
            </a></div>
        <nav class="hidden items-center space-x-2 text-sm font-medium text-gray-800 md:flex"><a href="#"
                                                                                                class="rounded bg-stone-100 px-3 py-2 transition hover:bg-white">Features</a>
            <a href="#" class="rounded bg-stone-100 px-3 py-2 transition hover:bg-white">Pricing</a>
            <a href="#" class="rounded bg-stone-100 px-3 py-2 transition hover:bg-white">Changelog</a>
            <a href="#" class="rounded bg-stone-100 px-3 py-2 transition hover:bg-white">About</a>
            <a href="#" class="rounded bg-stone-100 px-3 py-2 transition hover:bg-white">Blog</a></nav>
        <nav class="flex items-center space-x-1 text-sm font-medium text-gray-800"><a href="#"
                                                                                      class="hidden rounded bg-stone-100 px-3 py-2 transition hover:bg-white sm:inline">Login</a>
            <a href="#" class="rounded bg-blue-600 px-3 py-2 text-stone-100 transition hover:bg-blue-700">Sign Up</a></nav>
    </div>
</header>