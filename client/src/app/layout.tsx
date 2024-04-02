import type { Metadata } from "next";
import "./globals.css";

import { Header } from "@/components/layout/header";

export const metadata: Metadata = {
  title: "Markdown editor",
  description: "Welcome to Markdown Editor App",
};

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="en">
      <body>
        <Header />
        {children}
      </body>
    </html>
  );
}