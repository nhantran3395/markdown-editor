import { type ClassValue, clsx } from "clsx";
import { twMerge } from "tailwind-merge";
import { type ReadonlyRequestCookies } from "next/dist/server/web/spec-extension/adapters/request-cookies";

export function cn(...inputs: ClassValue[]) {
  return twMerge(clsx(inputs));
}

export type Mode = "light" | "dark";

export function getInitialModeFromCookies(
  cookies: ReadonlyRequestCookies,
): Mode {
  return (cookies.get("mode")?.value as Mode) ?? "light";
}