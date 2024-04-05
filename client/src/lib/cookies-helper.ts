import JsCookie from "js-cookie";
import { type ReadonlyRequestCookies } from "next/dist/server/web/spec-extension/adapters/request-cookies";

import { type Mode } from "@/types/mode";

const COOKIE_KEY = {
  mode: "mode",
};

class CookiesHelper {
  private instance: ReadonlyRequestCookies | undefined;

  public initialize(cookies: ReadonlyRequestCookies) {
    this.instance = cookies;
  }

  public getMode() {
    if (!this.instance) {
      throw new Error("must be initialized before reading");
    }

    return (this.instance.get(COOKIE_KEY.mode)?.value as Mode) || "light";
  }

  public setMode(mode: Mode) {
    JsCookie.set(COOKIE_KEY.mode, mode);
  }
}

export const cookies = new CookiesHelper();