"use client";
import { useState, useEffect } from "react";
import Cookie from "js-cookie";

import { Switch } from "@/components/ui/switch";
import { type Mode } from "@/lib/utils";

import DarkModeIcon from "@/assets/icons/icon-dark-mode.svg";
import LightModeIcon from "@/assets/icons/icon-light-mode.svg";

type ModeToggleProps = {
  initialMode: Mode;
};

export function ModeToggle({ initialMode }: ModeToggleProps) {
  const [mode, setMode] = useState<"light" | "dark">(initialMode);

  function onToggle() {
    const next = mode === "light" ? "dark" : "light";
    setMode(next);
    Cookie.set("mode", next);
  }

  useEffect(() => {
    if (mode === "dark") {
      document.body.classList.add("dark");
    } else {
      document.body.classList.remove("dark");
    }
  }, [mode]);

  return (
    <div className={"flex items-center gap-x-3"}>
      <DarkModeIcon />
      <Switch checked={mode === "light"} onClick={onToggle} value={mode} />
      <LightModeIcon />
    </div>
  );
}