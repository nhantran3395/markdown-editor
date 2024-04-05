import { cookies } from "next/headers";

import { Label } from "@/components/ui/label";
import { Button } from "@/components/ui/button";
import { MenuSidebar } from "./menu-sidebar";
import { DeleteIconWithDialog } from "./delete-icon-with-dialog";
import { getInitialModeFromCookies } from "@/lib/utils";

import Logo from "@/assets/icons/logo.svg";
import DocumentIcon from "@/assets/icons/icon-document.svg";
import SaveIcon from "@/assets/icons/icon-save.svg";

export function Header() {
  const initialMode = getInitialModeFromCookies(cookies());

  return (
    <nav className={"bg-gray-700 flex items-center justify-between"}>
      <div className="flex gap-x-6 items-center">
        <MenuSidebar initialMode={initialMode} />
        <Logo className={"max-md:hidden"} />
        <div
          className={"max-md:hidden border-l-[1px] h-[40px] border-l-gray-500"}
        />
        <div className="flex gap-x-4 items-center">
          <DocumentIcon className={"h-[16px] w-[14px]"} />
          <div className={"flex sm:flex-col"}>
            <Label className={"text-body text-gray-400 max-sm:hidden"}>
              Document Name
            </Label>
            <Label className={"text-white"}>Welcome.md</Label>
          </div>
        </div>
      </div>
      <div className={"flex gap-x-6 m-2 sm:m-4 items-center"}>
        <DeleteIconWithDialog />
        <Button className={"flex gap-x-2"}>
          <SaveIcon className={"h-4 w-4"} />
          <span className={"max-sm:hidden"}>Save Changes</span>
        </Button>
      </div>
    </nav>
  );
}