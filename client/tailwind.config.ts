import type { Config } from "tailwindcss";

const config: Config = {
  content: [
    "./src/pages/**/*.{js,ts,jsx,tsx,mdx}",
    "./src/components/**/*.{js,ts,jsx,tsx,mdx}",
    "./src/app/**/*.{js,ts,jsx,tsx,mdx}",
  ],
  theme: {
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
      grey: {
        100: "#f5f5f5",
        200: "#e4e4e4",
        300: "#c1c4cb",
        400: "#7c8187",
        500: "#5a6069",
        600: "#35393f",
        700: "#2b2d31",
        800: "#1d1f22",
        900: "#151619",
      },
      white: "#ffffff",
      orange: {
        600: "#e46643",
        300: "#f39765",
      },
    },
    fontFamily: {
      sans: ["Roboto", "sans-serif"],
      slab: ["Roboto Slab", "serif"],
      mono: ["Roboto Mono", "monospace"],
    },
    extend: {},
  },
  plugins: [],
};
export default config;