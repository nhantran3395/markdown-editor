import type { Config } from "tailwindcss";

const config = {
  darkMode: ["class"],
  content: [
    "./src/pages/**/*.{js,ts,jsx,tsx,mdx}",
    "./src/components/**/*.{js,ts,jsx,tsx,mdx}",
    "./src/app/**/*.{js,ts,jsx,tsx,mdx}",
  ],
  prefix: "",
  theme: {
    // container: {
    //   center: true,
    //   padding: "2rem",
    //   screens: {
    //     "2xl": "1400px",
    //   },
    // },
    screens: {
      sm: "480px",
      md: "768px",
      lg: "976px",
    },
    fontSize: {
      xs: "0.813rem",
      sm: "0.875rem",
      md: "0.938rem",
      lg: "1rem",
      xl: "1.25rem",
      "2xl": "1.5rem",
      "3xl": "1.75rem",
      "4xl": "2rem",
    },
    colors: {
      gray: {
        100: "hsl(var(--color-gray-100))",
        200: "hsl(var(--color-gray-200))",
        300: "hsl(var(--color-gray-300))",
        400: "hsl(var(--color-gray-400))",
        500: "hsl(var(--color-gray-500))",
        600: "hsl(var(--color-gray-600))",
        700: "hsl(var(--color-gray-700))",
        800: "hsl(var(--color-gray-800))",
        900: "hsl(var(--color-gray-900))",
      },
      white: "hsl(var(--color-white))",
      orange: {
        300: "hsl(var(--color-orange-300))",
        600: "hsl(var(--color-orange-600))",
      },
      background: "hsl(var(--background))",
      foreground: "hsl(var(--foreground))",
      primary: {
        DEFAULT: "hsl(var(--primary))",
        hover: "hsl(var(--primary-hover))",
        foreground: "hsl(var(--primary-foreground))",
      },
      accent: {
        DEFAULT: "hsl(var(--accent))",
        foreground: "hsl(var(--accent-foreground))",
      },
    },
    fontFamily: {
      sans: ["Roboto", "sans-serif"],
      slab: ["Roboto Slab", "serif"],
      mono: ["Roboto Mono", "monospace"],
    },
    extend: {
      // colors: {
      //   border: "hsl(var(--border))",
      //   input: "hsl(var(--input))",
      //   ring: "hsl(var(--ring))",
      // },
      // borderRadius: {
      //   lg: "var(--radius)",
      //   md: "calc(var(--radius) - 2px)",
      //   sm: "calc(var(--radius) - 4px)",
      // },
      // keyframes: {
      //   "accordion-down": {
      //     from: { height: "0" },
      //     to: { height: "var(--radix-accordion-content-height)" },
      //   },
      //   "accordion-up": {
      //     from: { height: "var(--radix-accordion-content-height)" },
      //     to: { height: "0" },
      //   },
      // },
      // animation: {
      //   "accordion-down": "accordion-down 0.2s ease-out",
      //   "accordion-up": "accordion-up 0.2s ease-out",
      // },
    },
  },
  // plugins: [require("tailwindcss-animate")],
  plugins: [],
} satisfies Config;

export default config;