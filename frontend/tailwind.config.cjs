/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./index.html",
    "./src/**/*.{vue,js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {
      colors: {
        'blue-1': '#164863',
        'blue-2': '#427D9D',
        'blue-3': '#9BBEC8',
        'blue-4': '#DDF2FD'
      }
    },
  },
  plugins: [],
}

