import Image from "next/image";

import { Switch } from "@/components/ui/switch";

export function ModeToggle() {
  return (
    <div className={"flex items-center gap-x-3"}>
      <Image
        src={"icon-dark-mode.svg"}
        alt="Dark mode"
        width={16}
        height={16}
      />
      <Switch />
      <Image
        src={"icon-light-mode.svg"}
        alt="Light mode"
        width={16}
        height={16}
      />
    </div>
  );
}