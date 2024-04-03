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
      <body className={"min-h-dvh max-h-dvh flex flex-col"}>
        <Header />
        <main className={"flex-1 flex flex-col overflow-auto"}>{children}</main>
      </body>
    </html>
  );
}