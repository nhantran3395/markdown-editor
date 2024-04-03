import { Switch } from "@/components/ui/switch";

import DarkModeIcon from "@/assets/icons/icon-dark-mode.svg";
import LightModeIcon from "@/assets/icons/icon-light-mode.svg";

export function ModeToggle() {
  return (
    <div className={"flex items-center gap-x-3"}>
      <DarkModeIcon />
      <Switch />
      <LightModeIcon />
    </div>
  );
}