<%@ page %>
<header>
    <nav class="max-w-5xl rounded mx-auto flex items-center justify-between p-4">
        <div class="flex items-center gap-2 bg-brand hover:bg-grand-600 rounded">
            <a class="p-2" href="#">
                <h1 class="text-3xl font-semibold text-stone-100">
                    Brand
                </h1>
            </a>
        </div>
        <nav class="flex items-center space-x-1 text-sm font-medium">
            <button class="flex appearance-none p-1 text-blue-500">
                <svg class="h-6 w-6" fill="currentcolor" viewBox="0 0 256 256">
                    <line x1="40" y1="128" x2="216" y2="128" fill="none" stroke="currentcolor" stroke-linecap="round"
                          stroke-linejoin="round" stroke-width="24"></line>
                    <line x1="40" y1="64" x2="216" y2="64" fill="none" stroke="currentcolor" stroke-linecap="round"
                          stroke-linejoin="round" stroke-width="24"></line>
                    <line x1="40" y1="192" x2="216" y2="192" fill="none" stroke="currentcolor" stroke-linecap="round"
                          stroke-linejoin="round" stroke-width="24"></line>
                </svg>
            </button>
            <div class="relative max-w-md">
                <svg class="pointer-events-none absolute inset-y-0 left-0 h-full w-8 stroke-gray-400 pl-2.5"
                     viewBox="0 0 256 256" aria-hidden="true">
                    <circle cx="116" cy="116" r="84" fill="none" stroke-linecap="round" stroke-linejoin="round"
                            stroke-width="16"></circle>
                    <line x1="175.4" y1="175.4" x2="224" y2="224" fill="none" stroke-linecap="round"
                          stroke-linejoin="round" stroke-width="16"></line>
                </svg>
                <label for="search-basic" class="sr-only">Search for pets...</label>
                <input id="search-basic" type="search" placeholder="Search for pets..."
                       class="block w-full rounded-md border-gray-200 pl-10 text-sm transition focus:border-blue-600 focus:ring-blue-600 disabled:cursor-not-allowed disabled:bg-gray-200 disabled:opacity-75">
            </div>
            <a href="/login" class="hidden rounded px-3 py-2 transition hover:text-brand sm:inline">Login</a>
            <a href="/signup" class="rounded bg-blue-600 px-3 py-2 text-stone-100 transition hover:bg-brand">Sign Up</a>
        </nav>
    </nav>
    <hr class="border-stone-300" />
</header>