"use client";
import { useState, useEffect } from "react";

import { Switch } from "@/components/ui/switch";
import { cookies } from "@/lib/cookies-helper";
import { type Mode } from "@/types/mode";

import DarkModeIcon from "@/assets/icons/icon-dark-mode.svg";
import LightModeIcon from "@/assets/icons/icon-light-mode.svg";

type ModeToggleProps = {
  initialMode: Mode;
};

export function ModeToggle({ initialMode }: Readonly<ModeToggleProps>) {
  const [mode, setMode] = useState<"light" | "dark">(initialMode);

  function onToggle() {
    const next = mode === "light" ? "dark" : "light";
    setMode(next);
    cookies.setMode(next);
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