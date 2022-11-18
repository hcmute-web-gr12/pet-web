tailwind.config = {
    theme: {
        extend: {
            colors: {
                brand: {
                    50: '#ff4a4f',
                    100: '#fc4045',
                    200: '#f2363b',
                    300: '#e82c31',
                    400: '#de2227',
                    500: '#d4181d',
                    600: '#ca0e13',
                    700: '#c00409',
                    800: '#b60000',
                    900: '#ac0000',
                    DEFAULT: '#d4181d'
                },
                alternate: {
                    50: '#4f80ff',
                    100: '#4576ff',
                    200: '#3b6cf6',
                    300: '#3162ec',
                    400: '#2758e2',
                    500: '#1d4ed8',
                    600: '#1344ce',
                    700: '#093ac4',
                    800: '#0030ba',
                    900: '#0026b0',
                    DEFAULT: '#1d4ed8'
                }
            },
			ringColor: (theme) => ({
				DEFAULT: theme('colors.brand.DEFAULT')
			}),
        }
    }
}
