import type { Metadata } from "next";
import { cookies as NextCookies } from "next/headers";

import { Header } from "@/components/layout/header";
import { cookies } from "@/lib/cookies-helper";

import "./globals.css";

export const metadata: Metadata = {
  title: "Markdown editor",
  description: "Welcome to Markdown Editor App",
};

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  // initialize cookies with instance of ReadOnlyRequestCookies
  cookies.initialize(NextCookies());
  const initialMode = cookies.getMode();

  return (
    <html lang="en">
      <body
        className={`min-h-dvh max-h-dvh flex flex-col ${initialMode === "dark" ? "dark" : ""}`}
      >
        <Header />
        <main className={"flex-1 flex flex-col overflow-auto"}>{children}</main>
      </body>
    </html>
  );
}